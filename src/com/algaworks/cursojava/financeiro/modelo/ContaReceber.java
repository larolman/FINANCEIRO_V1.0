package com.algaworks.cursojava.financeiro.modelo;

public class ContaReceber extends Conta{
	
	private Cliente cliente;
	private Long id;
	
	
	public ContaReceber() {
		
		}
	
	public ContaReceber(Cliente cliente, String descricao, double valor, java.sql.Date dataVencimento) {
		this.cliente = cliente;
		this.descricao = descricao;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	
// Métodos substituídos por DAO
	
//	public void receber() throws OperacaoContaException {
//		
//		if (this.situacaoconta == "CANCELADA") {
//			
//			throw new OperacaoContaException("Conta com status " + this.situacaoconta + " não pode ser recebida.");
//			
//			
//		} 
//			this.situacaoconta = "PAGA";
//			System.out.println("---------------------");
//			System.out.println("Cliente: " + this.cliente.nome);
//			System.out.println("Sting descricao: " + this.descricao);
//			System.out.println("Valor: " + this.valor);
//			System.out.println("Vencimento: " + this.dataVencimento);
//			System.out.println(this.situacaoconta);
//			System.out.println("---------------------\n");
//			
//			
//		}
//	
//
//	public void cancelar() throws OperacaoContaException {
//		
//		if (this.valor > 50000d) {
//			
//			throw new OperacaoContaException("Contas com valor acima de 50k não podem ser canceladas!");			
//		} 
//		
//		super.cancelar();
//		
//	}
//
//	
//	public void exibirDetalhes() {
//		
//		System.out.println("---------------------");
//		System.out.println("Cliente: " + this.cliente.nome);
//		System.out.println("Sting descricao: " + this.descricao);
//		System.out.println("Valor: " + this.valor);
//		System.out.println("Vencimento: " + this.dataVencimento);
//		System.out.println(this.situacaoconta);
//		System.out.println("---------------------\n");
//		
//	}
			
		}

