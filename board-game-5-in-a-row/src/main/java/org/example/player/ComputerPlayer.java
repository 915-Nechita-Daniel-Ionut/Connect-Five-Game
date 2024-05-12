package org.example.player;
import org.example.game.GameBoard;

import java.util.Random;

public class ComputerPlayer implements Player {
    private char symbol;
    private GameBoard gameBoard;

    public ComputerPlayer(char symbol, GameBoard gameBoard) {
        this.symbol = symbol;
        this.gameBoard = gameBoard;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }


    @Override
    public void makeMove(int row, int col) {
        gameBoard.getBoard()[row][col] = symbol;
    }

    @Override
    public int[] getNextMove() {
        // Logic for computer player's move (e.g., random move)
        Random rand = new Random();
        int row = rand.nextInt(gameBoard.getSize());
        int col = rand.nextInt(gameBoard.getSize());
        while (gameBoard.getBoard()[row][col] != '-') {
            row = rand.nextInt(gameBoard.getSize());
            col = rand.nextInt(gameBoard.getSize());
        }
        return new int[]{row, col};
    }

}