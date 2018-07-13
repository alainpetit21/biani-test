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
import com.bianisoft.engine.Applet;


public class AppletJavaTest extends Applet{
	public static final int ID_CTX1= 0x0;
	public static final int ID_CTX2= 0x1;
	public static final int ID_CTX3= 0x2;
	public static final int ID_CTX4= 0x3;
	public static final int ID_CTX5= 0x4;


	public AppletJavaTest(){
		super("AppletJavaTest", 1024, 768);
	}

	public String getVersion(){
		return "1.2";
	}

	public void load(){
		addContext(new MyContext1());
		addContext(new MyContext2());
		addContext(new MyContext3());
		addContext(new MyContext4());
		addContext(new MyContext5());
		setCurContext(ID_CTX1);
	}
}