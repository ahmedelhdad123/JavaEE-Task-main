package repositories;

import entities.Product;
import org.example.HibernateUtil;
import org.hibernate.Session;

import java.util.Collections;
import java.util.List;

public class ProductRepo {
    Session session=null;
    public List<Product> allProducts()
    {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            List<Product> productList=session.createQuery("from Product", Product.class).stream().toList();


            session.getTransaction().commit();
            return productList;
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        return Collections.emptyList();
    }
    public void addProduct(String name,double price) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Product product = new Product();
            product.setName(name);
            product.setPrice(price);

            session.save(product);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public Boolean removeProduct(int id)
    {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Product product=session.get(Product.class,id);
            if (product!=null)
            {
                session.remove(product);
                session.getTransaction().commit();
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }
}
