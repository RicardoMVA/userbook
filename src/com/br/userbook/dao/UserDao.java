package com.br.userbook.dao;

import java.util.List;

import com.br.userbook.model.Phone;
import com.br.userbook.model.User;

public interface UserDao {
    List<User> getUsers();

    void createUser(User user);

	void createPhone(Phone phones);
}

