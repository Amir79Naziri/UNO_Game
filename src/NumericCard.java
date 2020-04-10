import java.util.LinkedList;

public class NumericCard extends ColorCard
{
    private int number;


    public NumericCard (Color color, int number)
    {
        super(color);
        this.number = number;
    }


    public int getNumber () {
        return number;
    }


    public boolean canUse (Board board)
    {
        if (board == null)
            return false;
        if (super.canUse (board))
            return true;

        return board.getCardOnBoard () instanceof NumericCard &&
                ((NumericCard) (board.getCardOnBoard ())).getNumber () == this.getNumber ();
    }

    public boolean use (GameDirection dir, Turn turn, Board board,Color color, Storage storage,
                        Player[] players)
    {
        if (!canUse (board))
            return false;
        if (super.use (dir, turn, board, color, storage, players))
        {
            updateTurn (dir,turn,1);
            return true;
        }
        storage.addCard (board.changeCardOnBoard (this));
        board.changeColor (this.getColor ());
        updateTurn (dir,turn,1);
        return true;
    }


    public static LinkedList<Card> produceCards ()
    {
        LinkedList<Card> list = new LinkedList<> ();

        for (int i = 0; i < 10; i++)
        {
            if (i == 0)
            {
                list.add (new NumericCard (Color.BLUE,i));
                list.add (new NumericCard (Color.RED,i));
                list.add (new NumericCard (Color.GREEN,i));
                list.add (new NumericCard (Color.YELLOW,i));
            }
            else
            {
                for (int j = 0; j < 2; j++)
                {
                    list.add (new NumericCard (Color.BLUE,i));
                    list.add (new NumericCard (Color.RED,i));
                    list.add (new NumericCard (Color.GREEN,i));
                    list.add (new NumericCard (Color.YELLOW,i));
                }
            }
        }
        return list;
    }
}
