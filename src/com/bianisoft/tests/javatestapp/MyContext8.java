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
//import com.bianisoft.engine.music.Music;
import com.bianisoft.engine.manager.MngInput;
import com.bianisoft.engine.sprites.Sprite;


public class MyContext8 extends Context{
	private Camera			m_objCam;
	private Sprite			m_sprCursor;

	int[]		m_nFreqOctave= {1, 2, 4, 8, 16, 32};
	double[][]	m_nResNoisePerOctave= new double[6][3];



	public void activate(){
		super.activate();

		m_sprCursor= new Sprite("/res/sprites/Cursor.png");
		m_sprCursor.setTextID("Spr_Cursor");
		m_sprCursor.addState("StateName0", 1, 0.0f);
		m_sprCursor.addState("StateName1", 1, 0.0f);
		m_sprCursor.load();
		m_sprCursor.setHotSpot(0, 16);
		addChild(m_sprCursor, false, false);
		setCursor(m_sprCursor);
		
		m_objCam= Camera.getCur(Camera.TYPE_2D);
	}

	public float onNoise1(int p_nValue){
		p_nValue= (p_nValue<<13) ^ p_nValue;
		return ( 1.0f - ( (p_nValue * (p_nValue * p_nValue * 15731 + 789221) + 1376312589) & 0x7fffffff) / 1073741824.0f);
	}
	
	public void onGenerate(int p_nWhichOctave){
		int nMax= (m_nFreqOctave[p_nWhichOctave]<<3);
		int n256OverMAX= 256/nMax;

		int		prev2;
		int		prev1;
		int		next1;
		int		next2;
		double	inc;

        /*
		//Generate Key Numbers
		for(int i= 0; i < nMax; ++i)
			gOctaves[0][(i<<8)/nMax]= onNoise1(i);

		//Smooth
//		if(m_smooth[0]){
		if(false){
			for(int i= 0; i < nMax;++i){	
				if(((i-1)<<8)/nMax < 0)	prev1= 0;
				else					prev1= ((i-1)<<8)/nMax;

				if(((i-1)<<8)/nMax > nMax)next1= (i<<8)/nMax;
				else					next1= ((i+1)<<8)/nMax;

				gOctaves[0][(i<<8)/nMax]	= m_FctSmooth1D(gOctaves[0][prev1], gOctaves[0][(i<<8)/nMax], gOctaves[0][next1]);
			}
		}

		//Interpolate
		m_FctInterpolateNoise.Init(m_choiceInterpolationOctave[0]);
		for(i= 0; i < 256;++i)
		{
		//Prev Ones
		if(((i / i256MAX) - 1) <= 0)
		{
		if(((i / i256MAX)) <= 0)
		{prev2= 0;	prev1= 0;}
		else					
		{prev2= 0;	prev1= (((i / i256MAX)<<8)/nMax);}
		}
		else						
		{prev2= (((i / i256MAX)<<8)/nMax) - i256MAX;
		prev1= (((i / i256MAX)<<8)/nMax) ;}
		//NExt Ones
		if(((i / i256MAX) + 2) >= nMax)
		{
		if(((i / i256MAX) + 1) >= nMax)
		{next2= 256;next1= 256;}
		else
		{next2= 256;next1= (((i / i256MAX)<<8)/nMax) + i256MAX;}
		}
		else 
		{next2= (((i / i256MAX)<<8)/nMax) + i256MAX + i256MAX;
		next1= (((i / i256MAX)<<8)/nMax) + i256MAX;}

		inc				= (double)(((double)(i % i256MAX)) / (double)i256MAX);
		gOctaves[0][i]	= m_FctInterpolateNoise(gOctaves[0][prev2], gOctaves[0][prev1], gOctaves[0][next1], gOctaves[0][next2], inc);

		}
		Invalidate(FALSE);
        */
	}

    /*
	public void OnNormalizeAllOctaves(){
		float lastValuePersistance= 1;

		for(int i= 0; i < 6; ++i, lastValuePersistance*= 0.9f)
			for(j= 0; j < 256; ++j)
				gOctaves[i][j]*= lastValuePersistance;
	}
	
	*/
	public boolean keyboardManage(MngInput p_mngInput){
		if(!super.keyboardManage(p_mngInput))
			return false;


		return true;
	}

	public void manage(float p_fRatioMovement) {
		super.manage(p_fRatioMovement);
	}

	public void drawDebug() {
		super.drawDebug();
	}	
}