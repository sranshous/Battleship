/**
 * An easier way to transport coordinate data
 */
public class Coordinate {
    public int row;
    public int col;

    public Coordinate() {
        this.row = -1;
        this.col = -1;
    }

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public String toString() {
        return "Row: " + row + "\tCol: " + col;
    }
}
