package com.algaworks.cursojava.financeiro.dao;

import java.sql.SQLException;
import java.util.List;

import com.algaworks.cursojava.financeiro.modelo.Fornecedor;

public interface FornecedorDAO {

	public void salvarFornecedor(Fornecedor fornecedor) throws SQLException;
	
	public Fornecedor buscarFornecedor(Long id) throws SQLException;
	
	public List<Fornecedor> buscarTodos() throws SQLException;
	
	

}
