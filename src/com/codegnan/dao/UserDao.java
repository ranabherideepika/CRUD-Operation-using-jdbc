package com.codegnan.dao;

import java.util.List;

import com.codegnan.entity.User;

public interface UserDao {
	public void addUser(User user);  // to add user
	public User getUserById(int id); // to get user by id
	public List<User> getAllUsers(); // to get all users
	public void updateUser(User user); // to update users data
	public void deleteUser(int id); // to delete data by id
}
