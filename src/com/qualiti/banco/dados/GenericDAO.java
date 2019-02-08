package com.qualiti.banco.dados;

public interface GenericDAO<G, CHAVE> { //G é o cliente ou conta.CHAVE é a chave primaria
	void inserir(G entity); 
	void atualizar(G entity);
	void remover(CHAVE chave);
	G procurar(CHAVE chave);

}
