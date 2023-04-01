package package4;
import package1.WheeledTransportation;
import package2.Train;
/**
 * 
 * @author sydneycampbell
 * Class Monowheel that is a derived class of the WheeledTransportation
 */
public class Monowheel extends WheeledTransportation{

	private double maxWeight;
	/**
	 * Default constructor
	 */
	public Monowheel()
	{
		maxWeight=0.0;
	}
	/**
	 * 
	 * @param numWheels
	 * @param maxSpeed
	 * @param maxWeight
	 * Parameterized constructor that uses super to set the values from WheeledTransportation
	 * Initializes two other attribute
	 */
	public Monowheel(int numWheels, double maxSpeed, double maxWeight)
	{
		super(numWheels,maxSpeed);
		this.maxWeight=maxWeight;
	}
	/**
	 * 
	 * @param m
	 * Copy COnstructor
	 */
	public Monowheel(Monowheel m)
	{
		setNumWheels(m.numWheels);
		setMaxSpeed(m.maxSpeed);
		this.maxWeight=m.maxWeight;
	}
	/**
	 * 
	 * @return maxWeight
	 * Returns the double value maxWeight
	 */
	public double getMaxWeight() {
		return maxWeight;
	}
	/**
	 * 
	 * @param maxWeight
	 * Sets the maxWeight
	 */
	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}
	/**
	 * Overriden method of the toString from WheeledTransportation
	 * @return String
	 */
	@Override
	public String toString()
	{
		return "This Monowheel has " + getNumWheels() + " wheels, has a maximum speed of " + getMaxSpeed() + "km/h and has a maximum weight of " + maxWeight + "kg.";
	}
	/**
	 * Overriden method of the equals method that returns a boolean
	 * @param Object x
	 * @return boolean
	 */
	@Override
	public boolean equals(Object x)
	{
		if(x==null||this.getClass()!=x.getClass())
		{
			return false;
		}
		else
		{
			Monowheel m = (Monowheel)x;
			return this.getNumWheels()==m.getNumWheels()&&this.getMaxSpeed()==m.getMaxSpeed()&&this.maxWeight==m.maxWeight;
		}
	}
	
}
