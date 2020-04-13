import java.util.LinkedList;


public class GameMultiPlayer extends Game
{


    public GameMultiPlayer (int numOfPlayer)
    {
        super(numOfPlayer);
    }


    public boolean starterGameForPlayers ()
    {
        for (int i = 0; i < getNumOfPlayer (); i++)
        {
            LinkedList<Card> cardsForPlayer = getStorage ().CardsForPlayer (7);
            if (cardsForPlayer == null)
                return false;

            getPlayers ()[i] = new HumanPlayer (cardsForPlayer);
        }
        return true;
    }

}
