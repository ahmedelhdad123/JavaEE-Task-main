<html>
<head>
    <title>Add Product</title>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" />--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/product.css" />--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/forms.css" />--%>
</head>
<body>
<main>
    <form class="product-form" action="${pageContext.request.contextPath}/products/add" method="post">
        <div class="form-control">
            <label for="name">name</label>
            <input type="text" name="name" id="name">
        </div>
        <div class="form-control">
            <label for="price">price</label>
            <input type="text" name="price" id="price">
        </div>
        <button class="btn" type="submit">Add Product</button>
    </form>
</main>
</body>
</html>