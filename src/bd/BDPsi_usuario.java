/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;
import classes.*;
import interfaces.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Maria Heloisa Souza
 */
public class BDPsi_usuario 
{
   Connection conexao = null; // gerencia a conexão
   Statement comando = null; // instrução de consulta
   public String condicao = null;
   public String global;
   
   //Metodo insere usuarios
   public boolean insereMensagem(Psicologo_usuario p)
   {
       boolean resp =true; // variável de retorno 
       try
       {
           conectar(); // abrir conexão com o banco de dados
           // criar e executar a consulta ao banco de dados
          
           comando.executeUpdate
                  (
                   "INSERT INTO aluno_psicologo (link_aluno,link_psi,mensagem,nome) " +
                   "VALUES " +
                   "("+p.getLink_aluno()+","+p.getLink_psi()+",'"+p.getMensagem()+"','"+p.getNome()+"');"
                   );
            
       }  // fim do try    
       catch (SQLException e) 
       {
           imprimeErro("Erro da expressão SQL", e.getMessage());
           resp = false;
       } catch (InstantiationException e) 
       {
           imprimeErro("Erro no drive", e.getMessage());
           resp = false;
       } // fim do catch
       finally { // assegura que a instrução e conexão são fechadas adequadamente
           fechar(); // Chamo o método que fecha a conexão
       } // fim do finally

       return resp;
   } // Fim do método insereUsuarios()
    public ArrayList buscaMensagem(int cod_u) 
   {
        // Cria um ArrayList para armazenar os médicos
        ArrayList vetMen = new ArrayList();
        Psicologo_usuario obj;//Cria variavel do tipo pergunta
        try {
            conectar(); // abrir conexão com o banco de dados
            // criar e executar a consulta ao banco de dados
            ResultSet rs = comando.executeQuery
            ("SELECT * FROM aluno_psicologo WHERE link_aluno like "+cod_u+";");
            while (rs.next()) 
            {
                obj = new Psicologo_usuario(
                        Integer.parseInt(rs.getString("link_aluno")),
                        Integer.parseInt(rs.getString("link_psi")),
                        rs.getString("mensagem"),
                        rs.getString("nome")
                );
                vetMen.add(obj);// Adiciono cada objeto Pergunta ao vetor
            }
            return vetMen;

        } // fim do try
        catch (SQLException e)
        {
            imprimeErro("Erro da expressão SQL", e.getMessage());
        } 
        catch (InstantiationException e)
        {
            imprimeErro("Erro no drive", e.getMessage());
        } // fim do catch
        finally 
        { // assegura que a instrução e conexão são fechadas adequadamente
                fechar(); // Chamo o método que fecha a conexão
        } // fim do finally
        return null;
    } 

   // Método privado que faz a conexão com Banco de Dados
   private void conectar() throws InstantiationException 
   {
       try
       {
           Class.forName( "com.mysql.jdbc.Driver" ).newInstance(); // carrega classe de driver do banco de dados
           // estabelece conexão com o banco de dados
           conexao = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bd_meu_curso", "root", "" );
           // cria Statement para consultar banco de dados
           comando = conexao.createStatement();
           //System.out.println("Conectado!");
       }
       catch (ClassNotFoundException e) 
       {
           imprimeErro("Erro ao carregar o driver", e.getMessage());
       } 
       catch (SQLException e)
       {
           imprimeErro("Erro ao conectar", e.getMessage());
       }
       catch (IllegalAccessException e)
       {
           imprimeErro("Erro ao criar instância do drive", e.getMessage());           
       }
   } // Fim do método conectar()

   // Método privado que fecha a conexão com o Banco de Dados
   private void fechar() 
   {
       try
       {
           comando.close();
           conexao.close();
           //System.out.println("Conexão Fechada");
       }
       catch (SQLException e) 
       {
           imprimeErro("Erro ao fechar conexão", e.getMessage());
       }
   } // Fim do método fechar()

   // Método privado que imprime mensagens de erro provenientes Exceções
   private void imprimeErro(String msg, String msgErro)
   {
       JOptionPane.showMessageDialog(null, msg + ": " + msgErro, "Erro crítico", 0);
       System.err.println(msg);
       System.out.println(msgErro);
       //System.exit(0);
   } // Fim do método imprimeErro()

}
