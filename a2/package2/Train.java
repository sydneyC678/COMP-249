package package2;
import package1.WheeledTransportation;
/**
 * 
 * @author sydneycampbell
 * class Train that is derived from the class WheeledTransportation
 *
 */
public class Train extends WheeledTransportation{

	protected int numVehicles;
	protected String startStation;
	protected String destinationStation;
	
	/**
	 * Default constructor that sets numVehicles to 0 and the two other atttributes to empty strings
	 */
	public Train()
	{
		numVehicles=0;
		startStation="";
		destinationStation="";
	}
	/**
	 * 
	 * @param numWheels
	 * @param maxSpeed
	 * @param numVehicles
	 * @param startStation
	 * @param destinationStation
	 * Paramteterized constructor that uses super to initialize the attributes from the base class
	 */
	public Train(int numWheels, double maxSpeed,int numVehicles, String startStation, String destinationStation) {
		super(numWheels,maxSpeed);
		this.numVehicles = numVehicles;
		this.startStation = startStation;
		this.destinationStation = destinationStation;
	}
	/**
	 * 
	 * @param t
	 * Copy constructor using Train object
	 */
	public Train(Train t)
	{
		
		setNumWheels(t.numWheels);
		setMaxSpeed(t.maxSpeed);
		this.numVehicles = numVehicles;
		this.startStation = startStation;
		this.destinationStation = destinationStation;
	}
	/**
	 * 
	 * @return numVehicles
	 * Method that returns the number of vehicles
	 */
	public int getNumVehicles() {
		return numVehicles;
	}
	/**
	 * 
	 * @param numVehicles
	 * Method that sets the number of vehicles
	 */
	public void setNumVehicles(int numVehicles) {
		this.numVehicles = numVehicles;
	}
	/**
	 * 
	 * @return startStation
	 * Method that returns a string of the start station
	 */
	public String getStartStation() {
		return startStation;
	}
	/**
	 * 
	 * @param startStation
	 * Method that sets the start Station
	 */
	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}
	/**
	 * 
	 * @return destinationStation
	 * Method that return string destination station
	 */
	public String getDestinationStation() {
		return destinationStation;
	}
	/**
	 * 
	 * @param destinationStation
	 * Method that sets the string of the destination station
	 */
	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}
	/**
	 * Overriden method of the toString from WheeledTransportation
	 * @return String
	 */
	@Override
	public String toString()
	{
		return "This train has " + getNumWheels() + " wheels and a maximum speed of " + getMaxSpeed() + "km/h. It also has " + numVehicles + " vehicles and"
				+ " its starting and destination stations are " + startStation + " and " + destinationStation + ".";
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
			Train t = (Train)x;
			return this.getNumWheels()==t.getNumWheels()&&this.getMaxSpeed()==t.getMaxSpeed()&&this.numVehicles==t.numVehicles
					&& this.startStation.equals(t.startStation) && this.destinationStation.equals(t.destinationStation);
		}
	}
	
	
}
