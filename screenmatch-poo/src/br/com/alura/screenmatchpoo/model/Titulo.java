package br.com.alura.screenmatchpoo.model;

import br.com.alura.screenmatchpoo.exception.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    /* No paradigma do Encapsulamento é utilizado o modificador de acesso. Neste exemplo foi utilizado o modificador de
     acesso "private" que serve para não permitir que o metodo seja acessado diretamente na classe principal.
    Existem quatro tipos de modificadores de acesso em Java: public, protected, private e default (também conhecido
    como package-private). */

    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();

        if(meuTituloOmdb.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano porque tem mais de 04 caracteres.");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0,2));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibirFichaTecnica(){
        System.out.println("Nome do filme: " + this.nome);
        System.out.println("Ano de lançamento: " + this.anoDeLancamento);
    }

    public void avaliar(double nota){
        this.somaDasAvaliacoes += nota;
        this.totalDeAvaliacoes++;
    }

    public double obterMediaDasAvaliacoes(){
        return this.somaDasAvaliacoes / this.totalDeAvaliacoes;
    }

    // Aqui estamos sobrescrevendo o método compareTo da interface Comparable() para que seja possível ordenar a lista
    //  através do método sort. No exemplo abaixo, iremos comparar o nome dos títulos e ordenar alfabeticamente.
    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return  "(nome = " + nome +
                ", anoDeLancamento = " + anoDeLancamento + "," +
                " duração = " + duracaoEmMinutos + ")";
    }
}
