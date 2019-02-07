package com.qualiti.banco.gui;
import com.qualiti.banco.excecoes.BancoException;
import com.qualiti.banco.fachada.Fachada;
import com.qualiti.banco.fachada.IFachada;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.Poupança;
import com.qualiti.banco.modelo.TipoConta;

public class BancoTeste {
	public static void main(String[] args) {
		
		Conta c = new Conta();
		c.setNumero("123");
		c.setSaldo(1290);
		
		Poupança p = new Poupança();
		p.setNumero("129");
		p.setSaldo(8000);
		
		IFachada fachada =  Fachada.getFachada();
		
		IFachada fachada1 =  Fachada.getFachada();//qualquer outra que chamar, virá da primeira ja criada
		
		try {
			fachada.inserirConta(c);
		} catch (BancoException e) {
			System.out.println(e.getMessage());
		}
		try {
			fachada.inserirConta(p);
		} catch (BancoException e) {
			System.out.println(e.getMessage());
		}
		
		Conta retorno;
		try {
			retorno = fachada.procurarConta("123");
			
			if(retorno!=null){
				System.out.println("Conta encontrada: Saldo - " +retorno.getSaldo());
			}else{
				System.out.println("Conta não existe");
			}
		} catch (BancoException e) {
			System.out.println(e.getMessage());
		}
		
		
		String relatorio = fachada.gerarRelatorioContas();
		System.out.println(relatorio);
		
		double totalSaldos = fachada.somarSaldo(null);
		System.out.println(totalSaldos);
		
		double totalSaldosPoupancas = fachada.somarSaldo(TipoConta.POUPANÇA);
		System.out.println(totalSaldosPoupancas);
		
		double totalSaldosContasCorrentes = fachada.somarSaldo(TipoConta.CORRENTE);
		System.out.println(totalSaldosContasCorrentes);
	}

}
