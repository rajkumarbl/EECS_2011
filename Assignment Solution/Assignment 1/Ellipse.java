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
 * The purpose of this class is to construct an ellipse, find the area of it  and also to find if a given
 *  point lies within the ellipse.
 * 
 * The main method runs some tests.
 * 
 * @author rajkumar
 * 
 */
public class Ellipse implements PlanarShape 
{

	 protected Point2D.Double center;
	 private double hAxis, vAxis;
	 
	 /**
	  * Default constructor.  Results in an ellipse constructed with default values.
	  */
	 public Ellipse()
	 {
		 this. hAxis=0;
		 this.vAxis=0;
		 this.center.x=0;
		 this.center.y=0;
	 }
	 
	 /**
	  * Constructs an ellipse with given Centre, horizontal and vertical axis.
	  *  
	  * @param hAx - the horizontal axis of the ellipse.
	  * @param vAx - the vertical axis of the ellipse.
	  * @param cen - the centre coordinates of the ellipse.
	  * @throws InvalidShapeException if the horizontal or vertical axis values are negative.
	  */
	 public Ellipse(double hAx, double vAx, Point2D.Double cen) throws InvalidShapeException
	 {
			sethAxis(hAx);
		    setvAxis(vAx);
		    setCenter(cen);
	 }
	 
    /**
     *  
     * @return the Horizontal axis of the ellipse
     */
	public double gethAxis() 
	{
		return hAxis;
	}
    
	/**
	 * If possible, sets the horizontal axis of the ellipse to the given value.
	 * @param hAxis the horizontal axis of the ellipse.
	 * @throws InvalidShapeException if the given horizontal axis is in negative.
	 */
	public void sethAxis(double hAxis) throws InvalidShapeException
	{
		if (hAxis <0)
		 {
			 throw new InvalidShapeException("Invalid entry! Negative ellipse axis has been entered");
		 }
		 else
		 {
		     this.hAxis = hAxis;
		 }
	}
    
	/**
	 * 
	 * @return the Vertical axis of the ellipse
	 */
	public double getvAxis() 
	{
		return vAxis;
	}
    
	/**
	 * If possible, sets the vertical axis of ellipse to the given value.
	 * @param vAxis the vertical axis of the ellipse.
	 * @throws InvalidShapeException if the given vertical axis is in negative.
	 */
	public void setvAxis(double vAxis) throws InvalidShapeException
	{
		if (vAxis <0)
		 {
			 throw new InvalidShapeException("Invalid entry! Negative ellipse axis has been entered");
		 }
		 else
		 {
		     this.vAxis = vAxis;
		 }
	}
	
    /**
     * @return the centre coordinates of the ellipse.
     */
	public Point2D.Double getCenter() {
		return center;
	}

	/**
	 * Sets the centre of the ellipse to the given value.
	 * @param center the x,y coordinates for the ellipse.
	 */
	public void setCenter(Point2D.Double center)
	{
		this.center = center;
	}
    
	/**
	 * @return the string representation of the centre, horizontal and vertical axis of the ellipse.
	 */
	@Override
	public String toString() 
	{
		return "Ellipse [Centre = (" +center.x+","+center.y + "), Horizontal_Axis = " + hAxis + ", Vertical_Axis = " + vAxis + "]";
	}
    
	/**
	 * This is an overridden method implemented from the PlanerShape interface,
	 * that calculates and returns the area of an ellipse. 
	 * 
	 * @return the area of an ellipse.
	 */
	@Override
	public double area() 
	{
		return Math.PI*this.vAxis*this.hAxis;
	}
	
	/**
   	 * This is an overridden method implemented from the PlanerShape interface,
   	 * that finds if a given point lies within the ellipse.
   	 * 
   	 * @param p is an object of Point2D.Double class of java library with x and y coordinates.
   	 * @return true of false based on the condition that if the given point is contained within the ellipse.
   	 */
	@Override
	public boolean contains(Point2D.Double p)
	{
	
		return ((Math.pow(((p.x-this.center.x)/this.hAxis), 2) + Math.pow(((p.y-this.center.y)/this.vAxis), 2)) <=1) ? true:false;
	}
	
	/**
	 * main() runs test cases on area() and contains() method. Prints summary information on basic
	 * operations.
	 */
	public static void main(String[] args) throws InvalidShapeException
	{
		
		Point2D.Double centre = new Point2D.Double(0,0);
		Ellipse e = new Ellipse(15.00,30.00, centre);
		
		Point2D.Double point = new Point2D.Double(4,2);
		
		System.out.printf("%.2f\n",e.area());
		System.out.println(e.contains(point));
		
		Point2D.Double point2 = new Point2D.Double(17,15);
		System.out.println(e.contains(point2));
		
		System.out.println(e.toString());
	}
}
