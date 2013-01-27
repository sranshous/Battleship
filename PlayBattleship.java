/**
 * Driver class.
 */
public class PlayBattleship {
    public static void main(String[] args) {
        GameController gc = new GameController();
        gc.gameSetup();
        gc.play();
        System.out.println();
        System.out.println("Thank you for playing Battleship.");
    }
}
