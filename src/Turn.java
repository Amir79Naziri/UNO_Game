import java.util.Random;

/**
 * this class represents turn in game
 *
 * @author Amir Naziri
 */
public class Turn
{
    private static Turn turn = null; // instance of turn
    private int numberOfPlayers; // number of players
    private int whoIsTurn; // who is turn now

    /**
     * creates a Turn object for game
     * @param numberOfPlayers number of Players
     */
    private Turn (int numberOfPlayers)
    {
        Random random = new Random ();
        this.numberOfPlayers = numberOfPlayers;
        whoIsTurn = random.nextInt (numberOfPlayers) + 1;
    }

    /**
     * create a new instance for turn
     * @param numberOfPlayers number of players
     * @return Turn
     */
    public static Turn getInstance (int numberOfPlayers)
    {
        if (turn == null)
        {
            turn = new Turn (numberOfPlayers);
        }
        return turn;
    }

    /**
     * @return who is turn
     */
    public int getWhoIsTurn () {
        return whoIsTurn;
    }

    /**
     * change the turn
     * @param add unit for changing Turn
     */
    private void changeWhoIsTurn (int add)
    {
        whoIsTurn += add;
        whoIsTurn = whoIsTurn % numberOfPlayers;
        if (whoIsTurn < 0)
            whoIsTurn += numberOfPlayers;
        if (whoIsTurn == 0)
            whoIsTurn = numberOfPlayers;
    }

    /**
     * change turn in a dir direction with a unit
     * @param dir driection
     * @param addToTurn unit
     */
    public void changeTurn (GameDirection dir, int addToTurn)
    {
        if (dir == null)
            return;
        if (dir.getDirection () == Direction.CLOCKWISE)
            changeWhoIsTurn (addToTurn);
        if (dir.getDirection () == Direction.COUNTERCLOCKWISE)
            changeWhoIsTurn (-addToTurn);
    }
}
