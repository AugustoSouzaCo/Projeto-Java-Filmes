package br.com.alura.ProjetosEmJava.modelo;
// record recursso que representa classe imutavel contem apenass atributos leitores e metodos de leitura
//usado quando é necessario criar um objeto apenas para representear dados, sem nenhum comportamento
//imutabilidade = objeto nao pode ser alterado apos criado/instanciado
public record TituloOmdb(String title, String year, String runtime) {
	

}
