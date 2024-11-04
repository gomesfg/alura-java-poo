package br.com.alura.screenmatchpoo.calculation;

import br.com.alura.screenmatchpoo.model.Titulo;

import java.sql.SQLOutput;

public class CalculadoraDeTempo {
    private int tempoTotal = 0;

    public int getTempoTotal() {
        return this.tempoTotal;
    }

//    public void incluir(Filme f){
//        this.tempoTotal += f.getDuracaoEmMinutos();
//    }
//
//    public void incluir(Serie s){
//        this.tempoTotal += s.getDuracaoEmMinutos();
//    }

    /* Polimorfismo: Usamos o mesmo método para calcular tanto o objeto Filme quanto Série. Ou seja basta passar
    um objeto do tipo Titulo que o método atenderá.
     */
    public void incluir(Titulo titulo){
        System.out.println("Adicionando duração em minutos de: " + titulo);
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
