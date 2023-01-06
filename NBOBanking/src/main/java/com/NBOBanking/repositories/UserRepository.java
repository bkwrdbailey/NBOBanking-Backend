package com.NBOBanking.repositories;

import com.NBOBanking.models.UserDB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class UserRepository implements IUserRepository {

    private EntityManagerFactory emFactory;

    public UserDB getUserRecord(String username) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        emFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        EntityManager em = emFactory.createEntityManager();
        UserDB userDB = em.createQuery("SELECT u FROM Users u WHERE u.username = :username", UserDB.class).getSingleResult();
        em.getTransaction().commit();

        em.close();
        emFactory.close();

        return new UserDB();
    }

    public UserDB createUserRecord(UserDB newUser) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        emFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        EntityManager em = emFactory.createEntityManager();
        em.persist(newUser);
        em.getTransaction().commit();

        em.close();
        emFactory.close();

        return new UserDB();
    }

}
