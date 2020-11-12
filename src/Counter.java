public abstract class Counter {


int widthOfBoard = Board.getWidth();
int [][] gameBoard = Board.getBoard();
int heightOfBoard = Board.getHeight();
int totalPlayed = Board.getTotal();

public boolean placeCounter(int boardColumn, int playerNum){
    int i=0;
    for(i=0;i<widthOfBoard;i++){
        if(gameBoard[i][boardColumn] == 1 || gameBoard[i][boardColumn] == 2){
            gameBoard[i-1][boardColumn]=playerNum;
            break;
        }
    }
    if(i == widthOfBoard)
        gameBoard[i-1][boardColumn]=playerNum;

    totalPlayed++;
    return isConnected(i-1,boardColumn);
}

public boolean canMakeMove(int boardColumn){
    return gameBoard[0][boardColumn] == 0; 
}

public boolean gameDrawn(){
    return totalPlayed == widthOfBoard * heightOfBoard;
}

public boolean isHorizontal(int x, int y) {
    int count = 0;
    int i=y;
    int num=gameBoard[x][y];

    //HORIZONTAL.
    while(i<widthOfBoard && gameBoard[x][i] == num){
        count++;
        i++;
    }
    i=y-1;
    while(i>=0 && gameBoard[x][i] == num){
        count++;
        i--;
    }
    if(count == 4)
        return true;
    return false;
}

public boolean isVertical(int x, int y) {
    //VERTICAL.
    int count=0;
    int j=x;
    int num=gameBoard[x][y];

    while(j<widthOfBoard && gameBoard[j][y] == num){
        count++;
        j++;
    }
    if(count == 4)
        return true;
    return false;
}

public boolean isRightDiagonal(int x, int y) {
    //SECONDARY DIAGONAL.
    int count=0;
    int i=x;
    int j=y;
    int num=gameBoard[x][y];

    while(i<widthOfBoard && j<widthOfBoard && gameBoard[i][j] == num){
        count++;
        i++;
        j++;
    }

    if(count == 4)
        return true;
    return false;
}

public boolean isLeftDiagonal(int x, int y) {
    //LEADING DIAGONAL.
    int count=0;
    int i = x;
    int j=y;
    int num=gameBoard[x][y];

    while(i<widthOfBoard && j>=0 && gameBoard[i][j] == num){
        count++;
        i++;
        j--;
    }

    if(count == 4)
        return true;
    return false;
}

public boolean isConnected(int x, int y){

    isHorizontal(x, y);

    isVertical(x, y);

    isRightDiagonal(x, y);

    isLeftDiagonal(x, y);

    return false;

}
}