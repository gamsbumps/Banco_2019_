package com.qualiti.banco.gui;
import com.qualiti.banco.fachada.Fachada;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.Poupan�a;
import com.qualiti.banco.modelo.TipoConta;

public class BancoTeste {
	public static void main(String[] args) {
		
		Conta c = new Conta();
		c.setNumero("123");
		c.setSaldo(1290);
		
		Poupan�a p = new Poupan�a();
		p.setNumero("129");
		p.setSaldo(8000);
		
		Fachada fachada = new Fachada();
		
		fachada.inserirConta(c);
		fachada.inserirConta(p);
		
		Conta retorno = fachada.procurarConta("123");
		if(retorno!=null){
			System.out.println("Conta encontrada: Saldo - " +retorno.getSaldo());
		}else{
			System.out.println("Conta n�o existe");
		}
		
		String relatorio = fachada.gerarRelatorioContas();
		System.out.println(relatorio);
		
		double totalSaldos = fachada.somarSaldo(null);
		System.out.println(totalSaldos);
		
		double totalSaldosPoupancas = fachada.somarSaldo(TipoConta.POUPAN�A);
		System.out.println(totalSaldosPoupancas);
		
		double totalSaldosContasCorrentes = fachada.somarSaldo(TipoConta.CORRENTE);
		System.out.println(totalSaldosContasCorrentes);
	}

}