package com.fruitcart.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fruitcart.model.Fruits;


@WebServlet("/fruitcart")
public class FruitCartController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		System.out.println("action:"+action);
		if(action.equals("fetch"))
		{
			List<Fruits> fruits=FruitCartDB.getItems();
			System.out.println(fruits);
			request.setAttribute("fruits", fruits);
			RequestDispatcher rd=request.getRequestDispatcher("fruitlist.jsp");
			rd.forward(request, response);
		}
		if(action.equals("insert"))
		{
			String itemName=request.getParameter("item");
			int quantity=Integer.parseInt(request.getParameter("qty"));
			float price=Float.parseFloat(request.getParameter("price"));
			Fruits newFruit=new Fruits(itemName,quantity,price);
			FruitCartDB.addFruit(newFruit);
			List<Fruits> fruits=FruitCartDB.getItems();
			request.setAttribute("fruits", fruits);
			RequestDispatcher rd=request.getRequestDispatcher("fruitlist.jsp");
			rd.forward(request, response);
		}
		if(action.equals("delete"))
		try 
		{
			int id=Integer.parseInt(request.getParameter("id"));
			FruitCartDB.deleteFruit(id);
			List<Fruits> updatedFruits=FruitCartDB.getItems();
			request.setAttribute("fruits", updatedFruits);
			RequestDispatcher rd=request.getRequestDispatcher("fruitlist.jsp");
			rd.forward(request, response);
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		if (action.equals("update"))
		{
            // Update logic
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                String itemName = request.getParameter("item");
                int quantity = Integer.parseInt(request.getParameter("qty"));
                float price = Float.parseFloat(request.getParameter("price"));

                Fruits updatedFruit = new Fruits(itemName, quantity, price);
                FruitCartDB.updateFruit(id, updatedFruit);

                List<Fruits> updatedFruits = FruitCartDB.getItems();
                request.setAttribute("fruits", updatedFruits);
                RequestDispatcher rd = request.getRequestDispatcher("fruitlist.jsp");
                rd.forward(request, response);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input format");
            }
        }

	}
}
			
			
			
			
			
