public class ReverseCard extends ColorCard

{

    public ReverseCard (Color color)
    {
        super(color);
    }



    public boolean act (GameDirection dir, Turn turn, Board board, Color color) {
        boolean result = super.act (dir, turn, board, color);
        if (result)
            return true;
        if (board.getCardOnBoard () instanceof ReverseCard)
        {
            board.changeCardOnBoard (this);
            return true;
        }
        else return false;
    }


    private void changeDir (GameDirection dir)
    {
        if (dir == null)
            return;
        dir.changeDirection ();
    }


    public void updateTurn (GameDirection dir, Turn turn)
    {
        if (turn == null)
            return;
        changeDir (dir);
        turn.changeTurn (dir,1);
    }
}
