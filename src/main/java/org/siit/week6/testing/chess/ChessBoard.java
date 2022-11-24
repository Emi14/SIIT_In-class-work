package org.siit.week6.testing.chess;

public class ChessBoard {
    public static final int INVALID_COORDINATE = -1;
    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH + 1][MAX_BOARD_HEIGHT + 1];
    }

    private static void setPawnInvalidCoordinates(Pawn pawn) {
        pawn.setXCoordinate(INVALID_COORDINATE);
        pawn.setYCoordinate(INVALID_COORDINATE);
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (isLegalBoardPosition(xCoordinate, yCoordinate)) {
            if ((PieceColor.BLACK == pieceColor && xCoordinate != MAX_BOARD_WIDTH - 1)
                    || (PieceColor.WHITE == pieceColor && xCoordinate != 1)) {
                setPawnInvalidCoordinates(pawn);
                return;
            }

            if (pieces[xCoordinate][yCoordinate] == null) {
                pieces[xCoordinate][yCoordinate] = pawn;
                pawn.setXCoordinate(xCoordinate);
                pawn.setYCoordinate(yCoordinate);
            } else {
                setPawnInvalidCoordinates(pawn);
            }
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        if (xCoordinate > MAX_BOARD_WIDTH || xCoordinate < 0) {
            return false;
        }
        return yCoordinate <= MAX_BOARD_HEIGHT && yCoordinate >= 0;
    }

    public boolean isPositionEmpty(int xCoordinate, int yCoordinate) {
        return pieces[xCoordinate][yCoordinate] == null;
    }
}
