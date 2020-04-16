import java.util.LinkedHashMap;

public class UserInterface
{
    private Printer printer;
    private Reader reader;

    public UserInterface ()
    {
        printer = new Printer ();
        reader = new Reader ();
    }


    public void printGame (GameHandler gameHandler, boolean showTurn)
    {
        if (gameHandler == null)
            return;
        System.out.println ("\n\n\n");
        printer.printCardOnBoard (gameHandler.getBoard ());
        printer.printAllSize (gameHandler.getPlayers ());
        printer.printCardsOfPlayer (gameHandler.getPlayerWhoIsTurn ());
        if (showTurn)
            printer.printTurn (gameHandler.getTurn ());
        printer.printDir (gameHandler.getDir ());
    }

    public int getIndex (int size)
    {

        printer.printIndexGivingMassageFromPlayer ();
        int index = reader.getIndexOfChosenCard ();
        if (index >= size  || index < 0)
            return  getIndex (size);
        else
            return index;
    }

    public Color getColor (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return null;
        printer.printColorGetterMassage ();
        Color color =  reader.getColor (gameHandler.getPlayerWhoIsTurn ());
        if (color == null)
            return getColor (gameHandler);
        else
            return color;
    }


    public void printNoMatch ()
    {
        printer.printNoMatchCard ();
    }


    public void printEndTable (LinkedHashMap<String,Integer> sortedPlayers)
    {
        printer.
                printEndTable (sortedPlayers);
    }
}
