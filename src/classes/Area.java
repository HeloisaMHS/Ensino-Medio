
package classes;

/* Esta classe permite inserção, alteração, consulta e captura dos dados referentes a uma area do sistema.
 * @author Fábio Nunes De Paula
 */
public class Area {
    private String nome;
    private int cod_area;

    public Area(String nome, int cod_area) {
        this.nome = nome;
        this.cod_area = cod_area;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCod_area() {
        return cod_area;
    }

    public void setCod_area(int cod_area) {
        this.cod_area = cod_area;
    }

    @Override
    public String toString() {
        return "Area{" + "nome=" + nome + ", cod_area=" + cod_area + '}';
    }
    
}
