<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.fruitcart.model.Fruits"%>
<%@ page import="com.fruitcart.controller.FruitCartDB" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
    String idParameter = request.getParameter("id");
    if (idParameter != null && !idParameter.isEmpty()) {
        int id = Integer.parseInt(idParameter);
        Fruits fruitToUpdate = FruitCartDB.getFruitById(id);

        if (fruitToUpdate != null) {
%>
            <form action="fruitcart" method="get">
                <input type="hidden" name="action" value="update">
                ID: <input type="text" name="id" value="<%= fruitToUpdate.getId() %>" readonly><br>
                Item: <input type="text" name="item" value="<%= fruitToUpdate.getItems() %>"><br>
                Quantity: <input type="text" name="qty" value="<%= fruitToUpdate.getQuantity() %>"><br>
                Price: <input type="text" name="price" value="<%= fruitToUpdate.getPrice() %>"><br>
                <input type="submit" value="Update">
            </form>
<%
        } else {
%>
            <p>Fruit with ID <%= id %> not found.</p>
<%
        }
    } else {
%>
        <p>Please enter a valid ID.</p>
<%
    }
%>

</body>
</html>