package org.example.player;

import org.example.game.GameBoard;

public class PlayerFactory {
    public Player createPlayer(char symbol, GameBoard gameBoard, boolean isHuman) {
        if (isHuman) {
            return new HumanPlayer(symbol, gameBoard);
        } else {
            return new ComputerPlayer(symbol, gameBoard);
        }
    }
}

