import java.util.LinkedList;

public class SkipCard extends ColorCard
{
    private SkipCard (Color color)
    {
        super(color);
    }



    public boolean act (GameDirection dir, Turn turn, Board board, Color color, Storage storage)
    {
        boolean result = super.act (dir,turn,board,color,storage);
        if (result)
            return true;
        if (board.getCardOnBoard () instanceof SkipCard)
        {
            board.changeCardOnBoard (this);
            board.changeColor (this.getColor ());
            return true;
        }
        else
            return false;
    }

    public void updateTurn (GameDirection dir, Turn turn)
    {
        if (turn == null)
            return;
        turn.changeTurn (dir,2);
    }

    public static LinkedList<Card> produceCards ()
    {
        LinkedList<Card> list = new LinkedList<> ();

        for (int i = 0; i < 4; i++)
        {
            list.add (new SkipCard (Color.YELLOW));
            list.add (new SkipCard (Color.RED));
            list.add (new SkipCard (Color.GREEN));
            list.add (new SkipCard (Color.BLUE));
        }
        return list;
    }
}
