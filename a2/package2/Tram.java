package package2;
import package3.Metro;

/**
 * 
 * @author sydneycampbell
 * Class Tram that is derived from the class Metro
 *
 */
public class Tram extends Metro{

	private int creation_year;
	
	/**
	 * Default constructor
	 */
	public Tram()
	{
		creation_year=0;
	}

	/**
	 * 
	 * @param numWheels
	 * @param maxSpeed
	 * @param numVehicles
	 * @param startStation
	 * @param destinationStation
	 * @param nbstops
	 * @param creation_year
	 * Uses super to intialize attributes from Metro class
	 * intializes new Tram attributes
	 */
	public Tram(int numWheels, double maxSpeed, int numVehicles, String startStation, String destinationStation,
			int nbstops,int creation_year) {
		super(numWheels, maxSpeed, numVehicles, startStation, destinationStation, nbstops);
		this.creation_year=creation_year;
		
	}
	/**
	 * 
	 * @param t
	 * Copy constructor 
	 */
	public Tram(Tram t)
	{
		numWheels = t.numWheels;
		maxSpeed=t.maxSpeed;
		numVehicles=t.numVehicles;
		startStation=t.startStation;
		destinationStation=t.destinationStation;
		nbstops=t.nbstops;
		creation_year=t.creation_year;
	}

	/**
	 * 
	 * @return creation_year
	 * Method that returns integer creation_year
	 */
	public int getCreation_year() {
		return creation_year;
	}
	/**
	 * 
	 * @param creation_year
	 * Method that sets the creation_year
	 */
	public void setCreation_year(int creation_year) {
		this.creation_year = creation_year;
	}
	/**
	 * Overriden method of the toString method of the Metro class
	 * @return String
	 */
	@Override
	public String toString()
	{
		return "This metro has " + getNumWheels() + " wheels and a maximum speed of " + getMaxSpeed() + "km/h. It also has " + getNumVehicles() + " vehicles,"
				+ " its starting and destination stations are " + getStartStation() + " and " + getDestinationStation() + ", it has " + getNbstops() + " stops and its creation year is " +
				creation_year;
				
	}
	/**
	 * Overriden equals method of the Metro class
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
			Tram t = (Tram)x;
			return this.getNumWheels()==t.getNumWheels()&&this.getMaxSpeed()==t.getMaxSpeed()&&this.getNumVehicles()==t.getNumVehicles()
					&& this.getStartStation().equals(t.getStartStation()) && this.getDestinationStation().equals(t.getDestinationStation())&&this.getNbstops()==t.getNbstops()&&
					this.creation_year == t.creation_year;
		}
	}
}
