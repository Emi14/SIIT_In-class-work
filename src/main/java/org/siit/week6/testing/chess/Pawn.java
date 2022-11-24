package org.siit.week6.testing.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
        if (!chessBoard.isLegalBoardPosition(newX, newY)) {
            return;
        }

        if (MovementType.MOVE == movementType) {
            if (!chessBoard.isPositionEmpty(newX, newY)) {
                return;
            }
            if (isPositionValidForMove(newX, newY)) {
                setXCoordinate(newX);
                setYCoordinate(newY);
            }
        } else {
            throw new UnsupportedOperationException("Need to implement Pawn.Move() when MovementType is Capture");
        }
    }

    private boolean isPositionValidForMove(int newX, int newY) {
        if (getPieceColor() == PieceColor.BLACK) {
            return getXCoordinate() - 1 == newX && getYCoordinate() == newY;
        }
        return false;
    }

    @Override
    public String toString() {
        return CurrentPositionAsString();
    }

    protected String CurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
}
