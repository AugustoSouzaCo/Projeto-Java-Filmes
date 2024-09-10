import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.ProjetosEmJava.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.ProjetosEmJava.modelo.TituloOmdb;
import br.com.alura.ProjetosEmJava.modelo.Título;

public class PrincipalComBusca {
	public static void main(String args[]) throws IOException, InterruptedException {
		Scanner leitor = new Scanner(System.in);
		String busca = "";
		List<Título> titulos = new ArrayList<Título>();
		Gson gson = new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
				.setPrettyPrinting()
				.create();
		while (!busca.equalsIgnoreCase("sair")) {
			System.out.println("Digite um filme para busca");
			busca = leitor.nextLine();
			
			if (busca.equalsIgnoreCase("sair")){
				break;
			}
			String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=2bd6b576";
			
			try {
				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

				String json = response.body();
				System.out.println(json);

				TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
				System.out.println(meuTituloOmdb);

				Título meuTitulo = new Título(meuTituloOmdb);
				System.out.println("Título já convertido");
				System.out.println(meuTitulo);

				titulos.add(meuTitulo);
				
			} catch (NumberFormatException e) {
				System.out.println("Aconteceu um erro: " + e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println("Aconteceu um erro de argumento na busca");
			} catch (ErroDeConversaoDeAnoException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(titulos);
		
		FileWriter escrita = new FileWriter("filmes.json");
		escrita.write(gson.toJson(titulos));
		escrita.close();
		System.out.println("O programa finalizou corretamente");

	}
}
