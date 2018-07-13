package com.bianisoft.tests.javatestapp.snailMaze;

import com.bianisoft.engine.sprites.Sprite;


public class SprSnail extends Sprite{
	public int[] m_ptPos= {0, 0};
	
	
	public SprSnail()		{super("");}
	public SprSnail(String p_stResFile)		{super(p_stResFile);}
	
	public void setPos(float p_nPosX, float p_nPosY){setPos(p_nPosX, p_nPosY, 40.0f);}
	public void setPos(float p_nPosX, float p_nPosY, float p_nPosZ){
		float posX= (p_nPosX*20)-290;
		float posY= (p_nPosY*20)-70;
		
		m_ptPos[0]= (int)p_nPosX;
		m_ptPos[1]= (int)p_nPosY;
		
		super.setPos(posX, posY, p_nPosZ);
	}
	
	public void moveTo(float p_nPosX, float p_nPosY){moveTo(p_nPosX, p_nPosY, 40.0f);}
	public void moveTo(float p_nPosX, float p_nPosY, float p_nPosZ){
		float posX= (p_nPosX*20)-290;
		float posY= (p_nPosY*20)-70;

		super.moveTo(posX, posY, p_nPosZ, 1000);
	}
	
	public void moveRight(){
		if(m_ptPos[0] == Level.getLevelWidth()-1)
			return;
		
		m_ptPos[0]++;
		moveTo(m_ptPos[0], m_ptPos[1]);
	}
	
	public void moveLeft(){
		if(m_ptPos[0] == 0)
			return;
		
		m_ptPos[0]--;
		moveTo(m_ptPos[0], m_ptPos[1]);
	}
	
	public void moveUp(){
		if(m_ptPos[1] == 0)
			return;

		m_ptPos[1]--;
		moveTo(m_ptPos[0], m_ptPos[1]);
	}
	
	public void moveDown(){
		if(m_ptPos[1] == Level.getLevelHeight()-1)
			return;
		
		m_ptPos[1]++;
		moveTo(m_ptPos[0], m_ptPos[1]);
	}
}
