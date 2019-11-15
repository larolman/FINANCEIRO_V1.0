package com.algaworks.cursojava.financeiro.modelo;

import java.util.Date;

public abstract class Conta {

	protected String descricao;
	protected double valor;
	protected java.sql.Date dataVencimento;
	protected String situacaoconta;
	
	public Conta() {
		
		this.situacaoconta = "PENDENTE";
		
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setDataVencimento(java.sql.Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	
	
	public String getSituacaoconta() {
		return situacaoconta;
	}

	public void setSituacaoconta(String situacaoconta) {
		this.situacaoconta = situacaoconta;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValor() {
		return valor;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}
	
	

}
