/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map.exercicio2.util;

import br.edu.map.exercicio2.model.Produto;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author diego
 */
public class RelatorioManager {
    public static String path = RelatorioManager.class.getClassLoader().getResource("").getPath() + "/jasper";
    
    public static JasperPrint gerarRelatorioProduto(List<Produto> Produtos) throws JRException{
        JasperReport report = JasperCompileManager.compileReport(path + "/produtosLista.jrxml");
        
        return JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(Produtos));
    }
    
    public static JasperPrint gerarRelatorioProdutoPreco(List<Produto> Produto) throws JRException{
        JasperReport report = JasperCompileManager.compileReport(path + "/produtosPreco.jrxml");
        
        return JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(Produto));
    }
    
}
