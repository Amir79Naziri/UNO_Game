import java.util.LinkedList;
import java.util.Random;

public class Game
{
    private int numOfPlayer;
    private Turn turn;
    private Player[] players;
    private Storage storage;
    private Board board;
    private GameDirection dir;


    public Game (int numOfPlayer)
    {
        turn = Turn.getInstance (numOfPlayer);
        players = new Player[numOfPlayer];
        storage = Storage.getInstanceStorage ();
        board = new Board ();
        dir = new GameDirection ();
    }


    public int getNumOfPlayer () {
        return numOfPlayer;
    }


    private boolean starterGameForPlayers ()
    {
        Random random = new Random ();
        int indexOfHumanPlayer = random.nextInt (getNumOfPlayer ());
        for (int i = 0; i < getNumOfPlayer (); i++)
        {
            LinkedList<Card> cardsForPlayer = storage.CardsForPlayer (7);
            if (cardsForPlayer == null)
                return false;
            if (i == indexOfHumanPlayer)
                players[i] = new HumanPlayer (cardsForPlayer);
            else
                players[i] = new MachinePlayer (cardsForPlayer);
        }
        return true;
    }

    private boolean starterGameForBoard ()
    {
        Card cardForBoard = storage.CardForBoard ();
        if (cardForBoard == null)
            return false;
        board.changeCardOnBoard (cardForBoard);
        board.changeColor (((ColorCard)cardForBoard).getColor ());
        return true;
    }

    public boolean startGame ()
    {
        boolean res1 = starterGameForPlayers ();
        boolean res2 = starterGameForBoard ();
        return res1 && res2;
    }

    public boolean play ()
    {
        if (!startGame ())
            return false;
        while (stopGame ()) {
            int index = turn.getWhoIsTurn ();

        }
    }

    public boolean stopGame ()
    {

    }


}
