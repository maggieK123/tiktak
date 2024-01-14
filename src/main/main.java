package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void  main(String [] args){
        // Initializes player before the game starts
        String name;
        String status;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Name");
        name = myObj.nextLine();  // Read user input
        do{
            System.out.println("Choose X or O");
            status = myObj.nextLine();  // Read user input
        } while(status.compareTo("O") != 0 && status.compareTo("X")!=0);

        System.out.println("Username is: " + name);  // Output user input
        System.out.println("Player is : " + status);  // Output user input

        player player1 = new player(name,0,0,status); //Creates player object for user
        player computer = new player("Computer",0,0,"O"); //Creates player object for opponent

        if (player1.getStatus() == "O"){
            computer.setStatus("X");
        }


        tiktaktoe game = new tiktaktoe(player1,computer); // Creates tiktaktoe object
        Boolean turn = true; // player goes first
        while (!game.checkBoard()){ // while no one has won the game
            if (turn){ //Player's Turn
                turn = false;
                game.printBoard();
                System.out.println("Pick a position");
                //pick position
                int i=0;
                int j = 0;
                try {
                    i = myObj.nextInt(); // Read user input
                    j = myObj.nextInt();
                }
                catch (Exception e){
                    System.out.println(e);
                }
                game.setBoard(i, j, player1.getStatus());
                if (game.checkBoard()){
                    player1.setWins();
                    System.out.println("You win! Player 1");
                }
            }
            else{ //Computer's turn
                turn = true;
                game.printBoard();
                System.out.println("Pick a position");
                //pick position
                int i=0;
                int j = 0;
                try {
                    i = myObj.nextInt(); // Read user input
                    j = myObj.nextInt();
                }
                catch (Exception e){
                    System.out.println(e);
                }
                game.setBoard(i, j, computer.getStatus());
                if (game.checkBoard()){
                    computer.setWins();
                    System.out.println("You win! computer");
                }
            }

        }


    }
}
