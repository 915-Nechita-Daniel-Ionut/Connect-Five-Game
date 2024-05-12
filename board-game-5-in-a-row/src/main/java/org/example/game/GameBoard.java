package org.example.game;

import org.example.winningStrategy.DiagonalWinningStrategy;
import org.example.winningStrategy.HorizontalWinningStrategy;
import org.example.winningStrategy.VerticalWinningStrategy;
import org.example.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private static GameBoard instance;
    private char[][] board;
    private int size;

    private GameBoard(int size) {
        this.size = size;
        this.board = new char[size][size];
        initializeBoard();
    }

    public static GameBoard getInstance(int size) {
        if (instance == null) {
            instance = new GameBoard(size);
        }
        return instance;
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }

    public void displayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}



