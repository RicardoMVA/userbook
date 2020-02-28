package com.br.userbook.dao;

import java.util.List;

import com.br.userbook.model.Phone;
import com.br.userbook.model.User;

public interface UserDao {
	List<User> getUsers();

	User getUser(long id);

	User getUserByEmail(String email);

	Phone getPhoneByNumber(String number);

	User authUser(String email, String password);

	void createUser(User user);

	void createPhone(Phone phones);

	void updateUser(User user);

	void deleteUser(long id);
}
