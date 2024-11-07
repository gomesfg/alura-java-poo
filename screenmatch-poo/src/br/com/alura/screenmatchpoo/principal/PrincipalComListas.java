package br.com.alura.screenmatchpoo.principal;

import br.com.alura.screenmatchpoo.model.Filme;
import br.com.alura.screenmatchpoo.model.Serie;
import br.com.alura.screenmatchpoo.model.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Poderoso chefão",1970);
        meuFilme.avaliar(9);
        Filme outroFilme = new Filme("Avatar",2023);
        outroFilme.avaliar(6);
        Filme filmeDoFelipe = new Filme("Resident Evil",2010);
        filmeDoFelipe.avaliar(10);
        Serie lost = new Serie("Lost",2000);



        /* Criar a lista de filmes */
        ArrayList<Titulo> lista = new ArrayList<>();

        /* Adicionar titulos a lista */
        lista.add(filmeDoFelipe);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        // Aqui foi usado o for each, onde usa uma variavel "item" do tipo Titulo, que percorre cada item da lista
        for (Titulo item: lista){
            System.out.println(item.getNome());
            // instanceof: Verifica se um objeto é de um determinado tipo
            if(item instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("Classificação " + filme.getClassificacao());
            }

        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Felipe Gomes");
        buscaPorArtista.add("Capitão Nascimento");
        System.out.println(buscaPorArtista);

        // Ordena por ordem alfabética
        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação");
        System.out.println(buscaPorArtista);

        Collections.sort(lista);
        System.out.println(lista);

        /* Aqui foi utilizado o comparator para ordenar a lista por ano de lançamento. A diferença entre comparator e
        comparable, é que o comparable serve para definir a ordenação padrão de uma classe. Já o comparator serve para
        realizar comparações alternativas. */
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano");
        System.out.println(lista);
    }
}
