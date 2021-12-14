package com.cg.spring.boot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Hello {
	
	private static final Logger LOG = LoggerFactory.getLogger(Hello.class);
	
	@RequestMapping("/hello")
	public String hello() {
//		System.out.println("Hello");
		LOG.info("Hello");
		return "Hello world!!!!!";
	}

}
