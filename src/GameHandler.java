import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

/**
 * this class is the central logic unit of Game
 *
 * @author Amir Naziri
 */
public class GameHandler
{
    private Turn turn; // turn in game
    private Player[] players;// players in game
    private Storage storage; // Storage in game
    private Board board; // board in game
    private GameDirection dir; // direction in game
    private UserInterface userInterface; //userInterface
    private SequenceKeeper sequenceKeeper; // sequence keeper

    /**
     * creates a new Game handler
     * @param numOfPlayer number of Players
     */
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

    /**
     * @return number of Players
     */
    public int getNumOfPlayer () {
        return players.length;
    }

    /**
     * @return user interface in game
     */
    public UserInterface getUserInterface () {
        return userInterface;
    }

    /**
     * @return board
     */
    public Board getBoard () {
        return board;
    }

    /**
     * @return Storage
     */
    public Storage getStorage () {
        return storage;
    }

    /**
     * @return direction of Game
     */
    public GameDirection getDir () {
        return dir;
    }

    /**
     * @return players
     */
    public Player[] getPlayers () {
        return players;
    }

    /**
     * @return turn
     */
    public Turn getTurn () {
        return turn;
    }

    /**
     * @return sequenceKeeper
     */
    public SequenceKeeper getSequenceKeeper () {
        return sequenceKeeper;
    }

    /**
     * @return player who is in turn
     */
    public Player getPlayerWhoIsTurn ()
    {
        int index = turn.getWhoIsTurn () - 1;
        return players[index];
    }

    /**
     * by this method card on board will act at starting game for move cards
     * @throws InterruptedException some wasting time
     */
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
                getBoard ().getCardOnBoard ().use (this,Color.NON_COLOR);
            }
        }
    }

    /**
     * player will give a card
     * @return card
     * @throws InterruptedException some wasting time
     */
    public Card playerGetCard () throws InterruptedException {
        if (getPlayerWhoIsTurn () instanceof MachinePlayer)
            Thread.sleep (3000);
        return getPlayerWhoIsTurn ().useCard (this); // get card from player
    }

    /**
     * chosen card will act
     * @param card card which player gave
     */
    public void useCard (Card card)
    {
        if (card instanceof WildCard)
        {
            card.use (this,getUserInterface ().getColor (this));
            // use wild card
        }
        else
            card.use (this,Color.NON_COLOR);
        // use normal card
    }

    /**
     * this method will produce sorted map of player and their scores
     * @return map of player and their scores
     */
    public LinkedHashMap<String,Integer> findSortedListOfPlayers ()
    {
        ArrayList<Integer> points = new ArrayList<> ();
        for (Player player : getPlayers ())
        {
            player.calculatePoints ();
            points.add (player.getPoint ());
        }
        Collections.sort (points); // sort points

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
