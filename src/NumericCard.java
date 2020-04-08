import java.util.ArrayList;

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


    public boolean act (GameDirection dir, Turn turn, Board board,Color color,
                        ArrayList<Card> cardsInStorage)
    {
        if (board == null)
            return false;

        boolean result = super.act (dir,turn,board,color,cardsInStorage);
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
}
