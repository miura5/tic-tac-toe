package tictactoe;

import java.util.Arrays;

public class Board {

    public char[][] table = new char[3][3];
    public int moves = 0;

    public void clear() {
        for (int i = 0; i < table.length; i++) {
            Arrays.fill(table[i], ' ');
        }
    }

    public void display() {
        System.out.println("---------");
        for (int i = 0; i < table.length; i ++) {
            System.out.print("| ");
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf("%c ", table[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public boolean isFull() {

        String elements = "";

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                elements += table[i][j];
            }
        }

        if (elements.contains(" ")){
            return false;
        } else {
            return true;
        }

    }

    public boolean place(int row, int column) {

        char move = moves % 2 == 0 ? 'X' : 'O';

        if (table[row][column] == ' ') {
            table[row][column] = move;
            moves += 1;
            return true;
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

    }


    public char match() {
        //vertical win or horizontal win
        for (int i = 0; i < table.length; i++) {
            if (table[0][i] != ' ' && table[0][i] == table[1][i] && table[0][i] == table[2][i]) {
                return table[0][i];
            } else if (table[i][0] != ' ' && table[i][0] == table[i][1] && table[i][0] == table[i][2]) {
                return table[i][0];
            }
        }

        //diagonal win
        if (table[0][0] != ' ' && table[0][0] == table[1][1] && table[0][0] == table[2][2]) {
            return table[0][0];
        } else if (table[0][2] != ' ' && table[0][2] == table[1][1] && table[0][2] == table[2][0]) {
            return table[0][2];
        }

        return ' ';
    }

}
