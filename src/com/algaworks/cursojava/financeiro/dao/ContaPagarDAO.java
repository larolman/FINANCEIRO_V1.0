package com.algaworks.cursojava.financeiro.dao;

import java.sql.SQLException;
import java.util.List;

import com.algaworks.cursojava.financeiro.modelo.ContaPagar;
import com.algaworks.cursojava.financeiro.modelo.OperacaoContaException;

public interface ContaPagarDAO {
	
	public void salvarConta(ContaPagar contaPagar) throws SQLException, OperacaoContaException;
	
	public void pagarConta(Long id_conta) throws SQLException, OperacaoContaException;
	
	public void cancelarConta(Long id_conta) throws SQLException, OperacaoContaException;
	
	public ContaPagar buscarConta(ContaPagar contaPagar) throws SQLException, OperacaoContaException;
	
	public List<ContaPagar> buscarTodas() throws SQLException, OperacaoContaException;

}
