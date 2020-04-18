import java.util.LinkedList;
import java.util.Random;
/**
 * this class represents OnePlayerGame
 *
 * @author Amir Naziri
 */
public class GameOnePlayer extends Game
{

    /**
     * creates a new One Player Game
     * @param numOfPlayer number of Player
     */
    public GameOnePlayer (int numOfPlayer)
    {
        super(numOfPlayer);
    }

    @Override
    public boolean starterGameForPlayers ()
    {
        Random random = new Random ();
        int indexOfHumanPlayer = random.nextInt (getGameHandler ().getNumOfPlayer ());
        for (int i = 0; i < getGameHandler ().getNumOfPlayer (); i++)
        {
            LinkedList<Card> cardsForPlayer = getGameHandler ().
                    getStorage ().CardsForPlayer (7);
            if (cardsForPlayer == null)
                return false;

            if (i == indexOfHumanPlayer) // choose one of player for being human randomly
                getGameHandler ().getPlayers ()[i] = new HumanPlayer (cardsForPlayer);
            else
                getGameHandler ().getPlayers ()[i] = new MachinePlayer (cardsForPlayer);
            // gives 7 cards to player for Start
        }
        return true;
    }

}
