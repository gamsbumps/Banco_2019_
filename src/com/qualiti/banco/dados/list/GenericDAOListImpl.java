package com.qualiti.banco.dados.list;

import java.util.ArrayList;
import java.util.List;

import com.qualiti.banco.dados.GenericDAO;
import com.qualiti.banco.modelo.BancoEntity;

public class GenericDAOListImpl<G extends BancoEntity<CHAVE>, CHAVE> implements GenericDAO<G, CHAVE>{
	
private List<G> repositorio;
	
	public GenericDAOListImpl() {
		repositorio = new ArrayList<>();
	}

	@Override
	public void inserir(G entity) {
		repositorio.add(entity);
		
	}

	@Override
	public void atualizar(G entity) {
		repositorio.remove(entity);
		repositorio.add(entity);
		
	}

	@Override
	public void remover(CHAVE chave) {
		G entityRetorno = procurar(chave);
		repositorio.remove(entityRetorno);
		
	}

	@Override
	public G procurar(CHAVE chave) {
for (G entity : repositorio){
			
			if(entity != null && entity.getChave().equals(chave)){
				return entity;
			}
			
		}
		
		return null;
	}

}
