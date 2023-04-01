


public class Player{

    /*
 * The Player class contains all the information of each player as they move along in the game
 * Instead of creating different attributes or methods in the main LadderAndSnake class, 
 * We create two player objects in the play method so that everytime they get a new position,
 * we can set it using the setPosition() method.
 */

//holds all the info of each player
//their name and what position they are at 
    private String name;
    private int position;
    
    
   public Player()
    {
        name = "";
        position = 0;
    }
    public Player(String name)
    {
        this.name = name;
        this.position = 0;
    }

    public String getName()
    {
        return name;
    }
    public void setName()
    {
        this.name = name;
    }
    public int getPosition()
    {
        return position;
    }
    public void setPosition(int pos)
    {
        this.position=pos;
    }
    public String toString()
    {
        return "\n" +name + " is at square " + position;
    }
    


}