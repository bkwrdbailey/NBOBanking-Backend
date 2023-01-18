package com.NBOBanking.repositories;

import com.NBOBanking.Entities.User;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {
        @Autowired
        private EntityManager em;

    public User getUserRecord(String username) {

        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);

        query.setParameter("username", username);

        try {
            User checkUser = query.getSingleResult();

            em.close();

            return checkUser;

        } catch(NoResultException ex) {
            em.close();

            return new User();
        }
    }


    public User createUserRecord(User newUser) {

        try {
            em.getTransaction().begin();
            em.persist(newUser);
            em.getTransaction().commit();

            em.close();

            return getUserRecord(newUser.username);

        } catch (EntityExistsException ex) {
            em.close();

            return new User();
        }
    }

}
