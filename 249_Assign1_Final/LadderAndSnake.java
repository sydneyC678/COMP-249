import java.awt.Color;
import java.util.Scanner;
public class LadderAndSnake {

    //--------------------------------------------
    //Assignment #1
    //Written by: Sydney Campbell (40243309)
    //____________________________________________

    //The program is made to create a Snakes and Ladders type game using Java.
    /* 
     * This LadderAndSnake class uses constructors to initialize the number of players (max 2),
     * the board array (displayer and position) as well as the ladders and snakes arrays (2D).
     * The ladders and snakes array are used to associate the input (start of each location) with the
     * output(end of location) and change the player's position accordingly.
     * Different methods are used to help run and facilitate the game:
     * 1. Dice Roll method (returning an integer from 1-6)
     * 2. whoStarts method (returns an integer (0 or 1) associated with each of the 2 players, in order to decide
     * who is the first to begin the game).
     * 3. isWinner method (returns a boolean indicating if a player has reached the exact position of the winning point (100))
     * 4.Position method (returns an integer position with respect to whether they a. land on the same square as the other player,
     * b. land on a snake c. land on a ladder d. doesn't land on anything).
     * 5. GameBoard method which sets up the physical "look" of the board as well as replaces each numbered square with the 
     * first two letters of the players name when they land on the square. For every player's turn they receive a new display of where
     * they are positioned.
     * 6. play method which brings all of the methods together. Is called in the driver method.
    */
    Scanner in = new Scanner(System.in);
    private int nbPlayers;
    private int[][] board;
    private int[][] ladders;
    private int[][] snakes;
    private final int ROWS=10;
    private final int COLS=10;
    private final int NUM_LADDERS=9;
    private final int NUM_SNAKES=8;
    private int winPosition = 100;
    private int playerTurn =0;
    private boolean winner = false;
   

    public LadderAndSnake()
    {

    }
    public LadderAndSnake(int np)
    {
        //when constructor is called to set number of players
        //we also set everything else at the same time
        
            if(np !=2)
                {
                    if(np<2)
                    {
                        System.out.println("\nError: Cannot execute the game with less than 2 playerd! Will exit");
                        System.exit(0);
                    }
                    System.out.println("\nInitialization was attempted for " + np +" number of players; however," 
                    + " this is only expected for an extended version of the game. Value will be set to 2.");
                   this.nbPlayers= np;
                   np=2;
                }
                else
                {
                    this.nbPlayers=np;
    
                }
    
                //Set the board rowsxcol
    
                board = new int[ROWS][COLS];
                for(int row = 0; row<ROWS;row++)
                {
                    for(int col =0; col<COLS;col++)
                    {
                        board[row][col]=row*ROWS + col + 1;
                    }
                }
    
                snakes = new int[NUM_SNAKES][2];
                snakes[0][0] = 16; //start of snake
                snakes[0][1] = 6; //tail of snake
                snakes[1][0] = 48;
                snakes[1][1] = 30;
                snakes[2][0] = 64;
                snakes[2][1] = 60;
                snakes[3][0] = 79;
                snakes[3][1] = 19;
                snakes[4][0] = 93;
                snakes[4][1] = 68;
                snakes[5][0] = 95;
                snakes[5][1] = 24;
                snakes[6][0] = 97;
                snakes[6][1] = 76;
                snakes[7][0] = 98;
                snakes[7][1] = 78;
                
                ladders = new int[NUM_LADDERS][2];
                ladders[0][0]= 1;
                ladders[0][1]=38;
                ladders[1][0]=4;
                ladders[1][1]=14;
                ladders[2][0]=9;
                ladders[2][1]=31;
                ladders[3][0]=28;
                ladders[3][1]= 84;
                ladders[4][0]=21;
                ladders[4][1]=42;
                ladders[5][0]=36;
                ladders[5][1]=44;
                ladders[6][0]=51;
                ladders[6][1]=67;
                ladders[7][0]=71;
                ladders[7][1]=91;
                ladders[8][0]=80;
                ladders[8][1]=100;
    
           
        }

        public void setPlayers(int nbPlayers)
        {
            this.nbPlayers=nbPlayers;
        }
        public int getPlayers()
        {
            return nbPlayers;
        }

        

