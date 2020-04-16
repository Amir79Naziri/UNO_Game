import java.util.LinkedList;
import java.util.Random;

public class GameOnePlayer extends Game
{

    public GameOnePlayer (int numOfPlayer)
    {
        super(numOfPlayer);
    }


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

            if (i == indexOfHumanPlayer)
                getGameHandler ().getPlayers ()[i] = new HumanPlayer (cardsForPlayer);
            else
                getGameHandler ().getPlayers ()[i] = new MachinePlayer (cardsForPlayer);
        }
        return true;
    }

}
