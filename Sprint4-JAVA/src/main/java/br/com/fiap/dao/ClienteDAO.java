package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Cliente;
import br.com.fiap.conexoes.ConexaoSav;

public class ClienteDAO {
	
	public Connection minhaConexao;
	// método const
	public ClienteDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoSav().conexao();
	}
	// insert
	public String inserir (Cliente cliente) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(" insert into T_SAV_CLIENTE values (?,?,?,?,?,?,?)");
		stmt.setInt(1, cliente.getIdCliente());;
		stmt.setString(2, cliente.getNome());
		stmt.setString(3, cliente.getDataDeNascimento());
		stmt.setString(4, cliente.getEstadoCivil());
		stmt.setString(5, cliente.getSexo());
		stmt.setDouble(6, cliente.getRenda());
		stmt.setString(7, cliente.getProfissao());
		stmt.execute();
		stmt.close();
		return "Cadastrado com Sucesso!";
	}
	// update
	public String atualizar (Cliente cliente) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(" UPDATE T_SAV_CLIENTE SET NOME=?, DT_NASC=?, ESTADO_CIVIL=?, SEXO=?, RENDA=?, PROFISSAO=?, WHERE ID_CLIENTE");
		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getDataDeNascimento());
		stmt.setString(3, cliente.getEstadoCivil());
		stmt.setString(4, cliente.getSexo());
		stmt.setDouble(5, cliente.getRenda());
		stmt.setString(6, cliente.getProfissao());
		stmt.setInt(7, cliente.getIdCliente());;
		stmt.executeUpdate();
		stmt.close();
		return "Cadastro Atualizado com sucesso!";
	}
	// delete
	public String deletar (int idCliente) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(" DELETE FROM T_SAV_CLIENTE WHERE ID_CLIENTE");
		stmt.setInt(1, idCliente);
		stmt.executeUpdate();
		stmt.close();
		return "Deletado com sucesso!";
	}
	// select
	public List<Cliente> selecionar() throws SQLException {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		PreparedStatement stmt = minhaConexao.prepareStatement(" SELECT * FROM T_SAV_CLIENTE");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Cliente cliente = new Cliente();
			
			cliente.setIdCliente(rs.getInt(1));
			cliente.setNome(rs.getString(2));
			cliente.setDataDeNascimento(rs.getString(3));
			cliente.setEstadoCivil(rs.getString(4));
			cliente.setSexo(rs.getString(5));
			cliente.setRenda(rs.getDouble(6));
			cliente.setProfissao(rs.getString(7));
		}
		
		rs.close();
		stmt.close();
		
		return listaClientes;
	}
}

