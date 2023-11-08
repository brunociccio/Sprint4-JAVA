package br.com.fiap.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Cliente;
import br.com.fiap.dao.ClienteDAO;

public class TesteSelect {
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
		
		List<Cliente> listaCliente = (ArrayList<Cliente>) dao.selecionar();
				
				if(listaCliente != null) {
					// forreach
					for( Cliente cliente : listaCliente) {
						System.out.println(cliente.getIdCliente() + " " +
								cliente.getNome() + " " +
								cliente.getDataDeNascimento() + " " +
								cliente.getEstadoCivil() + " " + 
								cliente.getSexo() + " " +
								cliente.getProfissao() + " " +
								cliente.getRenda() + " ");
			}
		}

	}

}
 