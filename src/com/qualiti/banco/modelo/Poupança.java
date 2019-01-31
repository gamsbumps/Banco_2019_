package com.qualiti.banco.modelo;
//usar 'extends' apos a classe + a classe que herda.
public class Poupança extends Conta {
	
	public void renderJuros(double taxa){
		
		double saldoPoupança = getSaldo();
		saldoPoupança = saldoPoupança+saldoPoupança*taxa;
		setSaldo(saldoPoupança);
	}
	

}
