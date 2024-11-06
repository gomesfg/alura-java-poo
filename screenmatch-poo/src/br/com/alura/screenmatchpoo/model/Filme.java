package br.com.alura.screenmatchpoo.model;

import br.com.alura.screenmatchpoo.calculation.Classificavel;

public class Filme extends Titulo implements Classificavel {

    private String diretor;

    // Construtor
    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) obterMediaDasAvaliacoes() / 2;
    }

    // Aqui fiz uma reescrita do método toString
    @Override
    public String toString() {
        return "Filme: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
    }
}
