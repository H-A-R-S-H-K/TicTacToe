package com.sst.models;

public class Cell {
    private int row;
    private int col;
    private CellStatus cellStatus;
    private Player player;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellStatus = CellStatus.EMPTY;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }


    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }
}
