package com.qualiti.banco.negocio;

import com.qualiti.banco.dados.ClienteDAO;
import com.qualiti.banco.modelo.Cliente;

public class ClienteBOImpl implements ClienteBO {
	
	private ClienteDAO repositorio;
	
	 public ClienteBOImpl(ClienteDAO repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public void inserir(Cliente cliente) {
		if(cliente == null){
			System.out.println("Cliente null");
			return;
		}
		
		if(cliente.getCpf() == null || cliente.getCpf().isEmpty()){
			System.out.println("Cpf não informado");
			return;
		}
		if(cliente.getCpf().length() !=14){
			System.out.println("Cpf invalido");
			return;
		}
		
		Cliente clienteBusca = repositorio.procurar(cliente.getCpf());
		if(clienteBusca==null){
			repositorio.inserir(cliente);
			
		}else{
			System.out.println("cpf ja cadastrado");
		}
		
	}

	@Override
	public void atualizar(Cliente cliente) {
		if(cliente == null){
			System.out.println("Cliente null");
			return;
		}
		
		if(cliente.getCpf() == null || cliente.getCpf().isEmpty()){
			System.out.println("Cpf não informado");
			return;
		}
		if(cliente.getCpf().length() !=14){
			System.out.println("Cpf invalido");
			return;
		}
		
		Cliente clienteBusca = repositorio.procurar(cliente.getCpf());
		if(clienteBusca!=null){
			repositorio.atualizar(cliente);
			
		}else{
			System.out.println("cpf nao cadastrado");
		}
		
	}

	@Override
	public void remover(String cpf) {
		
		if(cpf == null || cpf.isEmpty()){
			System.out.println("Cpf não informado");
			return;
		}
		if(cpf.length() !=14){
			System.out.println("Cpf invalido");
			return;
		}
		repositorio.remover(cpf);
	
	}

	@Override
	public Cliente procurar(String cpf) {
		if(cpf == null || cpf.isEmpty()){
			System.out.println("Cpf não informado");
			return null;
		}
		if(cpf.length() !=14){
			System.out.println("Cpf invalido");
			return null;
		}
		
		return repositorio.procurar(cpf);
	}

}
