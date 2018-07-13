package com.bianisoft.rpgengine;


public class RPG_Item{
	String m_stName;
	int m_nCashValue;
	int m_nWeight;
			
	public RPG_Item(String p_stName, int p_nWeight, int p_nCashValue){
		m_stName= p_stName;
		m_nWeight= p_nWeight;
		m_nCashValue= p_nCashValue;
	}
}