        public void play()
        {
           Scanner in = new Scanner(System.in);
           System.out.print("\nEnter Player 1's Name: ");
           String p1 = in.next();
           System.out.print("\nEnter Player 2's Name: ");
           String p2 = in.next();

           Player player1 = new Player(p1);
           Player player2 = new Player(p2);

           System.out.println("\nPRESS ENTER TO PLAY THE GAME!");
            String yourTurn = in.nextLine();

         

           whoStarts(player1,player2);
          
      
          do{

            
            if(playerTurn%2==0)
            {
                System.out.println("\nPRESS ENTER TO PLAY YOUR TURN!");
                 yourTurn = in.nextLine();
                Position(player1);
                if(player1.getPosition()==player2.getPosition())
                {
                    System.out.println("\nOh no! " + player1.getName() + " landed on the same point as " + player2.getName() + 
                                        ". Changing " + player1.getName() + " to position 0.");
                    player1.setPosition(0);
                   
                }
               
                GameBoard(player1);
                
                
               
            }
            else{
               
                System.out.println("\nPRESS ENTER TO PLAY YOUR TURN!");
                yourTurn = in.nextLine();
                Position(player2);
                if(player2.getPosition()==player1.getPosition())
                {
                    System.out.println("\nOh no! " + player2.getName() + " landed on the same point as " + player1.getName() + 
                                        ". Changing " + player2.getName() + " to position 0.");
                    player2.setPosition(0);
                }
               
                System.out.println();
                
                GameBoard(player2);
            }
           
           playerTurn++;
        } while(!winner);
        
        
        }
        public int diceRoll()
        {
            return (int)(6.0*Math.random()+1);
        }

        public int whoStarts(Player p1,Player p2)
        {
            int player1 = diceRoll();
            int player2 = diceRoll();

            if(player1==player2)
            {
                System.out.println("\nBoth players rolled a number of " + player1 +". Rolling again to break the tie.");
                whoStarts(p1,p2);
            }
            else{
                if(player1>player2)
                {
                    System.out.println("\n" + p1.getName() + " rolled a " + player1 + " which is greater than " + p2.getName() + " who rolled a " + player2 + "!");
                    System.out.println(p1.getName() + " starts");
                    playerTurn =0;
                }
                   
                else
                {
                    System.out.println("\n" +p2.getName() + " rolled a " + player2 + " which is greater than " + p1.getName() + " who rolled a " + player1 + "!");
                    System.out.println(p2.getName() + " starts");
                    playerTurn=1;
                   
                }
                
            }
           
            return playerTurn;
            
        
           
        
    }

        public int Position(Player p)
        {
            int roll = diceRoll();
            int newPosition = p.getPosition() + roll;
            p.setPosition(newPosition);
            System.out.println(p.getName() + " rolled a " + roll);
            System.out.println(p);

            if(isWinner(p)){
                System.out.println(p.getName() + " has won the game");
                System.out.println("Thank you for playing!");
                System.exit(0);   
     
                   
            }
            
            else{

                
                if(newPosition>winPosition)
                {
                    int over = newPosition-100;
                    newPosition=100-over;
                    System.out.println("\nRolled over winning point: taking " + p.getName() + " back down to " + newPosition);
                }
              
                for(int i = 0; i<NUM_LADDERS;i++)
            {
                if(ladders[i][0]==newPosition)
                {
                    newPosition = ladders[i][1];
                    p.setPosition(newPosition);
                    
                    System.out.println("\nLanded on a ladder: taking " + p.getName() + " to " + ladders[i][1]);  
                }
            }
            //check to see if it is on a snake
            for(int i = 0; i<NUM_SNAKES;i++)
            {
                if(snakes[i][0]==newPosition)
                {
                    newPosition = snakes[i][1];
                    p.setPosition(newPosition);
                    
                    System.out.println("\nLanded on a snake: taking " + p.getName() + " to " + snakes[i][1]);
                }
            }
             
        
        }
        return newPosition;

    }
        

        public boolean isWinner(Player p)
        {
            if (p.getPosition() == winPosition)
            {
                return true;
                
            }
            else{
                return false;
            }
            
        }

        
        public void LeftToRight(int row, Player p)
        {
            for(int column=0;column<=9;column++)
            {
                if(p.getPosition()==board[row][column])
                {
                    System.out.print(p.getName().substring(0,2) + "     |");
                }
                else{
                    if (row == 0){
                        System.out.print(board[row][column] + "      |");
                    }
                    else {
                        System.out.print(board[row][column] + "     |");
                    }
                }
            }

        }
        public void RightToLeft(int row, Player p)
        {
            for(int column = 9; column>=0;column--)
            {
                if(p.getPosition()==board[row][column])
                {
                    System.out.print(p.getName().substring(0,2) +"     |" );
                }
                else {
                     System.out.print(board[row][column] + "     |");
                }
            }
        }
        
        public void GameBoard(Player p)
        {
            
            for(int i = 9;i>=0;i--)
            {
                if(i%2==0)
                {
                    LeftToRight(i,p);
                    System.out.println("\n" + "----------------------------------------------------------------------------------");
                }
                else{
                    RightToLeft(i,p);
                    System.out.println("\n" + "----------------------------------------------------------------------------------");
                }
                }
            }
        }
    

