import java.util.ArrayList;

import br.com.alura.ProjetosEmJava.calculadora.CalculadoraDeTempo;
import br.com.alura.ProjetosEmJava.calculadora.FiltroRecomendacao;
import br.com.alura.ProjetosEmJava.modelo.Episodio;
import br.com.alura.ProjetosEmJava.modelo.Filme;
import br.com.alura.ProjetosEmJava.modelo.Serie;

public class Principal {
	public static void main(String args[]) {
		
		
		Filme meuFilme = new Filme("Dois careca", 2003);
		
		meuFilme.setAnoDeLancamento(2003);
		meuFilme.setDuracaoEmMinutos(180);
		meuFilme.avalia(7);
		meuFilme.avalia(8);
		meuFilme.avalia(5);
		meuFilme.getTotalDeAvaliacoes();
		meuFilme.getMedia();
		
		Serie lost = new Serie("lost", 2000);
		
		lost.exibeFixaTecnica();
		lost.setTemporadas(10);
		lost.setEpidodiosPorTemporada(10);
		lost.setMinutosPorEpisodio(50);
		System.out.println("duração filme: " + meuFilme.getDuracaoEmMinutos());
		System.out.println("duração para maratonar lost: " + lost.getDuracaoEmMinutos());
		
		//Dá pra usar o var (inferencia do tipo);
		Filme filmeDoPaulo = new Filme("Dogville", 2003);
		
		filmeDoPaulo.setDuracaoEmMinutos(200);
		filmeDoPaulo.avalia(10);
		
		
		Filme outroFilme = new Filme("Dois viado", 2000);
		outroFilme.setDuracaoEmMinutos(200);
		
		ArrayList<Filme> listaDeFilmes = new ArrayList<>();
		listaDeFilmes.add(filmeDoPaulo);
		listaDeFilmes.add(meuFilme);
		listaDeFilmes.add(outroFilme);
		System.out.println("Tamanho da lista " + listaDeFilmes.size());
		System.out.println("Primeiro filme " + listaDeFilmes.get(0).getNome());
		System.out.println(listaDeFilmes);
		System.out.println("ToString do filme " + listaDeFilmes.get(0).toString());
		
		CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
		calculadora.inclui(meuFilme);
		calculadora.inclui(outroFilme);
		calculadora.inclui(lost);
		System.out.println(calculadora.getTempoTotal());
		
		FiltroRecomendacao filtro = new FiltroRecomendacao();
		filtro.filtra(meuFilme);
		
		Episodio epi = new Episodio();
		epi.setNumero(1);
		epi.setSerie(lost);
		epi.setTotalDeVisualizacoes(300);
		filtro.filtra(epi);
		
		
	}
}	

