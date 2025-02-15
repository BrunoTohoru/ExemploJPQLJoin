/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.model.dao;

import br.edu.ifpr.model.bean.Produto;
import br.edu.ifpr.model.util.PersistenceUtil;
import jakarta.persistence.EntityManager;

/**
 *
 * @author efbaro
 */
public class ProdutoDAO extends GenericDAO<Integer, Produto>{
    
    public ProdutoDAO(EntityManager em) {
        super(em);
    }

    public ProdutoDAO() {
        super(PersistenceUtil.getEntityManager());
    }
    
    
    
}
