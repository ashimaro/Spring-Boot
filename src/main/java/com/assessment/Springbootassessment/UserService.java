package com.assessment.Springbootassessment;

import java.util.Date;

public interface UserService {
	
	RegistrationResponse register(UserModel userModel);
	LoginResponse login(LoginModel loginModel);
	getProfileResponse getProfile(String token);
	void logout(UserModel user);
	void updateProfile( String userid,String username, Date timestamp);
}