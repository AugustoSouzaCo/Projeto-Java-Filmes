package br.com.alura.ProjetosEmJava.modelo;

public class Serie extends Título{
	
	private boolean ativa;
	private int temporadas;
	private int epidodiosPorTemporada;
	private int minutosPorEpisodio;
	
	public Serie(String nome, int anoDeLancamento) {
		super(nome, anoDeLancamento);
	}
	public boolean isAtiva() {
		return ativa;
	}
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
	public int getTemporadas() {
		return temporadas;
	}
	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}
	public int getEpidodiosPorTemporada() {
		return epidodiosPorTemporada;
	}
	public void setEpidodiosPorTemporada(int epidodiosPorTemporada) {
		this.epidodiosPorTemporada = epidodiosPorTemporada;
	}
	public int getMinutosPorEpisodio() {
		return minutosPorEpisodio;
	}
	public void setMinutosPorEpisodio(int minutosPorEpisodio) {
		this.minutosPorEpisodio = minutosPorEpisodio;
	}
	//sobrescrever metodo do titulo
	@Override
	public int getDuracaoEmMinutos() {
		return temporadas * epidodiosPorTemporada * minutosPorEpisodio;
	}
	
	@Override
	public String toString() {
		return "Série: " + this.getNome() + "(" + this.getAnoDeLancamento() + ")";
	}
		
	
}
