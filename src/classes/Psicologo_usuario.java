/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Maria Heloisa Souza
 */
public class Psicologo_usuario {
 
    private int link_aluno;
    private int link_psi;
    private String mensagem;
    private String nome;

    public Psicologo_usuario(int link_aluno, int link_psi, String mensagem, String nome) {
        this.link_aluno = link_aluno;
        this.link_psi = link_psi;
        this.mensagem = mensagem;
        this.nome = nome;
    }

    public int getLink_aluno() {
        return link_aluno;
    }

    public void setLink_aluno(int link_aluno) {
        this.link_aluno = link_aluno;
    }

    public int getLink_psi() {
        return link_psi;
    }

    public void setLink_psi(int link_psi) {
        this.link_psi = link_psi;
    }
    
   public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
