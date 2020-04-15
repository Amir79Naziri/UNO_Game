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

        return board.getColor () == this.getColor ();
    }

    public boolean use (GameDirection dir, Turn turn, Board board,Color color,
                        Storage storage, Player[] players, int sequence)
    {
        if (!canUse (board))
            return false;
        storage.addCard (board.changeCardOnBoard (this));
        board.changeColor (this.getColor ());
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
