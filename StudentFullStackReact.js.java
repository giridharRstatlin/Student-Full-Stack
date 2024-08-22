package com.fruitcart.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import com.fruitcart.model.Fruits;
public class FruitCartDB 
{
	public static List<Fruits> getItems()
	{
		ArrayList<Fruits> fruit=new ArrayList<>();
		String sql="select * from fruits";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnect","root","Extramarks123*");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				int id=rs.getInt(1);
				String items=rs.getString(2);
				int qty=rs.getInt(3);
				float price=rs.getFloat(4);
				Fruits f=new Fruits(id,items,qty,price);
				fruit.add(f);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return fruit;
	}
	public static void addFruit(Fruits newFruit)
	{
		String sql="INSERT INTO fruits (items,quantity,price) VALUES (?,?,?)";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnect","root","Extramarks123*");
			PreparedStatement pst=con.prepareStatement(sql);
					
						pst.setString(1,newFruit.getItems());
						pst.setInt(2,newFruit.getQuantity());
						pst.setFloat(3, newFruit.getPrice());
						int rowsAffected=pst.executeUpdate();
						if(rowsAffected>0)
						{
							System.out.println("Fruit added successfully");
						}
						else
						{
							System.out.println("Failed to add fruit");
						}
					
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void deleteFruit(int id)
	{
		String sql="Delete from fruits where id=?";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnect","root","Extramarks123*");
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,id);
			int rowsAffected=pst.executeUpdate();
			if(rowsAffected>0)
			{
				System.out.println("Fruit deleted successfully!");
			}
			else
			{
				System.out.println("Failed to delete fruit");
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	public static Fruits getFruitById(int id) 
	{
        String sql = "SELECT * FROM fruits WHERE id = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnect", "root", "Extramarks123*");
            try (
            	PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, id);

                try (
                		ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        String items = rs.getString(2);
                        int qty = rs.getInt(3);
                        float price = rs.getFloat(4);
                        return new Fruits(id, items, qty, price);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; // Fruit not found
    }
	public static void updateFruit(int id, Fruits updatedFruit) {
        String sql = "UPDATE fruits SET items=?, quantity=?, price=? WHERE id=?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnect", "root", "Extramarks123*");
            try (
            	PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, updatedFruit.getItems());
                pst.setInt(2, updatedFruit.getQuantity());
                pst.setFloat(3, updatedFruit.getPrice());
                pst.setInt(4, id);

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Fruit updated successfully!");
                } else {
                    System.out.println("Failed to update fruit.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }

	}

