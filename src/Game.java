public abstract class Game
{
    private GameHandler gameHandler;

    public Game (int numOfPlayer)
    {
        gameHandler = new GameHandler (numOfPlayer);
    }

    public GameHandler getGameHandler () {
        return gameHandler;
    }

    public abstract boolean starterGameForPlayers ();


    private boolean starterGameForBoard ()
    {
        Card cardForBoard = getGameHandler ().getStorage ().CardForBoard ();
        if (cardForBoard == null)
            return false;
        getGameHandler ().getBoard ().changeCardOnBoard (cardForBoard);
        getGameHandler ().getBoard ().changeColor (((ColorCard)cardForBoard).getColor ());
        return true;
    }

    private boolean stopGame ()
    {
        int counter = 1;
        for (Player player : getGameHandler ().getPlayers ())
        {
            if (player.getCards ().size () == 0)
            {
                System.out.println ("\n\n\n\n");
                System.err.println ("                   player" + counter + " won " +
                        "                   \n");
                getGameHandler ().getUserInterface ().printEndTable
                        (getGameHandler ().findSortedListOfPlayers ());
                return true;
            }
            counter++;
        }
        return false;
    }

    private boolean startGame ()
    {
        boolean res1 = starterGameForPlayers ();
        boolean res2 = starterGameForBoard ();
        return res1 && res2;
    }

    public void play () throws InterruptedException
    {
        if (!startGame ())
            return;
        getGameHandler ().boardCardUse ();
        while (!stopGame ())
        {
            Card card;
            if (getGameHandler ().getPlayerWhoIsTurn ().
                    hasMatchCard (getGameHandler ()))
            {
                getGameHandler ().getUserInterface ().printGame (getGameHandler (),true);

                card = getGameHandler ().playerGetCard ();
            }
            else
            {
                getGameHandler ().getUserInterface ().
                        printGame (getGameHandler (),true);
                getGameHandler ().getUserInterface ().printNoMatch ();
                Thread.sleep (3000);
                getGameHandler ().getPlayerWhoIsTurn ().addCards (getGameHandler ().getStorage ().
                        CardsForPlayer (1));

                if (getGameHandler ().getPlayerWhoIsTurn ().
                        hasMatchCard (getGameHandler ()))
                {
                    getGameHandler ().getUserInterface ().
                            printGame (getGameHandler (),true);
                    card = getGameHandler ().playerGetCard ();
                }
                else
                {
                    getGameHandler ().getUserInterface ().
                            printGame (getGameHandler (),true);
                    getGameHandler ().getUserInterface ().printNoMatch ();

                    Thread.sleep (3000);
                    getGameHandler ().getTurn ().changeTurn (getGameHandler ().
                            getDir (),1);
                    continue;
                }
            }

            if (card == null)
                continue;
            getGameHandler ().useCard (card);
        }
    }
}
