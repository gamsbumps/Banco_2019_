package com.qualiti.banco.negocio;

import com.qualiti.banco.dados.ContaDAO;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.TipoConta;

public class ContaBOImpl implements ContaBO {

	private ContaDAO repositorio;
	
	 public ContaBOImpl(ContaDAO repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public void inserir(Conta conta) {
		if (conta == null) {
			System.out.println("Objeto conta null");
			return;
		}
		if (conta.getNumero().length() != 6) {
			System.out.println("Número de conta invalido");
			return;
		}

		if (conta.getNumero() == null || conta.getNumero().isEmpty()) {
			System.out.println("Numero da conta deve ser preenchido");
			return;
		}
		Conta contaBusca = repositorio.procurar(conta.getNumero());
		if (contaBusca == null) {
			repositorio.inserir(conta);
		} else
			System.out.println("numero de conta ja cadastrado");
	}

	@Override
	public void atualizar(Conta conta) {
		if (conta == null) {
			System.out.println("Objeto conta null");
			return;
		}
		if (conta.getNumero().length() != 6) {
			System.out.println("Número de conta invalido");
			return;
		}

		if (conta.getNumero() == null || conta.getNumero().isEmpty()) {
			System.out.println("Numero da conta deve ser preenchido");
			return;
		}
		Conta contaBusca = repositorio.procurar(conta.getNumero());
		if (contaBusca != null) {
			repositorio.atualizar(conta);
		} else
			System.out.println("numero de conta não existe");

	}

	@Override
	public void remover(String numero) {
		if (numero == null || numero.isEmpty()) {
			System.out.println("numero da conta deve ser informado");
			return;
		}
		if (numero.length() != 6) {
			System.out.println("Número de conta invalido");
			return;
		}
		repositorio.remover(numero); 
	}

	@Override
	public Conta procurar(String numero) {
		if (numero == null || numero.isEmpty()) {
			System.out.println("numero da conta deve ser informado");
			return null;
		}
		if (numero.length() != 6) {
			System.out.println("Número de conta invalido");
			return null;
		}
		return repositorio.procurar(numero);
	}

	@Override
	public String gerarRelatorioContas() {
		
		return repositorio.gerarRelatorioContas();
	}

	@Override
	public double somarSaldo(TipoConta tipo) {
		
		return repositorio.somarSaldo(tipo);
	}

}
