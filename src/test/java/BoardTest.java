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
}
