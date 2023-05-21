package com.example.symphony.repository;

import com.example.symphony.misc.EntityManagerProvider;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

public class BasicRepositoryImpl<T, ID> implements BasicRepository<T, ID>{

    protected EntityManager entityManager;

    private final Class<T> entityClass;

    BasicRepositoryImpl(Class<T> entityClass){
        this.entityClass = entityClass;
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    @Override
    public T findById(ID id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass)
                .getResultList();
    }

    @Override
    public void save(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(T entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    @Transactional
    public void deleteById(ID id) {
        T entity = entityManager.find(entityClass, id);
        if (entity != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        }
    }

    public void refresh(T entity){
        entityManager.refresh(entity);
    }
}
