
package bd;

import classes.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BDPergunta 
{
    Connection conexao = null; // gerencia a conexão
    Statement comando = null; // instrução de consulta
    public String condicao = null;
    
     // Metodo que insere pergunta
    public boolean inserePergunta(Pergunta p)
    {
       boolean resp =true; // variável de retorno 
       try
       {
           conectar();//chama o metodo de conecxao
           comando.executeUpdate(
                   "INSERT INTO pergunta (descricao,cod_pergunta,link_area,link_etapa,link_curso) " +
                   "VALUES " +
                   "('"+p.getDescricao()+"',"+p.getCod_pergunta()+","+p.getLink_area()+","+p.getLink_etapa()+","+p.getLink_curso()+");"
           );
           
       }  // fim do try    
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
   }
     
     // Fim do método inserePergunta()
    public boolean inserePerguntaEtapa1(Pergunta p)
    {
       boolean resp =true; // variável de retorno 
       try 
       {
           conectar();
           comando.executeUpdate(
                   "INSERT INTO pergunta_etapa1 (descricao_etapa1,link_etapa,link_area,cod_pergunta_etapa1) " +
                   "VALUES " +
                   "('"+p.getDescricao()+"',"+p.getLink_etapa()+","+p.getLink_area()+","+p.getCod_pergunta()+");"
           );
           
       }  // fim do try    
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
   } // Fim do método inserePergunta()

   //Metodo de busca de Perguntas 
   public ArrayList buscaPerguntasGeral() 
   {
        // Cria um ArrayList para armazenar os médicos
        ArrayList vetPergunta = new ArrayList();
        Pergunta obj;//Cria variavel do tipo pergunta
        try {
            conectar(); // abrir conexão com o banco de dados
            // criar e executar a consulta ao banco de dados
            ResultSet rs = comando.executeQuery
            ("SELECT * FROM pergunta ORDER BY cod_pergunta");

            while (rs.next()) 
            {
                obj = new Pergunta(
                        rs.getString("descricao"),
                        Integer.parseInt(rs.getString("cod_pergunta")),
                        Integer.parseInt(rs.getString("link_area")),
                        Integer.parseInt(rs.getString("link_etapa")),
                        Integer.parseInt(rs.getString("link_curso"))
                );
                vetPergunta.add(obj);// Adiciono cada objeto Pergunta ao vetor
            }
            return vetPergunta;

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
   
    // Método que altera um Pergunta no Banco de Dados
   public boolean alteraPergunta(Pergunta objP) 
   {
        boolean resp = true; // variável de retorno
        try {
            conectar(); // abrir conexão com o banco de dados
            // criar e executar a consulta ao banco de dados

             comando.executeUpdate(
                    "UPDATE pergunta SET descricao = '"+objP.getDescricao()
                    +"',cod_pergunta ="+objP.getCod_pergunta()
                    +",link_area ="+objP.getLink_area()
                    +",link_etapa = "+objP.getLink_etapa()
                    +",link_curso = "+objP.getLink_curso()
                    + " WHERE cod_pergunta = " +objP.getCod_pergunta()
            );

        } // fim do try
        catch (InstantiationException ex) 
        {
            Logger.getLogger(BdCursos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(BdCursos.class.getName()).log(Level.SEVERE, null, ex);
        } // fim do catch
        finally 
        { // assegura que a instrução e conexão são fechadas adequadamente
            fechar(); // Chamo o método que fecha a conexão
        } // fim do finally

        return resp;
    } // Fim do método alteraPergunta()
 
    // Método que altera um Pergunta Etapa 1 no Banco de Dados
   public boolean alteraPerguntaEtapa1(Pergunta objP) 
   {
        boolean resp = true; // variável de retorno
        try {
            conectar(); // abrir conexão com o banco de dados
            // criar e executar a consulta ao banco de dados
            comando.executeUpdate(
                    
                    "UPDATE pergunta_etapa1 SET descricao_etapa1 = '"+objP.getDescricao()
                    +"',cod_pergunta_etapa1 ="+objP.getCod_pergunta()
                    +",link_area ="+objP.getLink_area()
                    +",link_etapa = "+objP.getLink_etapa()
                    + " WHERE cod_pergunta_etapa1 = " +objP.getCod_pergunta()
            );

        } // fim do try
        catch (InstantiationException ex) 
        {
            Logger.getLogger(BdCursos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(BdCursos.class.getName()).log(Level.SEVERE, null, ex);
        } // fim do catch 
        finally 
        { // assegura que a instrução e conexão são fechadas adequadamente
            fechar(); // Chamo o método que fecha a conexão
        } // fim do finally

        return resp;
    } // Fim do método alteraPerguntaEtapa1()
 
   public ArrayList buscaPerguntasEtapa1()
   {
        // Cria um ArrayList para armazenar os médicos
        ArrayList vetPergunta = new ArrayList();
        Pergunta obj;
        try {
            conectar(); // abrir conexão com o banco de dados
            // criar e executar a consulta ao banco de dados
            ResultSet rs = comando.executeQuery("SELECT * "
                    + "FROM pergunta_etapa1 ORDER BY cod_pergunta_etapa1");

            while (rs.next()) {
                obj = new Pergunta(
                        rs.getString("descricao_etapa1"),
                        Integer.parseInt(rs.getString("cod_pergunta_etapa1")),
                        Integer.parseInt(rs.getString("link_area")),
                        Integer.parseInt(rs.getString("link_etapa"))
                );
                vetPergunta.add(obj);// Adiciono cada objeto Pergunta
            }
            return vetPergunta;

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

    // Método que deleta um Pergunta no Banco de Dados
    public boolean deletaPergunta(int codigo) 
    {
        boolean resp = true; // variável de retorno
        try {
            conectar(); // abrir conexão com o banco de dados
            // criar e executar a consulta ao banco de dados
            comando.executeUpdate(
                    "DELETE FROM pergunta "
                    + "WHERE cod_pergunta = " + codigo);
        } // fim do try
        catch (InstantiationException ex)
        {
            Logger.getLogger(BdCursos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(BdCursos.class.getName()).log(Level.SEVERE, null, ex);
        } // fim do catch 
        finally 
        { // assegura que a instrução e conexão são fechadas adequadamente
            fechar(); // Chamo o método que fecha a conexão
        } // fim do finally

        return resp;
    } // Fim do método deletaPergunta()

    // Método que deleta um Pergunta Etapa 1no Banco de Dados
    public boolean deletaPerguntaEtapa1(int codigo) 
    {
        boolean resp = true; // variável de retorno
        try {
            conectar(); // abrir conexão com o banco de dados
            // criar e executar a consulta ao banco de dados
            comando.executeUpdate(
                    "DELETE  FROM pergunta_etapa1 "
                    + "WHERE cod_pergunta_etapa1 = " + codigo);
        } // fim do try
        catch (InstantiationException ex)
        {
            Logger.getLogger(BdCursos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(BdCursos.class.getName()).log(Level.SEVERE, null, ex);
        } // fim do catch
        finally 
        { // assegura que a instrução e conexão são fechadas adequadamente
            fechar(); // Chamo o método que fecha a conexão
        } // fim do finally

        return resp;
    } // Fim do método deletaPerguntaEtapa1()

    // Método privado que faz a conexão com Banco de Dados
    private void conectar() throws InstantiationException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); // carrega classe de driver do banco de dados
            // estabelece conexão com o banco de dados
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_meu_curso", "root", "");
            // cria Statement para consultar banco de dados
            comando = conexao.createStatement();
            //System.out.println("Conectado!");
        } catch (ClassNotFoundException e) {
            imprimeErro("Erro ao carregar o driver", e.getMessage());
        } catch (SQLException e) {
            imprimeErro("Erro ao conectar", e.getMessage());
        } catch (IllegalAccessException e) {
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
