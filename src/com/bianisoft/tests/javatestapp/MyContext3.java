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
//import com.bianisoft.engine.music.Music;
import com.bianisoft.engine.manager.MngInput;
//import com.bianisoft.engine.music.MusicMOD;


public class MyContext3 extends Context {
//	Music		m_musicThisContext;
	Camera		m_objCam;
	Obj3DBoard	m_objBoard;
	int			m_nHiglightPlayer;
	boolean		m_isInclined= true;


	public void activate(){
		super.activate();

		m_objCam= Camera.getCur(Camera.TYPE_3D);
		m_objCam.setCur();
		m_objCam.setPosY(4);
		m_objCam.setPosZ(-20);
//		m_objCam.setAngleX(-20);
//		Background back= new Background("/res/back/BkTest2_1.png");
//		back.m_vPos[2]= 10;
//		back.load();
//		addChild(back);

		addChild(m_objBoard= new Obj3DBoard());
		m_objCam.lockOnObject(m_objBoard);

		for(int i= 0; i < 10; ++i){
			Object3D obj= new Obj3DPyramide();

			obj.setPos(-4.5f + i, 7.5f, 0);
			addChild(obj);
		}

//		m_musicThisContext= new MusicMOD("/res/music/118in64.xm");
//		m_musicThisContext.load();
//		m_musicThisContext.play();
	}

	public boolean keyboardManage(MngInput p_mngInput){
		if(!super.keyboardManage(p_mngInput))
			return false;

		if (p_mngInput.isMouseClicked(MngInput.M_RIGHT)){
			App.g_theApp.setCurContext(AppJavaTest.ID_CTX2);
		}else if (p_mngInput.isMouseClicked(MngInput.M_LEFT)){
			App.g_theApp.setCurContext(AppJavaTest.ID_CTX4);
		}

		if(!m_objCam.isMoving()){
			if(p_mngInput.isKeyboardDown(MngInput.K_ARROW_RIGHT)){
				if((m_nHiglightPlayer+= 1) > 3)
					m_nHiglightPlayer= 0;

				if(m_isInclined){
					switch(m_nHiglightPlayer){
					case 0:	m_objCam.moveTo(0, 4, -15, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);		break;
					case 1:	m_objCam.moveTo(-4, 0, -15, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);	break;
					case 2:	m_objCam.moveTo(0, -4, -15, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);	break;
					case 3:	m_objCam.moveTo(4, 0, -15, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);		break;
					}
				}
			}else if(p_mngInput.isKeyboardDown(MngInput.K_ARROW_LEFT)){
				if((m_nHiglightPlayer-= 1) < 0)
					m_nHiglightPlayer= 3;

				if(m_isInclined){
					switch(m_nHiglightPlayer){
					case 0:	m_objCam.moveTo(0, 4, -15, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);		break;
					case 1:	m_objCam.moveTo(-4, 0, -15, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);	break;
					case 2:	m_objCam.moveTo(0, -4, -15, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);	break;
					case 3:	m_objCam.moveTo(4, 0, -15, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);		break;
					}
				}
			}else if(p_mngInput.isKeyboardDown(MngInput.K_ENTER)){
				if(m_isInclined){
					m_isInclined= false;
					m_objCam.moveTo(m_objCam.getPosX(), 0, m_objCam.getPosZ(), m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);
				}else{
					m_isInclined= true;
					switch(m_nHiglightPlayer){
					case 0:	m_objCam.moveTo(0, 4, -15, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);		break;
					case 1:	m_objCam.moveTo(-4, 0, -15, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);	break;
					case 2:	m_objCam.moveTo(0, -4, -15, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);	break;
					case 3:	m_objCam.moveTo(4, 0, -15, m_objCam.getAngleX(), m_objCam.getAngleY(), m_objCam.getAngleZ(), 1000);		break;
					}
				}
			}
		}

		return true;
	}
	
	public void manage(float p_fTimeScaleFactor){
		super.manage(p_fTimeScaleFactor);
	}
}
