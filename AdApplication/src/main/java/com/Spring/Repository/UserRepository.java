package com.Spring.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.Spring.Entity.Users;

@Component
public interface UserRepository extends JpaRepository<Users, Long> {
	
	List<Users> findByFirstName(String firstName);
	public List<Users> findBySessionId(String authToken);
	List<Users> findByOrderByFirstNameAsc();
	List<Users> findByOrderByFirstNameDesc();
}