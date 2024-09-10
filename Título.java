package br.com.alura.ProjetosEmJava.modelo;

import com.google.gson.annotations.SerializedName;

import br.com.alura.ProjetosEmJava.excecao.ErroDeConversaoDeAnoException;

public class Título implements Comparable<Título>{
	private String nome;
	private int anoDeLancamento;
	private boolean incluidoNoPlano;
	private double somaDasAvalicoes;
	private int totalDeAvaliacoes;
	private int duracaoEmMinutos;
	
	//criando um metodo
	public void exibeFixaTecnica() {
		System.out.println("Nome do filme: " + nome);
		System.out.println("Ano de lançamento: " + anoDeLancamento);
	}
	
	public void avalia(double nota) {
		somaDasAvalicoes += nota;
		totalDeAvaliacoes++;
	}
	
	//getter method
	public double getMedia() {
		return somaDasAvalicoes / totalDeAvaliacoes;
	}
	public int getTotalDeAvaliacoes() {
		return totalDeAvaliacoes;
	}
	
	// setter method
	public void setNome(String nome) {
		this.nome = nome;
	
	}
	public String getNome() {
		return nome;
	}

	public void setAnoDeLancamento(int anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}
	
	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public void setDuracaoEmMinutos(int duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
	}

	public int getDuracaoEmMinutos() {
		return duracaoEmMinutos;
	}

	public boolean isIncluidoNoPlano() {
		return incluidoNoPlano;
	}

	public void setIncluidoNoPlano(boolean incluidoNoPlano) {
		this.incluidoNoPlano = incluidoNoPlano;
	}
	
	public Título(String nome, int anoDeLancamento) {
		this.nome = nome;
		this.anoDeLancamento = anoDeLancamento;
	}

	public Título(TituloOmdb meuTituloOmdb) {
		this.nome = meuTituloOmdb.title();
		if (meuTituloOmdb.year().length() > 4) {
			throw new ErroDeConversaoDeAnoException("Não consegui converter o ano");
		}
		this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
		this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2));
	}

	@Override
	public int compareTo(Título outrotitulo) {
		return this.getNome().compareTo(outrotitulo.getNome());
	}

	@Override
	public String toString() {
		return "Título (nome = " + nome + 
				", anoDeLancamento = " + anoDeLancamento + 
				", duração em minutos = " + duracaoEmMinutos + ")";
	}
	
}
