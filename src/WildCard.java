import java.util.LinkedList;

public abstract class WildCard
        implements Card
{

    public boolean act (GameDirection dir, Turn turn, Board board, Color color, Storage storage,
                        Player[] players)
    {
        if (board == null)
            return false;
        board.changeCardOnBoard (this);
        board.changeColor (color);
        return true;
    }



    public static LinkedList<Card> produceCards ()
    {
        LinkedList<Card> cards = new LinkedList<> ();
        cards.addAll (WildColorCard.produceCards ()); // wildColor
        cards.addAll (WildDrawCard.produceCards ()); // wildDraw
        return cards;
    }
}
