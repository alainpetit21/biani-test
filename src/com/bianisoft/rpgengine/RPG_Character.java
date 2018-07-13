package com.bianisoft.rpgengine;


//Standard Java library imports
import java.util.ArrayList;

//RPG engine imports
import com.bianisoft.rpgengine.internals.Ability;
import com.bianisoft.rpgengine.internals.Attack;
import com.bianisoft.rpgengine.internals.AttackMeleeVsAC;
import com.bianisoft.rpgengine.internals.Defense;
import com.bianisoft.rpgengine.internals.HP;
import com.bianisoft.rpgengine.internals.HP_CalculationFighter;
import com.bianisoft.rpgengine.internals.Initiative;
import com.bianisoft.rpgengine.internals.XP;


public class RPG_Character{
	public static final int CLASS_FIGHTER_ID= 1;
	public static final int RACE_HUMAN_ID= 1;
	public static final String CLASS_FIGHTER_STRING= "Fighter";
	public static final String RACE_HUMAN_STRING= "Human";
	public static final String[] CLASS_ALL_STRING= {"Nil", CLASS_FIGHTER_STRING};
	public static final String[] RACE_ALL_STRING= {"Nil", RACE_HUMAN_STRING};
	
	
	public int m_nRaceID;
	public int m_nClassID;
	public String m_stName;
	
	public int[] m_nPointAbility= {32};
	public int[] m_nPointAbilityFreebie= {0};
	
	public Ability m_abSTR= new Ability();
	public Ability m_abCON= new Ability();
	public Ability m_abDEX= new Ability();
	public Ability m_abINT= new Ability();
	public Ability m_abWIS= new Ability();
	public Ability m_abCHA= new Ability();
			
	public Defense m_defAC	= new Defense();
	public Defense m_defFort= new Defense();
	public Defense m_defRef	= new Defense();
	public Defense m_defWill= new Defense();
	
	public Initiative m_objInitiative= new  Initiative();
	
	public XP	m_xp= new XP();
	public HP	m_hp= new HP();
	
	public RPG_Inventory	m_objInventory;
	public Attack			m_objCurAttack;
	
	public ArrayList<RPG_Character>	m_arEvilTo= new ArrayList<RPG_Character>();
	
	public RPG_Character(int p_nRaceID, int p_nClassID, String p_stName, int p_nSTR, int p_nCON, int p_nDEX, int p_nINT, int p_nWIS, int p_nCHA){
		m_nRaceID= p_nRaceID;
		m_nClassID= p_nClassID;
		m_stName= p_stName;
		
		m_abSTR.m_nScore= p_nSTR;
		m_abCON.m_nScore= p_nCON;
		m_abDEX.m_nScore= p_nDEX;
		m_abINT.m_nScore= p_nINT;
		m_abWIS.m_nScore= p_nWIS;
		m_abCHA.m_nScore= p_nCHA;
		
		m_nPointAbilityFreebie[0]= 2;
		
		if((p_nClassID == CLASS_FIGHTER_ID) && (p_nRaceID == RACE_HUMAN_ID)){
			m_hp.m_objHPCalc= new HP_CalculationFighter();
			m_objCurAttack= new AttackMeleeVsAC();
			m_objCurAttack.m_objItemUsed= new RPG_Weapon("Long Sword", 20, 100, 1, 8);
		}
			
		update();
		healFully();
	}
	
	public void update(){
		m_xp.update(this);
		
		m_abSTR.update(this);
		m_abCON.update(this);
		m_abDEX.update(this);
		m_abINT.update(this);
		m_abWIS.update(this);
		m_abCHA.update(this);
		
		m_defAC.update(this);	m_defAC.m_nAbilityMod= m_abDEX.m_nModifier;				
		m_defFort.update(this);
		m_defRef.update(this);
		m_defWill.update(this);
		
		m_objInitiative.update(this);
		
		if(m_abSTR.m_nModifier > m_abCON.m_nModifier)
			m_defFort.m_nAbilityMod= m_abSTR.m_nModifier;
		else
			m_defFort.m_nAbilityMod= m_abCON.m_nModifier;

		if(m_abDEX.m_nModifier > m_abINT.m_nModifier)
			m_defRef.m_nAbilityMod= m_abDEX.m_nModifier;
		else
			m_defRef.m_nAbilityMod= m_abINT.m_nModifier;

		if(m_abWIS.m_nModifier > m_abCHA.m_nModifier)
			m_defWill.m_nAbilityMod= m_abWIS.m_nModifier;
		else
			m_defWill.m_nAbilityMod= m_abCHA.m_nModifier;
		
		m_hp.update(this);
	}

