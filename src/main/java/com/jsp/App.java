package com.jsp;

import java.util.Scanner;

import com.jsp.service.CartService;
import com.jsp.service.ProductService;

public class App 
{
	
	public static void main( String[] args )
	{
		ProductService productService = new ProductService();
		Scanner input=new Scanner(System.in);
		System.out.print("Enter your choice \n"+
				" 1 to add product \n"+
				" 2 to get by id  \n"+
				" 3 to get all product \n"+
				" 4 to update product \n "+
				" 5 to delete product  \n"+
				" 6 to update by id \n"+
				" 7 to update all \n");
		int choice=input.nextInt();
		switch (choice) {
		case 1:
			String message = productService.addProduct();
			System.out.println(message);

			break;
		case 2:
			productService.getById();
			break;
			case 3:
				productService.getAll();
				break;
			case 4:
				productService.updateProduct();
				break;
			case 5:
				productService.deleteProduct();
				break;
			
		default:
			break;
		}
		
		CartService cs=new CartService();
//		cs.addCart();
//		cs.addProductToCart();
//		cs.removeProductFromCart();
	}
}