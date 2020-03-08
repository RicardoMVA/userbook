package com.br.userbook.ejb;

import java.util.List;

import javax.ejb.Local;

import com.br.userbook.model.Phone;
import com.br.userbook.model.User;

@Local
public interface UserDaoLocal {
	List<User> getUsers();

	User getUser(long id);

	User getUserByEmail(String email);

	Phone getPhoneByNumber(String number);

	User authUser(String email, String password);

	void createUser(User user);

	void updateUser(User user);

	void deleteUser(long id);

	void validateUserAndPhone(User user);
}
