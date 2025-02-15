/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.model.dao;

import jakarta.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 *
 * @author efbaro
 */
public class GenericDAO<PK, T> {
    
    protected EntityManager em;

    public GenericDAO(EntityManager em) {
        this.em = em;
    }
    
    public void create(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }
    
    public T retrieve(PK pk) {
        T entity = (T) em.find(getTypeClass(), pk);
        return entity;
    }
    
    public void update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }
    
    public void delete(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }
    
    public List<T> findAll() {
        List<T> entities;
        entities = em.createQuery("FROM " 
                + getTypeClass().getName()).getResultList();
        return entities;
    }
    
    private Class<?> getTypeClass() {
        // Esse método getTypeClass() está relacionado ao uso de tipos genéricos em Java.
        // Ele tenta obter o tipo genérico da classe superclasse da classe atual
        // que está sendo executada, mais especificamente, o segundo parâmetro de 
        // tipo genérico.
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
}
