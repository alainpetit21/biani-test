package com.bianisoft.rpgengine.internals;

//RPG Engine imports
import com.bianisoft.rpgengine.RPG_Character;


public class HP{
	public HP_Calculation m_objHPCalc;
	public int m_nCur;
	public int m_nMax;
	public int m_nTemp;
	public int m_nBloodied;
	
	public void update(RPG_Character p_objChar){
		m_nMax= m_objHPCalc.getMaxHP(p_objChar.m_xp.m_nLevel, p_objChar.m_abCON.getValue());
		m_nBloodied= m_nMax / 2;
	}
	
	public int getCurHP()	{return m_nCur;}
	public void healFully()	{m_nCur= m_nMax;}
	public void applyDmg(int p_nDmg){
		m_nCur-= p_nDmg;
	}
}
