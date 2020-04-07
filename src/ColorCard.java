public abstract class ColorCard
        implements Card
{
    private Color color;


    public ColorCard (Color color)
    {
        this.color = color;
    }

    public boolean act (GameDirection dir, Turn turn, Board board,Color color)
    {
        if (board == null)
            return false;

        if (board.getCardOnBoard () instanceof ColorCard)
        {
            ColorCard colorCard = (ColorCard) board.getCardOnBoard ();
            if (colorCard.getColor () == this.getColor ())
            {
                board.changeCardOnBoard (this);
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
