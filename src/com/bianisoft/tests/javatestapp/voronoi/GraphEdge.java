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


public class GraphEdge{
    public double m_nX1;
    public double m_nY1;
    public double m_nX2;
    public double m_nY2;

    public int m_nIDSite1;
    public int m_nIDSite2;


	public GraphEdge()	{	}
	public GraphEdge(Site p_objSiteLeft, Site p_objSiteRight, double p_nX1, double p_nY1, double p_nX2, double p_nY2){
		m_nX1= p_nX1;
		m_nY1= p_nY1;
		m_nX2= p_nX2;
		m_nY2= p_nY2;

		m_nIDSite1= p_objSiteLeft.m_nIDSite;
		m_nIDSite2= p_objSiteRight.m_nIDSite;
	}
}
