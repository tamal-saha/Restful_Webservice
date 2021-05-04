package com.RestfulWebservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.RestfulWebservice.beans.HelloWorldBean;

@RestController
public class Controller {

	@GetMapping(path = "/getHelloWorld")
	public String helloWorld() {
		
		return "Hello world";
		}
	
	@GetMapping(path = "/getHelloWorldBean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello world");
		}
	
	@GetMapping(path = "/getHelloWorld/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable(name = "name") String name) {
		return new HelloWorldBean(String.format("Hello world ,%s",name));
		}
}
