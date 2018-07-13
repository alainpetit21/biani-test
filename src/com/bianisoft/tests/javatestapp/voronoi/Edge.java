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


public class Edge{
	public double a, b, c;

	Site[] m_objEndPoint= new Site[2];
	Site[] m_refSite= new Site[2];
	int m_nIDEdge;
}