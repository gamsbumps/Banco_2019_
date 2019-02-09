package com.qualiti.banco.dados.list;

import com.qualiti.banco.dados.ContaDAO;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.Poupança;
import com.qualiti.banco.modelo.TipoConta;

//para virar contaDAO tem que fazer implementação pela interface contaDAO
public class ContaDAOListImpl extends GenericDAOListImpl<Conta, String> implements ContaDAO {
	


	@Override
	public String gerarRelatorioContas() {
		String retorno = "";
		for (Conta conta : repositorio) {
			retorno = retorno + conta.getNumero() + "---------" + conta.getSaldo() + "\n";

		}
		return retorno;
		
	}

	@Override
	public double somarSaldo(TipoConta tipo) {
		double soma = 0;
		for (Conta conta : repositorio) {
			if (tipo == null) {
				soma = soma + conta.getSaldo();
			} else if (tipo.equals(TipoConta.POUPANÇA)) {
				if (conta.getClass()==Poupança.class) {
					soma = soma + conta.getSaldo();
				}
			} else if (tipo.equals(TipoConta.CORRENTE)) {
				if (conta.getClass()==Conta.class) {
					soma = soma + conta.getSaldo();
				}
			}
		}
		return soma;
	}
	
	

}
