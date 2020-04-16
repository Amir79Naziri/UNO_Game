import java.util.Random;

public class Turn
{
    private static Turn turn = null;
    private int numberOfPlayers;
    private int whoIsTurn;

    private Turn (int numberOfPlayers)
    {
        Random random = new Random ();
        this.numberOfPlayers = numberOfPlayers;
        whoIsTurn = random.nextInt (numberOfPlayers) + 1;
    }

    public static Turn getInstance (int numberOfPlayers)
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

    public void changeTurn (GameDirection dir, int addToTurn)
    {
        if (dir == null)
            return;
        if (dir.getDirection () == Direction.CLOCKWISE)
            changeWhoIsTurn (addToTurn);
        if (dir.getDirection () == Direction.COUNTERCLOCKWISE)
            changeWhoIsTurn (-addToTurn);
    }
}
