/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map.exercicio2.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author diego
 */
public class ConfiguracaoUtil {
    
    private static final ResourceBundle resource = ResourceBundle.getBundle("conf");
    
    public static final String URL = "conf.jdbc.url";
    public static final String USUARIO = "conf.jdbc.usuario";
    public static final String SENHA = "conf.jdbc.senha";
    public static final String ERRO = "conf.jdbc.erro";

   public static String getString(String key) {
       return resource.getString(key);
   }
}
