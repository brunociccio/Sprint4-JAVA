package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Cliente;
import br.com.fiap.dao.ClienteDAO;

public class TesteUpdate {
	static String texto(String j) {
		return JOptionPane.showInputDialog(j);
	}
	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	static double decimal(String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ClienteDAO dao = new ClienteDAO();
		Cliente objCliente = new Cliente();
		
		objCliente.setIdCliente(inteiro("ID cliente: "));		
		objCliente.setNome(texto("Nome: "));
		objCliente.setDataDeNascimento(texto("Data de nascimento: "));
		objCliente.setEstadoCivil(texto("Estado Civil: "));
		objCliente.setSexo(texto("Sexo: "));
		objCliente.setProfissao(texto("Profissão: "));
		objCliente.setRenda(decimal("Renda: "));
		
		System.out.println(dao.atualizar(objCliente));
	}

}
