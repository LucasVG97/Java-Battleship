package com.letscode.battleship.services;



import static com.letscode.battleship.services.Positions.letter;
import static com.letscode.battleship.services.Positions.validRowPosition;

public class Letters {
    public static int rowLetterBoard(char lettersToInt){
        switch (lettersToInt) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            case 'F':
                return 5;
            case 'G':
                return 6;
            case 'H':
                return 7;
            case 'I':
                return 8;
            case 'J':
                return 9;
            default:
                validRowPosition();
        }
        return letter;
    }
}
