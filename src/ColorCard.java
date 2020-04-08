import java.util.LinkedList;

public abstract class ColorCard
        implements Card
{
    private Color color;


    public ColorCard (Color color)
    {
        this.color = color;
    }


    public boolean act (GameDirection dir, Turn turn, Board board,Color color,
                        Storage storage)
    {
        if (board == null)
            return false;

        if (board.getCardOnBoard () instanceof ColorCard)
        {
            if (board.getColor () == this.getColor ())
            {
                board.changeCardOnBoard (this);
                board.changeColor (this.getColor ());
                return true;
            }
            else return false;
        }
        else return false;
    }

    public Color getColor () {
        return color;
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
