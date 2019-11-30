/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map.exercicio2.model;

/**
 *
 * @author diego
 */
public class Especificacao {
    private int codigo_especificacao;
    private String fabricante;
    private String cor;
    private String sistema;
    private String detalhe;

  
    public int getCodigo() {
        return codigo_especificacao;
    }

    public void setCodigo(int codigo) {
        this.codigo_especificacao = codigo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhes) {
        this.detalhe = detalhes;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Cor: ")
                .append(cor)
                .append("\n")
                .append("Fabricante: ")
                .append(fabricante)
                .append("\n")
                .append("Sistema: ")
                .append(sistema)
                .append("\n")
                .append("Detalhe: ")
                .append(detalhe)
                .append("\n");
        
        return sb.toString();
    }
    
}
