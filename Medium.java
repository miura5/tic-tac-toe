package tictactoe;

import java.util.Random;

public class Medium extends Player {

    // Medium AI algorithm to read the present table and check any possible winning combinations

    @Override
    public void nextMove(Board board) {
        System.out.println("Making move level \"medium\"");
        Random random = new Random();
        char[][] table = board.table;
        int row = 0;
        int column = 0;

        //vertical and horizontal check
        for (int i = 0; i < 3; i++) {
            if (table[0][i] == table[1][i] || table[1][i] == table[2][i] || table[0][i] == table[2][i]) {
                int spaces = 0;
                for (int j = 0; j < 3; j++) {
                    if (table[j][i] == ' ') {
                        row = j;
                        column = i;
                        spaces += 1;
                    }
                }
                if (spaces == 1) {
                    board.place(row, column);
                    return;
                }
            } else if (table[i][0] == table[i][1] || table[i][1] == table[i][2] || table[i][0] == table[i][2]) {
                int spaces = 0;
                for (int j = 0; j < 3; j++) {
                    if (table[i][j] == ' ') {
                        row = i;
                        column = j;
                        spaces += 1;
                    }
                }
                if (spaces == 1) {
                    board.place(row, column);
                    return;
                }
            }
        }

        //diagonal check
        if (table[0][0] == table[1][1] || table[1][1] == table[2][2] || table[0][0] == table[2][2]) {
            int spaces = 0;
            for (int i = 0; i < 3; i++) {
                if (table[i][i] == ' ') {
                    row = i;
                    column = i;
                    spaces += 1;
                }
            }
            if (spaces == 1) {
                board.place(row, column);
                return;
            }
        } else if (table[0][2] == table[1][1] || table[1][1] == table[2][0] || table[0][2] == table[2][0]) {
            int spaces = 0;
            for (int i = 0; i < 3; i++) {
                if (table[i][2 - i] == ' ') {
                    row = i;
                    column = 2 - i;
                    spaces += 1;
                }
            }
            if (spaces == 1) {
                board.place(row, column);
                return;
            }
        }

        //random move
        while (true) {
            row = random.nextInt(3);
            column = random.nextInt(3);
            if (table[row][column] == ' ') {
                board.place(row, column);
                break;
            }
        }
    }

}
