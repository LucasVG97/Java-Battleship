package com.letscode.battleship;

import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static int boardLength = 10;
    public static char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    public static String[][] playerBoard = new String[boardLength][boardLength];
    public static String[][] CPUBoard = new String[boardLength][boardLength];

    public static String sub = "N";
    public static String shot = "*";
    public static String miss = "-";
    public static boolean isGameRunning = true;

    public static void playerPositions(){
        for(int i = 0 ; i < boardLength; i++){
            System.out.print("Insert x - coord: ");
            int xCoord = scanner.nextInt();
            System.out.print("Insert y - coord: ");
            int yCoord = scanner.nextInt();

            if(Objects.equals(playerBoard[xCoord][yCoord], sub)){
                do{
                    System.out.println("There is already a ship here. Please enter another coord");
                    System.out.print("Insert x - coord: ");
                    xCoord = scanner.nextInt();
                    System.out.print("Insert y - coord: ");
                    yCoord = scanner.nextInt();
                }while(Objects.equals(playerBoard[xCoord][yCoord], sub));

            }
            playerBoard[xCoord][yCoord] = sub;
        }

    }

    public static void playerBoard(String playerName){
        System.out.println("---------------------------------------------");
        System.out.println(playerName);
        System.out.println("---------------------------------------------");
        System.out.println("|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < boardLength; i++) {
            System.out.print("| " + letters[i] + " |");
            for (int j = 0; j < boardLength; j++) {
                String spaceJ = playerBoard[i][j] == null ? " " : playerBoard[i][j];
                System.out.print(" "+ spaceJ + " |");
            }
            System.out.println("\n---------------------------------------------");
        }
    }


    public static void CPUPositions(){
        for(int i = 0 ; i < boardLength; i++){
            int xPosition;
            int yPosition;
            do {
                xPosition = random.nextInt(10);
                yPosition = random.nextInt(10);
            }
            while (Objects.equals(CPUBoard[xPosition][yPosition], sub));
            CPUBoard[xPosition][yPosition] = sub;
        }
        CPUBoard();
    }



    public static void CPUBoard(){

        System.out.println("---------------------------------------------");
        System.out.println("CPU");
        System.out.println("---------------------------------------------");
        System.out.println("|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |");
        System.out.println("---------------------------------------------");


        for (int i = 0; i < boardLength; i++) {
            System.out.print("| " + letters[i] + " |");

            for (int j = 0; j < boardLength; j++) {
                String spaceJ = CPUBoard[i][j] == null ? " " : CPUBoard[i][j];
                System.out.print(" "+ spaceJ + " |");

            }

            System.out.println("\n---------------------------------------------");

        }
    }

    public static void askPlayerCoordinates() {
        String playerMessage;
        System.out.println("Select the coordinates");
        System.out.print("Row: ");
        int row = scanner.nextInt();
        System.out.print("Col: ");
        int col = scanner.nextInt();
        if(CPUBoard[row][col] == shot || CPUBoard[row][col] == miss ){
            do{
                System.out.println("You've already made this move, please select another space");
                System.out.print("Row: ");
                row = scanner.nextInt();
                System.out.print("Col: ");
                col = scanner.nextInt();
            }while(CPUBoard[row][col] == shot || CPUBoard[row][col] == miss);
        }
        if (CPUBoard[row][col] == sub){
            playerMessage = "Nice Shot!";
            CPUBoard[row][col] = shot;
        }
        else{
            playerMessage = "You missed!";
            CPUBoard[row][col] = miss;
        }
        System.out.println(playerMessage);
    }

    public static void CPUCoordinates(){
        String message;
        int rowPosition;
        int colPosition;
        do{
            rowPosition = random.nextInt(10);
            colPosition = random.nextInt(10);
        } while(playerBoard[rowPosition][colPosition] == shot || playerBoard[rowPosition][colPosition] == miss);

        if (playerBoard[rowPosition][colPosition] == sub){
            message = "CPU nice Shot!";
            playerBoard[rowPosition][colPosition] = shot;
        }
        else{
            message = "CPU missed!";
            playerBoard[rowPosition][colPosition] = miss;
        }
        System.out.println(message);
    }

    public static void setIsGameOver(){
        String playerSub = "";
        String CPUSub = "";
        isGameRunning = false;
        for(int i = 0; i < boardLength; i++){
            for(int j = 0; j < boardLength; j++){
                if(playerBoard[i][j] == sub){
                    playerSub = "true";
                }
                if(CPUBoard[i][j] == sub){
                    CPUSub = "true";
                }
            }
        }
        if (playerSub.contains("true") && CPUSub.contains("true")){
            isGameRunning = true;
        }
    }

    public static void setWinner(String playerName){
        boolean playerWins = true;
        for(int i = 0; i < boardLength; i++){
            for(int j = 0; j < boardLength; j++){
                if(CPUBoard[i][j] == sub){
                    playerWins = false;
                }
            }
        }
        if(playerWins == true){
            System.out.println(playerName + " wins!!!");
        }
        else{
            System.out.println("CPU wins!!!");
        }
        CPUBoard();
        playerBoard(playerName);
    }

    public static void main (String[] args){
        System.out.println("Welcome to the battleship");
        System.out.print("Insert your first name: ");
        String playerName = scanner.next();
        System.out.println("Select your submarine positions");
        playerPositions();
        playerBoard(playerName);
        CPUPositions();
        do{
            askPlayerCoordinates();
            CPUCoordinates();
            playerBoard(playerName);
            CPUBoard();
            setIsGameOver();
        }while (isGameRunning == true);
        setWinner(playerName);
    }
}
