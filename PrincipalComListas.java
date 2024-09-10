import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.alura.ProjetosEmJava.modelo.Filme;
import br.com.alura.ProjetosEmJava.modelo.Serie;
import br.com.alura.ProjetosEmJava.modelo.Título;

public class PrincipalComListas {
	public static void main(String args[]) {
		var meuFilme = new Filme("Dois careca", 2003);
		var lost = new Serie("lost", 2000);
		var outroFilme = new Filme("Dois viado", 1970);
		var filmeDoPaulo = new Filme("Dogville", 2024);
// reference variable
		var f1 = filmeDoPaulo;
		
		meuFilme.avalia(9);
		outroFilme.avalia(6);
		filmeDoPaulo.avalia(10);
		
		List<Título> lista = new ArrayList<>();
		lista.add(filmeDoPaulo);
		lista.add(meuFilme);
		lista.add(outroFilme);
		lista.add(lost);
		
		for (Título item: lista){
			System.out.println(item.getNome());
			if (item instanceof Filme filme && filme.getClassificacao() > 2) {
//casting for films items in list
//var filme = (Filme) item;
				System.out.println("Classificação" + filme.getClassificacao());
			}
		}
		
		ArrayList<String> buscaArtista = new ArrayList<String>();
		buscaArtista.add("Adam Levrone");
		buscaArtista.add("Paulo");
		buscaArtista.add("Jaqueline");
		System.out.println(buscaArtista);
		
// java.util method
		Collections.sort(buscaArtista);
		System.out.println("Depois de ordenar " + buscaArtista);
		
		Collections.sort(lista);
		System.out.println("Lista de títulos ordenados " + lista);
// using other criterion
		lista.sort(Comparator.comparing(Título::getAnoDeLancamento));
		System.out.println(lista);
	}
}
