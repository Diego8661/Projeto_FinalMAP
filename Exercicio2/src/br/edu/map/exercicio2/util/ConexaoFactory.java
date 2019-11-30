/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map.exercicio2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author diego
 */
public class ConexaoFactory {
    
    //private static final String URL = ConfiguracaoUtil.getString(ConfiguracaoUtil.URL);
    //private static final String USUARIO = "postgres";//ConfiguracaoUtil.getString(ConfiguracaoUtil.USUARIO);
    //private static final String SENHA = "admin";//ConfiguracaoUtil.getString(ConfiguracaoUtil.SENHA);
    
    public static Connection getConexao(){
        try{
            return DriverManager.getConnection(
                    ConfiguracaoUtil.getString(ConfiguracaoUtil.URL), 
                    ConfiguracaoUtil.getString(ConfiguracaoUtil.USUARIO), 
                    ConfiguracaoUtil.getString(ConfiguracaoUtil.SENHA));
        }catch(SQLException e){
            System.out.println(ConfiguracaoUtil.getString(ConfiguracaoUtil.ERRO) + e.getMessage());
            return null;
        }
    }
}
