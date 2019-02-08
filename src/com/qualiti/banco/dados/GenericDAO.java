package com.qualiti.banco.dados;

public interface GenericDAO<G, CHAVE> { //G � o cliente ou conta.CHAVE � a chave primaria
	void inserir(G entity); 
	void atualizar(G entity);
	void remover(CHAVE chave);
	G procurar(CHAVE chave);

}
