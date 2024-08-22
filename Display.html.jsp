<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Fruits Items </h1>
<table border="1" cellpadding="10%" bgColor="orange" align="center">
<tr>
<th>ID</th>
<th>FRUITS</th>
<th>QUANTITY</th>
<th>PRICE</th>
</tr>
<c:forEach var= "items" items="${fruits}">
 <tr>
 <td>${items.id} </td>
 <td>${items.items}</td>
 <td>${items.quantity} kg</td>
 <td>${items.price}</td>
 </tr>
 
 
 </c:forEach>
<tr>
<td>
 <form action="Home.jsp" method="get">
            <input type="submit" value="Back">
      
        </form>
</td>

</tr>


</table>
 

</body>
</html>