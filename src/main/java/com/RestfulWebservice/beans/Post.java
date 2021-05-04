package com.RestfulWebservice.beans;

public class Post {
	private Integer postId;
	private String postName;
	private String postContent;
	private Integer userId;
	public Post(Integer postId, String postName, String postContent, Integer userId) {
		super();
		this.postId = postId;
		this.postName = postName;
		this.postContent = postContent;
		this.userId = userId;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
