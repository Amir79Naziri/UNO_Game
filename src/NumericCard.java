import java.util.LinkedList;

public class NumericCard extends ColorCard
{
    private int number;

    private NumericCard (Color color, int number)
    {
        super(color);
        this.number = number;
    }


    public int getNumber () {
        return number;
    }


    public boolean act (GameDirection dir, Turn turn, Board board,Color color, Storage storage)
    {
        if (board == null)
            return false;

        boolean result = super.act (dir,turn,board,color,storage);
        if (result)
            return true;

        if (board.getCardOnBoard () instanceof NumericCard &&
                ((NumericCard)(board.getCardOnBoard ())).getNumber () == this.getNumber ())
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
        turn.changeTurn (dir,1);
    }


    public static LinkedList<Card> produceCards ()
    {
        LinkedList<Card> list = new LinkedList<> ();

        for (int i = 0; i < 10; i++)
        {
            if (i == 0)
            {
                for (int j = 0; j < 1; j++)
                {
                    list.add (new NumericCard (Color.BLUE,i));
                    list.add (new NumericCard (Color.RED,i));
                    list.add (new NumericCard (Color.GREEN,i));
                    list.add (new NumericCard (Color.YELLOW,i));
                }
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
