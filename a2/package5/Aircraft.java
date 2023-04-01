package package5;
/**
 * 
 * @author sydneycampbell
 * Class Aircraft
 *
 */
public class Aircraft {

	protected double price;
	protected double maxElevation;
	/**
	 * Default constructor
	 */
	public Aircraft()
	{
		price = 0.0;
		maxElevation = 0.0;
	}
	/**
	 * 
	 * @param price
	 * @param maxElevation
	 * Paramterized constructor 
	 */
	public Aircraft(double price, double maxElevation)
	{
		this.price=price;
		this.maxElevation=maxElevation;
	}
	/**
	 * 
	 * @param a
	 * Copy constructor of Aircraft object
	 */
	public Aircraft(Aircraft a)
	{
		this.price=a.price;
		this.maxElevation=a.maxElevation;
	}
	/**
	 * 
	 * @return price
	 * Method that return double value of price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * 
	 * @param price
	 * Method that sets double value of price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * 
	 * @return maxElevation
	 * Method that returns double value of maxElevation
	 */
	public double getMaxElevation() {
		return maxElevation;
	}
	/**
	 * 
	 * @param maxElevation
	 * Method that sets maxElevation
	 */
	public void setMaxElevation(double maxElevation) {
		this.maxElevation = maxElevation;
	}
	/**
	 * @return String
	 * toString method that return a string of the content of the object
	 */
	public String toString()
	{
		return "This aircraft costs $"+ price + " and the maximum elevation the airplane can reach is " + maxElevation + "km.";
	}
	/**
	 * @return boolean
	 * Method that returns a boolean when the contents of two Aircraft objects are equal
	 */
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
			Aircraft a = (Aircraft)x;
			return this.price==a.price && this.maxElevation==a.maxElevation;
		}
	}
}
