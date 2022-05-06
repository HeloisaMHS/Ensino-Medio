
package classes;

/* Esta classe permite inserção, alteração, consulta e captura dos dados referentes a um curso do sistema.
 * @author Fábio Nunes De Paula
 */
public class Curso {

    private int cod_curso;
    private String nome_curso;
    private int link_area;
    private String sobre_curso;
    private String notas_de_corte;
    private String grade_curricular;
    private String area_atuacao;
    private String pontos_positivos;
    private String pontos_negativos;
    private String perfil_profissional;
    private String mercado_atual;
    private String salario;

    public Curso(int cod_curso, String nome_curso, int link_area, String sobre_curso, String notas_de_corte, 
            String grade_curricular, String area_atuacao, String pontos_positivos, String pontos_negativos, 
            String perfil_profissional, String mercado_atual, String salario) {
        this.cod_curso = cod_curso;
        this.nome_curso = nome_curso;
        this.link_area = link_area;
        this.sobre_curso = sobre_curso;
        this.notas_de_corte = notas_de_corte;
        this.grade_curricular = grade_curricular;
        this.area_atuacao = area_atuacao;
        this.pontos_positivos = pontos_positivos;
        this.pontos_negativos = pontos_negativos;
        this.perfil_profissional = perfil_profissional;
        this.mercado_atual = mercado_atual;
        this.salario = salario;
    }

    public Curso(int cod_curso, String nome_curso, int link_area) {
        this.cod_curso = cod_curso;
        this.nome_curso = nome_curso;
        this.link_area = link_area;
        
    }

    public int getCod_curso() {
        return cod_curso;
    }

    public void setCod_curso(int cod_curso) {
        this.cod_curso = cod_curso;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public int getLink_area() {
        return link_area;
    }

    public void setLink_area(int link_area) {
        this.link_area = link_area;
    }

    public String getSobre_curso() {
        return sobre_curso;
    }

    public void setSobre_curso(String sobre_curso) {
        this.sobre_curso = sobre_curso;
    }

    public String getNotas_de_corte() {
        return notas_de_corte;
    }

    public void setNotas_de_corte(String notas_de_corte) {
        this.notas_de_corte = notas_de_corte;
    }

    public String getGrade_curricular() {
        return grade_curricular;
    }

    public void setGrade_curricular(String grade_curricular) {
        this.grade_curricular = grade_curricular;
    }

    public String getArea_atuacao() {
        return area_atuacao;
    }

    public void setArea_atuacao(String area_atuacao) {
        this.area_atuacao = area_atuacao;
    }

    public String getPontos_positivos() {
        return pontos_positivos;
    }

    public void setPontos_positivos(String pontos_positivos) {
        this.pontos_positivos = pontos_positivos;
    }

    public String getPontos_negativos() {
        return pontos_negativos;
    }

    public void setPontos_negativos(String pontos_negativos) {
        this.pontos_negativos = pontos_negativos;
    }

    public String getPerfil_profissional() {
        return perfil_profissional;
    }

    public void setPerfil_profissional(String perfil_profissional) {
        this.perfil_profissional = perfil_profissional;
    }

    public String getMercado_atual() {
        return mercado_atual;
    }

    public void setMercado_atual(String mercado_atual) {
        this.mercado_atual = mercado_atual;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Curso{" + "cod_curso=" + cod_curso + ", nome_curso=" + nome_curso + ", link_area=" + link_area + ", sobre_curso=" + sobre_curso + ", notas_de_corte=" + notas_de_corte + ", grade_curricular=" + grade_curricular + ", area_atuacao=" + area_atuacao + ", pontos_positivos=" + pontos_positivos + ", pontos_negativos=" + pontos_negativos + ", perfil_profissional=" + perfil_profissional + ", mercado_atual=" + mercado_atual + ", salario=" + salario + '}';
    }
    
    
   
}
