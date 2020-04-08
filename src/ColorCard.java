import java.util.LinkedList;

public abstract class ColorCard extends Card
{
    private Color color;


    public ColorCard (Color color)
    {
        this.color = color;
    }

    public boolean canUse (Board board)
    {
        if (board == null)
            return false;

        if (board.getCardOnBoard () instanceof ColorCard)
        {
            return board.getColor () == this.getColor ();
        }
        return false;
    }

    public boolean use (GameDirection dir, Turn turn, Board board,Color color,
                        Storage storage, Player[] players)
    {
        if (!canUse (board))
            return false;
        board.changeCardOnBoard (this);
        board.changeColor (this.getColor ());
        return true;
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
