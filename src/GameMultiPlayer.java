import java.util.LinkedList;


public class GameMultiPlayer extends Game
{


    public GameMultiPlayer (int numOfPlayer)
    {
        super(numOfPlayer);
    }


    public boolean starterGameForPlayers ()
    {
        for (int i = 0; i < getGameHandler ().getNumOfPlayer (); i++)
        {
            LinkedList<Card> cardsForPlayer = getGameHandler ().
                    getStorage ().CardsForPlayer (7);
            if (cardsForPlayer == null)
                return false;

            getGameHandler ().getPlayers ()[i] = new HumanPlayer (cardsForPlayer);
        }
        return true;
    }

}
