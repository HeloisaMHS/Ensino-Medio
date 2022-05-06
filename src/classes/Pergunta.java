
package classes;

/* Esta classe permite inserção, alteração, consulta e captura dos dados referentes a uma pergunta do sistema.
 * @author Fábio Nunes De Paula
 */
public class Pergunta {
    private String descricao;
    private int cod_pergunta;
    private int link_area;
    private int link_etapa;
    private int link_curso;

    public Pergunta(String descricao, int cod_pergunta, int link_area, int link_etapa, int link_curso) {
        this.descricao = descricao;
        this.cod_pergunta = cod_pergunta;
        this.link_area = link_area;
        this.link_etapa = link_etapa;
        this.link_curso = link_curso;
        //System.out.println(link_area);
    }
    
     public Pergunta(String descricao, int cod_pergunta, int link_area, int link_etapa) {
        this.descricao = descricao;
        this.cod_pergunta = cod_pergunta;
        this.link_area = link_area;
        this.link_etapa = link_etapa;
    }
     

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCod_pergunta() {
        return cod_pergunta;
    }

    public void setCod_pergunta(int cod_pergunta) {
        this.cod_pergunta = cod_pergunta;
    }

    public int getLink_area() {
        return link_area;
    }

    public void setLink_area(int link_area) {
        this.link_area = link_area;
    }

    public int getLink_etapa() {
        return link_etapa;
    }

    public void setLink_etapa(int link_etapa) {
        this.link_etapa = link_etapa;
    }

    public int getLink_curso() {
        return link_curso;
    }

    public void setLink_curso(int link_curso) {
        this.link_curso = link_curso;
    }

    @Override
    public String toString() {
        return "Pergunta{" + "descricao=" + descricao + ", cod_pergunta=" + cod_pergunta + ", link_area=" + link_area + ", link_etapa=" + link_etapa + ", link_curso=" + link_curso + '}';
    }
    
    
    
}
