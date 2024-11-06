import br.com.alura.screenmatchpoo.calculation.CalculadoraDeTempo;
import br.com.alura.screenmatchpoo.calculation.FiltroRecomendacao;
import br.com.alura.screenmatchpoo.model.Episodio;
import br.com.alura.screenmatchpoo.model.Filme;
import br.com.alura.screenmatchpoo.model.Serie;

import java.util.ArrayList;
import java.util.Objects;

public class Principal {
    public static void main(String[] args) {

        // Instanciando o objeto
        Filme meuFilme = new Filme("Poderoso chefão",1970);
        //meuFilme.setNome("Poderoso chefão");
        //meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);
        System.out.println("Duração do filme:" + meuFilme.getDuracaoEmMinutos());

        meuFilme.exibirFichaTecnica();
        meuFilme.avaliar(5);
        meuFilme.avaliar(8);
        meuFilme.avaliar(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println("Média das avaliações: " + meuFilme.obterMediaDasAvaliacoes());

        Serie lost = new Serie("Lost",2000);
        /*lost.setNome("Lost");
        lost.setAnoDeLancamento(2000);*/
        lost.exibirFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração da série:" + lost.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("Avatar",2023);
        //outroFilme.setNome("Avatar");
        //outroFilme.setAnoDeLancamento(2023);
        outroFilme.setDuracaoEmMinutos(200);
        System.out.println("Duração do filme:" + meuFilme.getDuracaoEmMinutos());

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.incluir(meuFilme);
        calculadora.incluir(outroFilme);
        calculadora.incluir(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalDeVisualizacoes(300);
        filtro.filtra(episodio);

        Filme filmeDoFelipe = new Filme("Resident Evil",2010);
        filmeDoFelipe.setDuracaoEmMinutos(200);
        //filmeDoFelipe.setNome("Resident Evil");
        //filmeDoFelipe.setAnoDeLancamento(2010);
        filmeDoFelipe.avaliar(10);

        /* Criar a lista de filmes */
        ArrayList<Filme> listaDeFilmes = new ArrayList<>();

        /* Adicionar filmes a lista */
        listaDeFilmes.add(filmeDoFelipe);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);

        // Pegar tamanho da lista
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());

        // Pegar primeiro filme da lista (posição zero)
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());

        // Imprimir os objetos da lista
        System.out.println(listaDeFilmes);

        // Imprimir o toString() do filme
        System.out.println("toString do filme: " + listaDeFilmes.get(0).toString());

    }
}
