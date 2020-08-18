/* *********************************************************
 * EECS2011A: Fundamentals of Data Structures,  Fall 2017
 * Assignment 1, Problem 2
 * Student Full Name   : Rajkumar Balakrishnan Lakshmi  
 * Student eecs account: kumarraj 
 * Student ID number   : 213141197
 **********************************************************/

package A1;

/**
 * The purpose of this class is to find the longest almost flat contiguous subarray of an input
 * array of ints. A subarray is almost flat if no two elements of it differ by more than 1.
 * 
 * The main method runs some tests.
 * 
 * @author andy & rajkumar
 * 
 */

public class LongestAlmostFlatSubarray 
{

  	/**
	 * longestAFS() returns the longest almost flat subarray of an input array of ints.
	 * 
	 * This method does not alter its input array.
	 * 
	 * @return an array int[2] of the form {start, len} representing the longestAFS of ints[] as a
	 *         contiguous subarray of length len starting at index start.
	 * 
	 *         For example, on the input array {7, 7, 2, 8, 7, 7, 8, 8, 7, 1, 2, 1, 7, 8}, it
	 *         returns {3, 6}, indicating the longest AFS of this array is the subarray {8, 7, 7, 8,
	 *         8, 7} which starts at index 3 and has length 6.
	 * 
	 * @param ints
	 *            the input array.
	 */

	public static int[] longestAFS(int[] ints) 
	{
		// I have provided detailed explanation in the solution pdf attached to this assignment, kindly refer to it for further clarification
		int i=0;
		int initial=0,length=0,max=ints.length;
		int tempinitial=0,templength=0,count=0,sublength=1;

		while (i < ints.length && (i+1) < ints.length)
		{
		    if((ints[i]==ints[i+1] ||  (ints[i] - ints[i+1] == 1) || (ints[i+1] - ints[i] == 1) ) && ((ints[i]<= max)&&(ints[i+1]<= max)))
			{
		    		if(count == 0)
		    		{
				 	  tempinitial =tempinitial+Math.abs(i);
					  count++;
		    		}
		    		if(count==1)
		    		{
		    		   if(ints[i]==ints[i+1]) 
		    		    {
		    			  max=ints[i];
		    			}
		    		   else
		    		    {
		    			  max = (ints[i]<ints[i+1]) ? ints[i+1] : ints[i];
		    			  count++;
		    		    }
		    		}
			        if((ints[i]==max)&&(ints[i+1]==max)&&(ints[i]==ints[i+1]))
			        {
			          sublength++;
			        }
			        else
			        {
			          sublength=1;
			        }
			        templength++;i++;
			}
			else
			{  
				if((sublength>1)&&ints[i+1]==(max+1) )
			    {
					tempinitial=-sublength;
				    templength=sublength;
				} 
				else 
				{
					tempinitial=0;
					templength=0;
				}
			count=0;
			max=ints.length;
			sublength=1;
			i++;
			}
			if(templength>length) 
			{
				length=templength;
				initial=tempinitial;
			}
		}
        length = length +1;
		return new int[] { initial, length}; 
	}


	/**
	 * testDrive tests longestAFS by comparing its returned result with the correct answer.
	 * 
	 * @param testArray
	 *            the test array
	 * @param answer
	 *            the correct answer to the test array
	 * 
	 */
	public static void testDrive(int[] testArray, String answer) {

		System.out.println("Longest almost flat subarray of " + TestHelper.stringInts(testArray));
		String result = TestHelper.stringInts(longestAFS(testArray));
		System.out.println("is the subarray specified as [ start index , length ] = " + result + ". \n");
		TestHelper.verify(result.equals(answer), "Wrong!!!  No brownies!");
	}

  	/**
	 * main() runs test cases on your longestAFS() method. Prints summary information on basic
	 * operations and halts with an error (and a stack trace) if any of the tests fail.
	 */

	public static void main(String[] args) {

		System.out.println("Let's test longestAFS on some arrays: \n");

		// TEST 1:
		testDrive(new int[] { 7, 7, 2, 8, 7, 7, 8, 8, 7, 1, 2, 1, 7, 8 }, "[ 3 , 6 ]");

		// TEST 2:
		testDrive(new int[] { 7, 7, 2, 3, 8, 8, 8, 8, 8, 6, 1, 2, 1, 7, 8 }, "[ 4 , 5 ]");

		// TEST 3:
		testDrive(new int[] { 7, 7, 2, 8, 7, 7, 8, 8, 8, 9, 9, 6, 1, 2, 1, 7, 8 }, "[ 3 , 6 ]");

		// TEST 4:
		testDrive(new int[] { 7, 7, 2, 8, 7, 7, 8, 8, 8, 9, 9, 8, 9, 9, 6, 1, 2, 1, 7, 8 }, "[ 6 , 8 ]");

		System.out.println("\nAdditional tests done by the student or TA:\n");
		
		// TEST 5:
		testDrive(new int[] { 7, 7, 2, 8, 7, 7, 8, 8, 8, 9, 9, 8, 9, 9, 10, 10, 10, 10, 10, 10, 10, 6, 1, 2, 1, 7, 8 }, "[ 12 , 9 ]");
				
		// TEST 6:
		testDrive(new int[] { 7, 8, 9, 9, 10, 10, 10, 10, 10, 10, 10, 2, 8, 7, 7, 8, 8, 8, 9, 9, 8, 6, 1, 2, 1, 7, 8 }, "[ 2 , 9 ]");
				
		// TEST 7:	
		testDrive(new int[] { 9, 9, 10, 10, 10, 10, 10, 10, 10, 2, 8, 7, 7, 8, 8, 8, 9, 9, 8, 6, 1, 2, 1, 7, 8 }, "[ 0 , 9 ]");
				
		// TEST 8:		
		testDrive(new int[] { 2, 5, 9, 8, 9, 9, 10, 10, 10, 10, 10, 10, 10, 6, 1, 7 ,7, 7, 8, 8, 8, 9, 9, 9, 9, 9 }, "[ 4 , 9 ]");
		
		// TEST 9:		
		testDrive(new int[] { 0, 0, 0, 1, 1, 1, 5, 1, 1, 1, 2, 2 }, "[ 0 , 6 ]");
	}
}