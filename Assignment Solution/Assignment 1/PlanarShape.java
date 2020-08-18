/* *********************************************************
 * EECS2011A: Fundamentals of Data Structures,  Fall 2017
 * Assignment 1, Problem 3 
 * Student Full Name   : Rajkumar Balakrishnan Lakshmi  
 * Student eecs account: kumarraj 
 * Student ID number   : 213141197
 **********************************************************/
package A1;

import java.awt.geom.Point2D;


/**
 * PlanerShape is an interface that has the methods (area and contains) without any implementation.  
 * 
 * The main purpose of this class is to act as an interface class with method signatures
 * that needs to be implemented by the class that uses this interface.
 * 
 * @author rajkumar
 * 
 */
public interface PlanarShape 
{
	/**
	 * The area() method is used to calculate the area of a given shape of that particular class. 
	 * 
	 * @return the area of a given shape.
	 */
   	public double area();
   	
   	/**
   	 * The contains() method is used to find if a given point lies within a particular shape.
   	 * 
   	 * @param p is an object of Point2D.Double class of java library with x and y coordinates.
   	 * @return true of false based on the condition that if the given point is contained in a particular shape.
   	 */
    public boolean contains(Point2D.Double p);
}
