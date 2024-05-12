package org.example.winningStrategy;

public class HorizontalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(char[][] board, char symbol) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
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

