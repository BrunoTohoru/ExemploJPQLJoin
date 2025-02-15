/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.model.dao;

import br.edu.ifpr.model.bean.Cliente;
import br.edu.ifpr.model.util.PersistenceUtil;
import jakarta.persistence.EntityManager;

/**
 *
 * @author efbaro
 */
public class ClienteDAO extends GenericDAO<Integer, Cliente>{
    
    public ClienteDAO(EntityManager em) {
        super(em);
    }

    public ClienteDAO() {
        super(PersistenceUtil.getEntityManager());
    }
    
    
}
