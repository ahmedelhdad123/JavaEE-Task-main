package servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import entities.Product;
import repositories.ProductRepo;

import java.io.IOException;
import java.util.List;

@WebServlet("/products/*")
public class ProductServlet extends HttpServlet {
    ProductRepo productRepository = new ProductRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo() != null ? request.getPathInfo() :"/";
        if(path.equals("/add")){
            request.getRequestDispatcher("/AddProduct.jsp").forward(request, response);
        }
        else if(path.equals("/")) {
            List<Product> products = productRepository.allProducts();
            request.setAttribute("products", products);
            request.getRequestDispatcher("/Products.jsp").forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path.equals("/delete")) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            boolean deleted = productRepository.removeProduct(productId);

            if (deleted) {
                response.sendRedirect(request.getContextPath() + "/products");
            } else {
                response.getWriter().write("Product deletion failed.");
            }
        }
        else if (path.equals("/add")){
            int price = Integer.parseInt(request.getParameter("price"));
            String name = request.getParameter("name");
            productRepository.addProduct(name, price);
            response.sendRedirect(request.getContextPath() + "/products");
        }

    }
}
