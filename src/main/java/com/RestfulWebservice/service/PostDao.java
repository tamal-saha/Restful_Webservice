package com.RestfulWebservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.RestfulWebservice.beans.Post;
import com.RestfulWebservice.beans.User;

@Component
public class PostDao {
	
	private static List<Post> posts = new ArrayList<>();
	private static int count=3;
	private List<Post> listOfPost;
	 static {
		 posts.add(new Post(1, "SELFIE", "Picture of mine", 2));
		 posts.add(new Post(2, "GROUP_PHOTO", "Picture of friends", 2));
		 posts.add(new Post(1, "PICNIC", "Picnic", 1));
		 posts.add(new Post(2, "MOVIE", "Movie at 7", 1));
		 posts.add(new Post(1, "TRAVEL", "Holiday", 3));
		 posts.add(new Post(2, "OFFICE_CELEBRATION ", "Office party", 3));
	}
	 
	 public List<Post> findAllPostsOfOneUser(Integer id){
		 
		 if(id!=null) {
			listOfPost = posts.stream().filter(post->post.getUserId().equals(id)).collect(Collectors.toList());
		 }
		 return listOfPost;
	 }
	 
	 public Post createNewPost(Integer id,Post post){
		 if(id!=null) {
			 listOfPost = posts.stream().filter(x->x.getUserId().equals(id)).collect(Collectors.toList());
			 if(!listOfPost.isEmpty()) {
				 post.setPostId(listOfPost.size()+1);
				 posts.add(post);
			 }
			 
		 }
		 
		 return post;
	 }
	 
	 public Post findDetailsOfOnePost(Integer userId, Integer postId){
		 if(userId!=null) {
			 listOfPost = posts.stream().filter(x->x.getUserId().equals(userId) && x.getPostId().equals(postId) )
					 .collect(Collectors.toList()); 
			 if(!listOfPost.isEmpty())
				 return listOfPost.get(0);
		}
		 return null;
	 }
	 
	 
}
