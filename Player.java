package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    // Player class to serve as a reference for the other classes (allowing them to override and implement their own
    // nextMove algorithm).

    // The default algorithm places nextMove by input

    public void nextMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coordinates: ");
        while (true) {
            try {
                int row = scanner.nextInt() - 1;
                int column = scanner.nextInt() - 1;
                if (row > 2 || row < 0 || column > 2 || column < 0) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (board.table[row][column] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    board.place(row, column);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }

}
