package com.qualiti.banco.modelo;
//BancoEntity é generico
public abstract class BancoEntity<CHAVE> {
	
	public abstract CHAVE getChave();

}
