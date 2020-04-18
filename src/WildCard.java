import java.util.LinkedList;

/**
 * this abstract class represents a wild card type
 * it extends Card class
 * @see Card
 * @author Amir Naziri
 */
public abstract class WildCard extends Card
{

    @Override
    public boolean canUse (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return false;
        return gameHandler.getBoard () != null;
    }

    @Override
    public boolean use (GameHandler gameHandler, Color color)
    {
        if (!canUse (gameHandler))
            return false;
        gameHandler.getStorage ().addCard (gameHandler.getBoard ().changeCardOnBoard (this));
        gameHandler.getBoard ().changeColor (color);
        updateTurn (gameHandler,1);
        return true;
    }

    @Override
    public boolean equals (Object o)
    {
        if (o == this) return true;
        return o instanceof WildCard;
    }

    /**
     * this static method creates wild cards for game
     * @return list of cards
     */
    public static LinkedList<Card> produceCards ()
    {
        LinkedList<Card> cards = new LinkedList<> ();
        cards.addAll (WildColorCard.produceCards ()); // wildColor
        cards.addAll (WildDrawCard.produceCards ()); // wildDraw
        return cards;
    }
}
