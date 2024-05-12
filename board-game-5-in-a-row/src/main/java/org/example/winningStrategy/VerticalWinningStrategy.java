package org.example.winningStrategy;

public class VerticalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(char[][] board, char symbol) {
        int size = board.length;
        for (int j = 0; j < size; j++) {
            int count = 0;
            for (int i = 0; i < size; i++) {
                if (board[i][j] == symbol) {
                    count++;
                    if (count == 5) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }
}

