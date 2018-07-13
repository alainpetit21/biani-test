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


public class AppJavaTest extends App{
	public static final int ID_CTX1= 0x0;	//BackTiled Test
	public static final int ID_CTX2= 0x1;	//MoveTo Object 3D
	public static final int ID_CTX3= 0x2;	//KozzBoard and Camera Test
	public static final int ID_CTX4= 0x3;	//KozzBoard, Camera + Pieces Test
	public static final int ID_CTX5= 0x4;	//New Enhanced Board Photo
	public static final int ID_CTX6= 0x5;	//Voronoi algorythm
	public static final int ID_CTX7= 0x6;	//MacCtlList Test
	public static final int ID_CTX8= 0x7;	//Noise ?? WIP
	public static final int ID_CTX9= 0x8;	//RPG engine
	public static final int ID_CTXA= 0x9;	//Maze Test

	
	public AppJavaTest(){
		super("JavaTestApp", 640, 480, false);
	}

	public String getVersion(){
		return "1.2";
	}

	public void load(){
		addContext(new MyContext1());
		addContext(new MyContext2());
		addContext(new MyContext3());	//Marche pas
		addContext(new MyContext4());	//Crash
		addContext(new MyContext5());
		addContext(new MyContext6());	//Marche pas 
		addContext(new MyContext7());
		addContext(new MyContext8());
		addContext(new MyContext9());
		addContext(new MyContextA());
		setCurContext(ID_CTXA);
	}

   public static void main(String[] args){
		AppJavaTest objGame= new AppJavaTest();
		libMain(args);
    }
}