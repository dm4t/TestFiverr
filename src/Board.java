public class Board extends Counter {

static int totalPlayed;
static int[][] gameBoard;
static int widthOfBoard=7;
static int heightOfBoard=7;

public static int [][] getBoard() {
    return gameBoard;
}

public static int getWidth() {
    return widthOfBoard;
}

public static int getHeight() {
    return heightOfBoard;
}

public static int getTotal() {
    return totalPlayed;
}

public Board(){
    gameBoard = new int[heightOfBoard][widthOfBoard];
    totalPlayed=0;
}

public void printBoard(){
    for(int i=0;i<gameBoard.length;i++){
        for(int j=0;j<gameBoard[0].length;j++){
            if(gameBoard[i][j] == 0)
                System.out.print(".  ");
            else
                System.out.print(gameBoard[i][j]+"  ");
        }
        System.out.println("");
    }
    System.out.println("--------------------");
    System.out.println("0  1  2  3  4  5  6");
}


}