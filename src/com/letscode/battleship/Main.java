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

    public static void playerPositions(){
        System.out.println("Welcome to the battleship");
        System.out.println("Select your submarine positions");

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
        playerBoard();

    }

    public static void playerBoard(){
        System.out.println("---------------------------------------------");
        System.out.println("Player");
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

    public static void main (String[] args){
        playerPositions();
        CPUPositions();


    }
}
