import java.util.LinkedHashMap;

/**
 * this class is for UserInterFace
 *
 * @author Amir Naziri
 */
public class UserInterface
{
    private Printer printer; // printer
    private Reader reader; // reader

    /**
     * create a new User interface
     */
    public UserInterface ()
    {
        printer = new Printer ();
        reader = new Reader ();
    }

    /**
     * print a game on console
     * @param gameHandler game handler
     * @param showTurn show who is turn
     */
    public void printGame (GameHandler gameHandler, boolean showTurn)
    {
        if (gameHandler == null)
            return;
        System.out.println ("\n\n\n");
        printer.printCardOnBoard (gameHandler);
        printer.printAllSize (gameHandler);
        printer.printCardsOfPlayer (gameHandler);
        if (showTurn)
            printer.printTurn (gameHandler);
        printer.printDir (gameHandler);
    }

    /**
     * getting index of a card by user
     * @param size total size of cards
     * @return chose index
     */
    public int getIndex (int size)
    {

        printer.printIndexGivingMassageFromPlayer ();
        int index = reader.getIndexOfChosenCard ();
        if (index >= size  || index < 0)
            return  getIndex (size);
        else
            return index;
    }

    /**
     * choosing a color by user
     * @param gameHandler game handler
     * @return color which chose by user
     */
    public Color getColor (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return null;
        printer.printColorGetterMassage ();
        Color color =  reader.getColor (gameHandler);
        if (color == null)
            return getColor (gameHandler);
        else
            return color;
    }

    /**
     * print no match on console
     */
    public void printNoMatch ()
    {
        printer.printNoMatchCard ();
    }

    /**
     * prints a EndTable of Game
     * @param sortedPlayers list of players which has been sorted by their points less to most
     */
    public void printEndTable (LinkedHashMap<String,Integer> sortedPlayers)
    {
        printer.
                printEndTable (sortedPlayers);
    }
}
