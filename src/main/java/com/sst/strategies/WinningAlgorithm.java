package com.sst.strategies;

import com.sst.models.Board;
import com.sst.models.Move;

import java.util.HashMap;

public class WinningAlgorithm {
    HashMap<Integer, HashMap<Character, Integer>> rowMaps = new HashMap<>();
    HashMap<Integer, HashMap<Character, Integer>> colMaps = new HashMap<>();
    HashMap<Character, Integer> leftDiagonalMap = new HashMap<>();
    HashMap<Character, Integer> rightDiagonalMap = new HashMap<>();

    private boolean checkRowOrCol(HashMap<Integer, HashMap<Character, Integer>> map, int index, Character character, Board board) {
        if (!map.containsKey(index)) {
            map.put(index, new HashMap<>());
        }
        HashMap<Character, Integer> currMap = map.get(index);

        if (!currMap.containsKey(character)) {
            currMap.put(character, 1);
        } else {
            currMap.put(character, currMap.get(character) + 1);
        }

        return currMap.get(character) == board.getSize();
    }
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character character = move.getPlayer().getSymbol().getaChar();

        //Row
        if (checkRowOrCol(rowMaps, row, character, board))
            return true;

        //Col
        if (checkRowOrCol(colMaps, col, character, board))
            return true;

        //Left Diagonal
        if (row == col) {
            if (!leftDiagonalMap.containsKey(character)) {
                leftDiagonalMap.put(character, 1);
            } else {
                leftDiagonalMap.put(character, leftDiagonalMap.get(character) + 1);
            }

            if (leftDiagonalMap.get(character) == board.getSize()) {
                return true;
            }
        }

        //Right Diagonal
        if (row + col == board.getSize() - 1) {
            if (!rightDiagonalMap.containsKey(character)) {
                rightDiagonalMap.put(character, 1);
            } else {
                rightDiagonalMap.put(character, rightDiagonalMap.get(character) + 1);
            }

            return rightDiagonalMap.get(character) == board.getSize();
        }

        return false;
    }
}
