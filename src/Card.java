public abstract class Card
{

    public abstract boolean canUse (GameHandler gameHandler);

    public abstract boolean use (GameHandler gameHandler, Color color);

    public void updateTurn (GameHandler gameHandler, int unit)
    {
        if (gameHandler == null)
            return;

        if (gameHandler.getTurn () == null)
            return;
        gameHandler.getTurn ().changeTurn (gameHandler.getDir (),unit);
    }

}
