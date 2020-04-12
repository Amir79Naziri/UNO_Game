import java.util.LinkedList;
import java.util.Random;

public class GameTwoPlayer
{
    private Turn turn;
    private Player[] players;
    private Storage storage;
    private Board board;
    private GameDirection dir;
    private UserInterface userInterface;

    public GameTwoPlayer (int numOfPlayer)
    {
        turn = Turn.getInstance (numOfPlayer);
        players = new Player[numOfPlayer];
        storage = Storage.getInstanceStorage ();
        board = new Board ();
        dir = new GameDirection ();
        userInterface = new UserInterface ();
    }


    public int getNumOfPlayer () {
        return players.length;
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

    public Player getPlayerWhoIsTurn ()
    {
        int index = turn.getWhoIsTurn () - 1;
        return players[index];
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
        while (!stopGame ())
        {
            Card card;

            if (getPlayerWhoIsTurn ().hasMatchCard (board))
            {
                card = getPlayerWhoIsTurn ().useCard (userInterface.showForHumanPlayer (board,
                        getPlayerWhoIsTurn (),turn,dir,players)
                        ,board);
            }
            else
            {
                getPlayerWhoIsTurn ().addCards (storage.CardsForPlayer (1));
                if (getPlayerWhoIsTurn ().hasMatchCard (board))
                {
                    card = getPlayerWhoIsTurn ().useCard (userInterface.showForHumanPlayer (board,
                            getPlayerWhoIsTurn (),turn,dir,players),board);
                }
                else
                {
                    turn.changeTurn (dir,1);
                    continue;
                }
            }
            if (card == null)
                continue;
            getPlayerWhoIsTurn ().removeCard (card);
            if (card instanceof WildCard)
                card.use (dir,turn,board,userInterface.getColor (),storage,players);
            else
                card.use (dir,turn,board,Color.NON_COLOR,storage,players);
        }
        return true;
    }

    public boolean stopGame ()
    {
        for (Player player : players)
        {
            player.calculatePoints ();
            if (player.getPoint () == 0)
                return true;
        }
        return false;
    }



}
