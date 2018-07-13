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
 * 01/03/11			0.1 First beta initial Version.
 * 12/09/11			0.1.1 Moved everything to a com.bianisoft and GPL
 *
 *-----------------------------------------------------------------------
 */
package com.bianisoft.tests.javatestapp;


//Bianisoft imports
import com.bianisoft.engine.App;
import com.bianisoft.engine.Camera;
import com.bianisoft.engine.Context;
import com.bianisoft.engine._3d.Object3D;
import com.bianisoft.engine._3d.ObjMD2;
//import com.bianisoft.engine.music.Music;
import com.bianisoft.engine.manager.MngInput;


public class MyContext4 extends Context {
//	Music			m_musicThisContext;
	Camera			m_objCam;
	Obj3DBoard		m_objBoard;
	ObjMD2			m_objMD2OfficerGold;
	ObjMD2			m_objMD2OfficerPearl;
	ObjMD2			m_objMD2OfficerJade;
	ObjMD2			m_objMD2OfficerRuby;
	ObjMD2			m_objMD2SoldierGold;
	ObjMD2			m_objMD2SoldierPearl;
	ObjMD2			m_objMD2SoldierJade;
	ObjMD2			m_objMD2SoldierRuby;
	ObjMD2			m_objMD2GeneralGold;
	ObjMD2			m_objMD2GeneralPearl;
	ObjMD2			m_objMD2GeneralJade;
	ObjMD2			m_objMD2GeneralRuby;
	Object3D		m_objInHand;

	Obj3DPyramide	m_objMouse;

	int			m_nHiglightPlayer;
	boolean		m_isInclined= true;


