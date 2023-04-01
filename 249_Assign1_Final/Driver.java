import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
        
        System.out.println("Welcome to Sydney's Snakes and Ladders Game!");
        System.out.print("\nEnter the number of players: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        LadderAndSnake game = new LadderAndSnake(n);
        game.play();
    }
}
