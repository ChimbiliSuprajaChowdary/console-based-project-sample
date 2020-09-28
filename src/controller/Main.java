package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Product;
import model.User;
import service.CRUD;

public class Main {

	static List<User> userlist = new ArrayList<User>();
	static Map<Integer,Product> productmap = new HashMap<Integer,Product>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		CRUD list=new CRUD();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int choice;
		do {
			System.out.println("Enter your choice");
			System.out.println("1.Registration");
			System.out.println("2.Login");
			System.out.println("3.Display user details");
			System.out.println("4.Add Products");
			choice = Integer.parseInt(br.readLine());
			switch(choice) {
			case 1: 
				System.out.println("Enter the details to register");
				String firstname;
				String lastname;
				String username;
				String password;
				int age;
				User user = new User();
				firstname = br.readLine();
				lastname = br.readLine();
				username = br.readLine();
				password = br.readLine();
				age = Integer.parseInt(br.readLine());
				user.setFirstname(firstname);
				user.setLastname(lastname);
				user.setUsername(username);
				user.setPassword(password);
				user.setAge(age);
				userlist = list.addUser(user);
				break;
			case 3:
				System.out.println("User Details");
				userlist.forEach((element)->System.out.println(element));
				
				for(User users:userlist) {
					System.out.println(users);
				}
				System.out.println("Sort by name");
				userlist = list.sortByName();
				userlist.forEach((element)->System.out.println(element));
				System.out.println("AGE - ASCENDING");
				userlist = list.sortByAge();
				userlist.forEach((element)->System.out.println(element));
				
				System.out.println("AGE - DESCENDING");
				userlist = list.sortByAgeDes();
				userlist.forEach((element)->System.out.println(element));
				break;
			case 4:
				System.out.println("Adding products");
				int product_id;
				String productname;
				String company;
				product_id = Integer.parseInt(br.readLine());
				productname = br.readLine();
				company = br.readLine();
				Product product = new Product();
				product.setProduct_id(product_id);
				product.setProductname(productname);
				product.setCompany(company);
				productmap = list.addProduct(product);
				System.out.println("Map details");
				for(Map.Entry<Integer, Product> entry:productmap.entrySet())
				{
					System.out.println(entry.getKey() + " "+ entry.getValue());
				}
				productmap.forEach((k,v)->System.out.println(k +"" +v ));
			
			}
		}while(choice > 0 && choice <=3);

	}

}
