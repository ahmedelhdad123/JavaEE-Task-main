<%@ page import="entities.Product" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<div style="text-align: center">
    <form action="${pageContext.request.contextPath}/products/add" method="get">
        <button class="btn">Add product</button>
    </form>
</div>

<h1>Product List</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Action</th>
    </tr>
    <%
        List<Product> products =(List<Product>) request.getAttribute("products");
    %>
    <%
        for (Product product : products){
    %>
        <tr>
            <td><%= product.getProductID() %></td>
            <td><%= product.getName() %></td>
            <td><%= product.getPrice() %></td>
            <td>
                <form action="${pageContext.request.contextPath}/products/delete" method="post">
                    <input type="hidden" name="productId" value=<%= product.getProductID() %>>
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
<%}%>
</table>
</body>
</html>
