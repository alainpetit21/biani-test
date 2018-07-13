package com.bianisoft.rpgengine.internals;

import com.bianisoft.rpgengine.RPG_Character;
import com.bianisoft.rpgengine.RPG_Item;


public class Attack{
	public RPG_Item	m_objItemUsed;
	public int		m_nHalfLevelMod;
	public int		m_nAbilityMod;
	public int		m_nClassMod;
	public int		m_nProfMod;
	public int		m_nFeatMod;
	public int		m_nEnhMod;
	public int		m_nMiscMod;
	
	//Actionned Attack
	public float	m_nLastRatioHit;
	public int		m_nLastDmg;
	
	public void update(RPG_Character p_objChar){
		m_nHalfLevelMod= p_objChar.m_xp.m_nLevel / 2;
	}
	
	public int getValue(){
		return m_nHalfLevelMod+m_nAbilityMod+m_nClassMod+m_nProfMod+m_nFeatMod+m_nEnhMod+m_nMiscMod;
	}
	
	public Defense getAttackedDefense(RPG_Character p_objEnn){
		return null;
	}
	
	public float rollHitDie(RPG_Character p_objEnn){
		return 0.0f;
	}
	
	public int rollDmgDie(){
		return 0;
	}
}



