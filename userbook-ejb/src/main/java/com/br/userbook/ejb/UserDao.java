package com.br.userbook.ejb;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.br.userbook.exception.CustomConstraintException;
import com.br.userbook.model.Phone;
import com.br.userbook.model.User;

@Stateless
public class UserDao implements UserDaoLocal {
	
	@Inject
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() throws EJBException {
		try {
			List<User> listOfUser = entityManager.createQuery("FROM User").getResultList();
			return listOfUser;
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage(), ex);
		}
	}

	@Override
	public User getUser(long id) throws EJBException {
		try {
			User existingUser = entityManager.find(User.class, id);
			return existingUser;
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage(), ex);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByEmail(String email) throws EJBException {
		try {
			List<User> existingUser = entityManager.createQuery("SELECT c FROM User c WHERE c.email = :email")
					.setParameter("email", email).getResultList();

			if (existingUser.size() > 0) {
				return existingUser.get(0);
			} else {
				return null;
			}

		} catch (Exception ex) {
			throw new EJBException(ex.getMessage(), ex);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Phone getPhoneByNumber(String number) throws EJBException {
		try {
			List<Phone> existingPhone = entityManager.createQuery("SELECT c FROM Phone c WHERE c.number = :number")
					.setParameter("number", number).getResultList();

			if (existingPhone.size() > 0) {
				return existingPhone.get(0);
			} else {
				return null;
			}

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

			if (existingUser.size() > 0) {
				if (existingUser.get(0).getPassword().equals(password)) {
					return existingUser.get(0);
				} else {
					return null;
				}
			} else {
				return null;
			}

		} catch (Exception ex) {
			throw new EJBException(ex.getMessage(), ex);
		}
	}

	@Override
	public void createUser(User user) throws EJBException {
		try {
			validateUserAndPhone(user);
			entityManager.persist(user);
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
			validateUserAndPhone(user);
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

	@Override
	public void validateUserAndPhone(User user) throws EJBException {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<User>> userConstraintViolations = validator.validate(user);
		Set<ConstraintViolation<Phone>> phoneConstraintViolations = new HashSet<>();

		User existingUser = getUserByEmail(user.getEmail());
		if (existingUser != null) {
			if (existingUser.getId() != user.getId()) {
				throw new EJBException("This email is already in use.");
			}
		}

		for (int i = 0; i < user.getPhones().size(); i++) {
			phoneConstraintViolations.addAll(validator.validate(user.getPhones().get(i)));

			Phone existingPhone = getPhoneByNumber(user.getPhones().get(i).getNumber());
			if (existingPhone != null) {
				if (existingPhone.getUser().getId() != user.getId()) {
					throw new EJBException("The phone(s) must be unique.");
				}
			}
		}

		if (userConstraintViolations.size() > 0) {
			throw new CustomConstraintException("hi", userConstraintViolations);
		} else if (phoneConstraintViolations.size() > 0) {
			throw new CustomConstraintException(phoneConstraintViolations, "hi");
		} else {
			return;
		}
	}
}
