/**
 * this class represents the Main class of project which
 * contains starting , stopping , play the game
 *
 * @author Amir Naziri
 */
public abstract class Game
{
    private GameHandler gameHandler; // game handler

    /**
     * creating new Game
     * @param numOfPlayer number of Players
     */
    public Game (int numOfPlayer)
    {
        gameHandler = new GameHandler (numOfPlayer);
    }

    /**
     * @return game handler
     */
    public GameHandler getGameHandler () {
        return gameHandler;
    }

    /**
     * start game by giving a 7 card to each Player and telling which player
     * is a machine and which are Human
     * @return result of success
     */
    public abstract boolean starterGameForPlayers ();

    /**
     * start game by giving a Color Type Card to Board for Start
     * @return result of success
     */
    private boolean starterGameForBoard ()
    {
        Card cardForBoard = getGameHandler ().getStorage ().CardForBoard ();
        if (cardForBoard == null)
            return false;
        getGameHandler ().getBoard ().changeCardOnBoard (cardForBoard);
        getGameHandler ().getBoard ().changeColor (((ColorCard)cardForBoard).getColor ());
        return true;
    }

    /**
     * check the game for condition's which will stop the Game
     * @return should game Stop ?
     */
    private boolean stopGame ()
    {
        int counter = 1;
        for (Player player : getGameHandler ().getPlayers ())
        {
            if (player.getCards ().size () == 0) // if a player has 0 cards the game should stop
            {
                gameHandler.getUserInterface ().printGame (gameHandler,false);
                System.out.println ("\n\n\n\n");
                System.err.println ("                   player" + counter + " won " +
                        "                   \n");
                getGameHandler ().getUserInterface ().printEndTable // printing the End Table
                        (getGameHandler ().findSortedListOfPlayers ());
                return true; // game finished
            }
            counter++;
        }
        return false; // game hasn't finish
    }

    /**
     * makes game ready for playing
     * @return result of success
     */
    private boolean startGame ()
    {
        boolean res1 = starterGameForPlayers (); // start game for players
        boolean res2 = starterGameForBoard (); // start game for Board
        return res1 && res2;
    }

    /**
     * play the Game
     * @throws InterruptedException for wasting time during some chooses
     */
    public void play () throws InterruptedException
    {
        if (!startGame ()) // is game ready for Play ?
            return;
        getGameHandler ().boardCardUse (); // the card on board will act when the start
                                           // card is Skip, Reverse, Draw 2+
        while (!stopGame ())
        {
            Card card;
            if (getGameHandler ().getPlayerWhoIsTurn ().
                    hasMatchCard (getGameHandler ())) // player has match card
            {
                getGameHandler ().getUserInterface ().printGame (getGameHandler (),true);
                // print game on console
                card = getGameHandler ().playerGetCard ();
            }
            else // player hasn't match card so System gives a card to player
            {
                getGameHandler ().getUserInterface ().
                        printGame (getGameHandler (),true);
                // print game on console
                getGameHandler ().getUserInterface ().printNoMatch ();
                Thread.sleep (3000); // wasting some time
                getGameHandler ().getPlayerWhoIsTurn ().addCards (getGameHandler ().getStorage ().
                        CardsForPlayer (1));

                if (getGameHandler ().getPlayerWhoIsTurn ().
                        hasMatchCard (getGameHandler ())) // now player has match card
                {
                    getGameHandler ().getUserInterface ().
                            printGame (getGameHandler (),true);
                    card = getGameHandler ().playerGetCard ();
                }
                else // player will loose turn
                {
                    getGameHandler ().getUserInterface ().
                            printGame (getGameHandler (),true);
                    getGameHandler ().getUserInterface ().printNoMatch ();
                    // print game on console
                    Thread.sleep (3000); // wasting some time
                    getGameHandler ().getTurn ().changeTurn (getGameHandler ().
                            getDir (),1); // change turn
                    continue;
                }
            }

            if (card == null)
                continue; // player chosen card wasn't valid
            getGameHandler ().useCard (card); // place card on board and change state of
                                              // game by it's act type
        }
    }
}
