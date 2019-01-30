package com.qualiti.banco.modelo;
//conta com numero e saldo
public class TesteBanco {
	public static void main(String[] args) {
		
		Conta cont = new Conta();
		
		cont.setNumero("31231-2");
		cont.setSaldo(500);
		
		cont.creditar(1000);
		
		
		
		System.out.println(cont.getSaldo());
		
	
	}

}
