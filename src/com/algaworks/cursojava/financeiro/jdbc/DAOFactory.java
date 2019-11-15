package com.algaworks.cursojava.financeiro.jdbc;

import com.algaworks.cursojava.financeiro.dao.ContaPagarDAO;
import com.algaworks.cursojava.financeiro.dao.ContaReceberDAO;
import com.algaworks.cursojava.financeiro.dao.FornecedorDAO;
import com.algaworks.cursojava.financeiro.dao.ClienteDAO;

public abstract class DAOFactory {
	
	public static DAOFactory getDAOFactory() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return new jdbcDAOFactory();
	}
	
	public abstract ClienteDAO getClienteDAO();
	public abstract FornecedorDAO getFornecedorDAO();
	public abstract ContaPagarDAO getContaPAgarDAO();
	public abstract ContaReceberDAO getContaReceberDAO();
	
	
	
	

}
