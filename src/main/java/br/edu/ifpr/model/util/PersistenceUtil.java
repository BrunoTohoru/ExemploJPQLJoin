/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.model.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Aluno
 */
public class PersistenceUtil {
    
    private static final EntityManagerFactory factory 
            = Persistence.createEntityManagerFactory("ifpr_db");
    
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
    
    public static void stopSessionFactory() {
        factory.close();
    }
    
}
