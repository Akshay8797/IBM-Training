package com.Spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Entity.Users;
import com.Spring.Json.User;
import com.Spring.Repository.UserRepository;
import com.Spring.Utils.UserUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User save(User user) {
		Users userEntity = userRepository.save(UserUtils.convertUserToUserEntity(user));
		return UserUtils.convertUserEntityToUser(userEntity);
	}

	public List<User> getAllUsers() {
		List<Users> userEntityList = userRepository.findAll();
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}

	public User getUserById(String id) {
		Users userEntity = userRepository.findById(Long.valueOf(id)).get();
		return UserUtils.convertUserEntityToUser(userEntity);
	}

	@Override
	public List<User> getUsersByFirstName(String firstName) {
		List<Users> userEntityList = userRepository.findByFirstName(firstName);
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}

	@Override
	public User update(User user, String id) {
		Users userEntity = userRepository.findById(Long.valueOf(id)).get();
		if (userEntity != null) {
			userEntity.setFirstName(user.getFirstName());
			userEntity.setUserName(user.getUserName());
			userEntity.setPassword(user.getPassword());
			userEntity = userRepository.save(userEntity);
			return UserUtils.convertUserEntityToUser(userEntity);
		}
		return null;
	}

	@Override
	public boolean delete(String id) {
		if (userRepository.existsById(Long.valueOf(id))) {
			userRepository.deleteById(Long.valueOf(id));
			return true;
		}
		return false;
	}

	@Override
	public List<User> getUsersByOrderByFirstNameAsc() {
		List<Users> userEntityList = userRepository.findByOrderByFirstNameAsc();
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}

	@Override
	public List<User> getUsersByOrderByFirstNameDesc() {
		List<Users> userEntityList = userRepository.findByOrderByFirstNameDesc();
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}

	@Override
	public List<User> findBySessionId(String authToken) {
		return null;
	}
}