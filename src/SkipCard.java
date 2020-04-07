public class SkipCard extends ColorCard
{
    public SkipCard (Color color)
    {
        super(color);
    }



    public boolean act (GameDirection dir, Turn turn, Board board, Color color)
    {
        boolean result = super.act (dir,turn,board,color);
        if (result)
            return true;
        if (board.getCardOnBoard () instanceof SkipCard)
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
        turn.changeTurn (dir,2);
    }
}
