package com.assessment.Springbootassessment;
import org.springframework.data.domain.Page;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController
@CrossOrigin
@RequestMapping("api")


public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	CarDao cardao;
	
	@PostMapping(path="/register")
	public RegistrationResponse registerUser(@RequestBody UserModel user ) {
		
		if (user == null || user.getUsername() == null || user.getPassword() == null || user.getDisplayusername() == null || user.getTimestamp()== null) {
            throw new Exception();
        }else {
		return userService.register(user);
        }
	}
	
	
	 @PostMapping(path = "/session/login")
	    public LoginResponse loginUser(@RequestBody LoginModel loginModel)
	    {
		 if (loginModel == null || loginModel.getUsername()== null || loginModel.getPassword()== null) {
			 throw new Exception();
		 }else {
		 return userService.login(loginModel);
		 }
	    }
	 
	 @PostMapping(path ="/session/logout")
	 public ResponseEntity<String> logoutUser(@RequestBody UserModel user) {
		 if(user== null || user.getTimestamp()==null) {
			 throw new Exception();
		 }else {
	        userService.logout(user);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
	 }
	 
	 @GetMapping("/getprofile")
	 public getProfileResponse  getProfile(@RequestHeader("Authorization") String authorizationHeader) {
	     String token = authorizationHeader.replace("Bearer ", ""); // Remove "Bearer " prefix
	     if (token==null) {
	    	 throw new Exception();
	     }else {
	     return userService.getProfile(token);
	     }
	 }

	 @PostMapping(path = "/updateprofile")
	    public ResponseEntity<String> updateProfile(@RequestHeader("Authorization") String authorizationHeader,
	                                                @RequestBody UpdateProfileRequest request) {
	        String token = authorizationHeader.replace("Bearer ", ""); // Remove "Bearer " prefix

	        if (token == null) {
	        	 throw new Exception();
	            
	        } else {
	        	 userService.updateProfile(token, request.getDisplayusername(), request.getTimestamp());
	              return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	        }}
	 
	@PostMapping("/carlist")
		 public Page<CarObject> getCarList(@RequestHeader("Authorization") String authorizationHeader,@RequestBody CarSearchRequest searchCar){
			 String token = authorizationHeader.replace("Bearer ", ""); // Remove "Bearer " prefix

		        if (token == null) {
		        	 throw new Exception();
		            
		        } else {
			
			return cardao.paginationCar(searchCar.getPageindex(),searchCar.getPagesize());
		 } 
		}
	}

