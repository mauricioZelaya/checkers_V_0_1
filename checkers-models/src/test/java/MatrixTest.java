import static org.junit.Assert.assertEquals;

import org.checkers.model.Matrix;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This class tests the Matrix class methods.
 *
 * @author  (Leonardo Antezana)
 * @version (July 2017)
 */
public class MatrixTest
{
    Matrix matrix;

    /**
     * Sets the initial state of the matrix instance for testing below.
     */
    @Before
    public void setUp() {
        matrix = new Matrix();
        matrix.initMatrixToDefaultState();
    }

    @Test
    public void matrixIsAtDefaultState() {
        matrix.initMatrixToDefaultState();
        assertEquals(9, matrix.getValueAtCoordinates("A8"));
        assertEquals(2, matrix.getValueAtCoordinates("A7"));
        assertEquals(9, matrix.getValueAtCoordinates("H1"));
        assertEquals(1, matrix.getValueAtCoordinates("H2"));
        assertEquals(0, matrix.getValueAtCoordinates("A5"));
        assertEquals(0, matrix.getValueAtCoordinates("H4"));
    }

    @Test
    public void testAnIntMatrixIsReturned() {
        Assert.assertTrue(matrix.getMatrix() instanceof int[][]);
    }

    @Test
    public void test98x95yMouseClickIsA8() {
        assertEquals("A8", matrix.getCoordinatesAtXY(95, 95));
    }

    @Test
    public void testValueAtCoordinatesA7Is2() {
        assertEquals(2, matrix.getValueAtCoordinates("A7"));
    }

    @Test
    public void testValueAtCoordinatesG1Is1() {
        assertEquals(1, matrix.getValueAtCoordinates("G1"));
    }

    @Test
    public void testValueAtCoordinatesE4Is0() {
        assertEquals(9, matrix.getValueAtCoordinates("E4"));
    }

    @Test
    public void testValueChangedAtA1Is2() {
        int originalValue = matrix.getValueAtCoordinates("A1");
        matrix.setValueAtCoordinates("A1", 2);
        assertEquals(2, matrix.getValueAtCoordinates("A1"));
        matrix.setValueAtCoordinates("A1", originalValue);
        assertEquals(1, matrix.getValueAtCoordinates("A1"));
    }

    @Test
    public void testMoveFromA3toB4() {
        matrix.initMatrixToDefaultState();
        assertEquals(1, matrix.getValueAtCoordinates("A3"));
        assertEquals(0, matrix.getValueAtCoordinates("B4"));
        matrix.moveGamePiece("A3", "B4");
        assertEquals(0, matrix.getValueAtCoordinates("A3"));
        assertEquals(1, matrix.getValueAtCoordinates("B4"));
    }

    @Test
    public void testMoveAndCaptureFromA3toC5() {
        matrix.initMatrixToDefaultState();
        assertEquals(1, matrix.getValueAtCoordinates("A3"));
        assertEquals(2, matrix.getValueAtCoordinates("B6"));
        assertEquals(0, matrix.getValueAtCoordinates("B4"));
        assertEquals(0, matrix.getValueAtCoordinates("C5"));
        matrix.moveGamePiece("B6", "B4");//""
        matrix.moveGamePiece("A3", "C5");//, "B4"
        matrix.captureGamePiece("B4");
        assertEquals(0, matrix.getValueAtCoordinates("A3"));
        assertEquals(0, matrix.getValueAtCoordinates("B6"));
        assertEquals(0, matrix.getValueAtCoordinates("B4"));
        assertEquals(1, matrix.getValueAtCoordinates("C5"));
    }

    @Test
    public void testSelectedGamePieceChangesForValue2AtB8() {
        matrix.initMatrixToDefaultState();
        assertEquals(2, matrix.getValueAtCoordinates("B8"));
        matrix.toggleSelectedGamePiece("B8");
        assertEquals(20, matrix.getValueAtCoordinates("B8"));
    }

    @Test
    public void testSelectedGamePieceChangesForValue1AtA1() {
        matrix.initMatrixToDefaultState();
        assertEquals(1, matrix.getValueAtCoordinates("A1"));
        matrix.toggleSelectedGamePiece("A1");
        assertEquals(10, matrix.getValueAtCoordinates("A1"));
    }

    @Test
    public void testSelectedGamePieceNoChangeForValue0AtA5() {
        matrix.initMatrixToDefaultState();
        assertEquals(0, matrix.getValueAtCoordinates("A5"));
        matrix.toggleSelectedGamePiece("A5");
        assertEquals(0, matrix.getValueAtCoordinates("A5"));
    }

    @Test
    public void testSelectedGamePieceNoChangeForValue9AtH1() {
        matrix.initMatrixToDefaultState();
        assertEquals(9, matrix.getValueAtCoordinates("H1"));
        matrix.toggleSelectedGamePiece("H1");
        assertEquals(9, matrix.getValueAtCoordinates("H1"));
    }

    @Test
    public void testCrownedGamePieceForValue1AtH1() {
        matrix.initMatrixToDefaultState();
        assertEquals(1, matrix.getValueAtCoordinates("G1"));
        matrix.crownGamePiece("G1");
        assertEquals(3, matrix.getValueAtCoordinates("G1"));
    }

    @Test
    public void testCrownedGamePieceForValue2AtH8() {
        matrix.initMatrixToDefaultState();
        assertEquals(2, matrix.getValueAtCoordinates("H8"));
        matrix.crownGamePiece("H8");
        assertEquals(4, matrix.getValueAtCoordinates("H8"));
    }

    @Test
    public void testCrownedGamePieceNoChangeForValue0AtD4() {
        matrix.initMatrixToDefaultState();
        assertEquals(0, matrix.getValueAtCoordinates("D4"));
        matrix.crownGamePiece("D4");
        assertEquals(0, matrix.getValueAtCoordinates("D4"));
    }

    @Test
    public void testCrownedGamePieceNoChangeForValue9AtA4() {
        matrix.initMatrixToDefaultState();
        assertEquals(9, matrix.getValueAtCoordinates("A4"));
        matrix.crownGamePiece("A4");
        assertEquals(9, matrix.getValueAtCoordinates("A4"));
    }
}