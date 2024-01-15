package main;

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

    public Integer[] findWinningPositionDiagonal(String status) {
        // Check diagonal for len - 1
        int count = 0;
        Integer[] position = new Integer[2];

        for (int i = 0; i < this.board.length; i += 1) {
            if (this.board[i][i] == status) {
                count += 1;
            } else {
                position[0] = i;
                position[1] = i;
            }
        }
        if (count == this.board.length - 1) {
            return position;
        }
        position[0] = -1;
        position[1] = -1;
        return position;
    }

    public Integer[] findWinningPositionHorizontal(String status) {
        int count = 0;
        Integer[] position = new Integer[2];
        // check horizontal
        for (int i = 0; i < this.board.length; i += 1) {
            count = 0;
            for (int j = 0; j < this.board.length; j += 1) {
                if (this.board[i][j] == status) {
                    count += 1;
                } else {
                    position[0] = i;
                    position[1] = j;
                }
            }
            if (count == this.board.length - 1) {
                return position;
            }
        }
        position[0] = -1;
        position[1] = -1;
        return position;
    }

    public Integer[] findWinningPositionVertical(String status){
        int count = 0;
        Integer[] position = new Integer[2];
        //check vertical
        for (int i = 0; i < this.board.length; i+=1){
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
            if (count == this.board.length-1){
                return position;
            }
        }
        position[0] = -1;
        position[1] = -1;
        return position;
    }
}
