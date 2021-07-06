package Solver;

public class Board {
    public static final int SIZE = 9;
    private int[][] board = new int[9][9];

    /***
     * Default constructor, when no parameters are provided. Sets all values to 0.
     */
    public Board() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = 0;
            }
        }
    }

    /***
     * Constructor for when a board is provided.
     * @param board
     */
    public Board(int[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    /***
     * Method for checking whether the current board breaks any sudoku rules.
     * @return
     */
    public boolean isValid() {
        return isValidColumn() && isValidRow() && isValidSquare();
    }

    /***
     * Method for checking whether all rows contain unique.
     * @return
     */
    public boolean isValidRow() {
        for (int i = 0; i < SIZE; i++) {
            String values = "";
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != 0) {
                    if (values.contains(String.valueOf(board[i][j]))) {
                        return false;
                    }
                    values += String.valueOf(board[i][j]);
                }
            }
        }
        return true;
    }

    /***
     * Method for checking whether all columns contain unique.
     * @return
     */
    public boolean isValidColumn() {
        for (int i = 0; i < SIZE; i++) {
            String values = "";
            for (int j = 0; j < SIZE; j++) {
                if (board[j][i] != 0) {
                    if (values.contains(String.valueOf(board[j][i]))) {
                        return false;
                    }
                    values += String.valueOf(board[j][i]);
                }
            }
        }
        return true;
    }

    /***
     * Method for checking whether all 3x3 squares on the board have unique values.
     * @return
     */
    public boolean isValidSquare() {
        for(int i = 0; i < 9; i+=3) {
            for(int j = 0; j < 9; j+=3) {
                String values = "";
                for(int k = 0; k < 3; k++) {
                    for(int l = 0; l < 3; l++) {
                        int a = i+k;
                        int b = j+l;
                        if (board[i+k][j+l] != 0) {
                            if (values.contains(String.valueOf(board[i+k][j+l]))) {
                                return false;
                            }
                            values += String.valueOf(board[i+k][j+l]);
                        }
                    }
                }
            }
        }
        System.out.println();
        return true;
    }

    /***
     * Method that checks whether the Sudoku board is complete.
     * @return
     */
    public boolean isComplete() {
        int countEmpty = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    countEmpty++;
                }
            }
        }
        if (countEmpty == 0 && isValid()) {
            return true;
        }

        return false;
    }

    /***
     * Method for setting the value of a certain cell.
     * @param x
     * @param y
     * @param value
     */
    public void setCell(int x, int y, int value) {
        this.board[x][y] = value;
    }

    /***
     * Getter method for the board.
     */
    public int[][] getBoard() {
        return this.board;
    }

    /***
     * Getter method for the next empty cell on the Sudoku board.
     */
    public void setNextEmpty(int value) {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if(board[i][j] == 0) {
                    board[i][j] = value;
                    return;
                }
            }
        }
    }
}
