package com.algaworks.cursojava.financeiro.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.algaworks.cursojava.financeiro.dao.ContaReceberDAO;
import com.algaworks.cursojava.financeiro.modelo.ContaReceber;
import com.algaworks.cursojava.financeiro.modelo.OperacaoContaException;


public class jdbcContaReceberDAO implements ContaReceberDAO {
	Connection connection;
	
	
	public jdbcContaReceberDAO(Connection connection) {
		this.connection = connection;
	}
	
	
	public void salvarConta(ContaReceber contaReceber) throws SQLException {
		String sql = String.format("insert into conta_receber (id_pessoa, conta_descricao, conta_valor, conta_vencimento, conta_situacao)"
				+ "values (%d, '%s', %.2f, '" + contaReceber.getDataVencimento() + "', '%s')", contaReceber.getCliente().getId(), contaReceber.getDescricao()
				, contaReceber.getValor(), contaReceber.getSituacaoconta());
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.executeUpdate();
		this.connection.close();
		
	}

	
	public void receberConta(Long id_conta) throws SQLException, OperacaoContaException {
		String sql = String.format("select * from conta_receber where id_conta_receber = %d;", id_conta);
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			if (rs.getString("conta_situacao").equalsIgnoreCase("PAGA") || rs.getString("conta_situacao").equalsIgnoreCase("CANCELADA")) {
				throw new OperacaoContaException("Conta não pode ser recebida.");
			}
			String updateSql = String.format("UPDATE conta_receber SET conta_situacao = 'PAGA' WHERE id_conta_receber = %d;", id_conta);
			PreparedStatement updatePS = this.connection.prepareStatement(updateSql);
			updatePS.executeUpdate();
			System.out.println("Conta Recebida com sucesso!");	
		} 
		
		this.connection.close();
	}

	
	public ContaReceber buscarConta(Long  id_conta) throws SQLException {
		String sql = String.format("select * from conta_receber where id_conta_receber = %d;", id_conta);
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ContaReceber contaReceber = new ContaReceber();
		
		while (rs.next()) {
			contaReceber.setDataVencimento(rs.getDate("conta_vencimento"));
			contaReceber.setDescricao(rs.getString("conta_descricao"));
			contaReceber.setSituacaoconta(rs.getString("conta_situacao"));
			contaReceber.setValor(rs.getDouble("conta_valor"));
			
		}
		
		this.connection.close();
		return contaReceber;
	}

	
	public List<ContaReceber> buscarTodas() throws SQLException {
		List <ContaReceber> contas = new ArrayList<ContaReceber>();
		String sql  = "select * from conta_receber";
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			ContaReceber conta = new ContaReceber();
			conta.setId(rs.getLong("id_conta_receber"));
			conta.setDataVencimento(rs.getDate("conta_vencimento"));
			conta.setDescricao(rs.getString("conta_descricao"));
			conta.setSituacaoconta(rs.getString("conta_situacao"));
			conta.setValor(rs.getDouble("conta_valor"));
			contas.add(conta);
		}
		this.connection.close();
		return contas;
	}


	
	public void cancelar(Long id_conta) throws SQLException, OperacaoContaException {
		String sql = String.format("select * from conta_receber where id_conta_receber = %d;", id_conta);
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			if (rs.getString("conta_situacao").equalsIgnoreCase("PAGA") || rs.getString("conta_situacao").equalsIgnoreCase("CANCELADA")) {
				throw new OperacaoContaException("Conta não pode ser cancelada.");
			}
			String updateSql = String.format("UPDATE conta_receber SET conta_situacao = 'CANCELADA' WHERE id_conta_receber = %d;", id_conta);
			PreparedStatement updatePS = this.connection.prepareStatement(updateSql);
			updatePS.executeUpdate();
			System.out.println("Conta cancelada com sucesso!");	
		} 
		
		this.connection.close();
		
	}

}
