package com.example.symphony.misc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class EntityManagerProvider{
    private static final String PERSISTENCE_UNIT_NAME = "theatres";
    private static EntityManagerFactory entityManagerFactory;

    public static synchronized EntityManager getEntityManager(){
        if(entityManagerFactory == null){
            entityManagerFactory = createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return entityManagerFactory.createEntityManager();
    }
}
