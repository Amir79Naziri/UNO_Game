import java.util.ArrayList;

public abstract class ColorCard
        implements Card
{
    private Color color;


    public ColorCard (Color color)
    {
        this.color = color;
    }

    public boolean act (GameDirection dir, Turn turn, Board board,Color color,
                        ArrayList<Card> cardsInStorage)
    {
        if (board == null)
            return false;

        if (board.getCardOnBoard () instanceof ColorCard)
        {
            if (board.getColor () == this.getColor ())
            {
                board.changeCardOnBoard (this);
                board.changeColor (this.getColor ());
                return true;
            }
            else return false;
        }
        else return false;
    }


    public Color getColor () {
        return color;
    }

}
