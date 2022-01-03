package com.letscode.battleship;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

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

    public static void playerPositions(){

        for(int i = 0 ; i < boardLength; i++){
            System.out.print("Insert x - coord: ");
            int xCoord = scanner.nextInt();
            System.out.print("Insert y - coord: ");
            int yCoord = scanner.nextInt();
            if(Objects.equals(playerBoard[xCoord][yCoord], sub)){
                System.out.println("There is already a ship here. Please enter another coord");
                System.out.print("Insert x - coord: ");
                xCoord = scanner.nextInt();
                System.out.print("Insert y - coord: ");
                yCoord = scanner.nextInt();
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

    public static void askPlayerCoordinates(){
        String message;
        System.out.print("Row: ");
        int row = scanner.nextInt();
        System.out.print("Col: ");
        int col = scanner.nextInt();
        if(CPUBoard[row][col] == sub){
            message = "Shot!";
            CPUBoard[row][col] = shot;
        }
        else if (CPUBoard[row][col] == null){
            message = "Miss!";
            CPUBoard[row][col] = miss;
        }
        else {
            message = "ERROR";
        }
        System.out.println(message);
    }


    public static void CPUPositions(){
        for(int i = 0 ; i < boardLength; i++){
            int xPosition = random.nextInt(9);
            int yPosition = random.nextInt(9);
            if(Objects.equals(CPUBoard[xPosition][yPosition], sub)){
                xPosition = random.nextInt(9);
                yPosition = random.nextInt(9);
            }
            CPUBoard[xPosition][yPosition] = sub;
        }
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

    public static void CPUCoordinates(){
        String message = null;
        int rowPosition = random.nextInt(9);
        int colPosition = random.nextInt(9);
        if(playerBoard[rowPosition][colPosition] == sub){
            message = "Shot!";
            playerBoard[rowPosition][colPosition] = shot;
        }
        else if (playerBoard[rowPosition][colPosition] == null){
            message = "Miss!";
            playerBoard[rowPosition][colPosition] = miss;
        }
        System.out.println(message);
    }

    public static void main (String[] args){
        System.out.println("Welcome to the battleship");
        System.out.print("Insert your first name: ");
        String playerName = scanner.next();
        System.out.println("Select your submarine positions");
        playerPositions();
        playerBoard(playerName);
        CPUPositions();

        while(true) {
            askPlayerCoordinates();
            CPUCoordinates();
            playerBoard(playerName);
//            CPUBoard();
        }


    }
}