	public void makeAttack(RPG_Character p_objEnn){
		//Get type of Attack
		Attack	curAttack= m_objCurAttack;
		Defense	curDefense= curAttack.getAttackedDefense(p_objEnn);
		
		//roll to Hit
		curAttack.m_nLastDmg= 0;
		curAttack.m_nLastRatioHit= curAttack.rollHitDie(p_objEnn);
		
		curAttack.m_nLastDmg= (int)(curAttack.m_nLastRatioHit * curAttack.rollDmgDie());
	}
	
	public void addEvilTo(RPG_Character p_objEnn){
		m_arEvilTo.add(p_objEnn);
	}
	
	public void removeEvilTo(RPG_Character p_objEnn){
		m_arEvilTo.remove(p_objEnn);
	}
	
	public boolean buySTRPoint()	{return buyAbilityPoint(m_abSTR);}
	public boolean buyCONPoint()	{return buyAbilityPoint(m_abCON);}
	public boolean buyDEXPoint()	{return buyAbilityPoint(m_abDEX);}
	public boolean buyINTPoint()	{return buyAbilityPoint(m_abINT);}
	public boolean buyWISPoint()	{return buyAbilityPoint(m_abWIS);}
	public boolean buyCHAPoint()	{return buyAbilityPoint(m_abCHA);}
	public boolean buyAbilityPoint(Ability p_ab){
		if(m_nPointAbilityFreebie[0] > 0){
			p_ab.buyPoint(m_nPointAbilityFreebie);
			p_ab.m_nCurBuyingIdx= 0;
			return true;
		}
		
		return p_ab.buyPoint(m_nPointAbility);
	}
	
	public int getCurHP()			{return m_hp.getCurHP();}
	public float getLastHitRatio()	{return m_objCurAttack.m_nLastRatioHit;}
	public int getLastDmg()			{return m_objCurAttack.m_nLastDmg;}
	public float getInitiative()	{return 1;}	//TODO fix this
	public void healFully()			{m_hp.healFully();}
	public void applyDmg(int p_nDmg){m_hp.applyDmg(p_nDmg);}
	
	public void printCharDebug(){
		System.out.print("----------\n");
		System.out.print("Name: " +m_stName+ "\tRace: " +RACE_ALL_STRING[m_nRaceID]+ "\tClass: " +CLASS_ALL_STRING[m_nClassID]+ "\n");
		
		System.out.print("HP: " +m_hp.m_nCur+ "\tMaxHP: " +m_hp.m_nMax+ "\n");
		System.out.print("XP: " +m_xp.m_nXP+ "\tLevel: " +m_xp.m_nLevel+ "\n");
		
		System.out.print("Extra buying point: " +m_nPointAbility[0]+ "\tExtra Freeebies points: " +m_nPointAbilityFreebie[0]+ "\n");
		
		System.out.print("STR: " +m_abSTR.getValue()+ "\t" +m_abSTR.m_nModifier+ "\n");
		System.out.print("CON: " +m_abCON.getValue()+ "\t" +m_abCON.m_nModifier+ "\n");
		System.out.print("DEX: " +m_abDEX.getValue()+ "\t" +m_abDEX.m_nModifier+ "\n");
		System.out.print("INT: " +m_abINT.getValue()+ "\t" +m_abINT.m_nModifier+ "\n");
		System.out.print("WIS: " +m_abWIS.getValue()+ "\t" +m_abWIS.m_nModifier+ "\n");
		System.out.print("CHA: " +m_abCHA.getValue()+ "\t" +m_abCHA.m_nModifier+ "\n");
		
		System.out.print("Defences: AC: " +m_defAC.getValue()+ "\n");
		System.out.print("Defences: FORT: " +m_defFort.getValue()+ "\n");
		System.out.print("Defences: REF: " +m_defRef.getValue()+ "\n");
		System.out.print("Defences: WILL: " +m_defWill.getValue()+ "\n");
		
	}
}
