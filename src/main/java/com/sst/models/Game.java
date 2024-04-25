package com.sst.models;

import com.sst.strategies.WinningAlgorithm;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameStatus gameStatus;
    private Player winner;
    private int nextPlayerMoveIndex;
    private WinningAlgorithm winningAlgorithm;

    public Game(int dimension, List<Player> players) {
        this.board = new Board(dimension);
        this.players = players;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.winner = null;
        this.nextPlayerMoveIndex = 0;
        this.winningAlgorithm = new WinningAlgorithm();
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

    public void printBoard() {
        this.board.displayBoard();
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

    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize())
            return false;

        return board.getBoard().get(row).get(col).getCellStatus().equals(CellStatus.EMPTY);
    }

    public void makeMove() {
        Player currentPlayer = players.get(nextPlayerMoveIndex);
        System.out.println("It is " + currentPlayer.getName() + "'s turn to make a move");

        Move move = currentPlayer.makeMove(board);

        while(!validateMove(move)) {
            System.out.println("INVALID MOVE! "+ currentPlayer.getName() +" please provide a valid move.");
            move = currentPlayer.makeMove(board);
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setCellStatus(CellStatus.FILLED);

        nextPlayerMoveIndex = (nextPlayerMoveIndex + 1) % players.size();

        if (winningAlgorithm.checkWinner(board, move)) {
            gameStatus = GameStatus.ENDED;
            winner = currentPlayer;
        }
    }
}
