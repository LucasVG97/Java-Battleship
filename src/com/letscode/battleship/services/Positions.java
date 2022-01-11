package com.letscode.battleship.services;

import com.letscode.battleship.utils.Printer;
import java.util.Objects;
import static com.letscode.battleship.services.Coordinates.sub;
import static com.letscode.battleship.services.Game.*;
import static com.letscode.battleship.services.GameBoard.*;
import static com.letscode.battleship.services.Letters.rowLetterBoard;

public class Positions {
    public static int letter;
    public static int number;
    public static int row;
    public static char rowChar;

    public static void validRowPosition() {
        Printer.validLetter();
        rowChar = Character.toUpperCase(scanner.next().charAt(0));
        letter = rowLetterBoard(rowChar);
    }

    public static void numberVerification() {
        do{
            Printer.enterNumber();
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                Printer.enterNumber();
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number < 0 || number > 9);
    }

    public static void playerPositions() {
        for(int i = 0 ; i < BOARDLENGTH; i++){
            enterTheCoordinates();

            if(Objects.equals(PLAYERBOARD[letter][number], sub)){
                do{
                    Printer.alreadyShipHere();
                    enterTheCoordinates();

                }while(Objects.equals(PLAYERBOARD[letter][number], sub));

            }
            PLAYERBOARD[letter][number] = sub;
        }

    }

    private static void enterTheCoordinates() {
        Printer.enterLetter();
        rowChar = Character.toUpperCase(scanner.next().charAt(0));
        letter = rowLetterBoard(rowChar);

        while (letter > 9){
            validRowPosition();
        }

        numberVerification();

    }

    public static void CPUPositions(){
        for(int i = 0 ; i < BOARDLENGTH; i++){
            int xPosition;
            int yPosition;
            do {
                xPosition = random.nextInt(10);
                yPosition = random.nextInt(10);
            }
            while (Objects.equals(CPUBoard[xPosition][yPosition], sub));
            CPUBoard[xPosition][yPosition] = sub;
        }
    }


}
