import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class GameHandler
{
    private Turn turn;
    private Player[] players;
    private Storage storage;
    private Board board;
    private GameDirection dir;
    private UserInterface userInterface;
    private SequenceKeeper sequenceKeeper;

    public GameHandler (int numOfPlayer)
    {
        turn = Turn.getInstance (numOfPlayer);
        players = new Player[numOfPlayer];
        storage = Storage.getInstanceStorage ();
        board = new Board ();
        dir = new GameDirection ();
        userInterface = new UserInterface ();
        sequenceKeeper = new SequenceKeeper ();
    }

    public int getNumOfPlayer () {
        return players.length;
    }

    public UserInterface getUserInterface () {
        return userInterface;
    }

    public Board getBoard () {
        return board;
    }

    public Storage getStorage () {
        return storage;
    }

    public GameDirection getDir () {
        return dir;
    }

    public Player[] getPlayers () {
        return players;
    }

    public Turn getTurn () {
        return turn;
    }

    public SequenceKeeper getSequenceKeeper () {
        return sequenceKeeper;
    }


    public Player getPlayerWhoIsTurn ()
    {
        int index = turn.getWhoIsTurn () - 1;
        return players[index];
    }


    public void boardCardUse () throws InterruptedException
    {
        if (!(getBoard ().getCardOnBoard () instanceof NumericCard))
        {
            getUserInterface ().printGame (this,true);

            if (getBoard ().getCardOnBoard () instanceof ReverseCard)
            {
                Thread.sleep (3000);
                dir.changeDirection ();
            }
            else
            {
                getTurn ().changeTurn (getDir (),-1);
                Thread.sleep (3000);
                getBoard ().getCardOnBoard ().use (getDir (),getTurn (),getBoard (),Color.NON_COLOR,
                        getStorage (),getPlayers (),getSequenceKeeper ());
            }
        }
    }


    public Card playerGetCard () throws InterruptedException {
        if (getPlayerWhoIsTurn () instanceof MachinePlayer)
            Thread.sleep (3000);
        return getPlayerWhoIsTurn ().useCard (getUserInterface (),getBoard ());
    }


    public void useCard (Card card)
    {
        if (card instanceof WildCard)
        {
            card.use (getDir (),getTurn (),getBoard (),getUserInterface ().
                            getColor (this),
                    getStorage (),getPlayers (),getSequenceKeeper ());
        }
        else
            card.use (getDir (),getTurn (),getBoard (),Color.NON_COLOR,
                    getStorage (),getPlayers (),getSequenceKeeper ());
    }

    public LinkedHashMap<String,Integer> findSortedListOfPlayers ()
    {
        ArrayList<Integer> points = new ArrayList<> ();
        for (Player player : getPlayers ())
        {
            player.calculatePoints ();
            points.add (player.getPoint ());
        }
        Collections.sort (points);

        LinkedHashMap<String,Integer> sortedPlayers = new LinkedHashMap<> ();

        for (Integer point : points)
        {
            for (int i = 0; i < getNumOfPlayer (); i++)
            {
                if (point.equals (getPlayers ()[i].getPoint ()))
                    sortedPlayers.put ("Player" + (i + 1),point);
            }
        }

        return sortedPlayers;
    }
}
