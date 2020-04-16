import java.util.LinkedList;

public abstract class WildCard extends Card
{

    public boolean canUse (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return false;
        return gameHandler.getBoard () != null;
    }

    public boolean use (GameHandler gameHandler, Color color)
    {
        if (!canUse (gameHandler))
            return false;
        gameHandler.getStorage ().addCard (gameHandler.getBoard ().changeCardOnBoard (this));
        gameHandler.getBoard ().changeColor (color);
        updateTurn (gameHandler,1);
        return true;
    }

    public boolean equals (Object o)
    {
        if (o == this) return true;
        return o instanceof WildCard;
    }

    public static LinkedList<Card> produceCards ()
    {
        LinkedList<Card> cards = new LinkedList<> ();
        cards.addAll (WildColorCard.produceCards ()); // wildColor
        cards.addAll (WildDrawCard.produceCards ()); // wildDraw
        return cards;
    }
}
