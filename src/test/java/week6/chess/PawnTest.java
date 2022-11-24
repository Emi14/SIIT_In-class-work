package week6.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.week6.testing.chess.ChessBoard;
import org.siit.week6.testing.chess.MovementType;
import org.siit.week6.testing.chess.Pawn;
import org.siit.week6.testing.chess.PieceColor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    private Pawn pawn;
    private ChessBoard chessBoard;

    @BeforeEach
    public void setUp() {
        chessBoard = new ChessBoard();
        pawn = new Pawn(PieceColor.BLACK);
        pawn.setChessBoard(chessBoard);
    }

    @Test
    public void testMove_whenMovementTypeIsMoveAndNewPositionIsInvalid_thenPawnIsNotMoved() {
        pawn.setXCoordinate(6);
        pawn.setYCoordinate(3);

        int initialX = pawn.getXCoordinate();
        int initialY = pawn.getYCoordinate();
        pawn.move(MovementType.MOVE, initialX, initialY + 1);

        assertEquals(initialX, pawn.getXCoordinate());
        assertEquals(initialY, pawn.getYCoordinate());
    }
}
