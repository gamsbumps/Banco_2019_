package com.qualiti.banco.modelo;

import java.time.LocalDate;

public class Conta {

	private String numero;
	private double saldo;
	private LocalDate dataAbertura;
	private TipoConta tipo;
	private Cliente cliente;
	
//	@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof Conta) {
//
//			Conta c = (Conta) obj;
//
//			return numero.equals(c.getNumero());
//		}
//
//		return false;
//
//	}

	public Conta() {
		saldo = 1000;
	}

	public Conta(String numero) {
		this.numero = numero;

	}

	public void transferir(Conta contaDestino, double valor) {
		if (valor <= saldo) {
			debitar(valor);
			contaDestino.creditar(valor);
		} else {
			System.out.println("saldo insuficiente");
		}
	}
	


	public void creditar(double valor) {
		saldo = saldo + valor;
	}

	public void debitar(double valor) {
		if (valor <= saldo) {
			saldo = saldo - valor;
		} else {
			System.out.println("saldo insuficiente");
		}

	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("descri��o conta:\n");
		sb.append("Numero: ").append(this.numero).append("\n");
		sb.append("Saldo: ").append(this.saldo).append("\n");
		sb.append("Cliente: ").append(this.cliente.getCpf()).append("\n");
		
		return sb.toString();
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
