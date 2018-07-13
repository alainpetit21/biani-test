package com.bianisoft.rpgengine.internals;


import com.bianisoft.rpgengine.RPG_Character;


public class Initiative{
	int m_nDexMod;
	int m_nHalfLevelMod;
	int m_nMiscMod;
	
	public void update(RPG_Character p_objChar){
		m_nHalfLevelMod= p_objChar.m_xp.m_nLevel / 2;
		m_nDexMod= p_objChar.m_abDEX.m_nModifier;
	}
	
	public int getValue(){
		return m_nDexMod+m_nHalfLevelMod+m_nMiscMod;
	}
}

