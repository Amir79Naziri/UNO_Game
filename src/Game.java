public abstract class Game
{
    private Turn turn;
    private Player[] players;
    private Storage storage;
    private Board board;
    private GameDirection dir;
    private UserInterface userInterface;

    public Game (int numOfPlayer)
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

    public abstract boolean starterGameForPlayers ();

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

    public boolean stopGame ()
    {
        int counter = 1;
        for (Player player : players)
        {
            if (player.getCards ().size () == 0)
            {
                System.out.println ("player" + counter + " won");
                return true;
            }
            counter++;
        }
        return false;
    }

    public boolean startGame ()
    {
        boolean res1 = starterGameForPlayers ();
        boolean res2 = starterGameForBoard ();
        return res1 && res2;
    }
}
