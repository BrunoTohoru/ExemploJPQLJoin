/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.model.dao;

import br.edu.ifpr.model.bean.Noticia;
import br.edu.ifpr.model.util.PersistenceUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author efbaro
 */
public class NoticiaDAO extends GenericDAO<Integer, Noticia>{
    
    public NoticiaDAO(EntityManager em) {
        super(em);
    }

    public NoticiaDAO() {
        super(PersistenceUtil.getEntityManager());
    }
    
    public List<Noticia> getNoticiasComComentario() {
        return em.createQuery("SELECT n FROM Noticia n INNER JOIN n.comentarios c", Noticia.class).getResultList();
    }
    
    public List<Noticia> getNoticiasTecnologiaComComentario(String texto) {
        return em.createQuery("SELECT DISTINCT n FROM Noticia n LEFT JOIN n.comentarios c " + "WHERE n.conteudo LIKE :texto " + "AND EXISTS (SELECT 1 FROM Comentario cm WHERE cm.noticia = n)", Noticia.class).setParameter("texto", "%" + texto + "%").getResultList();
    }
    
}
