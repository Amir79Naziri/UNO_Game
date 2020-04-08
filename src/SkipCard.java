import java.util.LinkedList;

public class SkipCard extends ColorCard
{
    private SkipCard (Color color)
    {
        super(color);
    }


    public boolean canUse (Board board)
    {
        if (board == null)
            return false;
        if (super.canUse (board))
            return true;
        return board.getCardOnBoard () instanceof SkipCard;
    }

    public boolean use (GameDirection dir, Turn turn, Board board, Color color, Storage storage,
                        Player[] players)
    {
        if (!canUse (board))
            return false;
        if (super.use (dir, turn, board, color, storage, players))
        {
            updateTurn (dir,turn,2);
            return true;
        }

        board.changeCardOnBoard (this);
        board.changeColor (this.getColor ());
        updateTurn (dir,turn,2);
        return true;
    }


    public static LinkedList<Card> produceCards ()
    {
        LinkedList<Card> list = new LinkedList<> ();

        for (int i = 0; i < 2; i++)
        {
            list.add (new SkipCard (Color.YELLOW));
            list.add (new SkipCard (Color.RED));
            list.add (new SkipCard (Color.GREEN));
            list.add (new SkipCard (Color.BLUE));
        }
        return list;
    }
}
