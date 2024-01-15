package main;
/*
Creates the board used for tiktaktoe game. Lets you print the board, check whether there is an open space at specific coordinates,
checks whether a player has won the game, checks whether there is a draw, Finds winning game move for diagonal/horizontal/vertical win
 */
public class Board {

    private String[][] board;

    public Board(int size) {
        this.board = new String[size][size];
    }

    public String[][] getBoard() {
        return board;
    }

    // Adds a player's X or O to the board
    public void setBoard(int i, int j, String status) {
        this.board[i][j] = status;
    }

    //Prints board
    public void printBoard(){
        for(int i = 0; i < 3; i +=1){
            for(int j = 0; j < 3; j +=1){
                if (!positionStatus(i,j)){
                    System.out.print(" ");
                    if (j <2){
                        System.out.print(" | ");
                    }
                    continue;

                }
                System.out.print(this.board[i][j]);

                if (j <2){
                    System.out.print(" | ");
                }

            }
            System.out.println();
            System.out.println("_________");

        }
    }

    // Returns True if there is an X or O on the index
    public Boolean positionStatus(int i, int j){
        if (this.board[i][j] == null){
            return false; // No players have used this position
        }
        return true; // There is a player who chose this position
    }

    //Checks whether the game over == "Won"
    public Boolean checkBoard(){
        // Checks for a diagonal win
        if(this.board[0][0] == this.board[1][1] && this.board[0][0] == this.board[2][2] && this.board[2][2] != null && this.board[1][1] != null && this.board[0][0] != null){
            return true;
        }
        for ( int i = 0; i<3;i+=1){
            // Checks for a horizontal win
            if(this.board[i][0] == this.board[i][1] && this.board[i][0] == this.board[i][2] && this.board[i][2] != null && this.board[i][1] != null && this.board[i][0] != null){
                return true;
            }
            // Checks for a vertical win
            if(this.board[0][i] == this.board[1][i] && this.board[0][i] == this.board[2][i] && this.board[2][i] != null && this.board[1][i] != null && this.board[0][i] != null){
                return true;
            }
        }
        // no winner yet
        return false;
    }

    // Checks whether no one can win the game
    public Boolean isDraw(){
        if (checkBoard()){ //no draw, continue game
            return false;
        }
        for ( int i = 0; i < board.length; i+=1){
            for ( int j = 0; j < board.length; j+=1){
                if (board[i][j] == null){
                    return false;
                }
            }
        }
        return true;
    }

    // Finds winning game move via diagonal win. Gives whether to look for "X" or "O" on board.
    public Integer[] findWinningPositionDiagonal(String status) {
        // Check diagonal for len - 1
        int count = 0;
        Integer[] position = new Integer[2];

        for (int i = 0; i < this.board.length; i += 1) { //searches board for a diagonal win
            if (this.board[i][i] == status) {
                count += 1;
            } else {
                position[0] = i;
                position[1] = i;
            }
        }
        if (count == this.board.length - 1) { // there is a winning move
            return position;
        }
        position[0] = -1;
        position[1] = -1;
        return position; // no winning move
    }
    // Finds winning game move via horizontal win. Gives whether to look for "X" or "O" on board.
    public Integer[] findWinningPositionHorizontal(String status) {
        int count = 0;
        Integer[] position = new Integer[2];
        // check horizontal
        for (int i = 0; i < this.board.length; i += 1) { // Looks for a horizontal winning move
            count = 0;
            for (int j = 0; j < this.board.length; j += 1) {
                if (this.board[i][j] == status) {
                    count += 1;
                } else {
                    position[0] = i;
                    position[1] = j;
                }
            }
            if (count == this.board.length - 1) {//there is a winning move
                return position;
            }
        }
        position[0] = -1;
        position[1] = -1;
        return position; // no winning move
    }

    // Finds winning game move via vertical win. Gives whether to look for "X" or "O" on board.
    public Integer[] findWinningPositionVertical(String status){
        int count = 0;
        Integer[] position = new Integer[2];
        //check vertical
        for (int i = 0; i < this.board.length; i+=1){// Looks for a vertical winning move
            count = 0;
            for (int j = 0; j < this.board.length; j+=1){
                if (this.board[j][i] == status){
                    count+=1;
                }
                else{
                    position[0] = j;
                    position[1] = i;
                }
            }
            if (count == this.board.length-1){ //there is a winning move
                return position;
            }
        }
        position[0] = -1;
        position[1] = -1;
        return position; // no winning move
    }
}
