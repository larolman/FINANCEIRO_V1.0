package com.algaworks.cursojava.financeiro.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.algaworks.cursojava.financeiro.dao.ContaPagarDAO;
import com.algaworks.cursojava.financeiro.dao.ContaReceberDAO;
import com.algaworks.cursojava.financeiro.dao.FornecedorDAO;
import com.algaworks.cursojava.financeiro.dao.ClienteDAO;

public class jdbcDAOFactory extends DAOFactory {
	
	private Connection connection;
	
	public jdbcDAOFactory() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection("jdbc:mysql://centos7/financeiro", "root", "3luproec");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}


	public ContaPagarDAO getContaPAgarDAO() {
		
		return new jdbcContaPagarDAO(connection);
	}

	
	public ContaReceberDAO getContaReceberDAO() {
		
		return new jdbcContaReceberDAO(connection);
	}


	
	public ClienteDAO getClienteDAO() {
		
		return new jdbcClienteDAO(connection);
	}



	public FornecedorDAO getFornecedorDAO() {
	
		return new jdbcFornecedorDAO(connection);
	}
	

}
