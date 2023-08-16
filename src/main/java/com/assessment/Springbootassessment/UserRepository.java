package com.assessment.Springbootassessment;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

	 Optional<UserEntity> findByUsername(String username);
	 UserModel findByTimestamp(Date date);
	 Optional<UserEntity> findByUserid(String userid);
	 
	}