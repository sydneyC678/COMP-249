import java.util.Scanner;
/**
 * 
 * The Driver class allows the program to implement the other classes when called
 * @author Sydney Campbell (40243309)
 * Assignment #1 
 * COMP-249 Section QQ
 * February 6th, 2023
 * 
 *
 */
public class Driver {

	/**
	 * 
	 * @param args
	 * Method that prints messages, asks for user input, and called the other method from the LadderAndSnake class
	 */
	public static void main(String[] args) {
	
		 System.out.println("Welcome to Sydney's Snakes and Ladders Game!");
	        System.out.print("\nEnter the number of players: ");
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();

	        LadderAndSnake game = new LadderAndSnake(n);
	        game.play();
	}
	

}
