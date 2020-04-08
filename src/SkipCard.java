import java.util.ArrayList;

public class SkipCard extends ColorCard
{
    public SkipCard (Color color)
    {
        super(color);
    }



    public boolean act (GameDirection dir, Turn turn, Board board, Color color,
                        ArrayList<Card> cardsInStorage)
    {
        boolean result = super.act (dir,turn,board,color,cardsInStorage);
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
}
