package org.example.player;

import org.example.game.GameBoard;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private char symbol;
    private GameBoard gameBoard;

    public HumanPlayer(char symbol, GameBoard gameBoard) {
        this.symbol = symbol;
        this.gameBoard = gameBoard;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
    @Override
    public int[] getNextMove() {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];

        boolean validMove = false;

        do  {
            System.out.print("Enter row number (0-" + (gameBoard.getSize() - 1) + "): ");
            move[0] = scanner.nextInt();

            System.out.print("Enter column number (0-" + (gameBoard.getSize() - 1) + "): ");
            move[1] = scanner.nextInt();

            if(gameBoard.getBoard()[move[0]][move[1]] == '-'){
                validMove = true;
            }
            else{
                System.out.println("Invalid place!!!");
            }
        }while (!validMove);

//        System.out.print("Enter row number (0-" + (gameBoard.getSize() - 1) + "): ");
//        move[0] = scanner.nextInt();
//
//        System.out.print("Enter column number (0-" + (gameBoard.getSize() - 1) + "): ");
//        move[1] = scanner.nextInt();

        return move;
    }

    @Override
    public void makeMove(int row, int col) {
        gameBoard.getBoard()[row][col] = symbol;
    }
}

