# JavaEE-Task
this repo contains an excercise on javaEE example using maven, hibernate, JSP, Servlet.
## here is the requirements:
Create a web project using JavaEE
it should have a front controller for Managing products (add product, list products, remove product)
you should have a page that lists products, beside each product a delete button (when pressing on it a request should be sent to the front controller to delete this product
above the products list an add button that redirects to a new page for adding product
control flow should be as the following:
ProductServlet --> ProductService --> ProductRepository
ProductServlet: (The front controller) receives requests and displays pages
ProductService: execute validations
ProductRepository: fetch/insert data (CRUD)
