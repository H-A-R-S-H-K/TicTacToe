package com.sst.controllers;

import com.sst.models.Game;
import com.sst.models.GameStatus;
import com.sst.models.Player;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> players) {
        return new Game(dimension, players);
    }
    public void makeMove(Game game) {
        game.makeMove();
    }
    public GameStatus checkStatus(Game game) {
        return game.getGameStatus();
    }
    public Player getWinner(Game game) {
        return game.getWinner();
    }
    public void printBoard(Game game) {
        game.printBoard();
    }
}
