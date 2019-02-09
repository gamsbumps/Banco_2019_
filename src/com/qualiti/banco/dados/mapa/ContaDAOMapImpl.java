package com.qualiti.banco.dados.mapa;

import com.qualiti.banco.dados.ContaDAO;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.Poupança;
import com.qualiti.banco.modelo.TipoConta;

public class ContaDAOMapImpl extends GenericDAOMapImpl<Conta, String> implements ContaDAO {
	

	@Override
	public String gerarRelatorioContas() {
		String retorno = "";
		for (Conta conta : repositorio.values()) {
			retorno = retorno + conta.getNumero() + "---------" + conta.getSaldo() + "\n";

		}
		return retorno;
	}

	@Override
	public double somarSaldo(TipoConta tipo) {
		double soma = 0;
		for (Conta conta : repositorio.values()) {
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
