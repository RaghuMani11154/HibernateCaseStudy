package com.jsp.service;


import java.util.List;
import java.util.Scanner;
import com.jsp.dao.ProductDao;
import com.jsp.entity.Product;


public class ProductService {
	ProductDao productDao;
	Scanner input=new Scanner(System.in);

	public ProductDao getProductDao() {
		return productDao;
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	public String addProduct() {
		Product product=new Product();
		System.out.println("enter the product  name");
		String productName=input.next();
		System.out.println("Enter the product price");
		double productPrice=input.nextDouble();
		System.out.println("Enter the product Quantity");
		int productQuantity=input.nextInt();
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setProductQuantity(productQuantity);
		productDao.addById(product);
		return "Successfully a product is added ";
	}
	public void getById() {
		System.out.println("Enter the product id which you fetch details");
		int productId=input.nextInt();
		Product product=productDao.getProdcutById(productId);
		if(product!=null) {
			System.out.print(product.getProductName()+" ");
			System.out.print(product.getProductPrice()+" ");
			System.out.print(product.getProductQuantity()+" ");
		}
		else {
			System.err.println("We dont have any record in database that you entered");
		}
	}
	public void getAll() {
		List<Product> allProduct = productDao.getAllProduct();
		for(Product product:allProduct) {
			if(product!=null) {
				System.out.print(product.getProductName()+" ");
				System.out.print(product.getProductPrice()+" ");
				System.out.print(product.getProductQuantity()+" ");
				System.out.println();
			}
			else {
				System.err.println("We dont have any record in database ");
			}
		}
	}
	public void updateProduct() {
		System.out.println("Enter the product id which should be updated");
		int productId=input.nextInt();
		Product product = productDao.getProdcutById(productId);
		getById();
		if(product!=null) {

			System.out.println("Enter product name which should be updated");
			String productName=input.next();
			System.out.println("enter product price which should be updated");
			double productPrice=input.nextDouble();
			System.out.println("enter the product quantity that you need to change");
			int productQuaantity=input.nextInt();
			product.setProductName(productName);
			product.setProductPrice(productPrice);
			product.setProductQuantity(productQuaantity);	
			productDao.updateProductById(product);

		}
		else {
			System.err.println("We dont have any record in database that you entered");
		}
	}
	public void deleteProduct() {
		System.out.println("Enter the product id which should be updated");
		int productId=input.nextInt();
		Product product = productDao.getProdcutById(productId);
		getById();
		if(product!=null) {
			productDao.deleteProductById(product);

		}
		else {
			System.err.println("We dont have any record in database that you entered");
		}

	}
}