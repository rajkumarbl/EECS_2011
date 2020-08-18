/* *********************************************************
 * EECS2011A: Fundamentals of Data Structures,  Fall 2017
 * Assignment 2, Problem 4
 * Student Full Name   : Rajkumar Balakrishnan Lakshmi  
 * Student eecs account: kumarraj 
 * Student ID number   : 213141197
 **********************************************************/

package A2;

import java.util.Arrays;
/*
 * The main purpose of this class is to efficiently find and print all saturated
 * itineraries for a given list of products price and the budget .
 */

public class SaturatedItineraries 
{
    public int[] quantities;
    public int[] unitPriceList;
    public int sat_itineraries = 0,final_budget,total;
    
	public SaturatedItineraries()
	{
	}
	
	
	/*
	 * This method is an overloaded version of the reportSI() method where, 
	 * the main recursion mechanism is carried out. This method 
	 * calculates all possible saturated itineraries for a given budget and also prints it.
	 * 
	 * @param budget - it is the current budget or in other words the remaining budget.
	 * @param position - Denotes the index of the price list.
	 */
	public void reportSI(int budget, int position)
	{
		if (position >= 0)
		{
		  if(budget <= (this.unitPriceList[0]-1) && budget >=0) 
			{
				sat_itineraries++;
				this.total=final_budget-budget;
				System.out.print("Quantities = "+Arrays.toString(this.quantities).replaceAll(", ", ",")+"\tTotal Price = "+total+"\n");
			} 
			else 
			{
				if (budget >= this.unitPriceList[position])
				{
					this.quantities[position]++;
					this.reportSI(budget - this.unitPriceList[position], position);
					this.quantities[position]--;
				}
				this.reportSI(budget, position - 1);
			}
		}
	}
    
	/*
	 * This method is the main functional method that calls its overloaded version to
	 * obtain the output. It also initialises the arrays and other variables. It prints
	 * out the head and tail part of the output and body part is printed upon call to its overloaded version.
	 * 
	 * @param priceList - list of unit prices from least to most expensive.
	 * @param budget - an estimate of the expenditure that can be spent over the list.
	 */
	public void reportSI(int[] priceList, int budget)
	{
		if(budget <= 0)
		 {
			System.out.println("Please enter a valid budget!");
			return ;
		 }
		else if(budget<priceList[0])
		{
			System.out.println("Cannot evaluate a itenary!\nSince the entered budget is lower than the price of any item on the list!");
			return ;
		}
		this.unitPriceList =priceList;
		this.quantities = new int[unitPriceList.length];	
		System.out.println("Unit Price List = "+Arrays.toString(this.unitPriceList).replaceAll(", ", ",")+"\t Budget = "+budget+"\n");
		System.out.println("The Saturated Itenaries are: \n");
		this.sat_itineraries = 0;this.final_budget=budget;this.total=0;
		this.reportSI(budget, this.unitPriceList.length - 1);	
		System.out.println("\nThe total number of saturated itenaries are : "+this.sat_itineraries);
    }
	
	public static void main(String[] args) 
	{
		int[] unit = {3, 5, 7};
		SaturatedItineraries  si = new SaturatedItineraries();
		si.reportSI(unit,88);
	}

}
