package com.bianisoft.rpgengine.internals;


import com.bianisoft.rpgengine.RPG_Character;


public class XP{
	public int m_nXP;
	public int m_nLevel;
	
	
	public void update(RPG_Character p_obCharacter){
		if(m_nXP > 1000000)		m_nLevel= 30;
		else if(m_nXP > 825000)	m_nLevel= 29;
		else if(m_nXP > 675000)	m_nLevel= 28;
		else if(m_nXP > 550000)	m_nLevel= 27;
		else if(m_nXP > 450000)	m_nLevel= 26;
		else if(m_nXP > 375000)	m_nLevel= 25;
		else if(m_nXP > 310000)	m_nLevel= 24;
		else if(m_nXP > 225000)	m_nLevel= 23;
		else if(m_nXP > 210000)	m_nLevel= 22;
		else if(m_nXP > 175000)	m_nLevel= 21;
		else if(m_nXP > 143000)	m_nLevel= 20;
		else if(m_nXP > 119000)	m_nLevel= 19;
		else if(m_nXP > 99000)	m_nLevel= 18;
		else if(m_nXP > 83000)	m_nLevel= 17;
		else if(m_nXP > 69000)	m_nLevel= 16;
		else if(m_nXP > 57000)	m_nLevel= 15;
		else if(m_nXP > 47000)	m_nLevel= 14;
		else if(m_nXP > 39000)	m_nLevel= 13;
		else if(m_nXP > 32000)	m_nLevel= 12;
		else if(m_nXP > 26000)	m_nLevel= 11;
		else if(m_nXP > 20500)	m_nLevel= 10;
		else if(m_nXP > 16500)	m_nLevel= 9;
		else if(m_nXP > 13000)	m_nLevel= 8;
		else if(m_nXP > 10000)	m_nLevel= 7;
		else if(m_nXP > 7500)	m_nLevel= 6;
		else if(m_nXP > 5500)	m_nLevel= 5;
		else if(m_nXP > 3750)	m_nLevel= 4;
		else if(m_nXP > 2250)	m_nLevel= 3;
		else if(m_nXP > 1000)	m_nLevel= 2;
		else if(m_nXP > 0)		m_nLevel= 1;
	}
}

