public abstract class WildCard
        implements Card
{

    public boolean act (GameDirection dir, Turn turn, Board board, Color color)
    {
        if (board == null)
            return false;
        board.changeCardOnBoard (this);
        return true;
    }

    public void getNextColor (GameDirection dir, Turn turn, Board board, Color color)
    {

    }
}
