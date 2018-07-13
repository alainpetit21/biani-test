package com.bianisoft.rpgengine;


//Bianisoft library imports
import com.bianisoft.engine.helper.Random;


public class RPG_Weapon extends RPG_Item{
	int m_nRangeMin, m_nRangeMax;
	
	public RPG_Weapon(String p_stName, int p_nWeight, int p_nCashValue, int p_nMin, int p_nMax){
		super(p_stName, p_nWeight, p_nCashValue);
		m_nRangeMin= p_nMin;
		m_nRangeMax= p_nMax;
	}
	
	public int rollDmgDie(){
		return ((int)Random.rand(m_nRangeMax-m_nRangeMin)+m_nRangeMin);
	}
}
