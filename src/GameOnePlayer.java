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
        int indexOfHumanPlayer = random.nextInt (getNumOfPlayer ());
        for (int i = 0; i < getNumOfPlayer (); i++)
        {
            LinkedList<Card> cardsForPlayer = getStorage ().CardsForPlayer (7);
            if (cardsForPlayer == null)
                return false;

            if (i == indexOfHumanPlayer)
                getPlayers ()[i] = new HumanPlayer (cardsForPlayer);
            else
                getPlayers ()[i] = new MachinePlayer (cardsForPlayer);
        }
        return true;
    }

}
