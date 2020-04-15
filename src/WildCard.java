import java.util.LinkedList;

public abstract class WildCard extends Card
{

    public boolean canUse (Board board)
    {
        return board != null;
    }

    public boolean use (GameDirection dir, Turn turn, Board board, Color color, Storage storage,
                        Player[] players, SequenceKeeper sequence)
    {
        if (!canUse (board))
            return false;
        storage.addCard (board.changeCardOnBoard (this));
        board.changeColor (color);
        updateTurn (dir,turn,1);
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
