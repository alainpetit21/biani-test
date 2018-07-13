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

//Special static LWJGL library imports
import static org.lwjgl.opengl.GL11.*;

//Standard Java library imports
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

//Bianisoft imports
import com.bianisoft.engine._3d.Object3D;


public class Obj3DPyramide extends Object3D{
	public Obj3DPyramide(){
		super();

		setPos(0, 0, 1);

		//TODO convert me
		float vertices[]= {
			0.0f, 0.0f, 1.0f,	 0.4f, 0.4f, 0.0f,	-0.4f, 0.4f, 0.0f,
			0.0f, 0.0f, 1.0f,	-0.4f, 0.4f, 0.0f,	-0.4f,-0.4f, 0.0f,
			0.0f, 0.0f, 1.0f,	-0.4f,-0.4f, 0.0f,	 0.4f,-0.4f, 0.0f,
			0.0f, 0.0f, 1.0f,	 0.4f,-0.4f, 0.0f,	 0.4f, 0.4f, 0.0f
		};
		
		ByteBuffer vbb= ByteBuffer.allocateDirect((m_nNbVertices= vertices.length) * 4); 
		vbb.order(ByteOrder.nativeOrder());
		m_bufVertices= vbb.asFloatBuffer();
		m_bufVertices.put(vertices);
		m_bufVertices.position(0);
	}

	public void draw(){
		if(!isShown() || m_texImage == null)
			return;

		if((m_bufVertices == null) || (m_bufUV == null))
			return;

		m_texImage.bind();
		
		glPushMatrix();

		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glTranslatef(-getPosX(), getPosY(), -getPosZ());
		glScalef(m_nZoom, m_nZoom, m_nZoom);
		glRotatef(getAngleX(), 1.0f, 0.0f, 0.0f);
		glRotatef(getAngleY(), 0.0f, 1.0f, 0.0f);
		glRotatef(getAngleZ(), 0.0f, 0.0f, 1.0f);
		glColor4f(m_colorFilterRed, m_colorFilterGreen, m_colorFilterBlue, m_colorFilterAlpha);
			
		//Point to our buffers
		glEnableClientState(GL_VERTEX_ARRAY);
		glEnableClientState(GL_TEXTURE_COORD_ARRAY);

		glVertexPointer(3, 0, m_bufVertices);
		glTexCoordPointer(2, 0, m_bufUV);

		glDrawArrays(GL_TRIANGLES, 0, 4*3);

		glDisableClientState(GL_VERTEX_ARRAY);
		glDisableClientState(GL_TEXTURE_COORD_ARRAY);
		glDisable(GL_CULL_FACE);		
		glPopMatrix();
	}
}
