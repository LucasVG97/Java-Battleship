package com.letscode.battleship.utils;

public class Printer {

    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_MAGENTA = "\033[0;35m";

    public static void startGame() {
        System.out.println(ANSI_PURPLE + "Welcome to the battleship" + ANSI_RESET);
    }

    public static void askPlayerFirstName(){
        System.out.print("Enter your first name: ");
    }

    public static void enterLetter() {
        System.out.print("Enter the letter (A-J): ");
    }

    public static void enterNumber(){
        System.out.print("Enter the number (0-9): ");
    }

    public static void lines() {
        System.out.println("---------------------------------------------");
    }

    public static void numbers(){
        System.out.println(ANSI_RED + "|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |" + ANSI_RESET);
    }

    public static void validLetter(){
        System.out.println(ANSI_RED + "Please, enter a valid letter (A-J)" + ANSI_RESET);
        System.out.print("Enter the letter: ");
    }

    public static void validNumber(){
        System.out.println(ANSI_RED + "Please, enter a valid number (0-9)" + ANSI_RESET);
        System.out.print("Enter the number: ");
    }

    public static void alreadyShipHere(){
        System.out.println(ANSI_RED + "There is already a ship here. Please enter another coord" + ANSI_RESET);
    }

    public static void invalidMove(){
        System.out.println(ANSI_RED + "You've already made this move, please select another space" + ANSI_RESET);
    }

    public static void coordinates(){
        System.out.println("Select the coordinates");
    }

}
