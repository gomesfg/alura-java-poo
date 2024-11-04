package br.com.alura.screenmatchpoo.model;

import br.com.alura.screenmatchpoo.calculation.Classificavel;

public class Filme extends Titulo implements Classificavel {

    private String diretor;

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
}
