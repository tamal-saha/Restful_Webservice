package com.RestfulWebservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.RestfulWebservice.beans.User;

@Component
public class UserDao {
	
	private static List<User> users = new ArrayList<>();
	private static int count=3;
	 static {
		 users.add(new User(1, "Sam", new Date()));
		 users.add(new User(2, "ram", new Date()));
		 users.add(new User(3, "jam", new Date()));
	}
	 
	 public List<User> findAll(){
		 return users;
	 }
	 
	 public User save(User user){
		 if(user.getId()==null) {
			 user.setId(++count);
		 }
		 users.add(user);
		 return user;
	 }
	 
	 public User findbyId(int id){
		 for (User user : users) {
			if(user.getId()== id) {
				return user;
			}
		}
		 return null;
	 }
	 
	 public User delete(int id){
		 
		 Iterator<User> iterator = users.iterator();
		 while(iterator.hasNext()) {
			 User user = iterator.next();
			 if(user.getId()==id) {
				 iterator.remove();
				 return user;
			 }
		 }
		 return null;
	 }
}
