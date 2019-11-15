package com.algaworks.cursojava.financeiro.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.algaworks.cursojava.financeiro.dao.FornecedorDAO;
import com.algaworks.cursojava.financeiro.modelo.Fornecedor;


public class jdbcFornecedorDAO implements FornecedorDAO {
	
	private Connection  connection;
	
	public jdbcFornecedorDAO(Connection connection) {
		this.connection = connection;
	}

	
	public void salvarFornecedor(Fornecedor fornecedor) throws SQLException {
		String sql = String.format("insert into pessoa (nome_pessoa, tipo) values ('%s', 'Fornecedor')", fornecedor.getNome());
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.executeUpdate();
		System.out.println("Fornecedor salvo com sucesso!");
		
	}


	
	public Fornecedor buscarFornecedor(Long id) throws SQLException {
		Fornecedor fornecedor = null;
		String sql = String.format("select * from pessoa where id_pessoa = %d", id);
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			fornecedor = new Fornecedor();
			fornecedor.setId(rs.getLong("id_pessoa"));
			fornecedor.setNome(rs.getString("nome_pessoa"));
			
		}
		
		return fornecedor;
	}
	
	public List<Fornecedor> buscarTodos() throws SQLException {
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		String sql = "select * from pessoa where tipo ='Fornecedor'";
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setId(rs.getLong("id_pessoa"));
			fornecedor.setNome(rs.getString("nome_pessoa"));
			fornecedores.add(fornecedor);
		}
		
		return fornecedores;
	}

}
