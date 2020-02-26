package com.br.userbook.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.br.userbook.model.Phone;
import com.br.userbook.model.User;

@Stateless
public class EJBUserDao implements UserDao {

	@Inject
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		try {
			List<User> listOfUser = entityManager.createQuery("FROM User").getResultList();
			return listOfUser;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public User getUser(long id) {
		User existingUser = entityManager.find(User.class, id);
		return existingUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User authUser(String email, String password) {
		try {
			List<User> existingUser = entityManager.createQuery("SELECT c FROM User c WHERE c.email = :email")
					.setParameter("email", email).getResultList();

			if (existingUser.get(0).getPassword().equals(password)) {
				return existingUser.get(0);
			} else {
				return null;
			}
			
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void createUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public void createPhone(Phone phones) {
		entityManager.persist(phones);
	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public void deleteUser(long id) {
		User existingUser = getUser(id);
		entityManager.remove(existingUser);
	}
}
