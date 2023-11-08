package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Cliente;
import br.com.fiap.dao.ClienteDAO;

public class TesteDelete {
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
		ClienteDAO dao = new ClienteDAO();
		Cliente objCliente = new Cliente();
		
		objCliente.setIdCliente(inteiro("ID cliente: "));	
		
		System.out.println(dao.deletar(objCliente.getIdCliente()));
	    
		}
	}