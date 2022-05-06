package tictactoe;

import java.util.Random;

public class Easy extends Player {

    // Easy AI algorithm chooses an empty space at random

    @Override
    public void nextMove(Board board) {
        System.out.println("Making move level \"easy\"");
        Random random = new Random();

        while (true) {
            int row = random.nextInt(3);
            int column = random.nextInt(3);
            if (board.table[row][column] == ' ') {
                board.place(row, column);
                break;
            }
        }
    }

}
