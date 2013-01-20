public class BoardTest {
    public static void main(String[] args) {
        System.out.println("---- Creating a default board ----");
        Board b1 = new Board(); // default constructor test
        System.out.println("---- Printing the default board ----");
        System.out.println(b1);

        /* Does the board think it has ships when it doesn't */
        System.out.println("Board has ships: " + b1.hasShipsLeft());

        /* Test adding ships */
        System.out.println("\n---- Adding ships to the board ----");
        System.out.println("---- Trying to add ship of length 3 to 0, 7 h ----");
        System.out.println(b1.placeShip(0, 7, 3, 'h')); // should fail because row cannot be 0

        System.out.println("---- Trying to add ship of length 3 to 0, 7 V ----");
        System.out.println(b1.placeShip(-1, 9, 2, 'V')); // should fail because row cannot be -1

        System.out.println("---- Trying to add ship of length 3 to 1, 7 h ----");
        System.out.println(b1.placeShip(1, 7, 3, 'h')); // should pass

        System.out.println("---- Trying to add ship of length 5 to 3, 3 v ----");
        System.out.println(b1.placeShip(3, 3, 5, 'v')); // should pass

        System.out.println("---- Trying to add ship of length 3 to 6, 1 H ----");
        System.out.println(b1.placeShip(6, 1, 3, 'H')); // should fail because ship at 3,3

        System.out.println("---- Trying to add ship of length 3 to 3, 0 h ----");
        System.out.println(b1.placeShip(3, 0, 3, 'h')); // should fail because col cannot be 0
        System.out.println("\n---- Board after trying to add the ships ----");
        System.out.println(b1);

        /* Does the board think it has ships when it does */
        System.out.println("Board has ships: " + b1.hasShipsLeft());

        /* Test the checkShot method */
        System.out.println("\n---- Testing the checkShot method ----");
        System.out.println("Shooting 7, 3: " + b1.checkShot(7, 3)); // should hit
        System.out.println("Shooting 1, 9: " + b1.checkShot(1, 9)); // should hit
        System.out.println("Shooting -1, 3: " + b1.checkShot(-1, 3)); // should fail
        System.out.println("Shooting 8, -1: " + b1.checkShot(8, -1)); // should fail
        System.out.println("Shooting 5, 5: " + b1.checkShot(5, 5)); // should fail
        System.out.println("Shooting 3, 3: " + b1.checkShot(3, 3)); // should hit
        System.out.println("Shooting 0, 8: " + b1.checkShot(0, 8)); // should fail
        System.out.println("Shooting 8, 0: " + b1.checkShot(8, 0)); // should fail
        System.out.println("Shooting 11, 5: " + b1.checkShot(11, 5)); // should fail

        /* Print the new board after the shooting to test the changing chars */
        System.out.println("\n---- Printing board after shots ----");
        System.out.println(b1);
        System.out.println("Board has ships: " + b1.hasShipsLeft());

        /* Destroy a ship and check the ships left method, then end the game
         * and check again */
        System.out.println("Shooting 1, 7: " + b1.checkShot(1, 7)); // should hit
        System.out.println("Shooting 1, 8: " + b1.checkShot(1, 8)); // should hit
        System.out.println("Shooting 4, 3: " + b1.checkShot(4, 3)); // should hit
        System.out.println("Shooting 5, 3: " + b1.checkShot(5, 3)); // should hit
        System.out.println("Shooting 6, 3: " + b1.checkShot(6, 3)); // should hit

        System.out.println("\n---- No ships should be remaining ----");
        System.out.println("Board has ships: " + b1.hasShipsLeft());
        System.out.println(b1);
    }
}
