public class GameViewTest {
    public static void main(String[] args) {
        /* Create a PlayerBoard and place some ships */
        System.out.println("---- Creating a Board and placing ships ----");
        PlayerBoard b = new PlayerBoard();
        b.placeShip(3, 3, 3, 'h');
        b.placeShip(5, 9, 2, 'v');
        b.placeShip(1, 7, 4, 'h');
        b.placeShip(2, 6, 5, 'h');

        /* Create a Radar and make some marks */
        System.out.println("\n---- Creating a Radar and marking ----");
        Radar r = new Radar();
        r.markRadar(3, 3, 'm');
        r.markRadar(9, 1, 'h');
        r.markRadar(1, 7, 'm');
        r.markRadar(4, 10, 'H');

        /* Create a GameView and display things */
        System.out.println("\n---- Creating the GameView and printing ----");
        GameView gv = new GameView();
        gv.displayWelcome();
        gv.displayBoard(b);
        gv.displayBoard(r);

        /* Test asking user for number of players */
        System.out.println("\n---- Testing getNumPlayers ----");
        int numPlayers = -10000;
        numPlayers = gv.getNumPlayers(); // 1
        System.out.println("numPlayers = " + numPlayers);
        numPlayers = gv.getNumPlayers(); // 2
        System.out.println("numPlayers = " + numPlayers);
        numPlayers = gv.getNumPlayers(); // 0
        System.out.println("numPlayers = " + numPlayers);
        numPlayers = gv.getNumPlayers(); // -1
        System.out.println("numPlayers = " + numPlayers);
        numPlayers = gv.getNumPlayers(); // 3
        System.out.println("numPlayers = " + numPlayers);

        /* Test the fire command */
        System.out.println("\n---- Testing the fire command ----");
        Coordinate c = null;
        c = gv.fire(); // 2,J
        System.out.println("The coordinate was " + c);
        c = gv.fire(); //  1,B
        System.out.println("The coordinate was " + c);
        c = gv.fire(); // 8, E
        System.out.println("The coordinate was " + c);
        c = gv.fire(); // 0,A
        System.out.println("The coordinate was " + c);
        c = gv.fire(); // 11,G
        System.out.println("The coordinate was " + c);
        c = gv.fire(); // -1,A
        System.out.println("The coordinate was " + c);
    }
}
