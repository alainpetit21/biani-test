/*
 * The author of this software is Steven Fortune.  Copyright (c) 1994 by AT&T
 * Bell Laboratories.
 * Permission to use, copy, modify, and distribute this software for any
 * purpose without fee is hereby granted, provided that this entire notice
 * is included in all copies of any software which is or includes a copy
 * or modification of this software and in all copies of the supporting
 * documentation for such software.
 * THIS SOFTWARE IS BEING PROVIDED "AS IS", WITHOUT ANY EXPRESS OR IMPLIED
 * WARRANTY.  IN PARTICULAR, NEITHER THE AUTHORS NOR AT&T MAKE ANY
 * REPRESENTATION OR WARRANTY OF ANY KIND CONCERNING THE MERCHANTABILITY
 * OF THIS SOFTWARE OR ITS FITNESS FOR ANY PARTICULAR PURPOSE.

 * This code was originally written by Stephan Fortune in C code.  I, Shane O'Sullivan,
 * have since modified it, encapsulating it in a C++ class and, fixing memory leaks and
 * adding accessors to the Voronoi Edges.
 * Permission to use, copy, modify, and distribute this software for any
 * purpose without fee is hereby granted, provided that this entire notice
 * is included in all copies of any software which is or includes a copy
 * or modification of this software and in all copies of the supporting
 * documentation for such software.
 * THIS SOFTWARE IS BEING PROVIDED "AS IS", WITHOUT ANY EXPRESS OR IMPLIED
 * WARRANTY.  IN PARTICULAR, NEITHER THE AUTHORS NOR AT&T MAKE ANY
 * REPRESENTATION OR WARRANTY OF ANY KIND CONCERNING THE MERCHANTABILITY
 * OF THIS SOFTWARE OR ITS FITNESS FOR ANY PARTICULAR PURPOSE.

 * Java Version by Zhenyu Pan
 * Permission to use, copy, modify, and distribute this software for any
 * purpose without fee is hereby granted, provided that this entire notice
 * is included in all copies of any software which is or includes a copy
 * or modification of this software and in all copies of the supporting
 * documentation for such software.
 * THIS SOFTWARE IS BEING PROVIDED "AS IS", WITHOUT ANY EXPRESS OR IMPLIED
 * WARRANTY.  IN PARTICULAR, NEITHER THE AUTHORS NOR AT&T MAKE ANY
 * REPRESENTATION OR WARRANTY OF ANY KIND CONCERNING THE MERCHANTABILITY
 * OF THIS SOFTWARE OR ITS FITNESS FOR ANY PARTICULAR PURPOSE.

 * Bianisoft integration version by Alain Petit
 * Permission to use, copy, modify, and distribute this software for any
 * purpose without fee is hereby granted, provided that this entire notice
 * is included in all copies of any software which is or includes a copy
 * or modification of this software and in all copies of the supporting
 * documentation for such software.
 * THIS SOFTWARE IS BEING PROVIDED "AS IS", WITHOUT ANY EXPRESS OR IMPLIED
 * WARRANTY.  IN PARTICULAR, NEITHER THE AUTHORS NOR AT&T MAKE ANY
 * REPRESENTATION OR WARRANTY OF ANY KIND CONCERNING THE MERCHANTABILITY
 * OF THIS SOFTWARE OR ITS FITNESS FOR ANY PARTICULAR PURPOSE.
 */
