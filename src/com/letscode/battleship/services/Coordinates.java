package com.letscode.battleship.services;

import com.letscode.battleship.utils.Printer;

import static com.letscode.battleship.services.Game.*;
import static com.letscode.battleship.services.GameBoard.CPUBoard;
import static com.letscode.battleship.services.GameBoard.PLAYERBOARD;
import static com.letscode.battleship.services.Letters.rowLetterBoard;
import static com.letscode.battleship.services.Positions.*;
import static com.letscode.battleship.utils.Printer.*;

public class Coordinates {
    public static String sub = ANSI_YELLOW + "N" + ANSI_RESET;
    public static String shot = ANSI_CYAN + "*" + ANSI_RESET;
    public static String miss = ANSI_WHITE + "-" + ANSI_RESET;
    public static int col;

    public static void CPUCoordinates(){
        int rowPosition;
        int colPosition;
        do{
            rowPosition = random.nextInt(10);
            colPosition = random.nextInt(10);
        } while(PLAYERBOARD[rowPosition][colPosition] == shot || PLAYERBOARD[rowPosition][colPosition] == miss);

        if (PLAYERBOARD[rowPosition][colPosition] == sub){
            Printer.CPUShot();
            PLAYERBOARD[rowPosition][colPosition] = shot;
        }
        else{
            CPUMiss();
            PLAYERBOARD[rowPosition][colPosition] = miss;
        }
    }

    public static void askPlayerCoordinates(){
        Printer.coordinates();
        Printer.enterLetter();
        char rowChar = Character.toUpperCase(scanner.next().charAt(0));
        row = rowLetterBoard(rowChar);

        while (row > 9){
            Printer.validLetter();
            rowChar = Character.toUpperCase(scanner.next().charAt(0));
            row = rowLetterBoard(rowChar);
        }
        coordVerification();
        if(CPUBoard[row][col] == shot || CPUBoard[row][col] == miss ){
            do{
                Printer.invalidMove();
                Printer.enterLetter();
                rowChar = Character.toUpperCase(scanner.next().charAt(0));
                row = rowLetterBoard(rowChar);
                coordVerification();
            }while(CPUBoard[row][col] == shot || CPUBoard[row][col] == miss);
        }
        if (CPUBoard[row][col] == sub){
            Printer.shot();
            CPUBoard[row][col] = shot;
        }
        else{
            Printer.miss();
            CPUBoard[row][col] = miss;
        }
    }

    public static void coordVerification() {
        do{
            Printer.enterNumber();
            while (!scanner.hasNextInt()) {
                Printer.validNumber();
                scanner.next();
            }
            col = scanner.nextInt();
        } while (col < 0 || col > 9);
    }

}