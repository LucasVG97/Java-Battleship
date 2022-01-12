package com.letscode.battleship;

import com.letscode.battleship.services.Coordinates;
import com.letscode.battleship.services.Game;
import com.letscode.battleship.services.GameBoard;
import com.letscode.battleship.services.Positions;
import com.letscode.battleship.utils.Printer;

import static com.letscode.battleship.services.Game.*;


public class Main {
    public static void main(String[] args){
        Printer.startGame();
        Printer.askPlayerFirstName();
        String playerName = scanner.next();

        Positions.playerPositions();
        GameBoard.playerBoard(playerName);
        Positions.CPUPositions();

        do{
            Coordinates.askPlayerCoordinates();
            Coordinates.CPUCoordinates();
            GameBoard.playerBoard(playerName);
            GameBoard.CPUBoard();
            Game.setIsGameOver();
        } while (isGameRunning);
        setWinner(playerName);

    }
}
