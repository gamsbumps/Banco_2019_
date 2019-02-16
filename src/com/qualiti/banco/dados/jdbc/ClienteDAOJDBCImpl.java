package com.qualiti.banco.dados.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.qualiti.banco.dados.ClienteDAO;
import com.qualiti.banco.excecoes.BancoException;
import com.qualiti.banco.modelo.Cliente;

public class ClienteDAOJDBCImpl implements ClienteDAO {

	@Override
	public void inserir(Cliente entity) throws BancoException {

		Connection con = JDBCConnection.getConnection();

		String sql = "insert into pessoa (cpf, nome, telefone, email, login, senha," + "tipo) values('"
				+ entity.getCpf() + "','" + entity.getNome() + "','" + entity.getTelefone() + "','" + entity.getEmail()
				+ "','" + entity.getLogin() + "','" + entity.getSenha() + "','" + entity.getTipo().name() + "')";

		String sqlEnd = "insert into endereco (cpf, cep, logradouro, numero, complemento, bairro, cidade, uf) values('"
				+ entity.getCpf() + "','" + entity.getEndereco().getCep() + "','" + entity.getEndereco().getLogradouro()
				+ "','" + entity.getEndereco().getNumero() + "','" + entity.getEndereco().getComplemento() + "','"
				+ entity.getEndereco().getBairro() + "','" + entity.getEndereco().getCidade() + "','"
				+ entity.getEndereco().getUf() + "')";

		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);

			stm = con.createStatement();
			stm.executeUpdate(sqlEnd);
		} catch (SQLException e) {

			throw new BancoException("Problemas ao acessar a base de dados");

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				throw new BancoException("Problemas ao acessar a base de dados");
			}
		}

	}

	@Override
	public void atualizar(Cliente entity) {

	}

	@Override
	public void remover(String chave) throws BancoException {

		Connection con = JDBCConnection.getConnection();

		String sql = "delete from pessoa where cpf =?";

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, chave);

			pstm.executeUpdate();

		} catch (SQLException e) {

			throw new BancoException("Problemas ao acessar a base de dados");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				throw new BancoException("Problemas ao acessar a base de dados");
			}
		}
	}

	@Override
	public Cliente procurar(String chave) {

		return null;
	}

}
