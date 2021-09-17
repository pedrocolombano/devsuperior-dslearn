package com.devsuperior.dslearn.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsuperior.dslearn.entities.User;
import com.devsuperior.dslearn.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	private static final Logger logger =  LoggerFactory.getLogger(UserService.class);
	
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = this.userRepository.findByEmail(email);
		if (user == null) {
			logger.error("User not found: " + email);
			throw new UsernameNotFoundException("User not found: " + email);
		}
		logger.info("User found: " + email);
		return user;
	}


}
