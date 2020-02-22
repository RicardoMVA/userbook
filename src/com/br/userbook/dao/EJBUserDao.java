package com.br.userbook.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.br.userbook.model.Phone;
import com.br.userbook.model.User;

@Stateful
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

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }
    
    @Override
    public void createPhone(Phone phones) {
        entityManager.persist(phones);
    }   
}
