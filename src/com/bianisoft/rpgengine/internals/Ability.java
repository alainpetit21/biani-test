package com.bianisoft.rpgengine.internals;


import com.bianisoft.rpgengine.RPG_Character;


public class Ability{
	static final int[] m_nBuyingCost= {1, 1, 1, 1, 1, 2, 2, 2, 2, 5};
	
	public int m_nScore;
	public int m_nModifier;
	public int m_nHalfLevelMod;
	
	public int m_nCurBuyingIdx= 0;
	
	public void update(RPG_Character p_objChar){
		m_nHalfLevelMod= p_objChar.m_xp.m_nLevel / 2;
		m_nModifier= (int)((m_nScore - 10) /2);
	}
	
	public int getValue(){
		return m_nScore+m_nModifier+m_nHalfLevelMod;
	}
	
	public boolean buyPoint(int[] p_nPointsBank){
		if(m_nCurBuyingIdx == 10)
			return false;
		
		if((p_nPointsBank[0] - m_nBuyingCost[m_nCurBuyingIdx]) >= 0){
			++m_nScore;
			p_nPointsBank[0]-= m_nBuyingCost[m_nCurBuyingIdx++];
			return true;
		}
		
		return false;
	}
}

