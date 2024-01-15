package main;

import java.util.InputMismatchException;
import java.util.Random;
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

        if (player1.getStatus().compareTo("O") == 0){
            computer.setStatus("X");
        }

        tiktaktoe game = new tiktaktoe(player1,computer,3); // Creates tiktaktoe object
        game.playGame();
    }
}
