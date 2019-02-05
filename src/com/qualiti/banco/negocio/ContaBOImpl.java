package com.qualiti.banco.negocio;

import com.qualiti.banco.dados.ContaDAO;
import com.qualiti.banco.excecoes.BancoException;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.TipoConta;

public class ContaBOImpl implements ContaBO {

	private ContaDAO repositorio;

	public ContaBOImpl(ContaDAO repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public void inserir(Conta conta) throws BancoException {
		if (conta == null) {
			throw new BancoException("Objeto conta null");
			
		}
		if (conta.getNumero().length() != 6) {
			throw new BancoException("Número de conta invalido");
			
		}

		if (conta.getNumero() == null || conta.getNumero().isEmpty()) {
			throw new BancoException("Numero da conta deve ser preenchido");
			
		}
		Conta contaBusca = repositorio.procurar(conta.getNumero());
		if (contaBusca == null) {
			repositorio.inserir(conta);
		} else
			throw new BancoException("numero de conta ja cadastrado");
	}

	@Override
	public void atualizar(Conta conta) throws BancoException {
		if (conta == null) {
			throw new BancoException("Objeto conta null");
			
		}
		if (conta.getNumero().length() != 6) {
			throw new BancoException("Número de conta invalido");
			
		}

		if (conta.getNumero() == null || conta.getNumero().isEmpty()) {
			throw new BancoException("Numero da conta deve ser preenchido");
			
		}
		Conta contaBusca = repositorio.procurar(conta.getNumero());
		if (contaBusca != null) {
			repositorio.atualizar(conta);
		} else
			throw new BancoException("numero de conta não existe");

	}

	@Override
	public void remover(String numero) throws BancoException {
		if (numero == null || numero.isEmpty()) {
			throw new BancoException("numero da conta deve ser informado");
			
		}
		if (numero.length() != 6) {
			throw new BancoException("Número de conta invalido");
			
		}
		repositorio.remover(numero);
	}

	@Override
	public Conta procurar(String numero) throws BancoException {
		if (numero == null || numero.isEmpty()) {
			throw new BancoException("numero da conta deve ser informado");
			
		}
		if (numero.length() != 6) {
			throw new BancoException("Número de conta invalido");
			
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

	@Override
	public void creditar(String numero, double valor) throws BancoException {
		if (numero == null || numero.isEmpty()) {
			throw new BancoException("numero da conta deve ser informado");
			
		}
		if (numero.length() != 6) {
			throw new BancoException("Número de conta invalido");
			
		}
		if (valor <= 0) {
			throw new BancoException("valor para crédito deve ser maior do que zero");
			
		}

		Conta contaRetorno = repositorio.procurar(numero);

		if (contaRetorno != null) {

			contaRetorno.creditar(valor);
			repositorio.atualizar(contaRetorno);

		} else {
			throw new BancoException("numero da conta nao existe");
		}

	}

	@Override
	public void debitar(String numero, double valor) throws BancoException {
		if (numero == null || numero.isEmpty()) {
			throw new BancoException("numero da conta deve ser informado");
			
		}
		if (numero.length() != 6) {
			throw new BancoException("Número de conta invalido");
			
		}
		if (valor <= 0) {
			throw new BancoException("valor para crédito deve ser maior do que zero");
			
		}

		Conta contaRetorno = repositorio.procurar(numero);

		if (contaRetorno != null) {

			contaRetorno.debitar(valor);
			repositorio.atualizar(contaRetorno);

		} else {
			throw new BancoException("numero da conta nao existe");
		}

	}

	@Override
	public void transferir(String numeroFonte, String numeroDestino, double valor) 
			                throws BancoException {
		if (numeroFonte == null || numeroFonte.isEmpty()) {
			throw new BancoException("numero da conta origem deve ser informado");
			
		}

		if (numeroFonte.length() != 6) {
			throw new BancoException("Número de conta origem invalido");
			
		}

		if (numeroDestino == null || numeroDestino.isEmpty()) {
			throw new BancoException("numero da conta destino deve ser informado");
			
		}

		if (numeroDestino.length() != 6) {
			throw new BancoException("Número de conta destino invalido");
			
		}

		if (valor <= 0) {
			throw new BancoException("valor para crédito deve ser maior do que zero");
			
		}

		Conta contaOrigem = repositorio.procurar(numeroFonte);

		if (contaOrigem != null) {
			
			Conta contaDestino = repositorio.procurar(numeroDestino);
			
			if(contaDestino != null){
				
				contaOrigem.transferir(contaDestino, valor);
				repositorio.atualizar(contaDestino);
				repositorio.atualizar(contaOrigem);
			}else{
				throw new BancoException("Numero de conta destino nao existe");
			}

		}else{
			throw new BancoException("Numero de conta origem nao existe");
		}

	}

	

}
