
package bd;
import classes.Psicologo;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * @author Maria Heloisa Souza
 */
public class BDpsicologo 
{
   Connection conexao = null; // gerencia a conexão
   Statement comando = null; // instrução de consulta
   public String condicao = null;
   
   // Método privado que faz a conexão com Banco de Dados
   private void conectar() throws InstantiationException 
   {
       try 
       {   // carrega classe de driver do banco de dados
           Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
           // estabelece conexão com o banco de dados
           conexao = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bd_meu_curso", "root", "" );
           // cria Statement para consultar banco de dados
           comando = conexao.createStatement();
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
       } catch (SQLException e)
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

   //Insere psicologos
    public boolean inserePsicologo(Psicologo p)
    {
       boolean resp =true; // variável de retorno 
       try {
           conectar(); // abrir conexão com o banco de dados
           // criar e executar a consulta ao banco de dados
         
           comando.executeUpdate(
                   "INSERT INTO psicologo (nome,senha) " +
                   "VALUES " +
                   "('"+p.getNome()+"','"+p.getSenha()+"');");
           
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
       finally 
       { // assegura que a instrução e conexão são fechadas adequadamente
           fechar(); // Chamo o método que fecha a conexão
       } // fim do finally
       return resp;
   } // Fim do método inserePsicologo()
    
    
     // consulta  psicologo
     public int verificaPsicologo(String nome, String senha) throws InstantiationException
     {
      // conecta-se ao banco de dados books e o consulta
      try {
          conectar(); // abrir conexão com o banco de dados
          // criar e executar a consulta ao banco de dados
          ResultSet resultSet = comando.executeQuery(
             "SELECT cod_psi " +
             "FROM psicologo " +
             "WHERE nome like '" + nome + "' and senha like '"+senha+"';"  );
          resultSet.next();
          if ( resultSet.getRow() == 0 )
          {
             return -1; //psicologo  não cadastrado
          }          
          return Integer.parseInt( resultSet.getString("cod_psi") ); // psicologo valido
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
   } // fim de metodo verificaPsicologo
   
}
