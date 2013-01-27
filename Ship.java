/**
 * A simple container for a ship to store its name and size
 */

public class Ship {
    public String name;
    public int size;

    public Ship() {
        this("Default", 0);
    }

    public Ship(String name, int size) {
        this.name = name;
        this.size = size;
    }
}
