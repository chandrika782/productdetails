package com.analytics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.analytics.model.UserDetails;
import java.lang.String;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer>{

	List<UserDetails> findByUserNameAndPassword(String userName,String password);
	
}
