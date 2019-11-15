package com.algaworks.cursojava.financeiro.modelo;

public class ContaPagar extends Conta{
	private Long id;
	private Fornecedor fornecedor;
	
	public ContaPagar() {
		
	}
	
	public ContaPagar(Fornecedor fornecedor, String descricao, double valor, java.sql.Date dataVencimento) {
		this.fornecedor = fornecedor;
		this.descricao = descricao;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	
// Métodos substituídos por DAO	
//	public void pagar() throws OperacaoContaException{
//		
//		if (this.situacaoconta == "CANCELADA" || this.situacaoconta == "PAGA") {
//			throw new OperacaoContaException("Conta com status " + this.situacaoconta + " não pode ser paga.");
//		} 
//			this.situacaoconta = "PAGA";
//			System.out.println("---------------------");
//			System.out.println("Fornedor: " + this.fornecedor.nome);
//			System.out.println("Sting descricao: " + this.descricao);
//			System.out.println("Valor: " + this.valor);
//			System.out.println("Vencimento: " + this.dataVencimento);
//			System.out.println(this.situacaoconta);
//			System.out.println("---------------------\n");
//	}
//
//	
//	public void exibirDetalhes() {
//		
//		System.out.println("---------------------");
//		System.out.println("Fornedor: " + this.fornecedor.nome);
//		System.out.println("Sting descricao: " + this.descricao);
//		System.out.println("Valor: " + this.valor);
//		System.out.println("Vencimento: " + this.dataVencimento);
//		System.out.println(this.situacaoconta);
//		System.out.println("---------------------\n");
//		
//	}
	
	
}
