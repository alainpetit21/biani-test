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
import com.bianisoft.engine.manager.MngInput;
import com.bianisoft.engine.resmng.Texture;
import com.bianisoft.tests.javatestapp.voronoi.GraphEdge;
import com.bianisoft.tests.javatestapp.voronoi.Voronoi;
import java.util.List;


public class MyContext6 extends Context {
	private static final float[] ZOOMING_LEVEL= {0.25f, 1.0f, 1.3333f, 2.1333f};


	Camera	m_objCam;

	List<GraphEdge>	m_lstGraphEdge;

	Voronoi		m_objVoronoi= new Voronoi(1);
	double[]	m_arPtX= {20, -100, 40, 346, 1, 55};
	double[]	m_arPtY= {10, -100, 98, 30, 12, 0};
	
	public int m_nZoomLevel= 1;
	public float m_nDelayZooming= 0;


	public void activate(){
		super.activate();

		m_objCam= Camera.getCur(Camera.TYPE_2D);

		m_lstGraphEdge= m_objVoronoi.generateVoronoi(m_arPtX, m_arPtY, -1000, 1000, -1000, 1000);
	}

	public boolean keyboardManage(MngInput p_mngInput){
		if(!super.keyboardManage(p_mngInput))
			return false;

		if(p_mngInput.isMouseClicked(MngInput.M_LEFT)){
			m_lstGraphEdge= m_objVoronoi.generateVoronoi(m_arPtX, m_arPtY, -1000, 1000, -1000, 1000);
		}

		if(!m_objCam.isMoving()){
			m_nDelayZooming+= MngInput.get().getMouseDeltaZ();
			if(Math.abs(m_nDelayZooming) > 500){
				m_nZoomLevel+= Math.signum(m_nDelayZooming);
				m_nDelayZooming= 0;

				if(m_nZoomLevel < 0)
					m_nZoomLevel= 0;
				else if(m_nZoomLevel > 3)
					m_nZoomLevel= 3;

				m_objCam.zoomTo(ZOOMING_LEVEL[m_nZoomLevel], 1000);

				if(m_nZoomLevel <= 1)
					m_objCam.AddMoveTo(0, 0, m_objCam.getPosZ(), 0, 0, m_objCam.getAngleZ(), 1000);
			}
		}

		return true;
	}

	public void draw(){
		super.draw();

		m_objCam.doWorldProjection();


		glPushMatrix();

		Texture.bindNone();
		glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
		glScalef(1, -1, 1);

		//Print Debug Collision
		for(GraphEdge objLine : m_lstGraphEdge){
			glColor3d(1.0, 0.0, 0.0);
			glBegin(GL_LINE);
				glVertex2d(objLine.m_nX1, objLine.m_nY1);
				glVertex2d(objLine.m_nX2, objLine.m_nY2);
			glEnd();
		}

		//Print Debug Collision
		for(int i= 0; i < m_arPtX.length; ++i){
			glColor3d(0.0, 1.0, 0.0);
			glBegin(GL_LINE);
				glVertex2d(m_arPtX[i]-2, m_arPtY[i]-2);
				glVertex2d(m_arPtX[i]+2, m_arPtY[i]+2);
			glEnd();
			glBegin(GL_LINE);
				glVertex2d(m_arPtX[i]+2, m_arPtY[i]-2);
				glVertex2d(m_arPtX[i]-2, m_arPtY[i]+2);
			glEnd();
		}

		glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
		glEnable(GL_TEXTURE_2D);
		glPopMatrix();
	}
}
