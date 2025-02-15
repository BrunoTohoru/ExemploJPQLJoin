/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.test;

import br.edu.ifpr.model.bean.Cliente;
import br.edu.ifpr.model.bean.Comentario;
import br.edu.ifpr.model.bean.Noticia;
import br.edu.ifpr.model.dao.ClienteDAO;
import br.edu.ifpr.model.dao.ComentarioDAO;
import br.edu.ifpr.model.dao.NoticiaDAO;
import java.util.List;

/**
 *
 * @author efbaro
 */
public class Teste {
    
    
    public static void main(String[] args) {
        
        NoticiaDAO daoNoticia = new NoticiaDAO();
        
        
        ComentarioDAO daoComentario = new ComentarioDAO();
        Noticia n1 = new Noticia();
        n1.setTexto("descricao noticia 1");
        daoNoticia.create(n1);
        
        Noticia n2 = new Noticia();
        n2.setTexto("descricao noticia 2");
        daoNoticia.create(n2);
        
        Comentario com1 = new Comentario();
        com1.setNoticia(n1);
        com1.setTexto("comentario 1 da noticia 1");
        
        Comentario com2 = new Comentario();
        com2.setNoticia(n1);
        com2.setTexto("comentario 2 da noticia 1");
        
        Comentario com3 = new Comentario();
        com3.setNoticia(n2);
        com3.setTexto("comentario 1 da noticia 2");
        
        daoComentario.create(com1);
        daoComentario.create(com2);
        daoComentario.create(com3);
        
        
        List<Noticia> noticias = daoNoticia.getNoticiasComComentario();
        System.out.println(noticias.size());
        
        for (Noticia noticia : noticias) {
            System.out.println(noticia);
        }
        
    }
}
