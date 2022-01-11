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

    public static void CPUCoordinates(){
        String message;
        int rowPosition;
        int colPosition;
        do{
            rowPosition = random.nextInt(10);
            colPosition = random.nextInt(10);
        } while(PLAYERBOARD[rowPosition][colPosition] == shot || PLAYERBOARD[rowPosition][colPosition] == miss);

        if (PLAYERBOARD[rowPosition][colPosition] == sub){
            message = "CPU nice Shot!";
            PLAYERBOARD[rowPosition][colPosition] = shot;
        }
        else{
            message = "CPU missed!";
            PLAYERBOARD[rowPosition][colPosition] = miss;
        }
        System.out.println(message);
    }

    public static void askPlayerCoordinates(){
        String playerMessage;
        Printer.coordinates();

        Printer.enterLetter();
        char rowChar = Character.toUpperCase(scanner.next().charAt(0));
        row = rowLetterBoard(rowChar);

        while (row > 9){
            Printer.validLetter();
            rowChar = Character.toUpperCase(scanner.next().charAt(0));
            row = rowLetterBoard(rowChar);
        }

        Printer.enterNumber();
        int col = scanner.nextInt();

        while (col > 9) {
            Printer.validNumber();
            col = scanner.nextInt();
        }

        if(CPUBoard[row][col] == shot || CPUBoard[row][col] == miss ){
            do{
                Printer.invalidMove();
                Printer.enterLetter();
                rowChar = Character.toUpperCase(scanner.next().charAt(0));
                row = rowLetterBoard(rowChar);
                Printer.enterNumber();
                col = scanner.nextInt();
                while (col > 9) {
                    Printer.validNumber();
                    col = scanner.nextInt();
                }
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
}