<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="fruitcart" method="get">
	Item<input type="text" name="item"><br>
	Quantity<input type="text" name="qty"><br>
	Price<input type="text" name="price"><br>
	<input type="submit" value="Add">
	<input type="hidden" name="id">
	<input type="hidden" name="action" value="insert">
</form>

</body>
</html>