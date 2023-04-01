package package5;
/**
 * 
 * @author sydneycampbell
 * Class WorldWarIIAirplane extends Aircraft
 */
public class WorldWarIIAirplane extends Aircraft{

	private boolean twinEngine;
	
	/**
	 * Default constructor
	 */
	public WorldWarIIAirplane()
	{
		twinEngine=false;
	}
	/**
	 * 
	 * @param price
	 * @param maxElevation
	 * @param twinEngine
	 * Parameterized constructor that uses super to initialize Aircraft attributes
	 * Initializes WorldWarIIAirplane attribute
	 */
	public WorldWarIIAirplane(double price, double maxElevation, boolean twinEngine) {
		super(price, maxElevation);
		this.twinEngine=twinEngine;
	}
	/**
	 * 
	 * @param a
	 * Copy constructor 
	 */
	public WorldWarIIAirplane(WorldWarIIAirplane a) {
		setPrice(a.price);
		setMaxElevation(a.maxElevation);
		this.twinEngine=a.twinEngine;
		
	}
	/**
	 * 
	 * @return twinEngine
	 * Method returns boolean value of the twinEngine
	 */
	public boolean isTwinEngine() {
		return twinEngine;
	}
/**
 * 
 * @param twinEngine
 * Method that sets the boolean value of the twinEngine
 */
	public void setTwinEngine(boolean twinEngine) {
		this.twinEngine = twinEngine;
	}
	
	/**
	 * Overriden method of the Aircraft class 
	 * Uses if statement to decide what statement is output
	 * @param String
	 */
	@Override
	public String toString()
	{
		if(twinEngine == true)
		{
			return "This World War II Airplane has a price of $" + getPrice() + ", is capable of reaching a maximum elevation of " + getMaxElevation() + "km and has a twin engine.";
		}
		else
		{
			return "This World War II Airplane has a price of " + getPrice() + ", is capable of reaching a maximum elevation of " + getMaxElevation() + "km and does not have a twin engine.";
		}
		
	}
	
	/**
	 * Overriden method of Aircraft
	 * Returns true if two objects have equals content
	 * @param Object x
	 * @return boolean
	 */
	@Override
	public boolean equals(Object x)
	{
		if(x==null)
		{
			return false;
		}
		else if(getClass()!=x.getClass())
		{
			return false;
		}
		else
		{
			WorldWarIIAirplane a = (WorldWarIIAirplane)x;
			return this.getPrice()==a.getPrice()&&this.getMaxElevation()==a.getMaxElevation()&&this.twinEngine==a.twinEngine;
		}
	}
}
