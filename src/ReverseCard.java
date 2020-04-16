import java.util.LinkedList;

public class ReverseCard extends ColorCard

{

    private ReverseCard (Color color)
    {
        super(color);
    }


    public boolean canUse (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return false;
        if (gameHandler.getBoard () == null)
            return false;
        if (super.canUse (gameHandler))
            return true;
        return gameHandler.getBoard ().getCardOnBoard () instanceof ReverseCard;
    }

    public boolean use (GameHandler gameHandler, Color color) {

        if (!canUse (gameHandler))
            return false;
        if (!(super.use (gameHandler, color)))
        {
            gameHandler.getStorage ().addCard (gameHandler.getBoard ().changeCardOnBoard (this));
            gameHandler.getBoard ().changeColor (this.getColor ());
        }

        changeDir (gameHandler.getDir ());
        updateTurn (gameHandler,1);
        return true;
    }


    private void changeDir (GameDirection dir)
    {
        if (dir == null)
            return;
        dir.changeDirection ();
    }

    public boolean equals (Object o)
    {
        if (!(super.equals (o))) return false;
        if (o == this) return true;
        return o instanceof ReverseCard;
    }

    public static LinkedList<Card> produceCards ()
    {
        LinkedList<Card> list = new LinkedList<> ();

        for (int i = 0; i < 2; i++)
        {
            list.add (new ReverseCard (Color.YELLOW));
            list.add (new ReverseCard (Color.RED));
            list.add (new ReverseCard (Color.GREEN));
            list.add (new ReverseCard (Color.BLUE));
        }
        return list;
    }
}
