package com.sst.models;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameStatus gameStatus;
    private Player winner;
    private int nextPlayerMoveIndex;

    public Game(int dimension, List<Player> players) {
        this.board = new Board(dimension);
        this.players = players;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.winner = null;
        this.nextPlayerMoveIndex = 0;
    }
    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }
}
