package com.stackroute.tokengenerator;

import java.util.HashMap;

import java.util.Map;

import com.stackroute.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
public class TokenGeneratorImpl implements TokenGenerator {

	@Override
	public Map<String, String> generateToken(User user) {
		// Token needs to be generated
		
		String jwtToken=Jwts.builder().setId(user.getEmail()).setSubject(user.getPassword()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();
	    System.out.println(jwtToken);
		Map<String,String> tokenMap=new HashMap<>();
		tokenMap.put("token", jwtToken);
		tokenMap.put("message", "User successfully logged in");
         return tokenMap;		
		
	}

}
