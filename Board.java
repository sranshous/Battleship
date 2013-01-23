public abstract class Board {
    protected int boardWidth, boardHeight;
    protected char[][] board;

    abstract protected void boardInit();
    abstract protected char[][] getBoard();
}
