package package3;
import package2.Train;
/**
 * 
 * @author sydneycampbell
 * Metro class that is a derived class of the Train class
 */
public class Metro extends Train{

	protected int nbstops;
	
	/**
	 * Default constructor
	 */
	public Metro()
	{
		nbstops=0;
	}

	/**
	 * 
	 * @param numWheels
	 * @param maxSpeed
	 * @param numVehicles
	 * @param startStation
	 * @param destinationStation
	 * @param nbstops
	 * Parameterized constructor
	 * Uses super to initialize attributes from Train class
	 * Initializes nbstops
	 */
	public Metro(int numWheels, double maxSpeed, int numVehicles, String startStation, String destinationStation, int nbstops) {
		super(numWheels, maxSpeed, numVehicles, startStation, destinationStation);
		this.nbstops=nbstops;
		
	}

	/**
	 * 
	 * @param m
	 * Copy constructor
	 */
	public Metro(Metro m) {
		numWheels = m.numWheels;
		maxSpeed=m.maxSpeed;
		numVehicles=m.numVehicles;
		startStation=m.startStation;
		destinationStation=m.destinationStation;
		nbstops=m.nbstops;
	}

	/**
	 * 
	 * @return nbstops
	 * Returns integer value of the number of stops
	 */
	public int getNbstops() {
		return nbstops;
	}

	/**
	 * 
	 * @param nbstops
	 * Sets the integer number of stops
	 */
	public void setNbstops(int nbstops) {
		this.nbstops = nbstops;
	}
	/**
	 * Overriden toString method of the Train class
	 * @return String
	 */
	@Override
	public String toString()
	{
		return "This metro has " + getNumWheels() + " wheels and a maximum speed of " + getMaxSpeed() + "km/h. It also has " + getNumVehicles() + " vehicles,"
					+ " its starting and destination stations are " + getStartStation() + " and " + getDestinationStation() + ", and it has " + nbstops + " stops.";
   }
	/**
	 * Overriden equals method of the Train class
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
			Metro t = (Metro)x;
			return this.getNumWheels()==t.getNumWheels()&&this.getMaxSpeed()==t.getMaxSpeed()&&this.getNumVehicles()==t.getNumVehicles()
					&& this.getStartStation().equals(t.getStartStation()) && this.getDestinationStation().equals(t.getDestinationStation())&&this.nbstops==t.nbstops;
		}
	}
	
	
	
	
}
