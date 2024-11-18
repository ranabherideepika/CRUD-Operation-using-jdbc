package com.codegnan.dao;
import java.util.List;
import java.util.Scanner;

import com.codegnan.entity.User;

public class Main {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/adjava";
		String user = "root";
		String password = "Deepika@21";
		Scanner scanner = new Scanner(System.in);
		UserDao userDao = new UserDaoImpl(url, user, password);
		while (true) {
			System.out.println("choose operation ");
			System.out.println("===================================================");
			System.out.println("1.Add user");
			System.out.println("2.view user by Id");
			System.out.println("3.view all users");
			System.out.println("4.update user");
			System.out.println("5.delete user");
			System.out.println("6.Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addUser(userDao);
				break;
			case 2:
				viewUserById(userDao);
				break;
			case 3:
				viewAllUsers(userDao);
				break;
			case 4:
				updateUser(userDao);
				break;
			case 5:
				deleteUser(userDao);
				break;
			case 6:
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice");
			}

		}

	}

	public static void addUser(UserDao userDao) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter name: ");
		String name = scanner.nextLine();
		System.out.println("enter email: ");
		String email = scanner.nextLine();
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		userDao.addUser(user);
		System.out.println("user added successfully");

	}

	public static void viewUserById(UserDao userDao) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter userId: ");
		int id = scanner.nextInt();
		User user = userDao.getUserById(id);
		if (user != null) {
			System.out.println("user found: ");
			System.out.println("Id: " + user.getId());
			System.out.println("name: " + user.getName());
			System.out.println("email: " + user.getEmail());
		} else {
			System.out.println("user not found");
		}

	}

	public static void viewAllUsers(UserDao userDao) {
		List<User> users = userDao.getAllUsers();
		System.out.println("All users: ");
		for (User user : users) {
			System.out.println("Id: " + user.getId() + ", name" + user.getName() + ",Email" + user.getEmail());

		}
	}

	private static void updateUser(UserDao userDao) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter user id");
		int id = scanner.nextInt();
		User existingUser = userDao.getUserById(id);
		if (existingUser != null) {
			System.out.println("enter new name: ");
			String name = scanner.next();
			System.out.println("enter new email: ");
			String email = scanner.next();
			existingUser.setName(name);
			existingUser.setEmail(email);
			userDao.updateUser(existingUser);

			System.out.println("User updated successfully");

		} else {
			System.out.println("user not found with id: " + id);
		}
	}

	private static void deleteUser(UserDao userDao) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter user id: ");
		int id = scanner.nextInt();
		User existingUser = userDao.getUserById(id);
		if (existingUser != null) {
			userDao.deleteUser(id);
			System.out.println("user deleted successfully ");

		} else {
			System.out.println("user not found with id is: " + id);
		}

	}

}
