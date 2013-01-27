/**
 * This class will control the flow of the game and enforce rules
 */

import java.util.HashMap;

public class GameController {
    private GameView gv;
    private int numPlayers;
    private PlayerBoard[] playerBoards;
    private Radar[] playerRadars;
    private HashMap<Integer, Ship> ships;
    private static final int PLAYER_ONE = 1;
    private static final int PLAYER_TWO = 2;
    private static final int AI = 2;
    private static final Integer NUM_SHIPS = 5;

    public GameController() {
        this.gv = new GameView();
        this.numPlayers = -1;

        this.playerBoards = new PlayerBoard[2];
        for(int i = 0; i < this.playerBoards.length; i++)
            playerBoards[i] = new PlayerBoard();

        this.playerRadars = new Radar[2];
        for(int i = 0; i < this.playerRadars.length; i++)
            playerRadars[i] = new Radar();

        shipsInit();
    }

    private void shipsInit() {
        this.ships = new HashMap<Integer, Ship>();
        this.ships.put(0, new Ship("Patrol Boat", 2));
        this.ships.put(1, new Ship("Destroyer", 3));
        this.ships.put(2, new Ship("Submarine", 3));
        this.ships.put(3, new Ship("Battleship", 4));
        this.ships.put(4, new Ship("Aircraft Carrier", 5));
    }

    /**
     * Do the initial setup of the board required before play begins
     */
    public void gameSetup() {
        this.gv.displayWelcome();

        /* Loop til they get the point you get 1 or 2 players */
        while(this.numPlayers < 1 || this.numPlayers > 2)
            this.numPlayers = gv.getNumPlayers();

        switch(this.numPlayers) {
            /* Default to single player mode */
            default:
            case 1:
                setupPlayerBoard(PLAYER_ONE);
                break;
            case 2:
                setupPlayerBoard(PLAYER_ONE);
                setupPlayerBoard(PLAYER_TWO);
        }
    }

    /* Get the player to put all their ships on the board */
    private void setupPlayerBoard(int playerNum) {
        for(int i = 0; i < NUM_SHIPS; i++) {
            /* Display their current board setup and get next ship */
            System.out.println(String.format("Player %d's board", playerNum));
            gv.displayBoard(this.playerBoards[playerNum]);

            Coordinate shipLocation = new Coordinate();
            char orientation = '\0';
            boolean validSpot = true;
            Ship ship = ships.get(i);

            while(shipLocation.row < 1 || shipLocation.row > 10 || orientation == '\0' ||
                  shipLocation.col < 1 || shipLocation.col > 10 || !validSpot) {
                shipLocation = gv.getShipPlacement(playerNum, ship);
                orientation = gv.getShipOrientation();
                validSpot = this.playerBoards[playerNum].placeShip(shipLocation.row, shipLocation.col, ship.size, orientation);
                /* Debug output */
                System.out.println("" + shipLocation.row + " " + shipLocation.col + " " + orientation + " " + validSpot);
            }
        }
    }

    /**
     * Play the game that has been setup
     */
    public void play() {
        switch(this.numPlayers) {
            /* Default to single player mode */
            default:
            case 1:
                playSinglePlayer();
                break;
            case 2:
                playTwoPlayer();
                break;
        }
    }

    private void playSinglePlayer() {
        /* Put off until AI is created */
    }

    private void playTwoPlayer() {
        boolean playerOnesTurn = true; // could use a counter and do the % 2 trick but meh

        while(playerBoards[0].hasShipsLeft() && playerBoards[1].hasShipsLeft()) {
            if(playerOnesTurn) {
                Coordinate shotLoc = new Coordinate();

                /* Loop til we get a valid shot from the user */
                while(shotLoc.row < 1 || shotLoc.row > 10 || shotLoc.col < 1 || shotLoc.col > 10) {
                    shotLoc = this.gv.fire(PLAYER_ONE);
                }

            }
        }
    }
}
