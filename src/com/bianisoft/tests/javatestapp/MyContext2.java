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
//import com.bianisoft.engine.Sound;
import com.bianisoft.engine._3d.ObjMD2;
//import com.bianisoft.engine.music.Music;
//import com.bianisoft.engine.resmng.SoundCache;
import com.bianisoft.engine.manager.MngInput;
//import com.bianisoft.engine.music.MusicMOD;


public class MyContext2 extends Context {
	Camera		m_objCam;
	ObjMD2		m_objMD2OfficerPearl;
//	Music		m_musThisContext;
//	Sound		m_sndFire;

	Obj3DPyramide	m_objMouse;

	public MyContext2(){
		super();
	}

	public void activate(){
		super.activate();

		addChild(m_objMD2OfficerPearl= new ObjMD2("/res/3d/Officer.md2", "/res/3d/OfficerPearl.png"));
		addChild(m_objMouse= new Obj3DPyramide());

		m_objMD2OfficerPearl.setScalingFactor(0.20f*3);
		m_objMD2OfficerPearl.load();

		m_objMouse.setPosZ(-1);

		m_objCam= Camera.getCur(Camera.TYPE_3D);
		m_objCam.setCur();
		m_objCam.setPosY(4);
		m_objCam.setPosZ(-15);
//		m_objCam.lockOnObject(m_objMD2OfficerPearl);

//		m_musThisContext= new MusicMOD("/res/music/rld-eyes.xm");
//		m_musThisContext.load();
//		m_musThisContext.play();

//		m_sndFire= SoundCache.getSound("/res/sound/LaserFire2.wav");
//		m_sndFire.load();
	}

	public boolean keyboardManage(MngInput p_mngInput){
		if(!super.keyboardManage(p_mngInput))
			return false;

		if (p_mngInput.isMouseClicked(MngInput.M_RIGHT))
			App.exit();

		m_objMouse.setPosX(m_objMouse.getPosX() - ((float)p_mngInput.getMouseDeltaX())/30);
		m_objMouse.setPosY(m_objMouse.getPosY() - ((float)p_mngInput.getMouseDeltaY())/30);

		if(p_mngInput.isKeyboardClicked(MngInput.K_ARROW_RIGHT)){
			App.g_theApp.setCurContext(AppJavaTest.ID_CTX3);
		}else if (p_mngInput.isKeyboardClicked(MngInput.K_ENTER)){
//			m_sndFire.play();
		}

		if (p_mngInput.isMouseClicked(MngInput.M_LEFT)){
			m_objMD2OfficerPearl.moveTo(m_objMouse.getPosX(), m_objMouse.getPosY(), 0, 0, 0, 0, 1000);
		}else if (p_mngInput.isMouseClicked(MngInput.M_RIGHT)){
			App.g_theApp.setCurContext(AppJavaTest.ID_CTX1);
		}

		return true;
	}

	public void manage(float p_fTimeScaleFactor){
		super.manage(p_fTimeScaleFactor);
	}
}
