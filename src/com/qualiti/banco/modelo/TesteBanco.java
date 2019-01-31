package com.qualiti.banco.modelo;
//conta com numero e saldo
public class TesteBanco {
	public static void main(String[] args) {
		
		Conta cont = new Conta();
		
		cont.setNumero("31231-2");
		cont.setSaldo(500);
		
		cont.creditar(1000);
		cont.debitar(1000);
		
		Conta cont2 = new Conta();
		
		cont2.setNumero("3333-s");
		cont2.setSaldo(30000);
		cont2.debitar(10000);
		System.out.println(cont2.getSaldo());
		
		Conta c3 = new Conta("3333");
		
		Cliente cli = new Cliente("Ana Maria", "088");
		
		Cliente cli2 = new Cliente();
		
		
		cont.setSaldo(1000);
		cont2.setSaldo(1000);
		
		cont.transferir(cont2, 500);
		System.out.println("saldo conta 2: " +cont2.getSaldo());
		
		System.out.println("saldo conta 1: "+cont.getSaldo());
		
		cont.transferir(cont2, 1000);
		System.out.println("saldo conta 2: " +cont2.getSaldo());
		
		System.out.println("saldo conta 1: "+cont.getSaldo());

		Poupança pou = new Poupança();
		
		pou.setNumero("777-a");
		pou.setSaldo(30000);
		pou.creditar(8000);
		pou.renderJuros(0.1);
		System.out.println(pou.getSaldo());
		
		ContaBonus cb1 = new ContaBonus();
		cb1.creditar(1000);
		
		System.out.println("saldo cb" +cb1.getSaldo());
		System.out.println("bonus cb1" +cb1.getBonus());
		
		
	
	}

}
