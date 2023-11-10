package com.jsp.service;

import java.util.List;
import java.util.Scanner;

import com.jsp.dao.CartDao;
import com.jsp.dao.ProductDao;
import com.jsp.entity.Cart;
import com.jsp.entity.Product;

public class CartService {
private	CartDao cd;
private	ProductDao pd;
Scanner sc=new Scanner(System.in);
	public CartDao getCd() {
	return cd;
}
public void setCd(CartDao cd) {
	this.cd = cd;
}
public ProductDao getPd() {
	return pd;
}
public void setPd(ProductDao pd) {
	this.pd = pd;
}
	
	
	
	public void addCart()
	{
		Cart c=new Cart();
		System.out.println("enter cart name");
		String carnName=sc.next();
		c.setCartName(carnName);
		cd.addCart(c);
	}
	public void addProductToCart()
	{
		System.out.println("enter cart id");
		int cartid=sc.nextInt();
		List<Product> li=pd.getAllProduct();
		for (Product product : li) {
			System.out.println(product.getProductId()+"  "+product.getProductName()+"  "+product.getProductPrice()+"  "+product.getProductQuantity());
		}
		System.out.println("enter product id to add");
		int prodid=sc.nextInt();
		cd.addProductToCart( prodid, cartid);
	}
	public void removeProductFromCart()
	{
		System.out.println("enter cart id");
		int cartid=sc.nextInt();
//		List<Product> p=cd.showCart(cartid);
////		System.out.println(p);
//		for(Product pr:p)
//		{
//			System.out.println(pr.getProductId()+"  "+pr.getProductName()+"  "+pr.getProductPrice()+"  "+pr.getProductQuantity());
//		}
		System.out.println("enter product id to remove");
		int prodid=sc.nextInt();
		cd.removeProductFromCart(prodid,cartid);
	}
	
}
