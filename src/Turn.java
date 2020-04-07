public class Turn
{
    private static Turn turn = null;
    private int numberOfPlayers;
    private int whoIsTurn;

    private Turn (int numberOfPlayers)
    {
        this.numberOfPlayers = numberOfPlayers;
        whoIsTurn = 0;
    }

    public Turn getInstance (int numberOfPlayers)
    {
        if (turn == null)
        {
            turn = new Turn (numberOfPlayers);
        }
        return turn;
    }

    public int getWhoIsTurn () {
        return whoIsTurn;
    }

    private void changeWhoIsTurn (int add)
    {
        whoIsTurn += add;
        whoIsTurn = whoIsTurn % numberOfPlayers;
        if (whoIsTurn < 0)
            whoIsTurn *= -1;
        if (whoIsTurn == 0)
            whoIsTurn = numberOfPlayers;
    }

    public void changeTurn (Direction dir, int addToTurn)
    {
        if (dir == Direction.CLOCKWISE)
            changeWhoIsTurn (addToTurn);
        if (dir == Direction.COUNTERCLOCKWISE)
            changeWhoIsTurn (-addToTurn);
    }
}