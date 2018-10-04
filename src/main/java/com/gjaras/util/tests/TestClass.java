/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gjaras.util.tests;

import com.gjaras.dao.FuncionarioDAO;
import com.gjaras.dao.UsuarioDAO;
import com.gjaras.pojos.Funcionario;
import com.gjaras.pojos.Usuario;

/**
 *
 * @author gabriel.jara
 */
public class TestClass {
    public static void main(String[] args){
        FuncionarioDAO fdao = new FuncionarioDAO();
        Funcionario func = fdao.getUsuarioFromRut("16976780-7");
        System.out.println(func.toString());
        UsuarioDAO udao = new UsuarioDAO();
        Usuario newUsu = new Usuario(func, "admin", "pass", "admin");
        String result = udao.createUsuario(newUsu);
        System.out.println(result);
    }
}
