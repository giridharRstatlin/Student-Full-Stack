<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1 align="center">Fruits Lists</h1>
    <div align="center">
    <table>
    <tr>
    <td>
    <form action="fruitcart" method="get">
            <input type="submit" value="View">
            <input type="hidden" name="action" value="fetch">
        </form>
    </td>

    <td>
    <form action="insert.jsp" method="get">
            <input type="submit" value="Add">
            <!-- <input type="hidden" name="action" value="insert"> -->
        </form>
    
    </td>
    <td>
    <form action="delete.jsp" method="get">
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    
    
    </td>
    
    <td>
     <form action="update.jsp" method="get">
            <input type="submit" value="Update">
            <!-- <input type="hidden" name="action" value="update">-->
        </form>
    </td>
    </tr>
    </table>
  </div>

</body>
</html>