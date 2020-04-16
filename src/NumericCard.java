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


    public boolean canUse (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return false;
        if (gameHandler.getBoard () == null)
            return false;
        if (super.canUse (gameHandler))
            return true;

        return gameHandler.getBoard ().getCardOnBoard () instanceof NumericCard &&
                ((NumericCard) (gameHandler.getBoard ().
                        getCardOnBoard ())).getNumber () == this.getNumber ();
    }

    public boolean use (GameHandler gameHandler, Color color)
    {
        if (!canUse (gameHandler))
            return false;
        if (!(super.use (gameHandler,color)))
        {
            gameHandler.getStorage ().addCard (gameHandler.getBoard ().changeCardOnBoard (this));
            gameHandler.getBoard ().changeColor (this.getColor ());
        }

        updateTurn (gameHandler,1);
        return true;
    }

    public boolean equals (Object o)
    {
        if (!(super.equals (o))) return false;
        if (o == this) return true;
        if (!(o instanceof NumericCard)) return false;

        NumericCard that = (NumericCard)o;
        return this.getNumber () == that.getNumber ();
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
