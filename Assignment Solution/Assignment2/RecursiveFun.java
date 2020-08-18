package A2;

public class RecursiveFun {

	public RecursiveFun() 
	{
		
	}
	
	public static int f ( int n )  
	{   
		if ( n > 1000 )
		{
		return n - 4; 
		}
		
	return f ( f (n + 5) ); 
	} 
	
	public static void main(String[] args) 
	{	
		System.out.println(RecursiveFun.f(1001));
		System.out.println(RecursiveFun.f(1000));
		System.out.println(RecursiveFun.f(0));}
    }
