package com.Spring.Service;

import java.util.List;

import com.Spring.Json.User;

public interface UserService {
	public List<User> getAllUsers();

	public User getUserById(String id);

	public List<User> getUsersByFirstName(String firstName);

	public User save(User user);

	public User update(User user, String id);

	public boolean delete(String id);

	public List<User> findBySessionId(String authToken);

	public static boolean isValid(String authToken) {
		return false;
	}

	public List<User> getUsersByOrderByFirstNameAsc();

	public List<User> getUsersByOrderByFirstNameDesc();
}