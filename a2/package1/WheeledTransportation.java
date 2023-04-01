package package1;

/**
 * 
 * @author sydneycampbell
 * Base class to many derived classes
 *
 */
public class WheeledTransportation {

	protected int numWheels;
	protected double maxSpeed;
	
	/**
	 * Default construct that sets everything to 0
	 */
	public WheeledTransportation()
	{
		numWheels=0;
		maxSpeed=0.0;
	}
	/**
	 * Parameterized constructor that initializes the number of wheels and the maximum speed
	 * @param numWheels
	 * @param maxSpeed
	 */
	public WheeledTransportation(int numWheels, double maxSpeed) 
	{
		
		this.numWheels = numWheels;
		this.maxSpeed = maxSpeed;
	}
	/**
	 * 
	 * @param w
	 * Copy constructor of WheeledTransportation
	 */
	public WheeledTransportation(WheeledTransportation w)
	{
		this.numWheels=w.numWheels;
		this.maxSpeed=w.maxSpeed;
	}
	/**
	 * 
	 * @return numWheels
	 * Returns an integer of the number of wheels
	 */
	public int getNumWheels() {
		return numWheels;
	}
	/**
	 * 
	 * @param numWheels
	 * Sets an integer value of a number of wheels
	 */
	public void setNumWheels(int numWheels) {
		this.numWheels = numWheels;
	}
	/**
	 * 
	 * @return maxSpeed
	 * Return a double value of the maximum speed
	 */
	public double getMaxSpeed() {
		return maxSpeed;
	}
	/**
	 * 
	 * @param maxSpeed
	 * Sets a double value of the maximum speed
	 */
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	/**
	 * @return String
	 * Returns a string representation of the content of a wheeled transportation object
	 */
	public String toString()
	{
		return "This wheeled transportation has " + numWheels + " wheels and a maximum speed of " + maxSpeed + "km/h.";
	}
	
	@Override
	/**
	 * @param Object otherObject
	 * @return boolean
	 * Overriden method that compares the content of two wheeled transportation and returns a boolean
	 */
	public boolean equals(Object otherObject)
	{
		
		
			if (otherObject == null)
			{
				return false;
			}
			else if (getClass()!=otherObject.getClass())
			{
				return false;
			}
			else
			{
				WheeledTransportation otherTransportation = (WheeledTransportation)otherObject;
				return this.numWheels==otherTransportation.numWheels && this.maxSpeed==otherTransportation.maxSpeed;
									
						
			}
		
	}
	
	
}
