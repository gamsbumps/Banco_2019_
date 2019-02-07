package com.qualiti.banco.dados.list;

import java.util.ArrayList;
import java.util.List;

import com.qualiti.banco.dados.ContaDAO;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.Poupan�a;
import com.qualiti.banco.modelo.TipoConta;

//para virar contaDAO tem que fazer implementa��o pela interface contaDAO
public class ContaDAOListImpl implements ContaDAO {
	
	private List<Conta> repositorio;
	
	public ContaDAOListImpl() {
		repositorio = new ArrayList<>();
	}

	@Override
	public void inserir(Conta conta) {
		repositorio.add(conta);
		
	}

	@Override
	public void atualizar(Conta conta) {
//		int indice = repositorio.indexOf(conta);
//		repositorio.set(indice, conta);
		repositorio.remove(conta);
		repositorio.add(conta);
		
	}

	@Override
	public void remover(String numero) {
		//ira procurar a mesma referencia e apagar pra substituir por uma nova
		Conta contaRetorno = procurar(numero);
		repositorio.remove(contaRetorno);
		
	}

	@Override
	public Conta procurar(String numero) {
	
		for (Conta conta : repositorio){
			
			if(conta != null && conta.getNumero().equals(numero)){
				return conta;
			}
			
		}
		
		return null;
	}

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
			} else if (tipo.equals(TipoConta.POUPAN�A)) {
				if (conta.getClass()==Poupan�a.class) {
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
