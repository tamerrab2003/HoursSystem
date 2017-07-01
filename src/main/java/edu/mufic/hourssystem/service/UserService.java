package edu.mufic.hourssystem.service;

import java.util.List;

import edu.mufic.hourssystem.dao.entity.User;

public interface UserService {

	public User findUserByEmail(String email);

	User findById(Long id);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserById(Long id);

	void deleteAllUsers();

	List<User> findAllUsers();

	boolean isUserExist(User user);

}
