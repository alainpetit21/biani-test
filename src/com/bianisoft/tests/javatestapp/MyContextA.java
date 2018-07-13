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
import com.bianisoft.engine.backgrounds.Background;
import com.bianisoft.engine.backgrounds.BackgroundTiled;
import com.bianisoft.engine.manager.MngHandlerTMX;
import com.bianisoft.engine.manager.MngInput;
import com.bianisoft.engine.sprites.Sprite;

import com.bianisoft.tests.javatestapp.snailMaze.Level;
import com.bianisoft.tests.javatestapp.snailMaze.LevelTest;
import com.bianisoft.tests.javatestapp.snailMaze.Level0;
import com.bianisoft.tests.javatestapp.snailMaze.SprSnail;


public class MyContextA extends Context{
	public static final int NO_WALL		= 0x0;
	public static final int WALL_RIGHT	= 0x1;
	public static final int WALL_DOWN	= 0x2;
	public static final int WALL_LEFT	= 0x4;
	public static final int WALL_UP		= 0x8;
	public static final int START		= 0x10;
	public static final int GOAL		= 0x20;
	

	private Camera			m_objCam;
	private Sprite			m_sprCursor;

	private Background		m_backTileBankWall;
	private BackgroundTiled	m_backWalls;
	private SprSnail		m_sprSnail;
	

	public void activate(){
		super.activate();

		MngHandlerTMX.loadTMX("/res/level/snail.tmx", this);
		
		m_sprCursor= (Sprite)findByTextID("sprCursor");
		m_sprCursor.setHotSpot(0, 16);
		setCursor(m_sprCursor);
		
		m_objCam= Camera.getCur(Camera.TYPE_2D);
		
		m_backTileBankWall= new Background("/res/back/bkTileBankSnail_Walls.png");
		m_backTileBankWall.setTextID("bkTileBankSnail_Walls");
		m_backTileBankWall.load();

		m_backWalls= new BackgroundTiled();
		m_backWalls.setTextID("bkTiledSnailWall");
		m_backWalls.setPos(0, 81, 50);
		m_backWalls.setMap(Level0.load());
		m_backWalls.m_nTileSize= 20;
		m_backWalls.loadWithTileBank(m_backTileBankWall);
		addChild(m_backWalls);
		
		m_sprSnail= new SprSnail("/res/sprites/sprSnail.png");
		m_sprSnail.setTextID("sprSnail");
		m_sprSnail.setPos(Level.getStartX(), Level.getStartY());
		m_sprSnail.addState("Idle", 1, 0.0f);
		m_sprSnail.load();
		addChild(m_sprSnail, false, false);
	}

	public boolean keyboardManage(MngInput p_mngInput){
		if(!super.keyboardManage(p_mngInput))
			return false;

		if(p_mngInput.isKeyboardDown(MngInput.K_ARROW_DOWN))
			if(!m_sprSnail.isMoving())
				m_sprSnail.moveDown();
		if(p_mngInput.isKeyboardDown(MngInput.K_ARROW_UP))
			if(!m_sprSnail.isMoving())
				m_sprSnail.moveUp();
		if(p_mngInput.isKeyboardDown(MngInput.K_ARROW_LEFT))
			if(!m_sprSnail.isMoving())
				m_sprSnail.moveLeft();
		if(p_mngInput.isKeyboardDown(MngInput.K_ARROW_RIGHT))
			if(!m_sprSnail.isMoving())
				m_sprSnail.moveRight();
		
		return true;
	}

	public void manage(float p_fRatioMovement) {
		super.manage(p_fRatioMovement);
	}

	public void draw(){
		super.draw();
	}	
}