package com.qualiti.banco.modelo;

import java.util.Arrays;

public class Cliente extends Pessoa implements Comparable<Cliente> {
	
	public Cliente(){
		super();
	}
	
	public Cliente(String nome, String cpf){
		super(nome,cpf);
	}
	
	@Override
	/**
	 * retorna 0 quando forem objetos com ordem igual
	 * retorna -1 quando this for menor que o parametro
	 * retorna 1 quando this for maior que o parametro
	 */
	public int compareTo(Cliente o) {
		
		return this.getNome().compareTo(o.getNome());
	}
	
	public static void main(String[] args) {
		Cliente[] clientes = new Cliente[2];
		
		Cliente cli1 = new Cliente();
		cli1.setNome("José joao");
		
		Cliente cli2 = new Cliente();
		cli2.setNome("rafael");
		
		clientes[0] = cli2;
		clientes[1] = cli1;
		
		Arrays.sort(clientes);
		
		for(Cliente cli : clientes){
			System.out.println(cli.getNome());
		}
		
	}
	

}
