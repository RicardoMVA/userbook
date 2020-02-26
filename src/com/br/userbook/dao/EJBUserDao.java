package com.br.userbook.dao;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.validation.ConstraintViolationException;

import com.br.userbook.exception.CustomConstraintException;
import com.br.userbook.model.Phone;
import com.br.userbook.model.User;

@Stateless
public class EJBUserDao implements UserDao {

	@Inject
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() throws EJBException {
		try {
			List<User> listOfUser = entityManager.createQuery("FROM User").getResultList();
			return listOfUser;
		} catch (NoResultException ex) {
			throw new EJBException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage(), ex);
		}
	}

	@Override
	public User getUser(long id) throws EJBException {
		try {
			User existingUser = entityManager.find(User.class, id);
			return existingUser;
		} catch (NoResultException ex) {
			throw new EJBException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage(), ex);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public User authUser(String email, String password) throws EJBException {
		try {
			List<User> existingUser = entityManager.createQuery("SELECT c FROM User c WHERE c.email = :email")
					.setParameter("email", email).getResultList();

			if (existingUser.get(0).getPassword().equals(password)) {
				return existingUser.get(0);
			} else {
				return null;
			}

		} catch (NoResultException ex) {
			throw new EJBException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage(), ex);
		}
	}

	@Override
	public void createUser(User user) throws EJBException {
		try {
			entityManager.persist(user);
		} catch (ConstraintViolationException ex) {
			CustomConstraintException constEx = new CustomConstraintException(ex.getConstraintViolations());
			throw new EJBException(constEx.getMessage(), constEx);
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage(), ex);
		}
	}

	@Override
	public void createPhone(Phone phones) throws EJBException {
		try {
			entityManager.persist(phones);
		} catch (ConstraintViolationException ex) {
			CustomConstraintException constEx = new CustomConstraintException(ex.getConstraintViolations());
			throw new EJBException(constEx.getMessage(), constEx);
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage(), ex);
		}
	}

	@Override
	public void updateUser(User user) throws EJBException {
		try {
			entityManager.merge(user);
		} catch (ConstraintViolationException ex) {
			CustomConstraintException constEx = new CustomConstraintException(ex.getConstraintViolations());
			throw new EJBException(constEx.getMessage(), constEx);
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage(), ex);
		}
	}

	@Override
	public void deleteUser(long id) throws EJBException {
		try {
			User existingUser = getUser(id);
			entityManager.remove(existingUser);
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage(), ex);
		}
	}
}
