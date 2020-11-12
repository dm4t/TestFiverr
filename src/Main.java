import java.io.InputStreamReader;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

public static void main(String args[])throws IOException{

    Board Connect4 = new Board();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Welcome to Connect 4");
    System.out.println("There are 2 players red and yellow");
    System.out.println("Player 1 is Red, Player 2 is Yellow");
    System.out.println("To play the game type in the number of the boardColumn you want to drop you counter in");
    System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
    System.out.println("");
    Connect4.printBoard();
    outer:

        while(true){

            int boardColumn = 0;

            //Player One Logic ----------------------------------------------------------------
            while(true){
                System.out.println("");
                System.out.println("Player 1, please select your column:");
                boardColumn = Integer.parseInt(br.readLine());
                if(Connect4.canMakeMove(boardColumn)){
                    if(Connect4.placeCounter(boardColumn, 1)){
                        Connect4.printBoard();
                        System.out.println("");
                        System.out.println("Congratulations! Player 1 has won the game");
                        break outer;
                    }
                    break;
                }
                else
                    System.out.println("Column "+boardColumn+" is already full!!");
            }
            Connect4.printBoard();

            //Player Two Logic ---------------------------------------------------------------   
            while(true){
                System.out.println("");
                System.out.println("The Computer has selected a column and played a counter");
                System.out.println("");

                Random r = new Random();
                int num = r.nextInt(7);

                boardColumn = num;

                if(Connect4.canMakeMove(boardColumn)){
                    if(Connect4.placeCounter(boardColumn, 2)){
                        Connect4.printBoard();
                        System.out.println("");
                        System.out.println("Unlucky! The Computer has won this game");
                        break outer;
                    }
                    break;
                }
                else
                    System.out.println("Column "+boardColumn+" is already full!!");
            }
            Connect4.printBoard();

            if(Connect4.gameDrawn()){
                System.out.print("The game has ended in a draw. Please start the game again.");
                break;
            }
        }
}