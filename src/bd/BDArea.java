package bd;
import classes.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/*
 * @author Maria Heloisa Souza
 */
public class BDArea 
{
    Connection conexao = null; // gerencia a conexão
    Statement comando = null; // instrução de consulta
    public String condicao = null;

      // Método que insere Area 
      public boolean insereArea(Area a)
      {
       boolean resp = true; // variável de retorno 
       try 
       {conectar();
           comando.executeUpdate
        (
                   "INSERT INTO area (cod_area,nome) " +
                   "VALUES " +
                   "("+a.getCod_area()+",'"+a.getNome()+"');"
        );
           
       }// fim do try    
       catch (SQLException e) 
       {   
           imprimeErro("Erro da expressão SQL", e.getMessage());
           resp = false;
       }
       catch (InstantiationException e) 
       {
           imprimeErro("Erro no drive", e.getMessage());
           resp = false;
       } // fim do catch
       finally 
       { // assegura que a instrução e conexão são fechadas adequadamente
           fechar(); // Chamo o método que fecha a conexão
       } // fim do finally
       return resp;
   } // Fim do método insereAreas()

    // Método que busca Area e retorna uma ArrayList de objetos Area
    public ArrayList buscaArea() 
    {
        ArrayList vetArea = new ArrayList(); // Cria um ArrayList para armazenar areas
        Area obj;// Cria uma variavel do tipo area
        try
        {
            conectar(); // abrir conexão com o banco de dados
            // criar e executar a consulta ao banco de dados
            ResultSet rs = comando.executeQuery("SELECT * FROM area ORDER BY cod_area");
            while (rs.next()) 
            {   // pega a próxima linha até o final
                obj = new Area(rs.getString("nome"),
                          Integer.parseInt(rs.getString("cod_area")) );
                vetArea.add(obj);// Adiciona cada objeto ao Array
            }
            return vetArea;
        } // fim do try
        catch (SQLException e) 
        {
            imprimeErro("Erro da expressão SQL", e.getMessage());
        } catch (InstantiationException e) 
        {
            imprimeErro("Erro no drive", e.getMessage());
        } // fim do catch
        finally 
        { // assegura que a instrução e conexão são fechadas adequadamente
            try 
            {
                fechar(); // Chamo o método que fecha a conexão
            } // fim do try
            catch (Exception e) 
            {
                imprimeErro("Erro ao fechar a conexão", e.getMessage());
            } // fim do catch
        } // fim do finally
        return null;
    } // fim de buscaLivros

    // Método que busca uma Area pelo seu código - Retorna um objeto Area
    public Area buscaAreaPorCodigo(String cond)
    {
        Area obj = null; // Cria uma variavel para guardar um objeto Area
        try 
        {
            conectar(); // abrir conexão com o banco de dados
            // criar e executar a consulta ao banco de dados
            ResultSet rs = comando.executeQuery(
                    "SELECT * "
                    + "FROM curso "
                    + "WHERE cod_curso = " + cond);

            while (rs.next())
            {
              obj = new Area(rs.getString("nome"),Integer.parseInt(rs.getString("cod_area")) );
            }
            // Retorna um objeto area
            return obj;
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
            try
            {
             fechar(); // Chamo o método que fecha a conexão
            } // fim do try
            catch (Exception e) 
            {
                imprimeErro("Erro ao fechar a conexão", e.getMessage());
            } // fim do catch
        } // fim do finally
        return null;
    } // fim de buscaareaPorCodigo

    // Método que altera um Area no Banco de Dados
    public boolean alteraArea(Area objA) 
    {
        boolean resp = true; // variável de retorno
        try 
        {
            conectar(); // abrir conexão com o banco de dados
            // criar e executar a consulta ao banco de dados
            comando.executeUpdate(
                    "UPDATE area SET "
                    + "cod_area = " + objA.getCod_area() + ","
                    + "nome = '" + objA.getNome() +"'"
                    + "WHERE cod_area = " + objA.getCod_area()
            );

        } // fim do try
        catch (InstantiationException ex) 
        {
            Logger.getLogger(BDArea.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(BDArea.class.getName()).log(Level.SEVERE, null, ex);
        } // fim do catch 
        finally 
        { // assegura que a instrução e conexão são fechadas adequadamente
            fechar(); // Chamo o método que fecha a conexão
        } // fim do finally
        return resp;
    } // Fim do método alteraLivro()

    // Método que deleta um Area no Banco de Dados
    public boolean deletaArea(int codigo) 
    {
        boolean resp = true; // variável de retorno
        try
        {
            conectar(); // abrir conexão com o banco de dados
            // criar e executar a consulta ao banco de dados
            comando.executeUpdate(
                    
                    "DELETE FROM area WHERE area.cod_area = "+ codigo);
                  /*  "DELETE * FROM area "
                    + "WHERE cod_area = " + codigo);*/
        } // fim do try
        catch (InstantiationException ex) 
        {
            Logger.getLogger(BdCursos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) 
        {
            Logger.getLogger(BdCursos.class.getName()).log(Level.SEVERE, null, ex);
        } // fim do catch
        finally 
        { // assegura que a instrução e conexão são fechadas adequadamente
            fechar(); // Chamo o método que fecha a conexão
        } // fim do finally
        return resp;
    } // Fim do método deletaLivro()

    // Método privado que faz a conexão com Banco de Dados
    private void conectar() throws InstantiationException 
    {
        try
        {   // carrega classe de driver do banco de dados
            Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            // estabelece conexão com o banco de dados
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_meu_curso", "root", "");
            // cria Statement para consultar banco de dados
            comando = conexao.createStatement();
        } 
        catch (ClassNotFoundException e) 
        {
            imprimeErro("Erro ao carregar o driver", e.getMessage());
        } catch (SQLException e) 
        {
            imprimeErro("Erro ao conectar", e.getMessage());
        } catch (IllegalAccessException e)
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
    } // Fim do método imprimeErro()

} 

