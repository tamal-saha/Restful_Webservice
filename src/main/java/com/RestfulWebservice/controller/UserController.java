package com.RestfulWebservice.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.RestfulWebservice.beans.Post;
import com.RestfulWebservice.beans.User;
import com.RestfulWebservice.service.PostDao;
import com.RestfulWebservice.service.UserDao;

@RestController
public class UserController {

	@Autowired(required = true)
	UserDao dao;
	
	@Autowired(required = true)
	PostDao postDao;

	@GetMapping("/users")
	public List<User> fetchAllUser() {
		 List<User> findAll = dao.findAll();
		// findAll.stream().map(x->x.setPosts(postDao.findAllPostsOfOneUser(x.getId()))).collect(Collectors.toList());
		 
		 for (User user : findAll) {
				user.setPosts(postDao.findAllPostsOfOneUser(user.getId()));
			}
	    return findAll;
	}

	@GetMapping("/user/{id}")
	public User fetchUser(@PathVariable Integer id) {
		User user = dao.findbyId(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		user.setPosts(postDao.findAllPostsOfOneUser(id));
		return user;
	}

	@PostMapping("/user")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		 User saveUser = dao.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/users/{id}/posts")
	public List<Post> findAllPostsOfOneUser(@PathVariable Integer id) {
		User user = dao.findbyId(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		return postDao.findAllPostsOfOneUser(id);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public User deleteUser(@PathVariable Integer id) {
		User user = dao.findbyId(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		 user = dao.delete(id);
		return user;
	}

	@GetMapping("/users/{id}/posts/{postId}")
	public Post findDetailsOfOnePost(@PathVariable Integer id,@PathVariable Integer postId) {
		User user = dao.findbyId(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		 Post post = postDao.findDetailsOfOnePost(id, postId);
		 if(post==null) {
			 throw new PostNotFoundException("postId-"+id);
		 }
		 return post;
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> createNewPost(@RequestBody Post post,@PathVariable Integer id) {
		User user = dao.findbyId(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		Post createNewPost = postDao.createNewPost(id, post);
		URI location =  ServletUriComponentsBuilder.fromCurrentRequest().pathSegment("{postId}")
				 .buildAndExpand(createNewPost.getPostId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
