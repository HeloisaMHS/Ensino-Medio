
package classes;

/* Esta classe permite inserção, alteração, consulta e captura dos dados referentes a uma etapa do sistema.
 * @author Fábio Nunes De Paula
 */
public class Etapa {
private String nome;
private int cod_etapa;

    public Etapa(String nome, int cod_etapa) {
        this.nome = nome;
        this.cod_etapa = cod_etapa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCod_etapa() {
        return cod_etapa;
    }

    public void setCod_etapa(int cod_etapa) {
        this.cod_etapa = cod_etapa;
    }

    @Override
    public String toString() {
        return "Etapa{" + "nome=" + nome + ", cod_etapa=" + cod_etapa + '}';
    }

}
