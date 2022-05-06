package bd;

import classes.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BdCursos {

    Connection conexao = null; // gerencia a conexão
    Statement comando = null; // instrução de consulta
    public String condicao = null;
    
    //Metodo insere Curso
    public boolean insereCurso(Curso c)
    {
       boolean resp =true; // variável de retorno 
       try 
       {
           conectar();
           comando.executeUpdate
           (
                   "INSERT INTO curso (cod_curso,nome,link_area,sobre_curso,notas_de_corte,grade_curricular,area_atuacao,"
                           + "pontos_positivos,pontos_negativos,perfil_profissional,mercado_atual,salario) " +
                   "VALUES " +
                   "("+c.getCod_curso()+",'"+c.getNome_curso()+"',"+c.getLink_area()+",'"+c.getSobre_curso()+"','"+c.getNotas_de_corte()
                           +"','"+c.getGrade_curricular()+"','"+c.getArea_atuacao()+"','"+c.getPontos_positivos()+"','"+c.getPontos_negativos()+
                           "','"+c.getPerfil_profissional()+"','"+c.getMercado_atual()+"','"+c.getSalario()+"');"
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
   } // Fim do método insereCurso()

    //Metodo que busca Cursos
      public ArrayList buscaCursosGeral()
      {
        // Cria um ArrayList para armazenar os cursos
        ArrayList vetCurso = new ArrayList();
        Curso obj;
        try 
        {
            conectar(); // abrir conexão com o banco de dados
            // criar e executar a consulta ao banco de dados
            ResultSet rs = comando.executeQuery("SELECT * "
                    + "FROM curso ORDER BY cod_curso");

            while (rs.next()) 
            {
                obj = new Curso
                (       Integer.parseInt(rs.getString("cod_curso")),
                        rs.getString("nome"),
                        Integer.parseInt(rs.getString("link_area")),
                        rs.getString("sobre_curso"),
                        rs.getString("notas_de_corte"),
                        rs.getString("grade_curricular"),
                        rs.getString("area_atuacao"),
                        rs.getString("pontos_positivos"),
                        rs.getString("pontos_negativos"),
                        rs.getString("perfil_profissional"),
                        rs.getString("mercado_atual"),
                        rs.getString("salario")
                );
                vetCurso.add(obj);// Adiciono cada objeto Curso
            }
            return vetCurso;

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
    } 
 
    // Método que altera um Curso no Banco de Dados
    public boolean alteraCurso(Curso objC) {
        boolean resp = true; // variável de retorno
        try {
            conectar(); // abrir conexão com o banco de dados
            // criar e executar a consulta ao banco de dados
            comando.executeUpdate
            (
                    "UPDATE curso SET "
                    + "cod_curso = " + objC.getCod_curso() + ","
                    + "nome = '" + objC.getNome_curso() + "',"
                    + "link_area = " + objC.getLink_area()+","
                    + "sobre_curso = '" + objC.getSobre_curso()+ "',"
                    + "notas_de_corte = '" + objC.getNotas_de_corte()+ "',"
                    + "grade_curricular = '" + objC.getGrade_curricular()+ "',"
                    + "area_atuacao = '" + objC.getArea_atuacao()+ "',"
                    + "pontos_positivos = '" + objC.getPontos_positivos()+ "',"
                    + "pontos_negativos = '" + objC.getPontos_negativos()+ "',"
                    + "perfil_profissional = '" + objC.getPerfil_profissional()+ "',"
                    + "mercado_atual = '" + objC.getMercado_atual()+ "',"
                    + "salario = '" + objC.getSalario()+ "'"
                    + "WHERE cod_curso = " + objC.getCod_curso()
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
    } // Fim do método alteraCurso()

    // Método que deleta um Curso no Banco de Dados
    public boolean deletaCurso(int codigo) 
    {
        boolean resp = true; // variável de retorno
        try {
            conectar(); // abrir conexão com o banco de dados
            // criar e executar a consulta ao banco de dados
            comando.executeUpdate(
                    "DELETE FROM curso WHERE curso.cod_curso ="
                    /*"DELETE * FROM curso "
                    + "WHERE cod_curso = "*/ + codigo);
        } // fim do try
        catch (InstantiationException ex) 
        {
            Logger.getLogger(BdCursos.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(BdCursos.class.getName()).log(Level.SEVERE, null, ex);
        } // fim do catch 
        finally { // assegura que a instrução e conexão são fechadas adequadamente
            fechar(); // Chamo o método que fecha a conexão
        } // fim do finally
        return resp;
    } // Fim do método deletaCurso()

    // Método privado que faz a conexão com Banco de Dados
    private void conectar() throws InstantiationException 
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); // carrega classe de driver do banco de dados
            // estabelece conexão com o banco de dados
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_meu_curso", "root", "");
            // cria Statement para consultar banco de dados
            comando = conexao.createStatement();
            //System.out.println("Conectado!");
        } catch (ClassNotFoundException e)
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

} // fim da classe BancoDados
