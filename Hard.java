package tictactoe;

public class Hard extends Player {

    char player;
    char opponent;

    // Minimax algorithm to calculate every move's value

    public int minimax(Board board, int depth, Boolean isMax) {

        if (board.isFull()) {
            return 0;
        } else if (board.match() == player) {
            return 10;
        } else if (board.match() == opponent) {
            return -10;
        }

        if (isMax) {
            int highest = Integer.MIN_VALUE;
            for (int i = 0; i < board.table.length; i++) {
                for (int j = 0; j < board.table.length; j++) {
                    if (board.table[i][j] == ' ') {
                        board.table[i][j] = player;
                        highest = Math.max(highest, minimax(board, depth + 1, false));
                        board.table[i][j] = ' ';
                    }
                }
            }
            return highest / depth;
        } else {
            int lowest = Integer.MAX_VALUE;
            for (int i = 0; i < board.table.length; i++) {
                for (int j = 0; j < board.table.length; j++) {
                    if (board.table[i][j] == ' ') {
                        board.table[i][j] = opponent;
                        lowest = Math.min(lowest, minimax(board, depth + 1, true));
                        board.table[i][j] = ' ';
                    }
                }
            }
            return lowest;
        }
    }

    // Hard AI algorithm to check every possible future move in order to maximize the value of its moves and minimize
    // the value of its opponent's moves.

    @Override
    public void nextMove(Board board) {
        this.player = board.moves % 2 == 0 ? 'X' : 'O';
        this.opponent = player == 'X' ? 'O' : 'X';
        int bestValue = Integer.MIN_VALUE;
        int row = -1;
        int column = -1;

        System.out.println("Making move level \"hard\"");

        for (int i = 0; i < board.table.length; i++) {
            for (int j = 0; j < board.table.length; j++) {
                if (board.table[i][j] == ' ') {
                    board.table[i][j] = player;
                    int moveValue = minimax(board, 0, false);
                    board.table[i][j] = ' ';
                    if (moveValue > bestValue) {
                        row = i;
                        column = j;
                        bestValue = moveValue;
                    }
                }
            }
        }
        board.place(row, column);
    }
}
