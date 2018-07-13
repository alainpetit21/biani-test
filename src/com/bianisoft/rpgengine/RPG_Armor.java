package com.bianisoft.rpgengine;

public class RPG_Armor extends RPG_Item{
	int m_nAC;
	
	public RPG_Armor(String p_stName, int p_nWeight, int p_nCashValue, int p_nAC){
		super(p_stName, p_nWeight, p_nCashValue);
		
		m_nAC= p_nAC;
	}
}
