package org.example.winningStrategy;

public class DiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(char[][] board, char symbol) {
        int size = board.length;

        for (int i = 0; i <= size - 5; i++) {
            for (int j = 0; j <= size - 5; j++) {
                if (checkDiagonal(board, i, j, 1, 1, symbol)) {
                    return true;
                }
            }
        }

        for (int i = 0; i <= size - 5; i++) {
            for (int j = size - 1; j >= 4; j--) {
                if (checkDiagonal(board, i, j, 1, -1, symbol)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkDiagonal(char[][] board, int startRow, int startCol, int rowIncrement, int colIncrement, char symbol) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (board[startRow + i * rowIncrement][startCol + i * colIncrement] == symbol) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
}


