package com.qualiti.banco.dados;

import com.qualiti.banco.excecoes.BancoException;

public interface GenericDAO<G, CHAVE> { //G � o cliente ou conta.CHAVE � a chave primaria
	void inserir(G entity) throws BancoException; 
	void atualizar(G entity) throws BancoException;
	void remover(CHAVE chave) throws BancoException;
	G procurar(CHAVE chave) throws BancoException;

}
