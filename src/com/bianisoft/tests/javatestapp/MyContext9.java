/* This file is part of the Bianisoft Java Test App
 *
 * This game is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *----------------------------------------------------------------------
 * Copyright (C) Alain Petit - alainpetit21@hotmail.com
 *
 * 21/11/11			0.1 First beta initial Version.
 *
 *-----------------------------------------------------------------------
 */
package com.bianisoft.tests.javatestapp;


//Bianisoft imports
import com.bianisoft.engine.Camera;
import com.bianisoft.engine.Context;
import com.bianisoft.engine.manager.MngInput;
import com.bianisoft.engine.sprites.Sprite;

//RPG Engine imports
import com.bianisoft.rpgengine.RPG_Character;
import com.bianisoft.rpgengine.RPG_Engine;


public class MyContext9 extends Context{
	private Camera			m_objCam;
	private Sprite			m_sprCursor;

	RPG_Engine		m_rpgEngine= new RPG_Engine();
	RPG_Character	m_charFighter1= new RPG_Character(RPG_Character.RACE_HUMAN_ID, RPG_Character.CLASS_FIGHTER_ID, "Fighter1", 8, 8, 8, 8, 8, 8);
	RPG_Character	m_charFighter2= new RPG_Character(RPG_Character.RACE_HUMAN_ID, RPG_Character.CLASS_FIGHTER_ID, "Fighter2", 8, 8, 8, 8, 8, 8);
	RPG_Character	m_charFighter3= new RPG_Character(RPG_Character.RACE_HUMAN_ID, RPG_Character.CLASS_FIGHTER_ID, "Fighter3", 8, 8, 8, 8, 8, 8);

	
	public void activate(){
		super.activate();

		m_sprCursor= new Sprite("/res/sprites/Cursor.png");
		m_sprCursor.setTextID("Spr_Cursor");
		m_sprCursor.addState("StateName0", 1, 0.0f);
		m_sprCursor.addState("StateName1", 1, 0.0f);
		m_sprCursor.load();
		m_sprCursor.setHotSpot(0, 16);
		addChild(m_sprCursor, false, false);
		setCursor(m_sprCursor);
		
		m_objCam= Camera.getCur(Camera.TYPE_2D);
		
		//RPG Engine
		m_rpgEngine.registerCharacter(m_charFighter1);
		m_rpgEngine.registerCharacter(m_charFighter2);
		m_rpgEngine.registerCharacter(m_charFighter3);
		
		m_charFighter1.addEvilTo(m_charFighter3);

		m_charFighter2.addEvilTo(m_charFighter3);
		
		m_charFighter3.addEvilTo(m_charFighter1);
		m_charFighter3.addEvilTo(m_charFighter2);
		
		m_charFighter3.buySTRPoint();
		m_charFighter3.buySTRPoint();
		m_charFighter3.buySTRPoint();
		m_charFighter3.buySTRPoint();
		m_charFighter3.buySTRPoint();
		m_charFighter3.buySTRPoint();

		m_charFighter3.buyCONPoint();
		m_charFighter3.buyCONPoint();
		m_charFighter3.buyCONPoint();
		m_charFighter3.buyCONPoint();
		m_charFighter3.buyCONPoint();
		m_charFighter3.buyCONPoint();
		m_charFighter3.buyCONPoint();
		m_charFighter3.buyCONPoint();

		m_charFighter3.buyDEXPoint();
		m_charFighter3.buyDEXPoint();
		m_charFighter3.buyDEXPoint();
		m_charFighter3.buyDEXPoint();
		m_charFighter3.buyDEXPoint();
		m_charFighter3.buyDEXPoint();
		m_charFighter3.buyDEXPoint();
		m_charFighter3.buyDEXPoint();
		m_charFighter3.buyDEXPoint();
		m_charFighter3.buyDEXPoint();
		m_charFighter3.buyDEXPoint();
		m_charFighter3.buyDEXPoint();
		m_charFighter3.buyDEXPoint();
		
		m_charFighter3.buySTRPoint();
		m_charFighter3.buyINTPoint();
		
		m_charFighter1.update();	m_charFighter1.healFully();
		m_charFighter2.update();	m_charFighter2.healFully();
		m_charFighter3.update();	m_charFighter3.healFully();
		
		startCombat();
	}

	public void startCombat(){
		m_rpgEngine.prepareInitiativeList();
	}

	public boolean doAttack(){
		if(m_rpgEngine.m_arEntities.size() == 1)
			return false;
		if(!m_rpgEngine.analyseFactions())
			return false;
		
		RPG_Character curAttacker= m_rpgEngine.getNextAttacker();
		
		if(curAttacker.getCurHP() <= 0)
			return false;
		
		RPG_Character curTarget= (RPG_Character)curAttacker.m_arEvilTo.get(0);
		
		if(curTarget == null)
			return false;
		
		curAttacker.makeAttack(curTarget);
		
		if(curAttacker.getLastHitRatio() >= 1.5)
			System.out.print(curAttacker.m_stName +" critical hit "+ curTarget.m_stName +" for "+ curAttacker.getLastDmg() +" dmg.\n");
		else if(curAttacker.getLastHitRatio() > 0)
			System.out.print(curAttacker.m_stName +" hit @ "+ curAttacker.getLastHitRatio() +" "+ curTarget.m_stName +" for "+ curAttacker.getLastDmg() +" dmg.\n");
		else 
			System.out.print(curAttacker.m_stName +" misses!\n");
	
		curTarget.applyDmg(curAttacker.getLastDmg());
		
		curAttacker.printCharDebug();
		curTarget.printCharDebug();
		
		return true;
	}

	public boolean keyboardManage(MngInput p_mngInput){
		if(!super.keyboardManage(p_mngInput))
			return false;

		if (p_mngInput.isMouseClicked(MngInput.M_LEFT)){
			doAttack();
		}

		return true;
	}

	public void manage(float p_fRatioMovement) {
		super.manage(p_fRatioMovement);
	}

	public void draw(){
		super.draw();
	}	
}