package com.NBOBanking.repositories;

import com.NBOBanking.Entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {

    private EntityManagerFactory emFactory;

    public User getUserRecord(String username) {

        EntityManager em = emFactory.createEntityManager();
        User userDB = em.createQuery("SELECT u FROM Users u WHERE u.username = :username", User.class).getSingleResult();
        em.getTransaction().commit();

        em.close();
        emFactory.close();

        return new User();
    }

    public User createUserRecord(User newUser) {

        EntityManager em = emFactory.createEntityManager();
        em.persist(newUser);
        em.getTransaction().commit();

        em.close();
        emFactory.close();

        return new User();
    }

}
