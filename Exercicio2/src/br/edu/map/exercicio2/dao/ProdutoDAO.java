/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map.exercicio2.dao;

import br.edu.map.exercicio2.model.Especificacao;
import br.edu.map.exercicio2.util.ConexaoFactory;
import br.edu.map.exercicio2.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 *
 * @author diego
 */
public class ProdutoDAO {
    private Connection con;
    private String sql;
    private PreparedStatement st;
    private ResultSet rs;
    
    public void inserir(Produto produto) throws SQLException{
        con = ConexaoFactory.getConexao();
        
        //inserir especificação
        
        sql = "insert into especificacao (fabricante, cor, sistema, detalhe) values(?,?,?,?)";
        
        st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        
        st.setString(1, produto.getEsp().getFabricante());
        st.setString(2, produto.getEsp().getCor());
        st.setString(3, produto.getEsp().getSistema());
        st.setString(4, produto.getEsp().getDetalhe());
        
        st.executeUpdate();
        
        rs = st.getGeneratedKeys();
        
        int codigoEspecificacao = 0;
        
        if(rs.next()){
            codigoEspecificacao = rs.getInt(1);
        }
        
        sql = "insert into produto (nome, preco, codico_especificacao) values(?,?,?)";
        
        st = con.prepareStatement(sql);
        
        st.setString(1, produto.getNome());
        st.setFloat(2, produto.getPreco());
        st.setInt(3, codigoEspecificacao);
        
        
        st.executeUpdate();
        
        con.close();
    }
    
    public void editar(Produto produto) throws SQLException{
        con = ConexaoFactory.getConexao();
        
        sql = "update produto set nome = ?, preco = ? where produto.codico_especificacao = ?;"
                + "update especificacao set cor = ?, fabricante = ?, sistema = ?, detalhe = ? where especificacao.codigo = ?";
        
        st = con.prepareStatement(sql);
        
        st.setString(1, produto.getNome());
        st.setFloat(2, produto.getPreco());
        st.setInt(3, produto.getCodigo());
        st.setString(4, produto.getEsp().getCor());
        st.setString(5, produto.getEsp().getFabricante());
        st.setString(6, produto.getEsp().getSistema());
        st.setString(7, produto.getEsp().getDetalhe());
        st.setInt(8, produto.getEsp().getCodigo());
        
        st.executeUpdate();
        
        con.close();
        
    }
    
    public Produto buscar(int codigo) throws SQLException{
        Produto p = null;
        
        con = ConexaoFactory.getConexao();
        
        sql = "select p.*, e.* from produto p, especificacao e "
        + "where p.codigo = ? and p.codico_especificacao = e.codigo";
        
        st = con.prepareStatement(sql);
        
        st.setInt(1, codigo);
        
        ResultSet rs = st.executeQuery();
        
        if(rs.next()){
            String nome = rs.getString("nome");
            float preco = rs.getFloat("preco");
            String cor = rs.getString("cor");
            String fabricante = rs.getString("fabricante");
            String sistema = rs.getString("sistema");
            String detalhe = rs.getString("detalhe");
            
            p = new Produto();
            p.setCodigo(codigo);
            p.getEsp().setCodigo(codigo);
            p.setNome(nome);
            p.setPreco(preco);
            p.getEsp().setCor(cor);
            p.getEsp().setFabricante(fabricante);
            p.getEsp().setSistema(sistema);
            p.getEsp().setDetalhe(detalhe);
        }
        con.close();
        return p;
    }
    
    public List<Produto> exibir() throws Exception{
        List<Produto> lista = new ArrayList<>();
        con = ConexaoFactory.getConexao();
        
        sql = "select pro.*, es.* from produto pro, especificacao es where pro.codico_especificacao = es.codigo";
        st = con.prepareStatement(sql);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()){
            int codigo = rs.getInt(1);
            String nome = rs.getString("nome");
            float preco = rs.getFloat("preco");
            String fabricante = rs.getString("fabricante");
            String cor = rs.getString("cor");
            String sistema = rs.getString("sistema");
            String detalhe = rs.getString("detalhe");
            
            Produto p = new Produto();
            //p.setEsp(new Especificacao());
            
            p.setCodigo(codigo);
            p.setNome(nome);
            p.setPreco(preco);
            p.getEsp().setFabricante(fabricante);
            p.getEsp().setCor(cor);
            p.getEsp().setSistema(sistema);
            p.getEsp().setDetalhe(detalhe);
            
            lista.add(p);
        }
        con.close();
        return lista;
    }
    
    public List<Produto> buscar(String query) throws SQLException{
        List<Produto> lista = new ArrayList<>();
        con = ConexaoFactory.getConexao();
        
        sql = "select pro.*, es.* from produto pro, especificacao es where pro.codico_especificacao = es.codigo and pro.nome ilike ?";
        st = con.prepareStatement(sql);
        st.setString(1, query + '%');
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()){
            int codigo = rs.getInt(1);
            String nome = rs.getString("nome");
            float preco = rs.getFloat("preco");
            String cor = rs.getString("cor");
            String fabricante = rs.getString("fabricante");
            String sistema = rs.getString("sistema");
            String detalhe = rs.getString("detalhe");
            
            Produto p = new Produto();
            
            p.setCodigo(codigo);
            p.setNome(nome);
            p.setPreco(preco);
            p.getEsp().setCor(cor);
            p.getEsp().setFabricante(fabricante);
            p.getEsp().setSistema(sistema);
            p.getEsp().setDetalhe(detalhe);
            
            lista.add(p);
        }
        con.close();
        return lista;
    }
    
    public void remover(Produto produtos) throws SQLException{
        con = ConexaoFactory.getConexao();
        
        sql = "delete from produto where produto.codico_especificacao = ?;"
                + "delete from especificacao where especificacao.codigo = ?";
        
        st = con.prepareStatement(sql);
        
        st.setInt(1, produtos.getCodigo());
        st.setInt(2, produtos.getEsp().getCodigo());
        
        st.executeUpdate();
        
        con.close();
    }
    public List<Produto> listarPreco() throws Exception{
        List<Produto> lista = new ArrayList<>();
        
        con = ConexaoFactory.getConexao();
        
        sql = "select * from produto where produto.preco < 1000";
        
        st = con.prepareStatement(sql);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()){
            int codigo = rs.getInt(1);
            String nome = rs.getString("nome");
            float preco = rs.getFloat("preco");
            /*String fabricante = rs.getString("fabricante");
            String cor = rs.getString("cor");
            String sistema = rs.getString("sistema");
            String detalhe = rs.getString("detalhe");*/
            
            Produto p = new Produto();
            //p.setEsp(new Especificacao());
            
            p.setCodigo(codigo);
            p.setNome(nome);
            p.setPreco(preco);
            /*p.getEsp().setFabricante(fabricante);
            p.getEsp().setCor(cor);
            p.getEsp().setSistema(sistema);
            p.getEsp().setDetalhe(detalhe);*/
            
            lista.add(p);
        }
        con.close();
        return lista;
    }
}
