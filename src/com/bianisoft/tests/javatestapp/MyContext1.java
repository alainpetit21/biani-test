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


//LWJGL library imports
import org.lwjgl.util.Rectangle;

//Bianisoft imports
import com.bianisoft.engine.App;
import com.bianisoft.engine.Context;
import com.bianisoft.engine.Drawable;
import com.bianisoft.engine.backgrounds.Background;
import com.bianisoft.engine.sprites.Sprite;
import com.bianisoft.engine.sprites.Button;
import com.bianisoft.engine.labels.Label;
import com.bianisoft.engine.labels.LabelTextField;
import com.bianisoft.engine.manager.MngHandlerTMX;
import com.bianisoft.engine.manager.MngInput;
//import com.bianisoft.engine.music.Music;
//import com.bianisoft.engine.music.MusicMP3;


public class MyContext1 extends Context{
	private class MySprite extends Sprite{
		public MySprite(){
			super("/res/sprites/SprHero.png");

			setPos(-100, -100, 2);

			addState(new Sprite.State("StandRight", 8, 0.1f));
			addState(new Sprite.State("StandDown", 8, 0.1f));
			addState(new Sprite.State("StandLeft", 8, 0.1f));
			addState(new Sprite.State("StandUp", 8, 0.1f));
			addState(new Sprite.State("WalkRight", 8, 0.2f));
			addState(new Sprite.State("WalkDown", 8, 0.2f));
			addState(new Sprite.State("WalkLeft", 8, 0.2f));
			addState(new Sprite.State("WalkUp", 8, 0.2f));
			load();
//			setCurFrame(10);
		}
		
		public void manage(float p_fTimeScaleFactor){
			super.manage(p_fTimeScaleFactor);

			MngInput mngInput= MngInput.get();

			if(mngInput.isKeyboardDown(MngInput.K_ARROW_RIGHT)){
				if(mngInput.isKeyboardDown(MngInput.K_ARROW_DOWN) || mngInput.isKeyboardDown(MngInput.K_ARROW_UP)){
					m_back2.setVelX(0.71f*2);
				}else{
					m_back2.setVelX(1*2);
				}
			}else if(mngInput.isKeyboardDown(MngInput.K_ARROW_LEFT)){
				if(mngInput.isKeyboardDown(MngInput.K_ARROW_DOWN) || mngInput.isKeyboardDown(MngInput.K_ARROW_UP)){
					m_back2.setVelX(-0.71f*2);
				}else{
					m_back2.setVelX(-1*2);
				}
			}else{
				m_back2.setVelX(0);
			}
			if(mngInput.isKeyboardDown(MngInput.K_ARROW_DOWN)){
				if(mngInput.isKeyboardDown(MngInput.K_ARROW_RIGHT) || mngInput.isKeyboardDown(MngInput.K_ARROW_LEFT)){
					m_back2.setVelY(0.71f*2);
				}else{
					m_back2.setVelY(1*2);
				}
			}else if(mngInput.isKeyboardDown(MngInput.K_ARROW_UP)){
				if(mngInput.isKeyboardDown(MngInput.K_ARROW_RIGHT) || mngInput.isKeyboardDown(MngInput.K_ARROW_LEFT)){
					m_back2.setVelY(-0.71f*2);
				}else{
					m_back2.setVelY(-1*2);
				}
			}else{
				m_back2.setVelY(0);
			}

			if((getVelX() == 0) && (getVelY() == 0)){
				if(m_nCurState >= 4){
					m_nCurState-= 4;
				}
			}else if((getVelX() >= 0.71*2) && ((getVelY() >= -0.71*2) && (getVelY() < 0.71*2))){
				m_nCurState= 4;
			}else if((getVelY() >= 0.71*2) && ((getVelX() >= -0.71*2) && (getVelX() < 0.71*2))){
				m_nCurState= 5;
			}else if((getVelX() < 0.71*2) && ((getVelY() >= -0.71*2) && (getVelY() < 0.71*2))){
				m_nCurState= 6;
			}else if((getVelY() < 0.71*2) && ((getVelX() >= -0.71*2) && (getVelX() < 0.71*2))){
				m_nCurState= 7;
			}
		}
	};

	private class MyCursor extends Sprite{
		public MyCursor(){
			super("/res/sprites/Cursor.png");
			setVel(0, 0, 1);

			addState(new Sprite.State("Idle", 1, 0.0f));
			addState(new Sprite.State("Over", 1, 0.0f));
			load();
		}
	};

	private class MyButton extends Button implements Button.I_Callback{
		public MyButton(){
			super("/res/sprites/BtPlay.png", 1, 1, 1, 1, 1, 1, 1, 1);
			setPos(0, 0, 3);

			m_objCallback= this;
			load();
		}

		public void callbackStateChanged(int p_nNewState, Button p_obj){
			if(p_nNewState == ST_CLICKED){
				App.g_theApp.setCurContext(AppJavaTest.ID_CTX2);
//				m_musicThisContext.stop();
			}
		}
	};


//	Music m_musicThisContext;
	Background m_back1;
	Background m_back2;

	public MyContext1(){
		super();
	}

	public void activate(){
		super.activate();

		MngHandlerTMX.loadTMX("/res/level/LvlTiled.tmx", this);
		m_back1= (Background)findByTextID("Tile Layer 1");
		m_back2= (Background)findByTextID("Tile Layer 2");

		setCursor(new MyContext1.MyCursor());
		getCursor().setHotSpot(2, 2);

		addChild(new MyContext1.MyButton());
		addChild(new MyContext1.MySprite());
		addChild(getCursor());

		Label label= new LabelTextField("/res/font/FreeMonoBold.ttf", 25, "", Label.MODE_LEFT, false, new Rectangle(0, 0, 100, 37));
		label.setPos(100, 100, 5);
		label.load();
		addChild(label);



//		m_musicThisContext= Music.create(Music.TYPE_MOD, "/res/music/12oz.s3m", 0);
//		m_musicThisContext= Music.create(Music.TYPE_EMU, "/res/music/LunarPool.nsf", 0);
//		m_musicThisContext= Music.create(Music.TYPE_EMU, "/res/music/test.spc", 0);
//		m_musicThisContext= new MusicMP3("/res/music/test.mp3");
//		m_musicThisContext.load();
//		m_musicThisContext.play();
	}

	public void deActivate(){
		super.deActivate();
//		m_musicThisContext.stop();
	}

	public boolean keyboardManage(MngInput p_mngInput){
		if(!super.keyboardManage(p_mngInput))
			return false;
		
//		if(!m_musicThisContext.isPlaying())
//			m_musicThisContext.play();

		if(p_mngInput.isKeyboardClicked(MngInput.K_ARROW_RIGHT))
			App.g_theApp.setCurContext(AppJavaTest.ID_CTX2);

		if (p_mngInput.isMouseClicked(MngInput.M_RIGHT))
			App.exit();

		return true;
	}

	public void manage(float p_fTimeScaleFactor){
		super.manage(p_fTimeScaleFactor);
	}

	public void draw(){
		super.draw();
	}
}


