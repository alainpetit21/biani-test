package com.bianisoft.rpgengine.internals;

//Bianisoft library imports
import com.bianisoft.engine.helper.Random;

//Rpg engine imports
import com.bianisoft.rpgengine.RPG_Character;
import com.bianisoft.rpgengine.RPG_Weapon;


public class AttackMeleeVsAC extends Attack{
	public Defense getAttackedDefense(RPG_Character p_objEnn){
		return p_objEnn.m_defAC;
	}
	
	public float rollHitDie(RPG_Character p_objEnn){
		float nRes= Random.rand(19)+1;
		float nPercentHit= nRes / p_objEnn.m_defAC.getValue();
		
		if((int)nRes == 1)
			return 0.0f;
		if((int)nRes == 20)
			return 2.0f;
		if(nPercentHit > 1.0f)
			return 1.0f;
		
		return nPercentHit;
	}
	
	public int rollDmgDie(){
		RPG_Weapon objWeapon= (RPG_Weapon)m_objItemUsed;
		
		return objWeapon.rollDmgDie();
	}
}

