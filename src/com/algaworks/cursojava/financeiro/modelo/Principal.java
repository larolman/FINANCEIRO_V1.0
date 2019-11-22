package com.algaworks.cursojava.financeiro.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.algaworks.cursojava.financeiro.dao.ClienteDAO;
import com.algaworks.cursojava.financeiro.dao.ContaPagarDAO;
import com.algaworks.cursojava.financeiro.dao.ContaReceberDAO;
import com.algaworks.cursojava.financeiro.dao.FornecedorDAO;
import com.algaworks.cursojava.financeiro.jdbc.DAOFactory;

public class Principal {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException
		,SQLException, OperacaoContaException {
		
		// instanciando fornecedores
//		Fornecedor imobiliaria = new Fornecedor();
//		imobiliaria.setNome("Casa & Cia Negócios Imobiliários");
//		imobiliaria.setId(1L);
//		Fornecedor mercado = new Fornecedor();
//		mercado.setNome("Mercado do João");
//		mercado.setId(2L);
		
//		FornecedorDAO fornecedorDAO = DAOFactory.getDAOFactory().getFornecedorDAO();
//		fornecedorDAO.salvarFornecedor(imobiliaria);
//		fornecedorDAO.salvarFornecedor(mercado);
//		
		// instanciando clientes
		Cliente atacadista = new Cliente();
		atacadista.setNome("Triângulo Quadrado Atacadista");
		atacadista.setId(4L);
		Cliente telecom = new Cliente();
		telecom.setNome("FoneNet Telecomunicações");
		telecom.setId(3L);
//		
//		ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();
//		clienteDAO.salvarCliente(telecom);
//		clienteDAO.salvarCliente(atacadista);
//		
		
//		Calendar c = new GregorianCalendar();
//		// instanciando contas a pagar
//		c.set(Calendar.DAY_OF_MONTH, 19);
//		c.set(Calendar.MONTH, 5);
//		c.set(Calendar.YEAR, 2012);
		java.sql.Date dateSql = new java.sql.Date(new java.util.Date().getTime());
		
//		ContaPagar contaPagar1 = new ContaPagar();
//		contaPagar1.setDescricao("Aluguel da matriz");
//		contaPagar1.setValor(1230d);
//		contaPagar1.setDataVencimento(dateSql);
//		contaPagar1.setFornecedor(imobiliaria);
//		contaPagar1.setSituacaoconta("PENDENTE");
//		
//		ContaPagarDAO contaPagarDAO = DAOFactory.getDAOFactory().getContaPAgarDAO();
//		contaPagarDAO.salvarConta(contaPagar1);
//		
//		
//		ContaPagar contaPagar2 = new ContaPagar(mercado, "Compras do mês", 390d, dateSql);
		
//		contaPagarDAO.salvarConta(contaPagar2);
//		contaPagarDAO.pagarConta(1L);
//		contaPagarDAO.cancelarConta(2L);
//		List<ContaPagar> contas =  contaPagarDAO.buscarTodas();
//		
//		for (ContaPagar c : contas) {
//			System.out.println(c.getDescricao());
//			System.out.println(c.getValor());
//			System.out.println(c.getDataVencimento());
//		}
		
		
//		
//		// instanciando contas a receber
		ContaReceber contaReceber1 = new ContaReceber();
		contaReceber1.setDescricao("Desenvolvimento de projeto de logística em Java");
		contaReceber1.setValor(89500d);
		contaReceber1.setDataVencimento(dateSql);
		contaReceber1.setCliente(atacadista);
		
		ContaReceber contaReceber2 = new ContaReceber(telecom, "Manutenção em sistema de conta online", 
			53200d, dateSql);
		
		ContaReceberDAO contaReceberDAO = DAOFactory.getDAOFactory().getContaReceberDAO();
//		contaReceberDAO.salvarConta(contaReceber2);
//		contaReceberDAO.receberConta(1L);
//		
		
		// pagamento e cancelamento de contas a pagar
//		try {
//			contaPagar1.pagar();
//		} catch (OperacaoContaException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//			contaPagar1.pagar();
//		} catch (OperacaoContaException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
//
//		// recebimento e cancelamento de contas a receber
//		try {
//			contaReceber1.receber();
//		} catch (OperacaoContaException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//			contaReceber2.cancelar();
//		} catch (OperacaoContaException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		} 
//		
		
		/* exibe listagem de todas as contas com detalhamento
		RelatorioContas relatorio = new RelatorioContas();
		Conta[] contas = new Conta[]{contaPagar1, contaPagar2, contaReceber1, contaReceber2};
		
		relatorio.exibirListagem(contas); */
				
		
	}
	
}
