import java.util.LinkedList;



public class WildDrawCard extends WildCard
    implements DrawType
{
    private WildDrawCard () {}


    public boolean use (GameHandler gameHandler, Color color)
    {
        if (!super.canUse (gameHandler))
            return false;
        if (!(super.use (gameHandler, color)))
        {
            gameHandler.getStorage ().addCard (gameHandler.getBoard ().changeCardOnBoard (this));
            gameHandler.getBoard ().changeColor (color);
            updateTurn (gameHandler,1);
        }


        if (!(gameHandler.getPlayerWhoIsTurn ().canUseWildCard (gameHandler) &&
                gameHandler.getPlayerWhoIsTurn ().hasWildDraw ()))
        {
            giveCardToPlayer (gameHandler);
            gameHandler.getSequenceKeeper ().finishSeqWD ();
            updateTurn (gameHandler,1);
        }
        else
        {
            gameHandler.getPlayerWhoIsTurn ().setShouldUseWildDraw (true);
            gameHandler.getSequenceKeeper ().increaseSeqWD ();
        }

        return true;
    }


    public void giveCardToPlayer (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return;
        LinkedList<Card> cards = gameHandler.getStorage ().
                CardsForPlayer (gameHandler.getSequenceKeeper ().getSeqWD () * 4);
        if (cards != null)
            gameHandler.getPlayerWhoIsTurn ().addCards (cards);
    }

    public boolean equals (Object o)
    {
        if (!(super.equals (o))) return false;
        if (o == this) return true;
        return o instanceof WildDrawCard;
    }

    public static LinkedList<Card> produceCards ()
    {
        LinkedList<Card> list = new LinkedList<> ();

        for (int i = 0; i < 4; i++)
        {
            list.add (new WildDrawCard ());
        }
        return list;
    }
}
