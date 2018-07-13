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


//Special static LWJGL library imports
import static org.lwjgl.opengl.GL11.*;

//Bianisoft imports
import com.bianisoft.engine.Camera;
import com.bianisoft.engine.Context;
//import com.bianisoft.engine.music.Music;
import com.bianisoft.engine.PhysObj;
import com.bianisoft.engine.manager.MngInput;
import com.bianisoft.engine.resmng.Texture;
import com.bianisoft.engine.sprites.Sprite;
import java.util.ArrayList;
import org.lwjgl.util.Rectangle;


class CtlMacSprList extends PhysObj{
	private ArrayList<Sprite>	m_lstSprite= new ArrayList<Sprite>();
	
	//Drawing option
	private float	m_nMinZoom= 0.5f;
	private float	m_nMaxZoom= 1.0f;
	
	//Manage data
	private Sprite		m_sprCursor;
	private Rectangle	m_recAreaManage;

	private	float		m_nPercentileHighlighted= 0.5f;
	private	int			m_nIdxHighlighted;
	private Sprite		m_sprHighlighted;
	private boolean		m_isActive;
			
			
	public CtlMacSprList(Rectangle p_recArea, Sprite p_sprCursor){
		super();
		m_recAreaManage= p_recArea;
		m_sprCursor= p_sprCursor;
	}

	public void add(Sprite p_spr){
		m_lstSprite.add(p_spr);
	}

	public void manageCalcultationHighlighted(float p_nPosMouseY){
		if(m_isActive){
			p_nPosMouseY-= m_recAreaManage.getY();
			m_nPercentileHighlighted= p_nPosMouseY / m_recAreaManage.getHeight();
		}else{
			m_nPercentileHighlighted= 0.5f;
		}
		
		m_nIdxHighlighted= (int)(m_lstSprite.size() * m_nPercentileHighlighted);
		m_sprHighlighted= m_lstSprite.get(m_nIdxHighlighted);
	}

	public void manageListPositioning(float p_nPosMouseY){
		int nStartPosY= (int)p_nPosMouseY;
		int nCurPosY= nStartPosY;
		float nZoonMax= m_nMaxZoom;
		
		if(!m_isActive){
			nStartPosY= (int)getPosY();
			nCurPosY= nStartPosY;
			nZoonMax= m_nMinZoom;
		}
		
		//First Set the Highlight at max zoom
		m_sprHighlighted.setPos(getPosX(), nCurPosY);
		m_sprHighlighted.setZoom(nZoonMax);
		nCurPosY-= m_sprHighlighted.getHeight() * nZoonMax;

		//Next Draw One Before the Highlight at half the zoom
		if((m_nIdxHighlighted - 1) >= 0){
			Sprite spr= m_lstSprite.get(m_nIdxHighlighted - 1);
			float nZoom= m_nMinZoom+((nZoonMax - m_nMinZoom)/2);
			
			spr.setPos(getPosX(), nCurPosY);
			spr.setZoom(nZoom);
			nCurPosY-= m_sprHighlighted.getHeight() * nZoom;
		}
		
		//Draw all the rest before, at min zoom
		for(int i= m_nIdxHighlighted - 2; i >= 0; --i){
			Sprite spr= m_lstSprite.get(i);
			spr.setPos(getPosX(), nCurPosY);
			spr.setZoom(m_nMinZoom);
			nCurPosY-= (m_sprHighlighted.getHeight() * m_nMinZoom);			
		}
		
		
		nCurPosY= nStartPosY;
		nCurPosY+= m_sprHighlighted.getHeight() * nZoonMax;
		
		//Next Draw One after the Highlight at half the zoom
		if((m_nIdxHighlighted + 1) < m_lstSprite.size()){
			Sprite spr= m_lstSprite.get(m_nIdxHighlighted + 1);
			float nZoom= m_nMinZoom+((nZoonMax - m_nMinZoom)/2);
			
			spr.setPos(getPosX(), nCurPosY);
			spr.setZoom(nZoom);
			nCurPosY+= m_sprHighlighted.getHeight() * nZoom;
		}

		//Draw all the rest after, at min zoom
		for(int i= m_nIdxHighlighted + 2; i < m_lstSprite.size(); ++i){
			Sprite spr= m_lstSprite.get(i);
			spr.setPos(getPosX(), nCurPosY);
			spr.setZoom(m_nMinZoom);
			nCurPosY+= (m_sprHighlighted.getHeight() * m_nMinZoom);			
		}
	}
	
