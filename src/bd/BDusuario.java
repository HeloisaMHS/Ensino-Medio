
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
 * @author nattane
 */
public class BDusuario {
   Connection conexao = null; // gerencia a conexão
   Statement comando = null; // instrução de consulta
   public String condicao = null;
   public String global;
   

   // Método que verifica se um usuario é cadastrado
   // Retorna -1 se ele não é cadastrado
   // Retorna o codigo caso ele seja  cadastrado
   public int verificaUsuario(String email, String senha) throws InstantiationException
   {
      // conecta-se ao banco de dados  e o consulta
      try 
      {
          conectar(); // abrir conexão com o banco de dados
          // criar e executar a consulta ao banco de dados
          ResultSet resultSet = comando.executeQuery(
             "SELECT * " +
             "FROM aluno " +
             "WHERE email like '" + email + "' and senha like '"+senha+"';"  );
          resultSet.next();
          
          if ( resultSet.getRow() == 0 ) 
          {
             return -1; // usuario não cadastrado
          }  
         String aluno = resultSet.getString("nome");
         global=aluno;
          return Integer.parseInt( resultSet.getString("cod_aluno") ); // usuario valido
      }  // fim do try
      catch (SQLException e) 
      {
          imprimeErro("Erro da expressão SQL", e.getMessage());
      } // fim do catch
      finally 
      { // assegura que a instrução e conexão são fechadas adequadamente
         try 
         {
            fechar(); // Chamo o método que fecha a conexão
         } // fim do try
         catch ( Exception e ) 
         {
             imprimeErro("Erro ao fechar a conexão", e.getMessage());
         } // fim do catch
      } // fim do finally
      return -1;
   } // fim de metodo verificaUsuario
   
   public String getGlobal(){
       return global;
   }
   
   //Metodo insere usuarios
   public boolean insereUsuarios(Usuario u)
   {
       boolean resp =true; // variável de retorno 
       try
       {
           conectar(); // abrir conexão com o banco de dados
           // criar e executar a consulta ao banco de dados
           String data="";
           data=u.getAno()+"-"+u.getMes()+"-"+u.getDia();
           comando.executeUpdate
                  (
                   "INSERT INTO aluno (senha,nome,sexo,data_nasc,email) " +
                   "VALUES " +
                   "('"+u.getSenha()+"','"+u.getNome()+"','"+u.getSexo()+"','"+data+"','"+u.getEmail()+"');"
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
    public ArrayList buscaUser() 
   {
        // Cria um ArrayList para armazenar os médicos
        ArrayList vetUsuario = new ArrayList();
        Usuario obj;//Cria variavel do tipo pergunta
        try {
            conectar(); // abrir conexão com o banco de dados
            // criar e executar a consulta ao banco de dados
            ResultSet rs = comando.executeQuery
            ("SELECT * FROM aluno ORDER BY nome");

            while (rs.next()) 
            {
                obj = new Usuario(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
                vetUsuario.add(obj);// Adiciono cada objeto Pergunta ao vetor
            }
            return vetUsuario;

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
     public int buscaCodUse(String nome) 
   {
        try {
            conectar(); // abrir conexão com o banco de dados
            // criar e executar a consulta ao banco de dados
            
            ResultSet rs = comando.executeQuery(
            "SELECT * FROM `aluno` WHERE nome LIKE '"+nome+"'"
            );
            if(rs.next())
            
            return Integer.parseInt( rs.getString("cod_aluno") );

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
        return 0;
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
