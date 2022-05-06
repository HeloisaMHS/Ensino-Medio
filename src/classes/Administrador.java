
package classes;

/* Esta classe permite inserção, alteração, consulta e captura dos dados referentes a um administrador do sistema.
 * @author Maria Heloisa Souza
 */

public class Administrador
{
    private String login;
    private String senha;

    public Administrador(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
