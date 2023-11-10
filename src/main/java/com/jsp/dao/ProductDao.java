package com.jsp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import com.jsp.entity.Product;

public class ProductDao {
	Configuration cfg =new Configuration().configure().addAnnotatedClass(Product.class);
	
	public void addById(Product product) {	
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		session.close();
	}

	public Product getProdcutById(int id) {
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Product product = session.get(Product.class, id);
		transaction.commit();
		session.close();
		return product;

	}
	public List<Product> getAllProduct() {
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		NativeQuery <Product>query = session.createNativeQuery("Select * from Product",Product.class);
		List <Product>product = query.list();
		return product;

	}
	public void updateProductById(Product product) {
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(product);

		transaction.commit();
		session.close();

	}
	public void deleteProductById(Product product) {
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(product);

		transaction.commit();
		session.close();
	}

}