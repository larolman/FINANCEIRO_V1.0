package com.algaworks.cursojava.financeiro.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.algaworks.cursojava.financeiro.dao.ContaPagarDAO;
import com.algaworks.cursojava.financeiro.modelo.ContaPagar;
import com.algaworks.cursojava.financeiro.modelo.OperacaoContaException;

public class jdbcContaPagarDAO implements ContaPagarDAO{
	Connection connection;
	
	public jdbcContaPagarDAO(Connection connection){
		this.connection = connection;
		
	}


	public void salvarConta(ContaPagar contaPagar) throws SQLException {
		String sql = String.format("insert into conta_pagar (id_pessoa, conta_descricao, conta_valor, conta_vencimento, conta_situacao)"
				+ "values (%d, '%s', %.2f, '" + contaPagar.getDataVencimento() + "', '%s')", contaPagar.getFornecedor().getId(), contaPagar.getDescricao()
				, contaPagar.getValor(), contaPagar.getSituacaoconta());
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.executeUpdate();
		this.connection.close();
		
	}

	
	public void pagarConta(Long id_conta) throws SQLException, OperacaoContaException {
		String sql = String.format("select * from conta_pagar where id_conta_pagar = %d;", id_conta);
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			if (rs.getString("conta_situacao") == "PENDENTE" || rs.getString("conta_situacao") == "CANCELADA") {
				throw new OperacaoContaException("Conta não pode ser paga.");
				
			}
			String updateSql = String.format("UPDATE conta_pagar SET conta_situacao = 'PAGA' WHERE id_conta_pagar = %d;", id_conta);
			PreparedStatement updatePS = this.connection.prepareStatement(updateSql);
			updatePS.executeUpdate();
			System.out.println("Conta Paga com sucesso!");	
		} 
		
		this.connection.close();
		
	}

	
	public void cancelarConta(Long id_conta) throws SQLException, OperacaoContaException {
		String sql = String.format("select * from conta_pagar where id_conta_pagar = %d;", id_conta);
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			if (rs.getString("conta_situacao") == "PAGA" || rs.getString("conta_situacao") == "CANCELADA") {
				throw new OperacaoContaException("Conta não pode ser cancelada.");
			}
			String updateSql = String.format("UPDATE conta_pagar SET conta_situacao = 'CANCELADA' WHERE id_conta_pagar = %d;", id_conta);
			PreparedStatement updatePS = this.connection.prepareStatement(updateSql);
			updatePS.executeUpdate();
			System.out.println("Conta cancelada com sucesso!");	
		} 
		
		this.connection.close();
		
	}

	
	public ContaPagar buscarConta(ContaPagar contaPagar) throws SQLException {
	
		String sql = String.format("select * from conta_pagar"
				+ "where id_conta_pagar = %d;", contaPagar.getId());
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			contaPagar.setDataVencimento(rs.getDate("conta_vencimento"));
			contaPagar.setDescricao(rs.getString("conta_descricao"));
			contaPagar.setSituacaoconta(rs.getString("conta_situacao"));
			contaPagar.setValor(rs.getDouble("conta_valor"));
			
		}
		
		this.connection.close();
		return contaPagar;
	}

	
	public List<ContaPagar> buscarTodas() throws SQLException {
		
		List <ContaPagar> contas = new ArrayList<ContaPagar>();
		String sql  = "select * from conta_pagar";
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			ContaPagar conta = new ContaPagar();
			conta.setId(rs.getLong("id_conta_pagar"));
			conta.setDataVencimento(rs.getDate("conta_vencimento"));
			conta.setDescricao(rs.getString("conta_descricao"));
			conta.setSituacaoconta(rs.getString("conta_situacao"));
			conta.setValor(rs.getDouble("conta_valor"));
			contas.add(conta);
		}
		this.connection.close();
		return contas;
	}


}
