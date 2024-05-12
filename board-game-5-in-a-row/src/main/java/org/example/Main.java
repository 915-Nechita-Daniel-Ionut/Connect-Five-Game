package org.example;

import org.example.game.Game;
import org.example.player.Player;
import org.example.player.PlayerFactory;

public class Main {
    public static void main(String[] args) {
        int boardSize = 10;
        Game game = new Game(boardSize);

        PlayerFactory playerFactory = new PlayerFactory();
        Player humanPlayer = playerFactory.createPlayer('X', game.getGameBoard(), true);
        Player computerPlayer = playerFactory.createPlayer('O', game.getGameBoard(), false);

        game.addPlayer(humanPlayer);
        game.addPlayer(computerPlayer);

        game.addObserver(game);

        game.startGame();

        game.removeObserver(game);
    }
}
