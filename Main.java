package tictactoe;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();

        // Players are declared in a type: Player array. Allows them to be different subclasses, but still be looped
        Player[] players = new Player[2];

        board.clear();

        // Menu loop to wait for command and handle incorrect parameters
        // Initializes player in players according to the available parameters

        menu: while (true) {
            System.out.println("Input command: ");
            String[] commands = scanner.nextLine().split(" ");
            if (commands[0].equals("exit")) {
                System.exit(0);
            } else if (commands.length != 3) {
                System.out.println("Bad parameters!");
                continue;
            }
            for (int i = 1; i < commands.length; i++) {
                switch (commands[i]) {
                    case "user":
                        players[i - 1] = new Player();
                        break;
                    case "easy":
                        players[i - 1] = new Easy();
                        break;
                    case "medium":
                        players[i - 1] = new Medium();
                        break;
                    case "hard":
                        players[i - 1] = new Hard();
                        break;
                    default:
                        System.out.println("Bad parameters");
                        continue menu;
                }
            }
            break;
        }

        // Game loop to iterate over player in players, calling their respective nextMove method
        // Checks for any matches or if the board is full after each move

        game: while (true) {
            for (Player player : players) {
                board.display();
                player.nextMove(board);
                if (board.match() == 'X' || board.match() == 'O') {
                    board.display();
                    System.out.printf("%c wins", board.match());
                    break game;
                } else if (board.isFull()) {
                    board.display();
                    System.out.println("Draw");
                    break game;
                }
            }
        }

    }
}