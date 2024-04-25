package com.sst;

import com.sst.controllers.GameController;
import com.sst.models.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe");

        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the number of players: ");
        int dimensions = scanner.nextInt() + 1;

        List<Player> players = new ArrayList<>();
        HashSet<Character> symbols = new HashSet<>();

        for (int i = 1; i <= dimensions; i++) {
            System.out.println("Please enter Player " + i + " type: HUMAN or BOT ?");
            String type = scanner.next();

            PlayerType playerType;
            if (type.equals("HUMAN")) {
                playerType = PlayerType.HUMAN;
            }
            else {
                playerType = PlayerType.BOT;
            }

            System.out.println("Please enter Player " + i + "'s name");
            String name = scanner.next();


            System.out.println("Please enter "+ name + "'s symbol");
            char achar = scanner.next().charAt(0);

            while (symbols.contains(achar)) {
                System.out.println("This symbol is already chosen, please select a new symbol: ");
                achar = scanner.next().charAt(0);
            }
            symbols.add(achar);

            if (playerType == PlayerType.BOT) {
                players.add(new Bot(name, new Symbol(achar), playerType, BotDifficultyLevel.EASY));
            }
            else {
                players.add(new Player(name, new Symbol(achar), playerType));
            }
        }

        Game game = gameController.startGame(dimensions, players);

        while (game.getGameStatus() == GameStatus.IN_PROGRESS) {
            gameController.printBoard(game);

            gameController.makeMove(game);
        }

        if (!gameController.checkStatus(game).equals(GameStatus.ENDED)) {
            game.setGameStatus(GameStatus.DRAW);
            System.out.println("Game DRAW");
        }

        else {
            gameController.printBoard(game);
            System.out.println("Player " + game.getWinner().getName() + " is the winner.");
        }
    }
}