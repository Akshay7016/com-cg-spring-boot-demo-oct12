package com.cg.spring.boot.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.exception.AppUserAlreadyExistsException;
import com.cg.spring.boot.demo.exception.AppUserNotFoundException;
import com.cg.spring.boot.demo.model.AppUser;
import com.cg.spring.boot.demo.repository.AppUserRepository;

@Service
public class AppUserService {

	// please check the logic

	private static final Logger LOG = LoggerFactory.getLogger(AppUserService.class);

	@Autowired
	private AppUserRepository appUserRepository;

	public AppUser register(AppUser appUser) {
		LOG.info("Service register");
		if(appUserRepository.findByUserName(appUser.getUserName())!=null) {
			LOG.info("User already exists");
			throw new AppUserAlreadyExistsException("\""+appUser.getUserName() + "\" user name is already exists.");
		}
		else
			return appUserRepository.save(appUser);

	}

	// ----------------------------------------------------------------------------------------------

	public AppUser login(AppUser appUser) {
		LOG.info("Service login");
		if(appUserRepository.findByUserName(appUser.getUserName())==null) {
			throw new AppUserNotFoundException("User name not valid...");
		}
		else {
			AppUser user = appUserRepository.findByUserName(appUser.getUserName());
			if(appUser.getUserName().equals(user.getUserName())) {
				if(appUser.getPassword().equals(user.getPassword())) {
					return appUserRepository.findByUserName(appUser.getUserName());
				}
				else {
					throw new AppUserNotFoundException("Wrong password...");
				}
			}
		}
		
		
		return null;
	}
}