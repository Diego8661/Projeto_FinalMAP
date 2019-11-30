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
public class MensagensUtil {
    
    public static final Locale LOCALE_PT_BR = new Locale("pt", "BR");
    public static final Locale LOCALE_EN_US = new Locale("en", "US");
    public static final Locale LOCALE_ES_ES = new Locale("es", "ES");
    
    private static ResourceBundle resource = ResourceBundle.getBundle("mensagens", LOCALE_PT_BR);
    
    public static final String MSG_MENU_IDIOMA = "msg.menu.idioma";
    public static final String MSG_MENUITEM_PORTUGUES = "msg.menuItem.portugues";
    public static final String MSG_MENUITEM_INGLES = "msg.menuItem.ingles";
    public static final String MSG_MENUITEM_ESPANHOL = "msg.menuItem.espanhol";
    public static final String MSG_MENU_RELATORIO = "msg.menu.relatorio";
    public static final String MSG_MENUITEM_LISTA_PRODUTO = "msg.menuItem.listaProduto";
    public static final String MSG_MENUITEM_LISTA_PRODUTO_PRECO = "msg.menuItem.listaProdutoPreco";
    public static final String MSG_TITLE_PRODUTO_NOVO = "msg.title.produto.novo";
    public static final String MSG_TITLE_PRODUTO_EDITAR = "msg.title.produto.editar";
    public static final String MSG_TITLE_PRODUTOS = "msg.title.produtos";
    public static final String MSG_LABEL_NOME = "msg.label.nome";
    public static final String MSG_LABEL_PRECO = "msg.label.preco";
    public static final String MSG_LABEL_FABRICANTE = "msg.label.fabricante";
    public static final String MSG_LABEL_COR = "msg.label.cor";
    public static final String MSG_LABEL_SISTEMA = "msg.label.sistema";
    public static final String MSG_LABEL_DETALHE = "msg.label.detalhe";
    public static final String MSG_BUTTON_SALVAR = "msg.button.salvar";
    public static final String MSG_BUTTON_CANCELAR = "msg.button.cancelar";
    public static final String MSG_BUTTON_NOVO = "msg.button.novo";
    public static final String MSG_BUTTON_EDITAR = "msg.button.editar";
    public static final String MSG_BUTTON_EXCLUIR = "msg.button.excluir";
    public static final String MSG_BUTTON_SAIR = "msg.button.sair";
    public static final String MSG_TABELA_CODIGO = "msg.table.codigo";
    public static final String MSG_TABELA_NOME = "msg.table.nome";
    public static final String MSG_TABELA_PRECO = "msg.table.preco";
    public static final String MSG_TABELA_FABRICANTE = "msg.table.fabricante";
    public static final String MSG_TABELA_COR = "msg.table.cor";
    public static final String MSG_TABELA_SISTEMA = "msg.table.sistema";
    public static final String MSG_TABELA_DETALHE = "msg.table.detalhe";
    public static final String MSG_ERRO = "msg.erro";
    public static final String MSG_ERRO_INSERIR = "msg.erro.inserir";
    public static final String MSG_ERRO_EDITAR = "msg.erro.editar";
    public static final String MSG_ERRO_EXCLUIR = "msg.erro.excluir";
    public static final String MSG_ERRO_SELECIONAR = "msg.erro.selecionar"; 
    
    public static String getString(String key){
        return resource.getString(key);
    }
    
    public static void setLocale(Locale locale){
        resource = ResourceBundle.getBundle("mensagens", locale);
    }
}
