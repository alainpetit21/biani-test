package com.bianisoft.rpgengine.internals;


import com.bianisoft.rpgengine.RPG_Character;


public class Defense{
	public int	m_nBase;
	public int	m_nHalfLevelMod;
	public int	m_nAbilityMod;
	public int	m_nClassMod;
	public int	m_nFeatMod;
	public int	m_nEnhMod;
	public int	m_nMisc1Mod;
	public int	m_nMisc2Mod;
	
	public void update(RPG_Character p_objChar){
		m_nBase= 10;
		m_nHalfLevelMod= p_objChar.m_xp.m_nLevel / 2;
	}
	
	public int getValue(){
		return m_nBase+m_nHalfLevelMod+m_nAbilityMod+m_nClassMod+m_nFeatMod+m_nEnhMod+m_nMisc1Mod+m_nMisc2Mod;
	}
}

