package org.example.move;

import org.example.player.Player;

public class MakeMoveCommand implements MoveCommand {
    private Player player;
    private int row;
    private int col;

    public MakeMoveCommand(Player player, int row, int col) {
        this.player = player;
        this.row = row;
        this.col = col;
    }

    @Override
    public void execute() {
        player.makeMove(row, col);
    }
}
