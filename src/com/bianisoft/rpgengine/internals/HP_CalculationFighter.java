package com.bianisoft.rpgengine.internals;


public class HP_CalculationFighter implements HP_Calculation{
	public int getMaxHP(int p_nLevel, int p_nCON){
		return (p_nLevel*6) + 9 + p_nCON;
	}
}
