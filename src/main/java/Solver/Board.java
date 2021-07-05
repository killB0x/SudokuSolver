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
        return false;
    }

    /***
     * Method for checking whether all rows contain unique
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
}
