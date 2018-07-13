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
 * Copyright (C) James Humphreys
 *
 * 06/07/11			0.1 James Humphreys version
 * 21/11/11			0.2 Alain Petit port
 *
 *-----------------------------------------------------------------------
 */
package com.bianisoft.tests.javatestapp.voronoi;


public class HalfEdge{
	private static final int LEFT_EDGE= 0;
	private static final int RIGHT_EDGE= 1;

	HalfEdge m_objLeftHE;
	HalfEdge m_objRightHE;
	HalfEdge PQnext;
    Edge m_objEdge;
	Site m_objVertex;

    boolean deleted;
	double m_nYStar;
    int m_isLeftOrRight;


	public HalfEdge()	{	}
	public HalfEdge(Edge p_objEdge, int p_isLeftOrRight){
		m_isLeftOrRight= p_isLeftOrRight;
		m_objEdge= p_objEdge;
    }

	public HalfEdge getRight()	{return m_objRightHE;}
	public HalfEdge getLeft()	{return m_objLeftHE;}

	public void insert(HalfEdge p_objNewHalfEdge){
		p_objNewHalfEdge.m_objLeftHE= this;
		p_objNewHalfEdge.m_objRightHE= this.m_objRightHE;

		(this.m_objRightHE).m_objLeftHE= p_objNewHalfEdge;
		this.m_objRightHE= p_objNewHalfEdge;
}

	public void delete(){
		(this.m_objLeftHE).m_objRightHE= this.m_objRightHE;
		(this.m_objRightHE).m_objLeftHE= this.m_objLeftHE;

		this.deleted= true;
	}

	public boolean isPointRightOf(Point p_pt){
		Edge objEdge= m_objEdge;
		Site topsite= objEdge.m_refSite[1];

		boolean isRightOfSite;
		boolean isAbove;

		if(p_pt.m_nX > topsite.m_pt.m_nX)
			isRightOfSite= true;
		else
			isRightOfSite= false;

		if(isRightOfSite && (m_isLeftOrRight == LEFT_EDGE))
			return true;
		if(!isRightOfSite && (m_isLeftOrRight == RIGHT_EDGE))
			return false;

		if(objEdge.a == 1.0){
			double dyp= p_pt.m_nY - topsite.m_pt.m_nY;
			double dxp= p_pt.m_nX - topsite.m_pt.m_nX;
			double dxs;
			boolean isFast= false;

			if((!isRightOfSite & (objEdge.b < 0.0)) | (isRightOfSite & (objEdge.b >= 0.0))){
				isAbove= dyp >= objEdge.b * dxp;
				isFast= isAbove;
			}else{
				isAbove= p_pt.m_nX + p_pt.m_nY * objEdge.b > objEdge.c;
				
				if(objEdge.b < 0.0)
					isAbove= !isAbove;
				if(!isAbove)
					isFast= true;
			}

			if (!isFast){
				dxs = topsite.m_pt.m_nX - (objEdge.m_refSite[0]).m_pt.m_nX;
				isAbove = objEdge.b * (dxp * dxp - dyp * dyp) < dxs * dyp * (1.0 + 2.0 * dxp / dxs + objEdge.b * objEdge.b);
				
				if(objEdge.b < 0.0)
					isAbove= !isAbove;
			}
		}else{
			double yl= objEdge.c - objEdge.a * p_pt.m_nX;
			double t1= p_pt.m_nY - yl;
			double t2= p_pt.m_nX - topsite.m_pt.m_nX;
			double t3= yl - topsite.m_pt.m_nY;

			isAbove= t1 * t1 > t2 * t2 + t3 * t3;
        }

        return (m_isLeftOrRight == LEFT_EDGE)? isAbove : !isAbove;
    }
}
