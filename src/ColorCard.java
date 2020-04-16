import java.util.LinkedList;

public abstract class ColorCard extends Card
{
    private Color color;


    public ColorCard (Color color)
    {
        this.color = color;
    }

    public boolean canUse (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return false;
        if (gameHandler.getBoard () == null)
            return false;

        return gameHandler.getBoard ().getColor () == this.getColor ();
    }

    public boolean use (GameHandler gameHandler, Color color)
    {
        if (gameHandler == null)
            return false;
        if (!canUse (gameHandler))
            return false;
        gameHandler.getStorage ().addCard (gameHandler.getBoard ().changeCardOnBoard (this));
        gameHandler.getBoard ().changeColor (this.getColor ());
        return true;
    }

    public Color getColor () {
        return color;
    }


    public boolean equals (Object o)
    {
        if (o == this) return true;
        if (!(o instanceof ColorCard)) return false;

        ColorCard that = (ColorCard)o;
        return this.getColor () == that.getColor ();
    }


    public static LinkedList<Card> produceCards ()
    {
        LinkedList<Card> cards = new LinkedList<> ();
        cards.addAll (NumericCard.produceCards ()); // adding numeric
        cards.addAll (ReverseCard.produceCards ()); // adding reverse
        cards.addAll (SkipCard.produceCards ()); // adding skip
        cards.addAll (ColorDrawCard.produceCards ()); // colorDrawCard
        return cards;
    }

}
