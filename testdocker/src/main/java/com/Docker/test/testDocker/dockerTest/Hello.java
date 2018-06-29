package com.Docker.test.testDocker.dockerTest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	@GetMapping("/hello")
	public String getHello(){
		System.out.println("**********************");
		return "docker test";
	}
}
