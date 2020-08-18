/* *********************************************************
 * EECS2011A: Fundamentals of Data Structures,  Fall 2017
 * Assignment 2, Problem 3
 * Student Full Name   : Rajkumar Balakrishnan Lakshmi  
 * Student eecs account: kumarraj 
 * Student ID number   : 213141197
 **********************************************************/

package A2;

import java.util.Scanner;
import java.util.Stack;

/*
 * The purpose of this class is to convert a positive integer into 
 * binary form using both recursive and iterative mechanism.
 */
public class DecimalToBinary 
{

	public DecimalToBinary() 
	{
	}
	
	/*
	 * This Method converts the given integer to binary format
	 * using the iteration mechanism.
	 * 
	 * @param number - Decimal number that is to be converted.
	 */
	public static void Iter10To2(int number)  
	{   
		Stack<Integer> st = new Stack<>();
		if(number==0)
		{
			return;
		}
		else
		{
			 while(number>0)
				{
				st.push(number%2);
				number =number/2;
				}
		}
		while(!st.isEmpty())
		{
			System.out.print(st.pop());
		}
	} 
	
	/*
	 * This Method converts the given integer to binary format
	 * using the recursion mechanism.
	 * 
	 * @param number - Decimal number that is to be converted.
	 */
	public static void Rec10To2(int number)  
	{
		if(number>0)
		{
			Rec10To2(number/2);
			System.out.print(number%2);
		}
		else
		{
		return ;
		}			
	}

	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number to be converted into binary:");
		int num = input.nextInt();
		System.out.println("The Binary representation of "+num+ " using Iter10To2("+num+") is: ");
		DecimalToBinary.Iter10To2(num);
		
		System.out.print("\nEnter a number to be converted into binary:");
		int num2 = input.nextInt();
		System.out.println("The Binary representation of "+num2+ " using Rec10To2("+num2+") is: ");
		DecimalToBinary.Rec10To2(num2);
		
		input.close();
	}

}
