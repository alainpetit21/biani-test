package com.bianisoft.tests.javatestapp.snailMaze;


public class Level{
	public static int[][]	g_nData;
	public static int[]		g_ptStart= {0, 0};
	public static int[]		g_ptEnd= {0, 0};
	
	
	public static int getLevelWidth()	{return g_nData.length;};
	public static int getLevelHeight()	{return g_nData[0].length;};
	
	public static int getStartX()	{return g_ptStart[0];}
	public static int getStartY()	{return g_ptStart[1];}
	public static int getEndX()		{return g_ptEnd[0];}
	public static int getEndY()		{return g_ptEnd[1];}
}
