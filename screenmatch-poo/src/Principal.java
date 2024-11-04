import br.com.alura.screenmatchpoo.model.Filme;
import br.com.alura.screenmatchpoo.model.Serie;

public class Principal {
    public static void main(String[] args) {

        // Instanciando o objeto
        Filme meuFilme = new Filme();

        meuFilme.setNome("Poderoso chefão");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibirFichaTecnica();
        meuFilme.avaliar(5);
        meuFilme.avaliar(8);
        meuFilme.avaliar(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        /*System.out.println(meuFilme.somaDasAvaliacoes);*/
        System.out.println(meuFilme.obterMediaDasAvaliacoes());

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2000);
        lost.exibirFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
    }
}
