package com.qualiti.banco.modelo;
/*armazenar o bonus acumulado
 * a cada deposito, 10% deve ficar armazenador na conta
 */
public class ContaBonus extends Conta {

	private double bonus;
	@Override //redefinição da classe pai
	public void creditar(double valor){
		bonus = bonus + valor*0.1;
		super.creditar(valor);
		
	}
	public void renderBonus(){
		super.creditar(bonus);//credita o bonus no saldo e depois zera
		bonus=0;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	
}
