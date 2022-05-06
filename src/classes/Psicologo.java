
package classes;

/* Esta classe permite inserção, alteração, consulta e captura dos dados referentes a um psicologo do sistema.
 * @author Fábio Nunes De Paula
 */
public class Psicologo {
private String nome;
private String senha;

    public Psicologo(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha( String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Psicologo{" + "nome=" + nome + ", senha =" + senha + '}';
    }
    
}
