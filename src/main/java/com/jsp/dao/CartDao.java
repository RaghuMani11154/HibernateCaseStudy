package com.jsp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.entity.Cart;
import com.jsp.entity.Product;

public class CartDao {
	Configuration cfg =new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
	
	public void addCart(Cart cart)
	{
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(cart);
		transaction.commit();
		session.close();
	}
	public void addProductToCart(int prodid,int cartid)
	{
//		Cart cart=new Cart();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Cart c=session.get(Cart.class, cartid);
		Product pr= session.get(Product.class, prodid);
		c.getProducts().add(pr);
		session.update(c);
		transaction.commit();
		session.close();
	}
	public void removeProductFromCart(int prodid,int cartid)
	{
//		Cart cart=new Cart();
		System.out.println("entering 1");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Cart c=session.get(Cart.class, cartid);
		System.out.println("entering 2");
		Product pr= session.get(Product.class, prodid);
		c.getProducts().remove(pr);
		session.update(c);
		transaction.commit();
		session.close();
	}
	public List<Product> showCart(int cartid)
	{	SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Cart c=session.get(Cart.class, cartid);
		ArrayList<Product> products = new ArrayList<Product>(c.getProducts());
//		System.out.println(products+"hi");
		return products;
	}
}
