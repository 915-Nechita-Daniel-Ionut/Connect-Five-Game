package org.example.game;

import org.example.move.MakeMoveCommand;
import org.example.player.ComputerPlayer;

import org.example.winningStrategy.DiagonalWinningStrategy;
import org.example.winningStrategy.HorizontalWinningStrategy;
import org.example.winningStrategy.VerticalWinningStrategy;
import org.example.winningStrategy.WinningStrategy;
import org.example.player.Player;

import java.util.List;
import java.util.ArrayList;

public class Game implements GameObserver {
    private List<Player> players;
    private GameBoard gameBoard;
    private boolean gameOver;
    private List<WinningStrategy> winningStrategies;
    private List<GameObserver> observers;

    public Game(int size) {
        this.players = new ArrayList<>();
        this.gameBoard = GameBoard.getInstance(size);
        this.gameOver = false;
        this.winningStrategies = new ArrayList<>();

        this.winningStrategies.add(new HorizontalWinningStrategy());
        this.winningStrategies.add(new VerticalWinningStrategy());
        this.winningStrategies.add(new DiagonalWinningStrategy());
        this.observers = new ArrayList<>();
    }


    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        gameBoard.displayBoard();
        while (!gameOver) {
            for (Player player : players) {
                int[] move;
                move = player.getNextMove();
                MakeMoveCommand moveC = new MakeMoveCommand(player, move[0], move[1]);
                moveC.execute();
                if(player instanceof ComputerPlayer){
                    gameBoard.displayBoard();
                }

                notifyObservers();
            }
        }

    }

    private boolean checkWin(char symbol) {
        for (WinningStrategy strategy : winningStrategies) {
            if (strategy.checkWin(gameBoard.getBoard(), symbol)) {
                return true;
            }
        }
        return false;
    }

    private boolean isBoardFull() {
        char[][] board = gameBoard.getBoard();
        for (int i = 0; i < gameBoard.getSize(); i++) {
            for (int j = 0; j < gameBoard.getSize(); j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (GameObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public void update() {
        for (Player player : players) {
            if (checkWin(player.getSymbol())) {
                gameOver = true;
                System.out.println("Player " + player.getSymbol() + " wins!");
                return;
            }
        }
        if (!gameOver && isBoardFull()) {
            gameOver = true;
            System.out.println("It's a draw!");
        }
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }
}

