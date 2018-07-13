package com.bianisoft.rpgengine;


//Standard Java library imports
import java.util.ArrayList;


public class RPG_Engine{
	static public RPG_Engine g_rpgEngine;
	
	public ArrayList<RPG_Character> m_arEntities= new ArrayList<RPG_Character>();
	public int m_nCurAttacker;
	
	
	public RPG_Engine()	{g_rpgEngine= this;}
	
	public boolean analyseFactions(){
		boolean isInCombat= false;
		
		for(int i= 0; i < m_arEntities.size(); ++i){
			RPG_Character objChar1= m_arEntities.get(i);
			
			if(!objChar1.m_arEvilTo.isEmpty()){
				for(int j= 0; j < m_arEntities.size(); ++j){
					RPG_Character objChar2= m_arEntities.get(i);

					if(objChar2.getCurHP() <= -10){
						objChar1.m_arEvilTo.remove(objChar2);
						m_arEntities.remove(objChar2);
						i= 0;
						j= 0;
					}
				}
			}
		}
		
		//Determine if the combat is over
		for(RPG_Character objChar1 : m_arEntities){
			if(!objChar1.m_arEvilTo.isEmpty()){
				isInCombat= true;
				break;
			}
		}
		
		return isInCombat;
	}
	
	public void prepareInitiativeList(){
		for(int i= 0; i < m_arEntities.size(); ++i){
			RPG_Character objChar1= m_arEntities.get(i);

			for(int j= i+1; j < m_arEntities.size(); ++j){
				RPG_Character objChar2= m_arEntities.get(i);

				if(objChar1.getInitiative() > objChar2.getInitiative()){
					m_arEntities.set(j, objChar1);
					m_arEntities.set(i, objChar2);
					i= -1;
					break;
				}
			}
		}
		
		m_nCurAttacker= 0;
	}
	
	public RPG_Character getNextAttacker(){
		if(m_nCurAttacker > m_arEntities.size())
			return null;
		
		return (RPG_Character)m_arEntities.get(m_nCurAttacker++);
	}
	
	public void registerCharacter(RPG_Character p_char){
		m_arEntities.add(p_char);
	}
}
