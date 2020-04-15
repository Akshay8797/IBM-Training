package com.Spring.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.Spring.Entity.Users;
import com.Spring.Json.User;

public class UserUtils {

	public static List<User> convertUserEntityListToUserList(List<Users> userEntityList) {
		List<User> userList = new ArrayList<User>();
		Consumer<Users> consumer = (Users userEntity) -> userList.add(convertUserEntityToUser(userEntity));
		userEntityList.stream().forEach(consumer);
		return userList;
	}

	public static User convertUserEntityToUser(Users user) {
		return new User(user.getId(), user.getUserName(), user.getFirstName(), user.getPassword());
	}

	public static Users convertUserToUserEntity(User user) {
		return new Users(user.getUserName(), user.getFirstName(), user.getPassword());
	}
}
