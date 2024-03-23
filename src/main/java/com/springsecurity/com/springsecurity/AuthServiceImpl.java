package com.springsecurity.com.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

	 @Autowired
	 private UserRepository userRepository;
	 
	 
	  public UserDTO createUser(SignupRequest signupRequest) {
	        User user = new User();
	        user.setName(signupRequest.getName());
	        user.setEmail(signupRequest.getEmail());
	        user.setPhone(signupRequest.getPhone());
	        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
	        User createdUser = userRepository.save(user);
	        UserDTO userDTO = new UserDTO();
	        userDTO.setId(createdUser.getId());
	        userDTO.setEmail(createdUser.getEmail());
	        userDTO.setName(createdUser.getName());
	        userDTO.setPhone(createdUser.getPhone());
	        return userDTO;
	    }
}
