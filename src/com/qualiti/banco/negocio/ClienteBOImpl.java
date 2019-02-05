package com.qualiti.banco.negocio;

import com.qualiti.banco.dados.ClienteDAO;
import com.qualiti.banco.excecoes.BancoException;
import com.qualiti.banco.modelo.Cliente;

public class ClienteBOImpl implements ClienteBO {

	private ClienteDAO repositorio;

	public ClienteBOImpl(ClienteDAO repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public void inserir(Cliente cliente) throws BancoException {
		if (cliente == null) {
			throw new BancoException("Cliente null");

		}

		if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
			throw new BancoException("Cpf não informado");

		}
		if (cliente.getCpf().length() != 14) {
			throw new BancoException("Cpf invalido");

		}

		Cliente clienteBusca = repositorio.procurar(cliente.getCpf());
		if (clienteBusca == null) {
			repositorio.inserir(cliente);

		} else {
			throw new BancoException("cpf ja cadastrado");
		}

	}

	@Override
	public void atualizar(Cliente cliente) throws BancoException {
		if (cliente == null) {
			throw new BancoException("Cliente null");

		}

		if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
			throw new BancoException("Cpf não informado");

		}
		if (cliente.getCpf().length() != 14) {
			throw new BancoException("Cpf invalido");

		}

		Cliente clienteBusca = repositorio.procurar(cliente.getCpf());
		if (clienteBusca != null) {
			repositorio.atualizar(cliente);

		} else {
			throw new BancoException("cpf nao cadastrado");
		}

	}

	@Override
	public void remover(String cpf) throws BancoException {

		if (cpf == null || cpf.isEmpty()) {
			throw new BancoException("Cpf não informado");
			
		}
		if (cpf.length() != 14) {
			throw new BancoException("Cpf invalido");
			
		}
		repositorio.remover(cpf);

	}

	@Override
	public Cliente procurar(String cpf) throws BancoException {
		if (cpf == null || cpf.isEmpty()) {
			throw new BancoException("Cpf não informado");
			
		}
		if (cpf.length() != 14) {
			throw new BancoException("Cpf invalido");
			
		}

		return repositorio.procurar(cpf);
	}

}