	public void activate(){
		super.activate();

		m_objCam= Camera.getCur(Camera.TYPE_3D);
		m_objCam.setCur();
		m_objCam.setPosY(4);
		m_objCam.setPosZ(-20);

		addChild(m_objBoard= new Obj3DBoard());
		addChild(m_objMouse= new Obj3DPyramide());
		m_objMD2OfficerGold= new ObjMD2("/res/3d/Officer.md2", "/res/3d/OfficerGold.png");
		m_objMD2OfficerPearl= new ObjMD2("/res/3d/Officer.md2", "/res/3d/OfficerPearl.png");
		m_objMD2OfficerJade= new ObjMD2("/res/3d/Officer.md2", "/res/3d/OfficerJade.png");
		m_objMD2OfficerRuby= new ObjMD2("/res/3d/Officer.md2", "/res/3d/OfficerRuby.png");
		m_objMD2SoldierGold= new ObjMD2("/res/3d/Soldier.md2", "/res/3d/SoldierGold.png");
		m_objMD2SoldierPearl= new ObjMD2("/res/3d/Soldier.md2", "/res/3d/SoldierPearl.png");
		m_objMD2SoldierJade= new ObjMD2("/res/3d/Soldier.md2", "/res/3d/SoldierJade.png");
		m_objMD2SoldierRuby= new ObjMD2("/res/3d/Soldier.md2", "/res/3d/SoldierRuby.png");
		m_objMD2GeneralGold= new ObjMD2("/res/3d/General.md2", "/res/3d/GeneralGold.png");
		m_objMD2GeneralPearl= new ObjMD2("/res/3d/General.md2", "/res/3d/GeneralPearl.png");
		m_objMD2GeneralJade= new ObjMD2("/res/3d/General.md2", "/res/3d/GeneralJade.png");
		m_objMD2GeneralRuby= new ObjMD2("/res/3d/General.md2", "/res/3d/GeneralRuby.png");
		m_objCam.lockOnObject(m_objBoard);
		
		m_objBoard.load();

		m_objMouse.setPos(0, 0, -5);
		m_objMouse.setAngleX(180);
		m_objMouse.setFilterAlpha(0.75f);
		m_objMouse.load();

		m_objMD2SoldierGold.setScalingFactor(0.25f);	m_objMD2SoldierGold.load();
		m_objMD2SoldierPearl.setScalingFactor(0.25f);	m_objMD2SoldierPearl.load();
		m_objMD2SoldierJade.setScalingFactor(0.25f);	m_objMD2SoldierJade.load();
		m_objMD2SoldierRuby.setScalingFactor(0.25f);	m_objMD2SoldierRuby.load();
		m_objMD2OfficerGold.setScalingFactor(0.20f);	m_objMD2OfficerGold.load();
		m_objMD2OfficerPearl.setScalingFactor(0.20f);	m_objMD2OfficerPearl.load();
		m_objMD2OfficerJade.setScalingFactor(0.20f);	m_objMD2OfficerJade.load();
		m_objMD2OfficerRuby.setScalingFactor(0.20f);	m_objMD2OfficerRuby.load();
		m_objMD2GeneralGold.setScalingFactor(0.25f);	m_objMD2GeneralGold.load();
		m_objMD2GeneralPearl.setScalingFactor(0.25f);	m_objMD2GeneralPearl.load();
		m_objMD2GeneralJade.setScalingFactor(0.25f);	m_objMD2GeneralJade.load();
		m_objMD2GeneralRuby.setScalingFactor(0.25f);	m_objMD2GeneralRuby.load();

		ObjMD2 obj;
		obj= new ObjMD2(m_objMD2GeneralGold);	obj.setAngleZ(180);	obj.setPos(-0.5f, 7.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2GeneralGold);	obj.setAngleZ(180);	obj.setPos(0.5f, 7.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerGold);	obj.setAngleZ(180);	obj.setPos(-1.5f, 7.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerGold);	obj.setAngleZ(180);	obj.setPos(-2.5f, 7.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerGold);	obj.setAngleZ(180);	obj.setPos(-3.5f, 7.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerGold);	obj.setAngleZ(180);	obj.setPos(1.5f, 7.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerGold);	obj.setAngleZ(180);	obj.setPos(2.5f, 7.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerGold);	obj.setAngleZ(180);	obj.setPos(3.5f, 7.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2SoldierGold);	obj.setAngleZ(180);	obj.setPos(-4.5f, 7.5f, -0.25f);	addChild(obj);
		obj= new ObjMD2(m_objMD2SoldierGold);	obj.setAngleZ(180);	obj.setPos(4.5f, 7.5f, -0.25f);		addChild(obj);
		for(int i= 0; i < 10; ++i){
			obj= new ObjMD2(m_objMD2SoldierGold);	obj.setAngleZ(180);	obj.setPos(-4.5f + i, 6.5f, -0.25f);	addChild(obj);
		}

		obj= new ObjMD2(m_objMD2GeneralPearl);	obj.setAngleZ(0);	obj.setPos(-0.5f, -7.5f, -0.5f);	addChild(obj);
		obj= new ObjMD2(m_objMD2GeneralPearl);	obj.setAngleZ(0);	obj.setPos(0.5f, -7.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerPearl);	obj.setAngleZ(0);	obj.setPos(-1.5f, -7.5f, -0.5f);	addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerPearl);	obj.setAngleZ(0);	obj.setPos(-2.5f, -7.5f, -0.5f);	addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerPearl);	obj.setAngleZ(0);	obj.setPos(-3.5f, -7.5f, -0.5f);	addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerPearl);	obj.setAngleZ(0);	obj.setPos(1.5f, -7.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerPearl);	obj.setAngleZ(0);	obj.setPos(2.5f, -7.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerPearl);	obj.setAngleZ(0);	obj.setPos(3.5f, -7.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2SoldierPearl);	obj.setAngleZ(0);	obj.setPos(-4.5f, -7.5f, -0.25f);	addChild(obj);
		obj= new ObjMD2(m_objMD2SoldierPearl);	obj.setAngleZ(0);	obj.setPos(4.5f, -7.5f, -0.25f);	addChild(obj);
		for(int i= 0; i < 10; ++i){
			obj= new ObjMD2(m_objMD2SoldierPearl);	obj.setAngleZ(0);	obj.setPos(-4.5f + i, -6.5f, -0.25f);	addChild(obj);
		}

		obj= new ObjMD2(m_objMD2GeneralJade);	obj.setAngleZ(90);	obj.setPos(-7.5f, -0.5f, -0.5f);	addChild(obj);
		obj= new ObjMD2(m_objMD2GeneralJade);	obj.setAngleZ(90);	obj.setPos(-7.5f, 0.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerJade);	obj.setAngleZ(90);	obj.setPos(-7.5f, -1.5f, -0.5f);	addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerJade);	obj.setAngleZ(90);	obj.setPos(-7.5f, -2.5f, -0.5f);	addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerJade);	obj.setAngleZ(90);	obj.setPos(-7.5f, -3.5f, -0.5f);	addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerJade);	obj.setAngleZ(90);	obj.setPos(-7.5f, 1.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerJade);	obj.setAngleZ(90);	obj.setPos(-7.5f, 2.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerJade);	obj.setAngleZ(90);	obj.setPos(-7.5f, 3.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2SoldierJade);	obj.setAngleZ(90);	obj.setPos(-7.5f, -4.5f, -0.25f);	addChild(obj);
		obj= new ObjMD2(m_objMD2SoldierJade);	obj.setAngleZ(90);	obj.setPos(-7.5f, 4.5f, -0.25f);	addChild(obj);
		for(int i= 0; i < 10; ++i){
			obj= new ObjMD2(m_objMD2SoldierJade);	obj.setAngleZ(90);	obj.setPos(-6.5f , -4.5f + i, -0.25f);	addChild(obj);
		}

		obj= new ObjMD2(m_objMD2GeneralRuby);	obj.setAngleZ(-90);	obj.setPos(7.5f, -0.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2GeneralRuby);	obj.setAngleZ(-90);	obj.setPos(7.5f, 0.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerRuby);	obj.setAngleZ(-90);	obj.setPos(7.5f, -1.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerRuby);	obj.setAngleZ(-90);	obj.setPos(7.5f, -2.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerRuby);	obj.setAngleZ(-90);	obj.setPos(7.5f, -3.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerRuby);	obj.setAngleZ(-90);	obj.setPos(7.5f, 1.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerRuby);	obj.setAngleZ(-90);	obj.setPos(7.5f, 2.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2OfficerRuby);	obj.setAngleZ(-90);	obj.setPos(7.5f, 3.5f, -0.5f);		addChild(obj);
		obj= new ObjMD2(m_objMD2SoldierRuby);	obj.setAngleZ(-90);	obj.setPos(7.5f, -4.5f, -0.25f);	addChild(obj);
		obj= new ObjMD2(m_objMD2SoldierRuby);	obj.setAngleZ(-90);	obj.setPos(7.5f, 4.5f, -0.25f);		addChild(obj);
		for(int i= 0; i < 10; ++i){
			obj= new ObjMD2(m_objMD2SoldierRuby);	obj.setAngleZ(-90);	obj.setPos(6.5f , -4.5f + i, -0.25f);	addChild(obj);
		}
	}

	public void rotate(){
		if(m_isInclined){
			switch(m_nHiglightPlayer){
			case 0:	m_objCam.moveTo(0, 4, -20, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);		break;
			case 1:	m_objCam.moveTo(-4, 0, -20, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);	break;
			case 2:	m_objCam.moveTo(0, -4, -20, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);	break;
			case 3:	m_objCam.moveTo(4, 0, -20, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);		break;
			}
		}else{
			switch(m_nHiglightPlayer){
			case 0:	m_objCam.moveTo(0, 0.04f, -20, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);		break;
			case 1:	m_objCam.moveTo(-0.04f, 0, -20, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);	break;
			case 2:	m_objCam.moveTo(0, -0.04f, -20, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);	break;
			case 3:	m_objCam.moveTo(0.04f, 0, -20, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);		break;
			}
		}			
	}

	public boolean keyboardManage(MngInput p_mngInput){
		if(!super.keyboardManage(p_mngInput))
			return false;

		if(m_nHiglightPlayer == 0){
			m_objMouse.setPosX(m_objMouse.getPosX() - ((float)p_mngInput.getMouseDeltaX())/30);
			m_objMouse.setPosY(m_objMouse.getPosY() - ((float)p_mngInput.getMouseDeltaY())/30);
		}else if(m_nHiglightPlayer == 1){
			m_objMouse.setPosX(m_objMouse.getPosX() - ((float)p_mngInput.getMouseDeltaY())/30);
			m_objMouse.setPosY(m_objMouse.getPosY() + ((float)p_mngInput.getMouseDeltaX())/30);
		}else if(m_nHiglightPlayer == 2){
			m_objMouse.setPosX(m_objMouse.getPosX() + ((float)p_mngInput.getMouseDeltaX())/30);
			m_objMouse.setPosY(m_objMouse.getPosY() + ((float)p_mngInput.getMouseDeltaY())/30);
		}else if(m_nHiglightPlayer == 3){
			m_objMouse.setPosX(m_objMouse.getPosX() + ((float)p_mngInput.getMouseDeltaY())/30);
			m_objMouse.setPosY(m_objMouse.getPosY() - ((float)p_mngInput.getMouseDeltaX())/30);
		}

		if(m_objInHand != null){
			if(p_mngInput.isKeyboardDown(MngInput.K_W)){
				m_objInHand.setPosY(m_objInHand.getPosY()-0.1f);
			}
		}

		if(!m_objCam.isMoving()){
			if(p_mngInput.isKeyboardClicked(MngInput.K_ARROW_UP)){
				m_isInclined= false;
				
				rotate();
			}else if(p_mngInput.isKeyboardClicked(MngInput.K_ARROW_DOWN)){
				m_isInclined= true;

				rotate();
			}else if(p_mngInput.isKeyboardClicked(MngInput.K_ARROW_RIGHT)){
				if((m_nHiglightPlayer+= 1) > 3)
					m_nHiglightPlayer= 0;

				rotate();
			}else if(p_mngInput.isKeyboardClicked(MngInput.K_ARROW_LEFT)){
				if((m_nHiglightPlayer-= 1) < 0)
					m_nHiglightPlayer= 3;

				rotate();
			}else if(p_mngInput.isKeyboardClicked(MngInput.K_ENTER)){
				App.g_theApp.setCurContext(AppJavaTest.ID_CTX5);
			}
		}

		return true;
	}
}
