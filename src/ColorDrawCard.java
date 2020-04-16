import java.util.LinkedList;


public class ColorDrawCard extends ColorCard
    implements DrawType

{
    private ColorDrawCard (Color color)
    {
        super(color);
    }


    public boolean canUse (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return false;
        if (gameHandler.getBoard () == null)
            return false;
        if (super.canUse (gameHandler))
            return true;
        return gameHandler.getBoard ().getCardOnBoard () instanceof ColorDrawCard;
    }

    public boolean use (GameHandler gameHandler, Color color)
    {
        if (!canUse (gameHandler))
            return false;
        if (!(super.use (gameHandler, color)))
        {
            gameHandler.getStorage ().addCard (gameHandler.getBoard ().changeCardOnBoard (this));
            gameHandler.getBoard ().changeColor (this.getColor ());
        }

        updateTurn (gameHandler,1);
        if (!(gameHandler.getPlayerWhoIsTurn ().hasColorDraw ()))
        {
            giveCardToPlayer (gameHandler);
            gameHandler.getSequenceKeeper ().finishSeqND ();
            updateTurn (gameHandler,1);
        }
        else
        {
            gameHandler.getPlayerWhoIsTurn ().setShouldUseDraw (true);
            gameHandler.getSequenceKeeper ().increaseSeqND ();
        }
        return true;
    }


    public void giveCardToPlayer (GameHandler gameHandler)
    {
        LinkedList<Card> cards;
        if (gameHandler == null)
            return;

        cards = gameHandler.getStorage ().
                CardsForPlayer (gameHandler.getSequenceKeeper ().getSeqND () * 2);

        if (cards != null)
            gameHandler.getPlayerWhoIsTurn ().addCards (cards);
    }

    public boolean equals (Object o)
    {
        if (!(super.equals (o))) return false;
        if (o == this) return true;
        return o instanceof ColorDrawCard;
    }

    public static LinkedList<Card> produceCards ()
    {
        LinkedList<Card> list = new LinkedList<> ();

        for (int i = 0; i < 2; i++)
        {
            list.add (new ColorDrawCard (Color.YELLOW));
            list.add (new ColorDrawCard (Color.RED));
            list.add (new ColorDrawCard (Color.GREEN));
            list.add (new ColorDrawCard (Color.BLUE));
        }
        return list;
    }

}
