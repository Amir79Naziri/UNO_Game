import java.util.LinkedList;

/**
 * this class represents reverse card
 * this extends color cards
 * @see ColorCard
 * @author Amir Naziri
 */
public class ReverseCard extends ColorCard

{

    /**
     * creates a new Reverse card
     * @param color color
     */
    private ReverseCard (Color color)
    {
        super(color);
    }

    @Override
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

    @Override
    public boolean use (GameHandler gameHandler, Color color) {

        if (!canUse (gameHandler))
            return false;
        if (!(super.use (gameHandler, color)))
        {
            gameHandler.getStorage ().addCard (gameHandler.getBoard ().changeCardOnBoard (this));
            gameHandler.getBoard ().changeColor (this.getColor ());
        }

        changeDir (gameHandler);
        updateTurn (gameHandler,1);
        return true;
    }

    /**
     * changes the direction of Game
     * @param gameHandler game handler
     */
    private void changeDir (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return;
        gameHandler.getDir ().changeDirection ();
    }

    @Override
    public boolean equals (Object o)
    {
        if (!(super.equals (o))) return false;
        if (o == this) return true;
        return o instanceof ReverseCard;
    }

    /**
     * this static method creates cards for game : 8 of this card with 4 colors
     * @return list of cards
     */
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
