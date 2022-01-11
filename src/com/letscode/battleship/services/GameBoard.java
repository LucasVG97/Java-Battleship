package com.letscode.battleship.services;

import com.letscode.battleship.utils.Printer;

import static com.letscode.battleship.utils.Printer.ANSI_RED;
import static com.letscode.battleship.utils.Printer.ANSI_PURPLE;
import static com.letscode.battleship.utils.Printer.ANSI_MAGENTA;

public class GameBoard {
    static final int BOARDLENGTH = 10;

    public static final String ANSI_RESET = "\u001B[0m";
    static final char[] LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    static final String[][] PLAYERBOARD = new String[BOARDLENGTH][BOARDLENGTH];
    public static String[][] CPUBoard = new String[BOARDLENGTH][BOARDLENGTH];

    public static void playerBoard(String playerName){
        Printer.lines();
        System.out.println(ANSI_PURPLE + playerName + ANSI_RESET);
        lines(PLAYERBOARD);
    }

    public static void CPUBoard(){
        Printer.lines();
        System.out.println(ANSI_MAGENTA + "CPU" + ANSI_RESET);
        lines(CPUBoard);
    }

    private static void lines(String[][] board) {
        Printer.lines();
        Printer.numbers();
        Printer.lines();


        for (int i = 0; i < BOARDLENGTH; i++) {
            System.out.print(ANSI_RED +"| " +  LETTERS[i]  + " |"+ ANSI_RESET);

            for (int j = 0; j < BOARDLENGTH; j++) {
                String spaceJ = board[i][j] == null ? " " : board[i][j];
                System.out.print(" "+ spaceJ + " |");

            }

            System.out.println("\n---------------------------------------------");

        }
    }

}
