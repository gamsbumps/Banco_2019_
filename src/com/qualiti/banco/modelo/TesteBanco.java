package com.qualiti.banco.modelo;
//conta com numero e saldo. dois clientes vao ser iguais quando
public class TesteBanco {
	public static void main(String[] args) {
		
		Conta cont = new Conta("1231");
		
		Cliente cli = new Cliente("Ana Maria", "088");
		
		cont.setSaldo(2000);
		cont.setCliente(cli);
		
		System.out.println(cont);
		
		Conta c3 = new Conta("3333");
		
		Conta c4 = new Conta("1111-3");
		
		if(c3.equals(c4)){
			System.out.println("c3 e c4 são iguais");
		}else{
			System.out.println("c3 e c4 são diferentes");
		}
		
		
		
		Conta cont2 = new Conta();
		
		cont2.setNumero("3333-s");
		cont2.setSaldo(30000);
		cont2.debitar(10000);
		System.out.println(cont2.getSaldo());
		
		
		
		
		
		Cliente cli2 = new Cliente();
		
		if(cli.equals(cli2)){
			System.out.println("mesmo cliente");
		}else{
			System.out.println("clientes diferentes");
		}
		
		
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
