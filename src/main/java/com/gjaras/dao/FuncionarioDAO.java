/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gjaras.dao;

import com.gjaras.pojos.Funcionario;
import com.gjaras.util.HibernateUtil;
import java.math.BigDecimal;
//import org.hibernate.Query;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FuncionarioDAO {

//GET
    public Funcionario getUsuarioFromRut(String rut){
        String ruts[] = rut.split("-");
        BigDecimal rutSinDv = new BigDecimal(ruts[0]);
        BigDecimal rutDv = new BigDecimal(ruts[1]);
        Transaction tx =null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tx= s.beginTransaction();
        Query q = s.createQuery("from Funcionario where RUN_SIN_DV='"+rutSinDv+"' and RUN_DV='"+rutDv+"'");
        Funcionario retorno = (Funcionario)q.uniqueResult();
        s.flush();
        s.close();
        return retorno;
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

