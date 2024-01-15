package main;

import java.util.Random;
import java.util.Scanner;

public class tiktaktoe {

    private player person;
    private player computer;
    private Board board;

    //initializes the new this.board
    public tiktaktoe(player person, player computer, int size) {
        this.person = person;
        this.computer = computer;
        this.board = new Board(size);
    }

    //makes smart move for computer
    private Integer[] computerMove(){
        //find win for computer/ offense
        Integer[] position = this.board.findWinningPositionDiagonal(this.computer.getStatus());
        if (position[0]>-1 && !this.board.positionStatus(position[0],position[1])){
            return position;
        }
        position = this.board.findWinningPositionHorizontal(this.computer.getStatus());
        if (position[0]>-1 && !this.board.positionStatus(position[0],position[1])){
            return position;
        }
        position = this.board.findWinningPositionVertical(this.computer.getStatus());
        if (position[0]>-1 && !this.board.positionStatus(position[0],position[1])){
            return position;
        }
        //Plays defense, if cannot find winning move
        position = this.board.findWinningPositionDiagonal(this.person.getStatus());
        if (position[0]>-1 && !this.board.positionStatus(position[0],position[1])){
            return position;
        }
        position = this.board.findWinningPositionHorizontal(this.person.getStatus());
        if (position[0]>-1 && !this.board.positionStatus(position[0],position[1])){
            return position;
        }
        position = this.board.findWinningPositionVertical(this.person.getStatus());
        if (position[0]>-1 && !this.board.positionStatus(position[0],position[1])){
            return position;
        }
        //cannot play either, so picks random spot
        Random rand = new Random();

        int i = rand.nextInt(3);
        int j = rand.nextInt(3);
        while (this.board.positionStatus(i, j)) {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
        }
        position[0] = i;
        position[1] = j;
        return position;
    }
    
    public Boolean playGame(){
        Scanner myObj = new Scanner(System.in);
        Random rand = new Random();
        Boolean turn = true;
        int i = 0;
        int j = 0;
        while (!this.board.checkBoard()) { // while no one has won the this.board
            if (turn) { //Player's Turn
                turn = false;
                this.board.printBoard();
                do {
                    System.out.println("Pick a position");
                    try {
                        i = myObj.nextInt(); // Read user input
                        j = myObj.nextInt();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } while (this.board.positionStatus(i, j));

                this.board.setBoard(i, j, this.person.getStatus());
                if (this.board.checkBoard()) {
                    this.person.setWins();
                    System.out.println("You win! "+ person.getName());
                }
            } else { //Computer's turn
                turn = true;
                Integer[] position = computerMove();
                i = position[0];
                j = position[1];
                System.out.println(i);
                System.out.println(j);
                this.board.setBoard(i, j, computer.getStatus());
                if (this.board.checkBoard()) {
                    computer.setWins();
                    System.out.println("You Loss! Player 1");
                }
            }
            if (this.board.isDraw()){
                System.out.println("It is a Draw");
            }
        }

            return true;
    }

}

    