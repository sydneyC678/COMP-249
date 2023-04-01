/**
 * 
 * @author Sydney Campbell (40243309)
 * 
 * Assignment #1 
 * COMP-249 Section QQ
 * February 6th, 2023
 * 
 * The Player class contains all the information of each player as they move along in the game
 * Instead of creating different attributes or methods in the main LadderAndSnake class, 
 * We create two player objects in the play method so that every time they get a new position,
 * we can set it using the setPosition() method.
 */
public class Player {

	 
 
	    private String name;
	    private int position;
	    
	    /**
		    * Default constructor 
		    */
	   public Player()
	    {
	        name = "";
	        position = 0;
	    }
	   /**
	    * Constructor that takes String name 
	    * @param name taking in a String name
	    */
	    public Player(String name)
	    {
	        this.name = name;
	        this.position = 0;
	    }
	    /**
	     * @return name  Allows retrieval of name of player
	     */
	    public String getName()
	    {
	        return name;
	    }
	    /**
	     * Method ables player object to be set a name
	     */
	    public void setName()
	    {
	        this.name = name;
	    }
	    /**
	     * Method returns the position the player is at
	     * @return position
	     */
	    public int getPosition()
	    {
	        return position;
	    }
	    /**
	     * @param pos taking in a position
	     * Method that allows position to be set to a value
	     */
	    public void setPosition(int pos)
	    {
	        this.position=pos;
	    }
	    /**
	     * Method that returns the name and position the player is located.
	     */
	    public String toString()
	    {
	        return "\n" +name + " is at square " + position;
	    }
}
