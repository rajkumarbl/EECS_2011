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
 * The purpose of this class is to construct a circle, find the area of it, to find if a circle lies within a circle  and also to find if a given
 *  point lies within the circle.
 * 
 * The main method runs some tests.
 * 
 * @author rajkumar
 * 
 */
public class Circle extends Ellipse 
{
    private double radius;
    protected Point2D.Double center;
    
    
	 /**
	  * Default constructor.  Results in a circle constructed with default values.
	  */
	public Circle() 
	{
		this.center.x=0;
		this.center.y=0;
		this.radius=0;
	}
    
	/**
	 * Constructs a circle with given Centre and radius.
	 * @param rad  radius of the circle
	 * @param center the centre coordinates of the circle.
	 * @throws InvalidShapeException if the entered radius value is negative. 
	 */
	public Circle (double rad, Point2D.Double centre) throws InvalidShapeException 
	{
		 super(0,0,centre);
		 setRadius(rad);
		 setCenter(centre);
	}
    
	/**
	 * 
	 * @return the radius of the circle.
	 */
	public double getRadius()
	{
		return radius;
	}
 
	/**
	 * If possible, sets the radius of circle to the given value.
	 * @param radius of the circle.
	 * @throws InvalidShapeException if the entered radius value is negative. 
	 */
	public void setRadius(double radius) throws InvalidShapeException 
	{
		if (radius<0)
		 {
			 throw new InvalidShapeException("Invalid entry! Negative circle radius has been entered");
		 }
		else
		{
		     this.radius = radius;
		}
	}
	
	
	/**
     * @return the centre coordinates of the circle.
     */
	public Point2D.Double getCenter() 
	{
		return center;
	}
 
	/**
	 * Sets the centre of the circle to the given value.
	 * @param center the x,y coordinates for the circle.
	 */
	public void setCenter(Point2D.Double center)
	{
		this.center = center;
	}
	
	/**
	 * @return the string representation of the Centre and radius of the circle.
	 */
	@Override
	public String toString() 
	{
		return "Circle [ Centre = (" + center.x + "," + center.y +"), Radius=" + radius + " ]";
	}
	
	/**
	 * This is an overridden method inherited from the parent class,
	 * that calculates and returns the area of a circle. 
	 * 
	 * @return the area of a circle.
	 */
	@Override
	public double area()
	{
		return Math.PI*this.radius*this.radius;	
	}
	
	/**
   	 * This is an overridden method implemented inherited from the parent class,
   	 * that finds if a given point lies within the circle.
   	 * 
   	 * @param p is an object of Point2D.Double class of java library with x and y coordinates.
   	 * @return true of false based on the condition that if the given point is contained within the circle.
   	 */
	@Override
	public boolean contains(Point2D.Double p)
	{
		return (Math.sqrt((Math.pow((p.x - this.center.x), 2)) + (Math.pow((p.y - this.center.y), 2))) <= this.radius);
	}
	
	/**
	 * This method checks if circle c inside this.circle and returns true or false respectively. 
	 * @param c is an object of the Circle class with centre (x & y) coordinates.
	 * @return true of false based on the condition that if the circle is contained within the circle.
	 */
	public boolean contains(Circle c)
	{
		return ( Math.sqrt((Math.pow((this.center.x-c.center.x), 2)) + (Math.pow((this.center.y - c.center.y), 2))) <= (Math.abs(this.radius-c.radius)));
	}
	
	/**
	 * main() runs test cases on area() and contains() method. Prints summary information on basic
	 * operations.
	 */
	public static void main(String[] args) throws InvalidShapeException
	{
		Point2D.Double mainCentre = new Point2D.Double(0,0);
		Circle mainCircle = new Circle(5,mainCentre);
		
		Point2D.Double subCentre = new Point2D.Double(0,0);
		Circle subCircle = new Circle(5,subCentre);
		
		Point2D.Double subCentre2 = new Point2D.Double(8,5);
		Circle subCircle2 = new Circle(5,subCentre2);
		
		Point2D.Double point = new Point2D.Double(4,2);
		Point2D.Double point2 = new Point2D.Double(4,4);
		System.out.printf("%.2f\n",mainCircle.area());
		System.out.println(mainCircle.contains(point));
		System.out.println(mainCircle.contains(point2));
		System.out.println(mainCircle.contains(subCircle));
		System.out.println(mainCircle.contains(subCircle2));
		System.out.println(mainCircle.toString());
	 
    }
}
