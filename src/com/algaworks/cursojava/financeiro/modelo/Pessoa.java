package com.algaworks.cursojava.financeiro.modelo;

public abstract class Pessoa {
	protected Long id;
	protected String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Long getId() {
		return this.id;
	}
	

}
