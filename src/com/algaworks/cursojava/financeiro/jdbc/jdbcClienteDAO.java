package com.algaworks.cursojava.financeiro.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.algaworks.cursojava.financeiro.dao.ClienteDAO;
import com.algaworks.cursojava.financeiro.modelo.Cliente;


public class jdbcClienteDAO implements ClienteDAO {
	
	private Connection  connection;
	
	public jdbcClienteDAO(Connection connection) {
		this.connection = connection;
	}

	
	public void salvarCliente(Cliente cliente) throws SQLException {
		String sql = String.format("insert into pessoa (nome_pessoa, tipo) values ('%s', 'Cliente')", cliente.getNome());
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.executeUpdate();
		System.out.println("Cliente salvo com sucesso!");
		
	}


	
	public Cliente buscarCliente(Long id) throws SQLException {
		Cliente cliente = null;
		String sql = String.format("select * from pessoa where id_pessoa = %d", id);
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			cliente = new Cliente();
			cliente.setId(rs.getLong("id_pessoa"));
			cliente.setNome(rs.getString("nome_pessoa"));
			
		}
		
		return cliente;
	}
	
	public List<Cliente> buscarTodos() throws SQLException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "select * from pessoa where tipo ='Cliente'";
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			Cliente cliente = new Cliente();
			cliente.setId(rs.getLong("id_pessoa"));
			cliente.setNome(rs.getString("nome_pessoa"));
			clientes.add(cliente);
		}
		
		return clientes;
	}

}
