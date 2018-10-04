/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gjaras.dao;

import com.gjaras.pojos.Usuario;
import com.gjaras.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO {

//GET
    public Usuario getUsuarioForAuth(Usuario usuario){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        Query q = s.createQuery("from Usuario where NOMBRE_USUARIO='"+usuario.getNombreUsuario()+"' and CLAVE='"+usuario.getClave()+"'");
        Usuario retorno = (Usuario)q.uniqueResult();
        s.flush();
        s.close();
        return retorno;
    }
    
    public Usuario getUsuarioForId(String rut){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx = s.beginTransaction();
        Query q = s.createQuery("from Usuario where NOMBRE_USUARIO='"+rut+"'");
        Usuario retorno = (Usuario)q.uniqueResult();
        s.flush();
        s.close();
        return retorno;
    }
    
    public String createUsuario(Usuario usu){
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        s.save(usu);
        s.getTransaction().commit();
        String result = s.getTransaction().getLocalStatus().name();
        s.flush();
        s.close();
        return result;
    }
    
//    public boolean createUsuario(Usuario usuario){
//        try{
//            Transaction tx =null;
//            Session s = HibernateUtil.getSessionFactory().openSession();
//            tx= s.beginTransaction();
//            s.save(usuario);
//            s.getTransaction().commit();
//            s.flush();
//            s.close();
//        }catch(Exception e){
//            return false;
//        }
//        return true;
//    } 
}

