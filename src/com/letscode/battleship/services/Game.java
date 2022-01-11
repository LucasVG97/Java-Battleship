package com.letscode.battleship.services;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static com.letscode.battleship.services.Coordinates.sub;
import static com.letscode.battleship.services.GameBoard.*;
import static com.letscode.battleship.utils.Printer.ANSI_PURPLE;

public class Game {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static boolean isGameRunning = true;

    public static void setIsGameOver(){
        boolean playerSub = false;
        boolean CPUSub = false;
        isGameRunning = false;
        for(int i = 0; i < BOARDLENGTH; i++){
            for(int j = 0; j < BOARDLENGTH; j++){
                if(Objects.equals(PLAYERBOARD[i][j], sub)){
                    playerSub = true;
                }
                if(Objects.equals(CPUBoard[i][j], sub)){
                    CPUSub = true;
                }
            }
        }
        if (playerSub && CPUSub){
            isGameRunning = true;
        }
    }

    public static void setWinner(String playerName){
        boolean playerWins = true;
        for(int i = 0; i < BOARDLENGTH; i++){
            for(int j = 0; j < BOARDLENGTH; j++){
                if (Objects.equals(CPUBoard[i][j], sub)) {
                    playerWins = false;
                }
            }
        }
        if(playerWins){
            System.out.println(ANSI_PURPLE + playerName + " wins!!!" +ANSI_RESET);
        }
        else{
            System.out.println("CPU wins!!!");
        }
        CPUBoard();
        playerBoard(playerName);
    }



}
