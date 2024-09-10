// classes specifies the abstraction; what is common for all films
package br.com.alura.ProjetosEmJava.modelo;

import br.com.alura.ProjetosEmJava.calculadora.Classificavel;

public class Filme extends Título implements Classificavel{
	private String diretor;

	// Constructor
	public Filme(String nome, int anoDeLancamento) {
		super(nome, anoDeLancamento);
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public int getClassificacao() {
		return (int) getMedia() / 2;
	}
	
	@Override
	public String toString() {
		return "Filme: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
	}
	
}