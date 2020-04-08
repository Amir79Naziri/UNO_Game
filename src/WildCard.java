import java.util.ArrayList;

public abstract class WildCard
        implements Card
{

    public boolean act (GameDirection dir, Turn turn, Board board, Color color,
                        ArrayList<Card> cardsInStorage)
    {
        if (board == null)
            return false;
        board.changeCardOnBoard (this);
        getNextColor (dir,turn,board,color);
        return true;
    }

    private void getNextColor (GameDirection dir, Turn turn, Board board, Color color)
    {
        if (board == null)
            return;
        board.changeColor (color);
    }
}
