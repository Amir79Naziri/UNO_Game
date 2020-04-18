import java.util.LinkedList;

/**
 * this class represents SkipCard
 * this extends ColorCard
 * @see ColorCard
 * @author Amir Naziri
 */
public class SkipCard extends ColorCard
{
    /**
     * create a new Skip card
     * @param color color of card
     */
    private SkipCard (Color color)
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
        return gameHandler.getBoard ().getCardOnBoard () instanceof SkipCard;
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


        updateTurn (gameHandler,2);
        return true;
    }

    @Override
    public boolean equals (Object o)
    {
        if (!(super.equals (o))) return false;
        if (o == this) return true;
        return o instanceof SkipCard;
    }

    /**
     * this static method will produce 8 of this cards in 4 color
     * @return list of cards
     */
    public static LinkedList<Card> produceCards ()
    {
        LinkedList<Card> list = new LinkedList<> ();

        for (int i = 0; i < 2; i++)
        {
            list.add (new SkipCard (Color.YELLOW));
            list.add (new SkipCard (Color.RED));
            list.add (new SkipCard (Color.GREEN));
            list.add (new SkipCard (Color.BLUE));
        }
        return list;
    }
}
