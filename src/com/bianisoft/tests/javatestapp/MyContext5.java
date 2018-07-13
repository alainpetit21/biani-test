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
//import com.bianisoft.engine.music.Music;
import com.bianisoft.engine.backgrounds.Background;
import com.bianisoft.engine.manager.MngInput;


public class MyContext5 extends Context {
	Background[]	m_arImage= new Background[3];
	Camera			m_objCam;
	int				m_nCurImage;

	
	public void activate(){
		super.activate();

		m_objCam= Camera.getCur(Camera.TYPE_2D);

		for(int i= 0; i < m_arImage.length; ++i){
			m_arImage[i]= new Background("/res/back/BkImage" +(i+1)+ ".png");
			m_arImage[i].setPos(i*1024, 0, 1);
			m_arImage[i].load();
			addChild(m_arImage[i]);
		}

		m_nCurImage= 0;
	}

	public void nextImage(){
		if((++m_nCurImage) >= m_arImage.length){
			m_nCurImage= 0;
		}

		m_objCam.moveTo(m_nCurImage * 1024, 0, 3000);
	}

	public void prevImage(){
		if((--m_nCurImage) < 0){
			m_nCurImage= m_arImage.length-1;
		}

		m_objCam.moveTo(m_nCurImage * 1024, 0, 3000);
	}

	public boolean keyboardManage(MngInput p_mngInput){
		if(!super.keyboardManage(p_mngInput))
			return false;


		if(!m_objCam.isMoving()){
			if(p_mngInput.isKeyboardClicked(MngInput.K_ENTER)){
				App.g_theApp.setCurContext(AppJavaTest.ID_CTX4);
			}else if(p_mngInput.isKeyboardClicked(MngInput.K_ARROW_RIGHT)){
				nextImage();
			}else if(p_mngInput.isKeyboardClicked(MngInput.K_ARROW_LEFT)){
				prevImage();
			}
		}

		return true;
	}
}
