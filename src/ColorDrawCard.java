import java.util.LinkedList;

/**
 * this class represents colorDraw (Draw 2+) card
 * this extends Color card
 * @see ColorCard
 * @author Amir Naziri
 */
public class ColorDrawCard extends ColorCard
    implements DrawType

{
    /**
     * creates a new ColorDrawCard
     * @param color color of Card
     */
    private ColorDrawCard (Color color)
    {
        super(color);
    }

    @Override
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

    @Override
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
        if (!(gameHandler.getPlayerWhoIsTurn ().hasColorDraw ())) // this is for checking rule
                                                                  // of Draw cards
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

    @Override
    public void giveCardToPlayer (GameHandler gameHandler)
    {
        LinkedList<Card> cards;
        if (gameHandler == null)
            return;

        cards = gameHandler.getStorage ().
                CardsForPlayer (gameHandler.getSequenceKeeper ().getSeqND () * 2);
        // give new cards to list of cards

        if (cards != null)
            gameHandler.getPlayerWhoIsTurn ().addCards (cards);
        // give list to player
    }

    @Override
    public boolean equals (Object o)
    {
        if (!(super.equals (o))) return false;
        if (o == this) return true;
        return o instanceof ColorDrawCard;
    }

    /**
     * this static method creates cards for game : 8 of this card with 4 colors
     * @return list of cards
     */
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