package com.bianisoft.tests.javatestapp.voronoi;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class Voronoi{
	private static final int LEFT_EDGE= 0;
	private static final int RIGHT_EDGE= 1;

	// ************* Private members ******************
	private Site[] m_arSites;
	private Site m_objBottomSite;
	private double m_nMinDistanceBetweenSites;

	private double m_nBorderMinX, m_nBorderMaxX, m_nBorderMinY, m_nBorderMaxY;
	private double m_nMinX, m_nMaxX, m_nMinY, m_nMaxY, m_nDeltaX, m_nDeltaY;
	private int m_nCurSite;
	private int m_nNbVertices;
	private int m_nNbEdges;
	private int m_nNbSites;
	private int m_nNbSiteSqrt;
	
	private int PQcount;
	private int PQmin;
	private int PQhashsize;
	private HalfEdge PQhash[];

	private int ELhashsize;
	private HalfEdge ELhash[];
	private HalfEdge ELleftend, ELrightend;
	private List<GraphEdge> m_lstEdges;


	public Voronoi(double p_nMinDistanceBetweenSites){
		m_nMinDistanceBetweenSites= p_nMinDistanceBetweenSites;
		m_nCurSite= 0;
	}

	public List<GraphEdge> generateVoronoi(double[] p_arXValues, double[] p_arYValues, double p_nBorderMinX, double p_nBorderMaxX, double p_nBorderMinY, double p_nBorderMaxY){
		initialize(p_arXValues, p_arYValues, p_arXValues.length);
		initializeSites(p_arXValues, p_arYValues, p_arXValues.length);
		sortSites(m_arSites);

		// Check bounding box inputs - if mins are bigger than maxes, swap them
		double temp;
		if(p_nBorderMinX > p_nBorderMaxX){
			temp= p_nBorderMinX;
			p_nBorderMinX= p_nBorderMaxX;
			p_nBorderMaxX= temp;
		}

		if(p_nBorderMinY > p_nBorderMaxY){
			temp= p_nBorderMinY;
			p_nBorderMinY= p_nBorderMaxY;
			p_nBorderMaxY= temp;
		}

		m_nBorderMinX= p_nBorderMinX;
		m_nBorderMinY= p_nBorderMinY;
		m_nBorderMaxX= p_nBorderMaxX;
		m_nBorderMaxY= p_nBorderMaxY;

		m_nCurSite= 0;
		buildVoronoi();

		return m_lstEdges;
	}


	//Private methods - implementation details
	private void initialize(double[] p_arXValuesIn, double[] p_arYValuesIn, int p_nNbPoints){
		m_lstEdges	= new LinkedList<GraphEdge>();
		m_arSites	= null;
		m_nNbSites	= p_nNbPoints;
		m_nNbSiteSqrt	= (int) Math.sqrt((double)m_nNbSites + 4);
		m_nNbVertices	= 0;
		m_nNbEdges		= 0;
	}

	private void initializeSites(double[] p_arXValues, double[] p_arYValues, int p_nNbPoints){
		m_arSites= new Site[m_nNbSites];
		m_nNbSites= p_nNbPoints;

		m_nMinX= p_arXValues[0];
		m_nMinY= p_arYValues[0];
		m_nMaxX= p_arXValues[0];
		m_nMaxY= p_arYValues[0];

		for(int i= 0; i < m_nNbSites; i++){
			m_arSites[i]= new Site();
			m_arSites[i].m_pt.setPoint(p_arXValues[i], p_arYValues[i]);
			m_arSites[i].m_nIDSite= i;

			if(p_arXValues[i] < m_nMinX)
				m_nMinX= p_arXValues[i];
			else if(p_arXValues[i] > m_nMaxX)
				m_nMaxX= p_arXValues[i];

			if(p_arYValues[i] < m_nMinY)
				m_nMinY= p_arYValues[i];
			else if(p_arYValues[i] > m_nMaxY)
				m_nMaxY= p_arYValues[i];
		}

		m_nDeltaY= m_nMaxY - m_nMinY;
		m_nDeltaX= m_nMaxX - m_nMinX;
	}


	private void sortSites(Site[] p_arSites){
		List<Site> lstSites= new ArrayList<Site>(p_arSites.length);

		for(Site s: p_arSites)
			lstSites.add(s);

		Collections.sort(lstSites, new Comparator<Site>(){
			public final int compare(Site p1, Site p2){
				Point s1= p1.m_pt;
				Point s2= p2.m_pt;
				
				if(s1.m_nY < s2.m_nY)	return -1;
				if(s1.m_nY > s2.m_nY)	return 1;
				if(s1.m_nX < s2.m_nX)	return -1;
				if(s1.m_nX > s2.m_nX)	return 1;

				return 0;
			}
		});

		// Copy back into the array
		for(int i= 0; i < p_arSites.length; i++)
			p_arSites[i]= lstSites.get(i);
    }

	private Site getNextSite(){
		if(m_nCurSite < m_nNbSites)
			return m_arSites[m_nCurSite++];
		else
			return null;
	}

	private Edge bisect(Site p_objSite1, Site p_objSite2){
		Edge objEdge= new Edge();
		double dx, dy, adx, ady;

		// store the sites that this edge is bisecting
		objEdge.m_refSite[0]= p_objSite1;
		objEdge.m_refSite[1]= p_objSite2;

		// get the difference in m_nX dist between the sites
		dx= p_objSite2.m_pt.m_nX - p_objSite1.m_pt.m_nX;
		dy= p_objSite2.m_pt.m_nY - p_objSite1.m_pt.m_nY;

		// make sure that the difference in positive
		adx= (dx > 0)? dx : -dx;
		ady= (dy > 0)? dy : -dy;

		// get the slope of the line
		objEdge.c= (double)(p_objSite1.m_pt.m_nX * dx + p_objSite1.m_pt.m_nY * dy + (dx * dx + dy* dy) * 0.5);

		if(adx > ady){
			objEdge.a= 1.0f;
			objEdge.b= dy / dx;
			objEdge.c/= dx;// set formula of line, with m_nX fixed to 1
		}else{
			objEdge.b= 1.0f;
			objEdge.a= dx / dy;
			objEdge.c/= dy;// set formula of line, with m_nY fixed to 1
		}

		objEdge.m_nIDEdge= m_nNbEdges++;
		return objEdge;
	}

	private void makeVertex(Site v){
		v.m_nIDSite= m_nNbVertices++;
	}

    private boolean PQ_Initialize(){
		PQhashsize	= 4 * m_nNbSiteSqrt;
		PQhash		= new HalfEdge[PQhashsize];
		PQcount	= 0;
		PQmin	= 0;

		for(int i= 0; i < PQhashsize; ++i)
			PQhash[i]= new HalfEdge();

		return true;
    }

	private int PQ_Bucket(HalfEdge he){
		int bucket= (int) ((he.m_nYStar - m_nMinY) / m_nDeltaY * PQhashsize);

		if(bucket < 0)
			bucket= 0;

		if(bucket >= PQhashsize)
			bucket= PQhashsize - 1;

		if (bucket < PQmin)
			PQmin= bucket;

		return bucket;
	}

	// push the HalfEdge into the ordered linked list of vertices
	private void PQ_Insert(HalfEdge he, Site p_objVertex, double offset){
		HalfEdge last, next;

		he.m_objVertex= p_objVertex;
		he.m_nYStar= (double) (p_objVertex.m_pt.m_nY + offset);

		last= PQhash[PQ_Bucket(he)];

		while((next= last.PQnext) != null && (he.m_nYStar > next.m_nYStar || (he.m_nYStar == next.m_nYStar && p_objVertex.m_pt.m_nX > next.m_objVertex.m_pt.m_nX))){
			last= next;
		}

		he.PQnext= last.PQnext;
		last.PQnext= he;
		PQcount++;
	}

	// remove the HalfEdge from the list of vertices
	private void PQ_Delete(HalfEdge he){
		HalfEdge last;

		if(he.m_objVertex != null){
			last= PQhash[PQ_Bucket(he)];

			while(last.PQnext != he){
				last= last.PQnext;
			}

			last.PQnext= he.PQnext;
			PQcount--;

			he.m_objVertex= null;
		}
	}

	private boolean PQ_IsEmpty(){
		return (PQcount == 0);
	}

	private Point PQ_Min(){
		Point answer= new Point();

		while(PQhash[PQmin].PQnext == null)
			PQmin++;

		answer.m_nX= PQhash[PQmin].PQnext.m_objVertex.m_pt.m_nX;
		answer.m_nY= PQhash[PQmin].PQnext.m_nYStar;
		return answer;
	}

	private HalfEdge PQ_ExtractMin(){
		HalfEdge curr= PQhash[PQmin].PQnext;

		PQhash[PQmin].PQnext= curr.PQnext;
		PQcount--;

		return curr;
	}

	private void EL_Initialize(){
		ELhashsize	= 2 * m_nNbSiteSqrt;
		ELhash		= new HalfEdge[ELhashsize];

		for(int i= 0; i < ELhashsize; ++i)
			ELhash[i]= null;

		ELleftend= new HalfEdge(null, 0);
		ELrightend= new HalfEdge(null, 0);

		ELleftend.m_objRightHE= ELrightend;
		ELrightend.m_objLeftHE= ELleftend;

		ELhash[0]= ELleftend;
		ELhash[ELhashsize - 1]= ELrightend;
	}

	private Site getLeftSiteRef(HalfEdge he){
		if(he.m_objEdge == null)
			return m_objBottomSite;

		return (he.m_isLeftOrRight == LEFT_EDGE)? he.m_objEdge.m_refSite[LEFT_EDGE] : he.m_objEdge.m_refSite[RIGHT_EDGE];
	}

	private Site getRightSiteRef(HalfEdge he){
		if(he.m_objEdge == null)
			return m_objBottomSite;

		return (he.m_isLeftOrRight == LEFT_EDGE)? he.m_objEdge.m_refSite[RIGHT_EDGE] : he.m_objEdge.m_refSite[LEFT_EDGE];
	}

    //Get entry from hash table, pruning any deleted nodes
	private HalfEdge EL_GetHash(int p_nValue){
		HalfEdge he;

		if((p_nValue < 0)|| (p_nValue >= ELhashsize))
			return null;

		he= ELhash[p_nValue];
		if((he == null) || (!he.deleted))
			return he;

		//Hash table points to deleted half edge. Patch as necessary.
		ELhash[p_nValue]= null;
		return null;
	}

	private HalfEdge EL_LeftBnd(Point p_pt){
        HalfEdge objHalfEdge;
        int bucket= (int) ((p_pt.m_nX - m_nMinX) / m_nDeltaX * ELhashsize);	//Use hash table to get close to desired halfedge */
																			// use the hash function to find the place in the hash map that this
																			// HalfEdge should be

		if(bucket < 0)
			bucket= 0;
		if(bucket >= ELhashsize)
			bucket= ELhashsize - 1;

		objHalfEdge= EL_GetHash(bucket);
		if(objHalfEdge == null){
			// if the HE isn't found, search backwards and forwards in the hash map
			// for the first non-null entry
			for(int i= 1; i < ELhashsize; ++i){
				if((objHalfEdge= EL_GetHash(bucket - i)) != null)
					break;
				if((objHalfEdge= EL_GetHash(bucket + i)) != null)
					break;
			}
		}

		//Now search linear list of halfedges for the correct one
		if((objHalfEdge == ELleftend) || ((objHalfEdge != ELrightend) && objHalfEdge.isPointRightOf(p_pt))){
			// keep going right on the list until either the end is reached, or
			// you find the 1st edge which the point isn't to the right of
			do{
				objHalfEdge= objHalfEdge.m_objRightHE;
			}while((objHalfEdge != ELrightend) && objHalfEdge.isPointRightOf(p_pt));

			objHalfEdge= objHalfEdge.m_objLeftHE;
		}else{
			// if the point is to the left of the HalfEdge, then search left for
			// the HE just to the left of the point
			do{
				objHalfEdge= objHalfEdge.m_objLeftHE;
			}while((objHalfEdge != ELleftend) && !objHalfEdge.isPointRightOf(p_pt));
		}

		/* Update hash table and reference counts */
//		if(bucket > 0 && bucket < ELhashsize - 1)	AP. That is a bug ... bucket is already set, furthermore position 0 and max wont be used
		ELhash[bucket]= objHalfEdge;

		return objHalfEdge;
    }

	private void clipLine(Edge p_edge){
		double pxmin= m_nBorderMinX;
		double pxmax= m_nBorderMaxX;
		double pymin= m_nBorderMinY;
		double pymax= m_nBorderMaxY;
		double x1= p_edge.m_refSite[0].m_pt.m_nX;
		double x2= p_edge.m_refSite[1].m_pt.m_nX;
		double y1= p_edge.m_refSite[0].m_pt.m_nY;
		double y2= p_edge.m_refSite[1].m_pt.m_nY;
		Site s1, s2;

		// if the distance between the two points this line was created from is
		// less than the square root of 2, then ignore it
		if(Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1))) < m_nMinDistanceBetweenSites)
			return;

		if((p_edge.a == 1.0) && (p_edge.b >= 0.0)){
			s1= p_edge.m_objEndPoint[1];
			s2= p_edge.m_objEndPoint[0];
		}else{
			s1= p_edge.m_objEndPoint[0];
			s2= p_edge.m_objEndPoint[1];
		}

		if(p_edge.a == 1.0){
			y1= pymin;

			if((s1 != null) && (s1.m_pt.m_nY > pymin))
				y1 = s1.m_pt.m_nY;
			if(y1 > pymax)
				y1 = pymax;

			x1= p_edge.c - p_edge.b * y1;
			y2= pymax;


			if((s2 != null) && (s2.m_pt.m_nY < pymax))
				y2= s2.m_pt.m_nY;
			if(y2 < pymin)
				y2= pymin;

			x2= (p_edge.c) - (p_edge.b) * y2;

			if(((x1 > pxmax) & (x2 > pxmax)) | ((x1 < pxmin) & (x2 < pxmin)))
				return;

			if(x1 > pxmax){
				x1= pxmax;
				y1= (p_edge.c - x1) / p_edge.b;
			}
			if(x1 < pxmin){
				x1= pxmin;
				y1= (p_edge.c - x1) / p_edge.b;
			}
			if(x2 > pxmax){
				x2= pxmax;
				y2= (p_edge.c - x2) / p_edge.b;
			}
			if(x2 < pxmin){
				x2= pxmin;
				y2= (p_edge.c - x2) / p_edge.b;
			}
		}else{
			x1= pxmin;

			if((s1 != null) && (s1.m_pt.m_nX > pxmin))
				x1= s1.m_pt.m_nX;
			if(x1 > pxmax)
				x1= pxmax;

			y1= p_edge.c - p_edge.a * x1;
			x2= pxmax;
			
			if((s2 != null) && (s2.m_pt.m_nX < pxmax))
				x2= s2.m_pt.m_nX;
			if(x2 < pxmin)
				x2= pxmin;

			y2= p_edge.c - p_edge.a * x2;

			if(((y1 > pymax) & (y2 > pymax)) | ((y1 < pymin) & (y2 < pymin)))
				return;

			if(y1 > pymax){
				y1= pymax;
				x1= (p_edge.c - y1) / p_edge.a;
			}
			if(y1 < pymin){
				y1= pymin;
				x1= (p_edge.c - y1) / p_edge.a;
			}
			if(y2 > pymax){
				y2= pymax;
				x2= (p_edge.c - y2) / p_edge.a;
			}
			if(y2 < pymin){
				y2= pymin;
				x2= (p_edge.c - y2) / p_edge.a;
			}
		}

		m_lstEdges.add(new GraphEdge(p_edge.m_refSite[0], p_edge.m_refSite[1], x1, y1, x2, y2));
    }

	private void setEndPointAndClip(Edge p_objEdge, int p_nLeftOrRight, Site p_objSite){
		p_objEdge.m_objEndPoint[p_nLeftOrRight]= p_objSite;

		if(p_objEdge.m_objEndPoint[RIGHT_EDGE - p_nLeftOrRight] == null)
			return;

		clipLine(p_objEdge);
	}


	//Create a new site where the HalfEdges p_objHE1 and p_objHE2 intersect
	private Site intersect(HalfEdge p_objHE1, HalfEdge p_objHE2){
        Edge objEdge1= p_objHE1.m_objEdge;
        Edge objEdge2= p_objHE2.m_objEdge;

		if((objEdge1 == null) || (objEdge2 == null))
			return null;
		if(objEdge1.m_refSite[1] == objEdge2.m_refSite[1])
			return null;

		double d= objEdge1.a * objEdge2.b - objEdge1.b * objEdge2.a;
		if(-1.0e-10 < d && d < 1.0e-10)
			return null;

		double xint= (objEdge1.c * objEdge2.b - objEdge2.c * objEdge1.b) / d;
		double yint= (objEdge2.c * objEdge1.a - objEdge1.c * objEdge2.a) / d;
        Edge objEdge;
        HalfEdge objHE;

		if((objEdge1.m_refSite[1].m_pt.m_nY < objEdge2.m_refSite[1].m_pt.m_nY)
				|| (objEdge1.m_refSite[1].m_pt.m_nY == objEdge2.m_refSite[1].m_pt.m_nY && objEdge1.m_refSite[1].m_pt.m_nX < objEdge2.m_refSite[1].m_pt.m_nX)){
			objHE= p_objHE1;
			objEdge= objEdge1;
		}else{
			objHE= p_objHE2;
			objEdge= objEdge2;
		}

		boolean isRightOfSite= (xint >= objEdge.m_refSite[1].m_pt.m_nX);
		if((isRightOfSite && (objHE.m_isLeftOrRight == LEFT_EDGE)) || (!isRightOfSite && (objHE.m_isLeftOrRight == RIGHT_EDGE)))
			return null;

        // create a new site at the point of intersection - this is a new vector event waiting to happen
        return new Site(xint, yint);
    }

	private boolean buildVoronoi(){
		HalfEdge lbnd;
		Edge e;

		PQ_Initialize();
		EL_Initialize();

		m_objBottomSite= getNextSite();
		Site newsite= getNextSite();

		while(true){
			Point newIntStar= null;

			Site objSiteBottom, objSiteTop;
			Site objVertex;
			Site p;

			HalfEdge rbnd, llbnd, rrbnd, bisector;

			if(!PQ_IsEmpty())
				newIntStar= PQ_Min();

			// if the lowest site has a smaller m_nY value than the lowest vector intersection,
			// process the site otherwise process the vector intersection
			if (newsite != null
					&& (PQ_IsEmpty() || newsite.m_pt.m_nY < newIntStar.m_nY || (newsite.m_pt.m_nY == newIntStar.m_nY && newsite.m_pt.m_nX < newIntStar.m_nX))){
				///New site is smallest -this is a site event

				lbnd= EL_LeftBnd((newsite.m_pt));		//Get the first HalfEdge to the LEFT of the new site
				rbnd= lbnd.getRight();					//Get the first HalfEdge to the RIGHT of the new site
				objSiteBottom= getRightSiteRef(lbnd);	//If this halfedge has no edge,bot =bottom site (whatever that is)
				e= bisect(objSiteBottom, newsite);		//Create a new edge that bisects


				bisector= new HalfEdge(e, LEFT_EDGE);	//Create a new HalfEdge, setting its m_isLeftOrRight field to 0
				lbnd.insert(bisector);					//Insert this new bisector edge between the left and right
														// vectors in a linked list

				//If the new bisector intersects with the left edge,
				// remove the left edge's m_objVertex, and put in the new one
				if((p= intersect(lbnd, bisector)) != null){
					PQ_Delete(lbnd);
					PQ_Insert(lbnd, p, p.dist(newsite));
				}

				lbnd= bisector;

				bisector= new HalfEdge(e, RIGHT_EDGE);	//Create a new HalfEdge, setting its m_isLeftOrRight field to 1 and
				lbnd.insert(bisector);					// insert the new HE to the right of the original bisectorearlier in the IF stmt

				// if this new bisector intersects with the new HalfEdge
				if((p= intersect(bisector, rbnd)) != null)
					PQ_Insert(bisector, p, p.dist(newsite));	//Push the HE into the ordered linked list of vertices

				newsite= getNextSite();
			}else if(!PQ_IsEmpty()){
				//Intersection is smallest - this is a vector event

				int isLeftOrRight;

				lbnd= PQ_ExtractMin();			//Pop the HalfEdge with the lowest vector off the ordered list of vectors
				llbnd= lbnd.getLeft();
				rbnd= lbnd.getRight();
				rrbnd= rbnd.getRight();

				objSiteBottom= getLeftSiteRef(lbnd);
				objSiteTop= getRightSiteRef(rbnd);

				objVertex= lbnd.m_objVertex;	//Get the m_objVertex that caused this event
				makeVertex(objVertex);			//Set the m_objVertex number - couldn't do this
												// earlier since we didn't know when it would be processed

				setEndPointAndClip(lbnd.m_objEdge, lbnd.m_isLeftOrRight, objVertex);	//Set the endpoint of
																						// the left HalfEdge to be this vector
				setEndPointAndClip(rbnd.m_objEdge, rbnd.m_isLeftOrRight, objVertex);	//Set the endpoint of
																						// the right HalfEdge to be this vector
				lbnd.delete();		//Mark the lowest HE for deletion - can't delete yet because there
									// might be pointers to it in Hash Map
				PQ_Delete(rbnd);	//Remove all m_objVertex events to do with the right HE
				rbnd.delete();		//Mark the right HE for deletion - can't delete yet because there
									// might be pointers to it in Hash Map
				isLeftOrRight= LEFT_EDGE;

				if(objSiteBottom.m_pt.m_nY > objSiteTop.m_pt.m_nY){
					// if the site to the left of the event is higher than the Site
					// to the right of it, then swap them and set the 'pm' variable to 1
					Site objSiteTemp= objSiteBottom;
					objSiteBottom= objSiteTop;
					objSiteTop= objSiteTemp;
					isLeftOrRight= RIGHT_EDGE;
				}

				e= bisect(objSiteBottom, objSiteTop);	//Create an Edge (or line)
														// that is between the two Sites. This creates the formula of
														// the line, and assigns a line number to it
				bisector= new HalfEdge(e, isLeftOrRight);	//Create a HE from the Edge 'e',
															// and make it point to that edge
															// with its m_objEdge field
				llbnd.insert(bisector); //Insert the new bisector to the right of the left HE
				setEndPointAndClip(e, RIGHT_EDGE - isLeftOrRight, objVertex);	//Set one endpoint to the new edge
																				// to be the vector point 'v'.
																				// If the site to the left of this bisector is higher than the
																				// right Site, then this endpoint
																				// is put in position 0; otherwise in pos 1

				//If left HE and the new bisector intersect, then delete the left HE, and reinsert it
				if((p= intersect(llbnd, bisector)) != null){
					PQ_Delete(llbnd);
					PQ_Insert(llbnd, p, p.dist(objSiteBottom));
				}

				//If right HE and the new bisector intersect, then reinsert it
				if((p= intersect(bisector, rrbnd)) != null)
					PQ_Insert(bisector, p, p.dist(objSiteBottom));
			}else
				break;
		}

		for(lbnd= ELleftend.getRight(); lbnd != ELrightend; lbnd= lbnd.getRight()){
			e= lbnd.m_objEdge;
			clipLine(e);
		}

		return true;
	}
}
