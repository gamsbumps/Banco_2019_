package com.qualiti.banco.modelo;
//usar 'extends' apos a classe + a classe que herda.
public class Poupan�a extends Conta {
	
	public void renderJuros(double taxa){
		
		double saldoPoupan�a = getSaldo();
		saldoPoupan�a = saldoPoupan�a+saldoPoupan�a*taxa;
		setSaldo(saldoPoupan�a);
	}
	

}
