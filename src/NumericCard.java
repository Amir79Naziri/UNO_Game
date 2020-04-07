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
            if (colorCard instanceof NumericCard &&
                    ((NumericCard)colorCard).getNumber () == this.getNumber ())
            {
                board.changeCardOnBoard (this);
                return true;
            }
            else
                return false;
        }
        if (board.getCardOnBoard () instanceof WildCard)
        {
            board.changeCardOnBoard (this);
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
}
