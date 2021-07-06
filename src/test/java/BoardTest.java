import Solver.Board;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardTest {

    @Test
    public void rowIsValid() {
        for(int k = 0; k < 10000; k++) {
            Board board = new Board();
            Random seedGenerator = new Random();
            int seed1 = seedGenerator.nextInt(9);
            int seed2 = seedGenerator.nextInt(9);
            for (int i = 0; i < Board.SIZE; i++) {
                for (int j = 0; j < Board.SIZE; j++) {
                    Random rand = new Random();
                    board.setCell(i,j,rand.nextInt(9) + 1);
                }
            }
            for (int i = 0; i < Board.SIZE; i++) {
                board.setCell(i,seed1,5);
                board.setCell(i,(seed1+seed2) % 9,5);
            }
            assertFalse(board.isValidRow());
        }
        Board board = new Board();
        assertTrue(board.isValidRow());
    }

    @Test
    public void columnIsValid() {
        for(int k = 0; k < 10000; k++) {
            Board board = new Board();
            Random seedGenerator = new Random();
            int seed1 = seedGenerator.nextInt(9);
            int seed2 = seedGenerator.nextInt(9);
            for (int i = 0; i < Board.SIZE; i++) {
                for (int j = 0; j < Board.SIZE; j++) {
                    Random rand = new Random();
                    board.setCell(j,i,rand.nextInt(9) + 1);
                }
            }
            for (int i = 0; i < Board.SIZE; i++) {
                board.setCell(seed1,i,5);
                board.setCell((seed1+seed2) % 9,i,5);
            }
            assertFalse(board.isValidColumn());
        }
        Board board = new Board();
        assertTrue(board.isValidColumn());
    }

    @Test
    public void squareIsValid() {
        for(int k = 0; k < 10000; k++) {
            Board board = new Board();
            Random seedGenerator = new Random();
            int seed1 = seedGenerator.nextInt(9);
            int seed2 = seedGenerator.nextInt(9);
            for (int i = 0; i < Board.SIZE; i++) {
                for (int j = 0; j < Board.SIZE; j++) {
                    Random rand = new Random();
                    board.setCell(i,j,rand.nextInt(9) + 1);
                }
            }
            for (int i = 0; i < 9; i+=3) {
                for (int j = 0; j < 9; j+=3) {
                    board.setCell(i,j,1);
                    board.setCell(i,j+1,1);
                }
            }
            assertFalse(board.isValidSquare());
        }
        Board board = new Board();
        assertTrue(board.isValidSquare());
    }
}
