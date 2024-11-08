package br.com.alura.screenmatchpoo.principal;

import br.com.alura.screenmatchpoo.exception.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatchpoo.model.Titulo;
import br.com.alura.screenmatchpoo.model.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();

        /* Aqui foi criado um DTO (Data transfer object) que nada mais é do que um objeto que recebe o json
        com as informações do filme e converte para um objeto da classe Titulo.

        A biblioteca Gson para converter um json em um objeto Java e vice versa.
        */
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")){

            System.out.println("Digite um filme para busca: ");
            busca = leitura.nextLine();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }

            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=ec2ff1f3";

            /*
            Aqui foi feito um tratamento, incluido um try/catch para verificar se existe algum erro
             */
            try {
                // Objeto client
                HttpClient client = HttpClient.newHttpClient();

                // Objeto request
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                //Objeto response
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);


                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);


                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo já convertido: ");

                // Adiciona o filme na lista, para gravar no arquivo posteriormente
                titulos.add(meuTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço!");
            } catch (ErroDeConversaoDeAnoException e) { // Aqui foi criado um exception customizado
                System.out.println(e.getMessage());
            }

            System.out.println(titulos);

            // Escreve a lista de filmes em um arquivo texto. A biblioteca gson faz a conversão do objeto para
            // um arquivo .json
            FileWriter escrita = new FileWriter("filmes.json");
            escrita.write(gson.toJson(titulos));
            escrita.close();
            System.out.println("O programa finalizou corretamente!");
        }
    }
}
