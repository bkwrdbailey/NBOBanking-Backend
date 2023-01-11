package com.NBOBanking.repositories;

import com.NBOBanking.models.UserDB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {

    private EntityManagerFactory emFactory;

    public UserDB getUserRecord(String username) {

        EntityManager em = emFactory.createEntityManager();
        UserDB userDB = em.createQuery("SELECT u FROM Users u WHERE u.username = :username", UserDB.class).getSingleResult();
        em.getTransaction().commit();

        em.close();
        emFactory.close();

        return new UserDB();
    }

    public UserDB createUserRecord(UserDB newUser) {

        EntityManager em = emFactory.createEntityManager();
        em.persist(newUser);
        em.getTransaction().commit();

        em.close();
        emFactory.close();

        return new UserDB();
    }

}
