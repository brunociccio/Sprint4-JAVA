package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Cliente;
import br.com.fiap.dao.ClienteDAO;


public class ClienteBO {
	// instanciar objeto
	ClienteDAO clienteDAO;
	
	// select
	public ArrayList<Cliente> selecionarBO() throws ClassNotFoundException, SQLException {
		clienteDAO = new ClienteDAO();
		return (ArrayList<Cliente>) clienteDAO.selecionar();
	}
	
	// insert
	public void inserirBo(Cliente cliente) throws ClassNotFoundException, SQLException {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.inserir(cliente);
	}
	
	// update
	public void atualizarBo(Cliente cliente) throws ClassNotFoundException, SQLException {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.atualizar(cliente);
	}
	
	// delete
	public void deletarBo(int idCliente) throws ClassNotFoundException, SQLException {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.deletar(idCliente);
	}
}
