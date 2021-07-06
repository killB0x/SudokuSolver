package Solver;

public  class Solver {

    /***
     * Recursive method for solving the sudoku puzzle.
     * @param current
     * @return
     */
    public static Board solveSudoku(Board current) {
        if(!current.isValid()) {
            return null;
        }
        if(current.isComplete()) {
            return current;
        }
        for(int i = 1; i <= Board.SIZE; i++) {
            Board nextStep = new Board(current.getBoard());
            nextStep.setNextEmpty(i);
            nextStep = solveSudoku(nextStep);
            if(nextStep != null) {
                return nextStep;
            }
        }
        return null;
    }
}