	public void manage(float p_fTimeScaleFactor) {
		super.manage(p_fTimeScaleFactor);

		//Detect if Mouse is within operational rectangle
		Camera cam= Camera.getCur(Camera.TYPE_2D);
		int nMousePosX= (int)cam.doUnprojectionX(m_sprCursor.getPosX());
		int nMousePosY= (int)cam.doUnprojectionY(m_sprCursor.getPosY());
		m_isActive= m_recAreaManage.contains(nMousePosX, nMousePosY);
		
		manageCalcultationHighlighted(nMousePosY);
		manageListPositioning(nMousePosY);
	}
	
	public void drawDebug(){
		glPushMatrix();

		Texture.bindNone();

		glTranslated(getPosX(), getPosY(), 0);
		glColor3d(1.0, 0.0, 0.0);
		glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);

		glBegin(GL_LINE_LOOP);
			glVertex2d(m_recAreaManage.getX(), m_recAreaManage.getY());		
			glVertex2d(m_recAreaManage.getX() + m_recAreaManage.getWidth(), m_recAreaManage.getY());

			glVertex2d(m_recAreaManage.getX() + m_recAreaManage.getWidth(), m_recAreaManage.getY());	
			glVertex2d(m_recAreaManage.getX() + m_recAreaManage.getWidth(), m_recAreaManage.getY() + m_recAreaManage.getHeight());

			glVertex2d(m_recAreaManage.getX() + m_recAreaManage.getWidth(), m_recAreaManage.getY() + m_recAreaManage.getHeight());
			glVertex2d(m_recAreaManage.getX(), m_recAreaManage.getY() + m_recAreaManage.getHeight());

			glVertex2d(m_recAreaManage.getX(), m_recAreaManage.getY() + m_recAreaManage.getHeight());
			glVertex2d(m_recAreaManage.getX(), m_recAreaManage.getY());		
		glEnd();
		glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
		glEnable(GL_TEXTURE_2D);
	}
};

public class MyContext7 extends Context {
	private Camera			m_objCam;
	private Sprite			m_sprCursor;
	private CtlMacSprList	m_ctlMacList;
			

	public void activate(){
		super.activate();

		DesignCtxMyContext7.load(this);
		
		m_objCam= Camera.getCur(Camera.TYPE_2D);
		m_sprCursor= (Sprite)findByTextID("Spr_Cursor");
		m_sprCursor.setHotSpot(0, 16);
		setCursor(m_sprCursor);

		m_ctlMacList= new CtlMacSprList(new Rectangle(-50, -200, 100, 400), (Sprite)findByTextID("Spr_Cursor"));
		
		m_ctlMacList.add((Sprite)findByTextID("Spr_Test1"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_Test2"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_Test3"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_Test4"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_Test5"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_Test6"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_Test7"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_Test8"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_Test9"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_TestA"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_TestB"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_TestC"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_TestD"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_TestE"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_TestF"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_TestG"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_TestH"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_TestI"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_TestJ"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_TestK"));
		m_ctlMacList.add((Sprite)findByTextID("Spr_TestL"));
	}

	public boolean keyboardManage(MngInput p_mngInput){
		if(!super.keyboardManage(p_mngInput))
			return false;


		return true;
	}

	public void manage(float p_fRatioMovement) {
		super.manage(p_fRatioMovement);
		
		m_ctlMacList.manage(p_fRatioMovement);
	}

	public void drawDebug() {
		super.drawDebug();
		
		m_ctlMacList.drawDebug();
	}	
}