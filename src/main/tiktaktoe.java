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
    
    public Boolean playGame(){
        Scanner myObj = new Scanner(System.in);
        Random rand = new Random();
        Boolean turn = false;
        while (!this.board.checkBoard()) { // while no one has won the this.board
            if (turn) { //Player's Turn
                turn = false;
                this.board.printBoard();
                //pick position
                int i = 0;
                int j = 0;
                while (this.board.positionStatus(i, j)) {
                    System.out.println("Pick a position");
                    try {
                        i = myObj.nextInt(); // Read user input
                        j = myObj.nextInt();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                this.board.setBoard(i, j, this.person.getStatus());
                if (this.board.checkBoard()) {
                    this.person.setWins();
                    System.out.println("You win! Player 1");
                }
            } else { //Computer's turn
                turn = true;
                int i = rand.nextInt(3);
                int j = rand.nextInt(3);
                while (this.board.positionStatus(i, j)) {
                    i = rand.nextInt(3);
                    j = rand.nextInt(3);
                }
                this.board.setBoard(i, j, computer.getStatus());
                if (this.board.checkBoard()) {
                    computer.setWins();
                    System.out.println("You Loss! Player 1");
                }
            }
        }

            return true;
    }

}

    