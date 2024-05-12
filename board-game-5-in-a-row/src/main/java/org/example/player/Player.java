package org.example.player;

public interface Player {
    char getSymbol();
    void makeMove(int row, int col);
    int[] getNextMove();
}