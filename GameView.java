/**
 * This is the class to handle display and receiving input
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GameView {
    private BufferedReader br;
    private String EOL;

    public GameView() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.EOL = System.getProperty("line.separator");
    }

    public void displayWelcome() {
        System.out.println(EOL + EOL +
                           "**********************************" + EOL +
                           "****  Welcome to BattleShip!  ****" + EOL +
                           "**********************************" + EOL + EOL +
                           "This is a traditional game of BattleShip. The board has rows" + EOL +
                           "1 through 10 inclusive and columns A through J inclusive." + EOL + EOL +
                           "   A B C D E F G H I J" + EOL +
                           "1" + EOL +
                           "2" + EOL +
                           "3" + EOL +
                           "4" + EOL +
                           "5" + EOL +
                           "6" + EOL +
                           "7" + EOL +
                           "8" + EOL +
                           "9" + EOL +
                           "10" + EOL + EOL +
                           "A typical fire location is: row,col (e.g. 3,J)" + EOL +
                           "To display your radar, type \"radar\"" + EOL +
                           "To display your board, type \"board\"" + EOL + EOL);
    }

    /**
     * Asks the user to input the number of players and returns it
     * @return Will return either 1 or 2 if those are input by the user. Will
     * return -1 if there was an error.
     */
    public int getNumPlayers() {
        System.out.println("Will there be 1 or 2 players?: ");
        int numPlayers = -1;

        try {
            String playerNumInput = br.readLine();
            int inputNum = Integer.parseInt(playerNumInput);
            if(inputNum > 2 || inputNum < 1)
                System.err.println("Please enter either 1 or 2");
            else
                numPlayers = inputNum;
        }
        catch(NumberFormatException nfe) {
            System.err.println("Please enter either 1 or 2");
        }
        catch(IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }

        return numPlayers;
    }

    /**
     * Asks the user for the location to fire at
     * @return Returns a Coordinate object. It will be the default object with
     * -1,-1 if there was a problem, otherwise the values will be the location
     *  to shoot at.
     */
    public Coordinate fire() {
        System.out.print("Enter where you would like to fire (e.g. row,col): ");
        String fireInput = "";
        Coordinate fireLocation = new Coordinate();

        try {
            fireInput = this.br.readLine();
            fireLocation = parseShot(fireInput);
        }
        catch(IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
        catch(IllegalArgumentException iae) {
            System.err.println("Invalid input. Please input coordinates as row,col");
        }

        return fireLocation;
    }


    /* Parses the input string checking the bounds. Returns the Coordinate if
     * the input was valid, otherwise it returns the default Coordinate object
     * with -1,-1 */
    private Coordinate parseShot(String fireInput) throws IllegalArgumentException {
        String[] tokens = fireInput.split(",");

        /* Saves us from an ArrayIndexOutOfBoundsException */
        if(tokens.length < 2)
            throw new IllegalArgumentException();

        // woot autobox
        Integer row = 0;

        /* Get the row from the input or return false with an error */
        try {
            row = Integer.parseInt(tokens[0]);
        }
        catch(NumberFormatException nfe) {
            throw new IllegalArgumentException();
        }

        // trim will clear the whitespace so "1, J" is also valid
        // since the " J" token becomes "J"
        char columnChar = tokens[1].trim().charAt(0);
        Integer col = 0;

        if(columnChar >= 65 && columnChar <= 74)
            col = columnChar - 64; // A -> 1, B -> 2, etc.
        else if(columnChar >= 97 && columnChar <= 106)
            col = columnChar - 96; // a -> 1, b -> 2, etc.

        /* row between 1:10 column between A:J */
        if(row >= 1 && row <= 10 && col >= 1 && col <= 10)
            return new Coordinate(row, col);
        else
            return new Coordinate();
    }

    public void displayBoard(Board board) {
        char[][] playerBoard = board.getBoard();
        StringBuilder sb = new StringBuilder();

        /* Add the row of alphabet labels */
        sb.append("  ");
        for(int i = 1; i < playerBoard[0].length; i++)
            sb.append(" " + (char)(i+64));

        /* Start adding the rows of the board
         * Start at 1 because we already did row 0 */
        for(int i = 1; i < playerBoard.length; i++) {
            if(i < 10)
                sb.append(EOL + i + "  ");
            else
                sb.append(EOL + i + " ");
            for(int j = 1; j < playerBoard[i].length; j++) {
                sb.append(playerBoard[i][j] + " ");
            }
        }

        sb.append(EOL);
        System.out.println(sb.toString());
    }
}
