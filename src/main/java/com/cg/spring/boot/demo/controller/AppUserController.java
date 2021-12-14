package com.cg.spring.boot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.AppUser;
import com.cg.spring.boot.demo.service.AppUserService;

@RestController
@CrossOrigin(origins = "*")
public class AppUserController {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private AppUserService appUserService;
	
	@PostMapping("/register")
	public ResponseEntity<AppUser> regAppUser(@RequestBody AppUser appUser) {
		LOG.info("Controller regAppUser");
		AppUser app = appUserService.register(appUser);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Registered successful...");
		LOG.info(headers.toString());
		LOG.info(appUser.toString());
		ResponseEntity<AppUser> response = new ResponseEntity<>(app, headers, HttpStatus.OK);
		return response;
	}
	
	//----------------------------------------------------------------------------------------------
	
	@PostMapping("/login")
	public ResponseEntity<AppUser> logInAppUser(@RequestBody AppUser appUser) {
		LOG.info("Controller logInAppUser");
		AppUser app = appUserService.login(appUser);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Logged in successful...");
		LOG.info(headers.toString());
		ResponseEntity<AppUser> response = new ResponseEntity<>(app, headers, HttpStatus.OK);
		return response;
	}
}
