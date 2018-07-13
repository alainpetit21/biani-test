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


//Standard Java library imports
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

//Bianisoft imports
import com.bianisoft.engine._3d.Object3D;


public class Obj3DBoard extends Object3D{
	public Obj3DBoard(){
		super("/res/back/backGame1024_2.png");
	}

	public void load(){
		super.load();

		float vertices[]= {
			-1.0f, -1.0f,  1.0f,	 1.0f, -1.0f,  1.0f,	-1.0f,  1.0f,  1.0f,	 1.0f,  1.0f,  1.0f,   
		};

		float texture[]= {    		
			0.0f, 0.0f,		0.0f, 1.0f,		1.0f, 0.0f,		1.0f, 1.0f, 
		};
		
		short indices[]= {
			0,   1,  3,		 0,  3,  2,
		};
		

		ByteBuffer vbb= ByteBuffer.allocateDirect((m_nNbVertices= vertices.length) * 4); 
		vbb.order(ByteOrder.nativeOrder());
		m_bufVertices= vbb.asFloatBuffer();
		m_bufVertices.put(vertices);
		m_bufVertices.position(0);

		ByteBuffer ibb = ByteBuffer.allocateDirect((m_nNbIndices= indices.length) * 2);
		ibb.order(ByteOrder.nativeOrder());
		m_bufIndices= ibb.asShortBuffer();
		m_bufIndices.put(indices);
		m_bufIndices.position(0);		

		ByteBuffer uvb= ByteBuffer.allocateDirect(m_nNbVertices * 4);
		uvb.order(ByteOrder.nativeOrder());
		m_bufUV= uvb.asFloatBuffer();
		m_bufUV.put(texture);
		m_bufUV.position(0);
	}
}
