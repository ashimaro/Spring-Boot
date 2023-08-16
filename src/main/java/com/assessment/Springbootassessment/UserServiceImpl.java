package com.assessment.Springbootassessment;

import java.util.Optional;
import java.util.Set;

import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import io.jsonwebtoken.security.Keys;
@Service
public class UserServiceImpl implements UserService {
	
@Autowired
private UserRepository userRepository;

private Set<UserModel> loggedInUsers = new HashSet<>();

	@Override
	public RegistrationResponse register(UserModel userModel) {
		
		UserEntity user = new UserEntity(
		 userModel.getUserid(),
		 userModel.getUsername(),
		 userModel.getPassword(),
		 userModel.getDisplayusername(),
		 userModel.getTimestamp()
		
		 );
		userRepository.save(user);
		
		RegistrationResponse response = new RegistrationResponse();
		response.setDisplayusername(user.getDisplayusername());
		response.setUserid(user.getUserid());
		return response;
		
	}
	  private static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000; // 24 hours in milliseconds
	  private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);    
	  
	@Override
	public LoginResponse login(LoginModel loginModel) {
	    String username = loginModel.getUsername();
	    String password = loginModel.getPassword();

	    Optional<UserEntity> userOpt = userRepository.findByUsername(username);

	  
	        UserEntity user = userOpt.get();
	        
	        if (user.getPassword().equals(password)) {
	            String token = generateJwtToken(user);
	            LoginResponse response = new LoginResponse();
	            response.setToken(token);
	            response.setDisplayusername(user.getDisplayusername());
	            response.setUserid(user.getUserid());
	            return response;
	        }else {
	    throw new RuntimeException("Invalid username or password");
	        }
	}
	private String generateJwtToken(UserEntity user) {
		return Jwts.builder()
	            .setSubject(user.getUserid().toString())
	            .claim("username", user.getUsername())
	            .setIssuedAt(new Date())
	            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
	            .signWith(SECRET_KEY)
	            .compact();
	}

	
	@Override
	public getProfileResponse  getProfile(String token) {
		
			  token = token.trim();

		        Jws<Claims> jwsClaims = Jwts.parserBuilder()
		                .setSigningKey(SECRET_KEY)
		                .build()
		                .parseClaimsJws(token);

	        String userid = jwsClaims.getBody().getSubject();
	        Optional<UserEntity> userEntityOpt = userRepository.findByUserid(userid);

	        if (userEntityOpt.isPresent()) {
	        	UserEntity user = userEntityOpt.get();
	        	getProfileResponse response = new getProfileResponse();
	        	response.setUsername(user.getUsername());
	        	response.setDisplayusername(user.getDisplayusername());
	        	response.setUserid(user.getUserid());
	        	
	            return response;
	        } else {
	        	 throw new RuntimeException("User not found");
	        }
	    } 
	@Override
	public void updateProfile(String token, String displayusername, Date timestamp) {
	    
	        token = token.trim();

	        Jws<Claims> jwsClaims = Jwts.parserBuilder()
	                .setSigningKey(SECRET_KEY)
	                .build()
	                .parseClaimsJws(token);
	        String userid = jwsClaims.getBody().getSubject();
	        Optional<UserEntity> optionalUserEntity = userRepository.findByUserid(userid);

	        if (optionalUserEntity.isPresent()) {
	            UserEntity userEntity = optionalUserEntity.get();
	            userEntity.setDisplayusername(displayusername);
	            userEntity.setTimestamp(timestamp);
	            userRepository.save(userEntity);
	        } else {
	        	 throw new RuntimeException("User not found");
	        }
	    }
	
	@Override
	public void logout(UserModel user) {
	        loggedInUsers.remove(user);

	}

}
