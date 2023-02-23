package com.stackroute.tokengenerator;

import java.util.Map;

import com.stackroute.model.User;

// An interface created for token generation
// We need to write a class which will implement this interface
public interface TokenGenerator {

	Map<String,String> generateToken(User user);
}
