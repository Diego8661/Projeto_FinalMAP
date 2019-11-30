/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map.exercicio2.view;

import br.edu.map.exercicio2.model.Produto;
import br.edu.map.exercicio2.dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Exercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, Exception {
        // TODO code application logic here
        Scanner ler = new Scanner(System.in);
        String op; //op = opção
        Produto pro;
        ProdutoDAO dao = new ProdutoDAO();
        
        menu();
        System.out.println("Digite: ");
        op = ler.nextLine();
        
        do{         
            if(op.equals("1")){
                System.out.println("-----CADASTRAR PRODUTO-----");
                
                pro = new Produto();
                
                System.out.println("Nome: ");
                pro.setNome(ler.nextLine());
                System.out.println("Preco: ");
                pro.setPreco(Float.parseFloat(ler.nextLine()));
                System.out.println("Fabricante: ");
                pro.getEsp().setFabricante(ler.nextLine());
                System.out.println("Cor: ");
                pro.getEsp().setCor(ler.nextLine());
                System.out.println("Sistema: ");
                pro.getEsp().setSistema(ler.nextLine());
                System.out.println("Detalhe: ");
                pro.getEsp().setDetalhe(ler.nextLine());
                
                dao.inserir(pro);
                
                System.out.println("Registro salvo com SUCESSO!"); 
                
            }
            else if(op.equals("2")){
                System.out.println("----------Consultar Produtos----------");
                
                List<Produto> produtos = dao.exibir();
                
                for(Produto p : produtos){
                    System.out.println(p);
                }
            }
            else if(op.equals("3")){
                System.out.println("----------Consultar Produtos por Codigo----------");
                
                System.out.println("Digite o codigo: ");
                Produto p = dao.buscar(Integer.parseInt(ler.nextLine()));
                
                if(p != null){
                   System.out.println(p); 
                }
                else{
                    System.out.println("Registro nao ENCONTRADO!"); 
                }       
            }
            else if(op.equals("4")){
                System.out.println("----------Editar----------");
                
                System.out.println("Informe o codigo: ");
                int cod = Integer.parseInt(ler.nextLine());
                
                pro = dao.buscar(cod);
                
                if(pro != null){
                    System.out.println("-----Dados atuais-----\n" + pro);
                    
                    System.out.println("Novo nome: ");
                    String novo_nome = ler.nextLine();
                    pro.setNome((novo_nome.equals("")) ? pro.getNome() : novo_nome);
                    
                    System.out.println("Novo preco: ");
                    String novo_preco = ler.nextLine();
                    pro.setPreco((novo_preco.equals("")) ? pro.getPreco() : Float.parseFloat(novo_preco));
                    
                    System.out.println("Nova cor: ");
                    String nova_cor = ler.nextLine();
                    pro.getEsp().setCor((nova_cor.equals("")) ? pro.getEsp().getCor() : nova_cor);
                    
                    System.out.println("Novo fabricante: ");
                    String novo_fabricante = ler.nextLine();
                    pro.getEsp().setFabricante(novo_fabricante.equals("") ? pro.getEsp().getFabricante() : novo_fabricante);
                    
                    System.out.println("Novo sistema: ");
                    String novo_sistema = ler.nextLine();
                    pro.getEsp().setSistema(novo_sistema.equals("") ? pro.getEsp().getSistema() : novo_sistema);
                    
                    System.out.println("Novo detalhe: ");
                    String novo_detalhe = ler.nextLine();
                    pro.getEsp().setDetalhe(novo_detalhe.equals("") ? pro.getEsp().getDetalhe() : novo_detalhe);
                    
                    dao.editar(pro);
                    System.out.println("Registro atualizado com SUCESSO!");
                }else{
                    System.out.println("Registro nao encontrado!");
                }
            }
            else if(op.equals("5")){
                System.out.println("----------Remover----------");
                
                System.out.println("Informe o codigo: ");
                int codigo = Integer.parseInt(ler.nextLine());
                
                pro = dao.buscar(codigo);
                
                if(pro != null){
                    dao.remover(pro);
                    System.out.println("Registro removido com SUCESSO!");
                }
                else{
                    System.out.println("Registro nao encontrado!");
                }
            }
            else{
                System.out.println("Opcao Invalida!");
            }
            menu();
            System.out.println("Digite: ");
            op = ler.nextLine();
        }while(!op.equals("0"));
        
    }
    
    public static void menu(){
        System.out.println("----------Menu----------");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Consultar Produtos");
        System.out.println("3 - Consultar por Codigo");
        System.out.println("4 - Editar");
        System.out.println("5 - Remover");
        System.out.println("0 - Sair");
        System.out.println("------------------------");
    }
    
}
