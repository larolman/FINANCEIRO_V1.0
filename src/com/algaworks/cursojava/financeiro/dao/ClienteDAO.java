package com.algaworks.cursojava.financeiro.dao;

import java.sql.SQLException;
import java.util.List;

import com.algaworks.cursojava.financeiro.modelo.Cliente;

public interface ClienteDAO {

	public void salvarCliente(Cliente cliente) throws SQLException;
	
	public Cliente buscarCliente(Long id) throws SQLException;
	
	public List<Cliente> buscarTodos() throws SQLException;
	
	

}
