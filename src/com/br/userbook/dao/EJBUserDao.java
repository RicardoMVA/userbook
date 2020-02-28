package com.br.userbook.dao;

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
public class EJBUserDao implements UserDao {

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
			User checkIfEmailExists = getUserByEmail(user.getEmail());

			if (checkIfEmailExists != null) {
				throw new EJBException("This email is already in use.");
			} else {
				entityManager.persist(user);
			}

		} catch (ConstraintViolationException ex) {
			CustomConstraintException constEx = new CustomConstraintException(ex.getConstraintViolations());
			throw new EJBException(constEx.getMessage(), constEx);
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage(), ex);
		}
	}

	@Override
	public void createPhone(Phone phone) throws EJBException {
		try {
			Phone checkIfPhoneExists = getPhoneByNumber(phone.getNumber());

			if (checkIfPhoneExists != null) {
				throw new EJBException("The phone(s) must be unique.");
			} else {
				entityManager.persist(phone);
			}

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
//			'merge' doesn't run validations the same way as 'persist' does, so 
//			we instead validate data before calling 'merge', to ensure it doesn't write
//			invalid data in one of the tables
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

			User checkIfEmailExists = getUserByEmail(user.getEmail());
			Phone checkIfPhoneExists = null;
			
			for (int i = 0; i < user.getPhones().size(); i++) {
				checkIfPhoneExists = getPhoneByNumber(user.getPhones().get(i).getNumber());
				if (checkIfPhoneExists != null) {
					break;
				}
			}
			
			if (constraintViolations.size() > 0) {
				throw new CustomConstraintException("edit", constraintViolations);
			} else if (checkIfEmailExists != null) {
				throw new EJBException("This email is already in use.");
			} else if (checkIfPhoneExists != null) {
				throw new EJBException("The phone(s) must be unique.");
			} else {
				entityManager.merge(user);
			}
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
