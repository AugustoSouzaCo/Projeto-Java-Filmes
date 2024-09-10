package br.com.alura.ProjetosEmJava.calculadora;

import br.com.alura.ProjetosEmJava.modelo.Título;

public class CalculadoraDeTempo {
	private int tempoTotal;

	public int getTempoTotal() {
		return this.tempoTotal;
	}
//	public void inclui(Serie f) {
//		this.tempoTotal += f.getDuracaoEmMinutos();
//	}
//	public void inclui(Filme f) {
//		this.tempoTotal += f.getDuracaoEmMinutos();
//	}
	public void inclui(Título titulo) {
		this.tempoTotal += titulo.getDuracaoEmMinutos();
	}
}

