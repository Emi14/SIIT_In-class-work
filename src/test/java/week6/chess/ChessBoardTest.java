package week6.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.week6.testing.chess.ChessBoard;
import org.siit.week6.testing.chess.Pawn;
import org.siit.week6.testing.chess.PieceColor;

import static org.junit.jupiter.api.Assertions.*;

public class ChessBoardTest {

    public static final int INVALID_COORDINATE = -1;
    private ChessBoard chessBoard;

    @BeforeEach
    public void setUp() {
        chessBoard = new ChessBoard();
    }

    @Test
    public void testHasMaxWidth7() {
        assertEquals(7, ChessBoard.MAX_BOARD_WIDTH, "The max width is not 7");
    }

    @Test
    public void testIsLegalBoardPosition_whenXisHigherThan7_thenResultIsFalse() {
        boolean isLegalBoardPosition = chessBoard.isLegalBoardPosition(9, 3);
        assertFalse(isLegalBoardPosition, "The position is not legal");
    }

    @Test
    public void testIsLegalBoardPosition_whenXisLowerThan0_thenResultIsFalse() {
        boolean isLegalBoardPosition = chessBoard.isLegalBoardPosition(-1, 3);
        assertFalse(isLegalBoardPosition, "The position is not legal");
    }

    @Test
    public void testIsLegalBoardPosition_whenYisHigherThan7_thenResultIsFalse() {
        boolean isLegalBoardPosition = chessBoard.isLegalBoardPosition(3, 9);
        assertFalse(isLegalBoardPosition, "The position is not legal");
    }

    @Test
    public void testIsLegalBoardPosition_whenYisLowerThan0_thenResultIsFalse() {
        boolean isLegalBoardPosition = chessBoard.isLegalBoardPosition(3, 9);
        assertFalse(isLegalBoardPosition, "The position is not legal");
    }

    @Test
    public void testIsLegalBoardPosition_whenPositionIsValid_thenResultIsTrue() {
        boolean isLegalBoardPosition = chessBoard.isLegalBoardPosition(3, 3);
        assertTrue(isLegalBoardPosition, "The position is legal");
    }

    @Test
    public void testAdd_whenTwoPawnsAreAddedOnTheSamePosition_thenOnlyOnAppearsOnBoard() {
        Pawn pawn1 = new Pawn(PieceColor.WHITE);
        Pawn pawn2 = new Pawn(PieceColor.WHITE);

        int xCoordinate = 1;
        int yCoordinate = 3;

        chessBoard.add(pawn1, xCoordinate, yCoordinate, pawn1.getPieceColor());
        chessBoard.add(pawn2, xCoordinate, yCoordinate, pawn2.getPieceColor());

        assertEquals(xCoordinate, pawn1.getXCoordinate(), "The X coordinate is not correct");
        assertEquals(yCoordinate, pawn1.getYCoordinate(), "The Y coordinate is not correct");
        assertEquals(INVALID_COORDINATE, pawn2.getXCoordinate(), "The X coordinate is not correct");
        assertEquals(INVALID_COORDINATE, pawn2.getYCoordinate(), "The Y coordinate is not correct");
    }

    @Test
    public void testAdd_whenBlackPawnIsSetInTheWrongPosition_thenPawnIsNotAddedToBoard() {
        Pawn pawn = new Pawn(PieceColor.BLACK);

        chessBoard.add(pawn, 5, 3, pawn.getPieceColor());
        assertEquals(INVALID_COORDINATE, pawn.getXCoordinate());
        assertEquals(INVALID_COORDINATE, pawn.getYCoordinate());

    }

    @Test
    public void testAdd_whenWhitePawnIsSetInTheWrongPosition_thenPawnIsNotAddedToBoard() {
        Pawn pawn = new Pawn(PieceColor.WHITE);

        chessBoard.add(pawn, 5, 3, pawn.getPieceColor());
        assertEquals(INVALID_COORDINATE, pawn.getXCoordinate());
        assertEquals(INVALID_COORDINATE, pawn.getYCoordinate());

    }

}
