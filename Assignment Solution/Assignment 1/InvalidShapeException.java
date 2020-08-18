/* *********************************************************
 * EECS2011A: Fundamentals of Data Structures,  Fall 2017
 * Assignment 1, Problem 3 
 * Student Full Name   : Rajkumar Balakrishnan Lakshmi  
 * Student eecs account: kumarraj 
 * Student ID number   : 213141197
 **********************************************************/

package A1;

class InvalidShapeException extends Exception {

	public InvalidShapeException() 
	{
		super();
	}

	public InvalidShapeException(String message) 
	{
		super(message);
		
	}

	public InvalidShapeException(Throwable arg0) {
		super(arg0);
	}

}
