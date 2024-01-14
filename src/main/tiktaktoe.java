package main;

public class tiktaktoe {

    private player person;
    private player computer;
    private String[][] board;

    //initializes the new game
    public tiktaktoe(player person, player computer) {
        this.person = person;
        this.computer = computer;
        this.board = new String[3][3];
    }

    public String[][] getBoard() {
        return board;
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

    // Adds a player's X or O to the board
    public void setBoard(int i, int j, String status) {
        this.board[i][j] = status;
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
            if(this.board[0][1] == this.board[1][i] && this.board[0][i] == this.board[2][i] && this.board[2][i] != null && this.board[1][i] != null && this.board[0][i] != null){
                return true;
            }
        }
        // no winner yet
        return false;
    }
}
