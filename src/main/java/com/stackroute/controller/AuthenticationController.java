package com.stackroute.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.model.User;
import com.stackroute.repository.AuthenticationRepository;
import com.stackroute.tokengenerator.TokenGenerator;
import com.stackroute.tokengenerator.TokenGeneratorImpl;

@RestController

// http://localhost:4444/api/authentication/add/User
// http://localhost:4444/api/authentication/login/stackroute@niit.com
@RequestMapping("/api/authentication")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationRepository repository;
	
	@PostMapping("add/User")
	public ResponseEntity<?> addUser(@RequestBody User user)
	{
		repository.save(user);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping("/login/{email}")
	public ResponseEntity<?> login(@PathVariable String email, HttpSession session)
	{
		User userFound=repository.findById(email).get();
		session.setAttribute("login_details", userFound.getEmail());
		TokenGenerator token=new TokenGeneratorImpl();
		Map<String,String> map=token.generateToken(userFound);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
   	

}
