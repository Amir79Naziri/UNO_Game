import java.util.LinkedList;

/**
 * this abstract class represents a color card type
 * it extends Card class
 * @see Card
 * @author Amir Naziri
 */
public abstract class ColorCard extends Card
{
    private Color color; // color of card

    /**
     * creates a new Color Card
     * @param color color
     */
    public ColorCard (Color color)
    {
        this.color = color;
    }

    @Override
    public boolean canUse (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return false;
        if (gameHandler.getBoard () == null)
            return false;

        return gameHandler.getBoard ().getColor () == this.getColor (); // true if color's are
                                                                        // same
    }

    @Override
    public boolean use (GameHandler gameHandler, Color color)
    {
        if (gameHandler == null)
            return false;
        if (!canUse (gameHandler))
            return false;
        gameHandler.getStorage ().addCard (gameHandler.getBoard ().changeCardOnBoard (this));
        //changing the board state and add the previous card to storage
        gameHandler.getBoard ().changeColor (this.getColor ());
        //change color on board
        return true;
    }

    /**
     * @return color of card
     */
    public Color getColor () {
        return color;
    }

    @Override
    public boolean equals (Object o)
    {
        if (o == this) return true;
        if (!(o instanceof ColorCard)) return false;

        ColorCard that = (ColorCard)o;
        return this.getColor () == that.getColor (); // equal if have same color
    }

    /**
     * this static method creates Color cards for game
     * @return list of cards
     */
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
