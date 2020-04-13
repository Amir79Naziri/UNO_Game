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

    public boolean play ()
    {
        if (!startGame ())
            return false;
        while (!stopGame ())
        {
            Card card;

            if (getPlayerWhoIsTurn ().hasMatchCard (getBoard ()))
            {
                card = getPlayerWhoIsTurn ().useCard (getUserInterface ().showForHumanPlayer
                                (getBoard (), getPlayerWhoIsTurn (),getTurn (),getDir (),
                                        getPlayers (),1),getBoard ());
            }
            else
            {
                getPlayerWhoIsTurn ().addCards (getStorage ().CardsForPlayer (1));
                if (getPlayerWhoIsTurn ().hasMatchCard (getBoard ()))
                {
                    card = getPlayerWhoIsTurn ().useCard (getUserInterface ().showForHumanPlayer
                            (getBoard (), getPlayerWhoIsTurn (),getTurn (),getDir (),
                                    getPlayers (),1),getBoard ());
                }
                else
                {
                    getUserInterface ().showForHumanPlayer (getBoard (),
                            getPlayerWhoIsTurn (),getTurn (),getDir (), getPlayers (),2);
                    getTurn ().changeTurn (getDir (),1);
                    continue;
                }
            }
            if (card == null)
                continue;
            getPlayerWhoIsTurn ().removeCard (card);
            if (card instanceof WildCard)
                card.use (getDir (),getTurn (),getBoard (),getUserInterface ().getColor (),
                        getStorage (),getPlayers ());
            else
                card.use (getDir (),getTurn (),getBoard (),Color.NON_COLOR,
                        getStorage (),getPlayers ());
        }
        return true;
    }





}
