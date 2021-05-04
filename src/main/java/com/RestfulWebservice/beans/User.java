package com.RestfulWebservice.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

public class User {
	private Integer id;
	@Size(min = 2 , message = "Name must be atleast 2 character.")
	private String name;
	private Date CreationDate;
	private List<Post> posts = new ArrayList<Post>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}
	public User(Integer id, String name, Date creationDate) {
		this.id = id;
		this.name = name;
		CreationDate = creationDate;
	}
	public User(Integer id, String name, Date creationDate, List<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		CreationDate = creationDate;
		this.posts = posts;
	}
	public User() {
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
}
