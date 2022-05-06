package classes;

/* Esta classe permite inserção, alteração, consulta e captura dos dados referentes a um usuário do sistema.
 * @author Fábio Nunes De Paula
 */
public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private String sexo;
    private String dia;
    private String mes;
    private String ano;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, String email, String senha, String sexo, String dia, String mes, String ano) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.sexo = sexo;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "usuario{" + "nome=" + nome + ", email=" + email + ", senha=" + senha + ", sexo=" + sexo + ", dia=" + dia + ", mes=" + mes + ", ano=" + ano + '}';
    }

}
