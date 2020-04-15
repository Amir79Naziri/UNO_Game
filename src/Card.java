public abstract class Card
{

    public abstract boolean canUse (Board board);

    public abstract boolean use (GameDirection dir, Turn turn, Board board, Color color,
                                 Storage storage, Player[] players, int sequence);

    public void updateTurn (GameDirection dir, Turn turn, int unit)
    {
        if (turn == null)
            return;
        turn.changeTurn (dir,unit);
    }

}
