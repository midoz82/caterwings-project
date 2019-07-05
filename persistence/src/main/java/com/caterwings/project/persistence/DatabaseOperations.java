package com.caterwings.project.persistence;

import com.caterwings.project.PresistenceSessionFactory;
import com.caterwings.project.models.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DatabaseOperations {


    SessionFactory factory = PresistenceSessionFactory.getSessionFactory();

    public void readProduct() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List product = session.createQuery("FROM Product").list();
            //product =  (Product) session.get(Product.class, Product);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();

        }
    }


    public Integer addProduct(Product p){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer productID = null;

        try {
            tx = session.beginTransaction();

            productID = (Integer) session.save(p);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return productID;
    }


    public boolean deleteProduct(int id){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer productID = null;
        boolean isSuccessful = false;
        try {
            tx = session.beginTransaction();
            Product product = new Product();
            product.setId(id);
            session.remove(product);
            tx.commit();
            isSuccessful = true;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isSuccessful;
    }

    public List<Product> getAllProducts(){
        Session session = factory.openSession();
        Transaction tx = null;
        List<Product> list = null;
        try {
            tx = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
            Root<Product> root = criteria.from(Product.class);

            criteria.select(root);
            Query<Product> query = session.createQuery(criteria);
            list = query.getResultList();
            tx.commit();

        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    public String getProductByName1(String name){
        return  "abc";
    }



    public List<Product> getProductByName(String name){
        Session session = factory.openSession();
        Transaction tx = null;
        List<Product> products = null;
        try {
            tx = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
            Root<Product> root = criteria.from(Product.class);

            criteria.select(root).where(builder.equal(root.get("title"), name));
            Query<Product> query = session.createQuery(criteria);
            products = query.getResultList();
            tx.commit();

        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    public Product getProductByDescription(String description){
        Session session = factory.openSession();
        Transaction tx = null;
        Product product = null;
        try {
            tx = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
            Root<Product> root = criteria.from(Product.class);

            criteria.select(root).where(builder.equal(root.get("description"), description));
            Query<Product> query = session.createQuery(criteria);
            product = query.getSingleResult();
            tx.commit();

        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return product;
    }


    public boolean updateProduct(Product p){
        Session session = factory.openSession();
        Transaction tx = null;
        boolean isSuccessful = false;
        try {
            tx = session.beginTransaction();
            session.update(p);
            tx.commit();
            isSuccessful = true;

        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isSuccessful;
    }

//    public static void main(String[] args){
//        DatabaseOperations operations = new DatabaseOperations();
//        //operations.addProduct();
//        //List<Product> list = operations.getAllProducts();
//        //for (Product p : list)
//         //   System.out.println(p.getId());
//        List<Product> plist = operations.getProductByName("mahmoud1");
//        for (Product p : plist)
//           System.out.println(p.getId());
//
//
//        //boolean isSuccessful = operations.deleteProduct(1);
//
////        Product p1 = new Product();
////        p1.setId(2);
////        p1.setDescription("blah");
////        p1.setTitle("new title");
////        p1.setPrice(10000);
////        operations.updateProduct(p1);
//    }

}
