package package1;

import package2.Train;
import package2.Tram;
import package3.Metro;
import package4.Monowheel;
import package5.Aircraft;
import package5.WorldWarIIAirplane;
import package6.Ferry;
/**
 * 
 * Part 2:
 * The Driver class allows the program to implement the other classes when called.
 * Also implements a new method (copying content of an array) for later discussion on weither it is a correct or incorrect way of implementation
 * @author Sydney Campbell (40243309)
 * Assignment #2
 * COMP-249 Section QQ
 * March 4th, 2023
 * 
 *
 */
public class Driver2 {

	/**
	 * 
	 * @param Object[] mixedobjects
	 * @return Object[]
	 * Method that takes as input an array of these objects (the array can be of any size and should have mixed objects from all of the classes) 
	 * And returns a copy of that array.
	 * Method does no allow: clone(), finding the object type inside the copy constructors, explicitly finding the exact type of the objects being copied
	 */
	public static Object[] copyTheObjects(Object[] mixedobjects) //shallow copy (need deep copy)
	{
		Object[] array = new Object[mixedobjects.length];
		
		for(int i =0;i<array.length;i++)
		{
			array[i]= mixedobjects[i];
		}
		return array;
	}
	/**
	 * 
	 * @param args
	 *  Method that creates 16 different objects and implements the copyTheObjects methods to test its behaviour
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
		
	
		
		Object[] array1 = {w1,w2,t1,t2,m1,m2,tr1,tr2,mo1,mo2,a1,a2,a3,ww1,ww2,f1,f2,f3,f4};
		Object[] newarray = copyTheObjects(array1);
		
		//Displaying the arrays
		System.out.println("Displaying original contents of array 1");
		for(int i =0; i<array1.length;i++)
		{
			System.out.println(array1[i]);
			System.out.println();
		}
		System.out.println("Displaying the contents of the copy array");
		for(int i =0;i<newarray.length;i++)
		{
			System.out.println(newarray[i]);
			System.out.println();
		}
	}

}
