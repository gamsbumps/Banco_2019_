package com.qualiti.banco.dados.mapa;

import java.util.Hashtable;
import java.util.Map;

import com.qualiti.banco.dados.GenericDAO;
import com.qualiti.banco.modelo.BancoEntity;

public class GenericDAOMapImpl <G extends BancoEntity<CHAVE>, CHAVE> implements GenericDAO<G, CHAVE> {
	
	protected Map<CHAVE, G> repositorio;
	
	public GenericDAOMapImpl() {
		repositorio = new Hashtable<>();
	}

	@Override
	public void inserir(G entity) {
		repositorio.put(entity.getChave(), entity);
		
	}

	@Override
	public void atualizar(G entity) {
		repositorio.put(entity.getChave(), entity);
		
	}

	@Override
	public void remover(CHAVE chave) {
		repositorio.remove(chave);
		
	}

	@Override
	public G procurar(CHAVE chave) {
		return repositorio.get(chave);
	}

}
