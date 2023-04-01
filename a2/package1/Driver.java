package package1;
import package2.*;
import package3.*;
import package4.*;
import package4.*;
import package6.*;
import package5.Aircraft;
import package5.WorldWarIIAirplane;
/**
 * 
 * Part 1:
 * The Driver class allows the program to implement the other classes when called.
 * @author Sydney Campbell (40243309)
 * Assignment #2
 * COMP-249 Section QQ
 * March 4th, 2023
 * 
 *
 */
public class Driver {

	/**
	 * 
	 * @param args
	 * Method that creates 16 different objects and implements the equals, toString and findLeastAndMostExpensiveAircraft methods
	 */
	public static void main(String[] args) {
		
		WheeledTransportation w1 = new WheeledTransportation(4,100);
		WheeledTransportation w2 = new WheeledTransportation(50,300);
		Train t1 = new Train(100,300,3,"Montreal","Toronto");
		Train t2 = new Train(40,250,5,"Vancouver","Chicago");
		Metro m1 = new Metro(50,265,2,"New York","Long Island",8);
		Metro m2 = new Metro(10,200,3,"Murtle Beach","San Francisco",5);
		Tram tr1 = new Tram(30,400,2,"Sydney","Gold Coast",3,2014);
		Tram tr2 = new Tram(22,420,5,"Sydney","Melbourne",3,2020);
		Monowheel mo1 = new Monowheel(2,10,10);
		Monowheel mo2 = new Monowheel(3,5,5);
		Aircraft a1 = new Aircraft(1000000,12);
		Aircraft a2 = new Aircraft(50340,6);
		Aircraft a3 = new Aircraft(1000000,12);
		WorldWarIIAirplane ww1 = new WorldWarIIAirplane(300121,9,true);
		WorldWarIIAirplane ww2 = new WorldWarIIAirplane(600871.23,10,false);
		Ferry f1 = new Ferry(80,10000);
		Ferry f2 = new Ferry(30,30000);
		Ferry f3 = new Ferry(20,100009);
		Ferry f4 = new Ferry(60,3000);
		
		//Displaying all information
		
		Object[] array1 = {w1,w2,t1,t2,m1,m2,tr1,tr2,mo1,mo2,a1,a2,a3,ww1,ww2,f1,f2,f3,f4};
		
		System.out.println("Displaying all information of objects:\n");
		for(int i =0; i<array1.length;i++)
		{
			System.out.println(array1[i]);
			System.out.println();
		}
		//Testing the equality of some of the created objects
		
		
		System.out.println("Testing the equality of a couple obects:");
		
		
			if(w1.equals(t1))
			{
				System.out.println("The Wheeled Transportation w1 is equal to the Train t1");
			}
			else
			{
				System.out.println("The Wheeled Transportation w1 is not equal to the Train t1");
			}
			if(mo1.equals(mo2))
			{
				System.out.println("The Metro mo1 is equal to the Metro mo2");
			}
			else
			{
				System.out.println("The Metro mo1 is not equal to the Metro mo2");
			}
			if(a1.equals(a3))
			{
				System.out.println("The Aircraft a1 equals the Aircraft a3");
			}
			else
			{
				System.out.println("The aircraft a2 is not equal to the Aircraft a3");
			}
			
			Object[] array2 = {w1,w2,t1,t2,m1,m2,tr1,tr2,mo1,mo2,f1,f2,f3,f4};

			
			//Testing out static method to find least and most expensive aircraft
			
			String s1 =findLeastAndMostExpensiveAircraft(array1);
			String s2 =findLeastAndMostExpensiveAircraft(array2);
			
			System.out.println("\n" + s1);
			System.out.println("\n" + s2);
		}
		
	
	/**
	 * 
	 * @param Object[] mixedobjects
	 * @return String
	 * This method receives an array of objects in its parameter and returns the least and most expensive aircraft (or neither if empty)
	 * And displays a message as well as all of its content when called
	 */
	public static String findLeastAndMostExpensiveAircraft(Object[] mixedobjects)
	{
		int count=0, minPosition=0, maxPosition=0;
		double lowestPrice=0;
		double highestPrice=0;
		
		for(int i =0;i<mixedobjects.length;i++)
		{
			if(mixedobjects[i] instanceof Aircraft)
			{
				count++;
				Aircraft a = (Aircraft)mixedobjects[i];
				if(a.getPrice()<lowestPrice||lowestPrice==0)
				{
					lowestPrice=a.getPrice();
					minPosition=i;
				}
				if(a.getPrice()>highestPrice||highestPrice==0)
				{
					highestPrice=a.getPrice();
					maxPosition=i;
				}
				
			}
		}
		if(count==0)
		{
			return "There are no Aircraft objects in this array";
		}
		else if (minPosition==maxPosition && count!=0)
		{
			return "The Aircraft with the information displayed is both the least and most expensive aircraft in the array \n" + mixedobjects[minPosition].toString();
		}
		else
		{
			return "The least exensive aircraft has the following information \n" + mixedobjects[minPosition]
			+ "\nThe most expensive aircraft has the following information \n" + mixedobjects[maxPosition];
		}
		
	}
	
}
