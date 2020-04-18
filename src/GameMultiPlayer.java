import java.util.LinkedList;

/**
 * this class represents MultiPlayerGame
 * this extends Game
 * @see Game
 * @author Amir Naziri
 */
public class GameMultiPlayer extends Game
{

    /**
     * creates a new Multi Player Game
     * @param numOfPlayer number of Player
     */
    public GameMultiPlayer (int numOfPlayer)
    {
        super(numOfPlayer);
    }

    @Override
    public boolean starterGameForPlayers ()
    {
        for (int i = 0; i < getGameHandler ().getNumOfPlayer (); i++)
        {
            LinkedList<Card> cardsForPlayer = getGameHandler ().
                    getStorage ().CardsForPlayer (7);
            if (cardsForPlayer == null)
                return false;

            getGameHandler ().getPlayers ()[i] = new HumanPlayer (cardsForPlayer);
            // give 7 cards to player for start
        }
        return true;
    }

}
