package com.algaworks.cursojava.financeiro.dao;

import java.sql.SQLException;
import java.util.List;

import com.algaworks.cursojava.financeiro.modelo.ContaReceber;
import com.algaworks.cursojava.financeiro.modelo.OperacaoContaException;

public interface ContaReceberDAO {
	
	public void salvarConta(ContaReceber contaReceber) throws SQLException, OperacaoContaException;
	
	public void receberConta(Long id_conta) throws SQLException, OperacaoContaException;
	
	public void cancelar(Long  id_conta) throws SQLException, OperacaoContaException;
	
	public ContaReceber buscarConta(Long  id_conta) throws SQLException, OperacaoContaException;
	
	public List<ContaReceber> buscarTodas() throws SQLException, OperacaoContaException;

}
