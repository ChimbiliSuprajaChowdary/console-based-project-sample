package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Product;
import model.User;

public class CRUD {

	static List<User> userlist=new ArrayList<User>();
	static Map<Integer,Product> productmap= new HashMap<Integer,Product>();
	static int i =0;
	public List<User> addUser(User user){
		
		System.out.println("Add list operation");
		userlist.add(user);
		return userlist;
	}
	
	public List<User> sortByName(){
		System.out.println(" Sort by Name");
		userlist.sort((User u1,User u2)->u1.getFirstname().compareTo(u2.getFirstname()));
		return userlist;
	}
	
	public List<User> sortByAge(){
		System.out.println("Sort by Age - Asc");
		userlist.sort((User u1,User u2)->u1.getAge()-u2.getAge());
		return userlist;
	}

	public List<User> sortByAgeDes(){
		System.out.println("Sort by Age - des");
		userlist.sort((User u1,User u2)->u2.getAge()-u1.getAge());
		return userlist;
	}
	
	public Map<Integer,Product> addProduct(Product product){
		
		 productmap.put(++i,product);
		 return productmap;
		
		
	
		
	}
}
