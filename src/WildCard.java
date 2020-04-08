import java.util.LinkedList;

public abstract class WildCard
        implements Card
{

    public boolean act (GameDirection dir, Turn turn, Board board, Color color, Storage storage)
    {
        if (board == null)
            return false;
        board.changeCardOnBoard (this);
        getNextColor (dir,turn,board,color);
        return true;
    }

    private void getNextColor (GameDirection dir, Turn turn, Board board, Color color)
    {
        if (board == null)
            return;
        board.changeColor (color);
    }

    public static LinkedList<Card> produceCards ()
    {
        LinkedList<Card> cards = new LinkedList<> ();
        cards.addAll (WildColorCard.produceCards ()); // wildColor
        cards.addAll (WildDrawCard.produceCards ()); // wildDraw
        return cards;
    }
}
