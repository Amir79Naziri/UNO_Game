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


    public void printGame (Board board, Player playerInTurn, Turn turn,
                                   GameDirection dir,Player[] players, boolean showTurn)
    {
        if (playerInTurn == null)
            return;
        System.out.println ("\n\n\n");
        printer.printCardOnBoard (board);
        printer.printAllSize (players);
        printer.printCardsOfPlayer (playerInTurn);
        if (showTurn)
            printer.printTurn (turn);
        printer.printDir (dir);
    }

    public int getIndex (Player playerInTurn)
    {
        return reader.
                getIndexOfChosenCard (playerInTurn,printer);
    }

    public Color getColor (Player playerInTurn)
    {
        return reader.getColor (playerInTurn,printer);
    }


    public void printNoMatch ()
    {
        printer.printNoMatchCard ();
    }


    public void printEndTable (LinkedHashMap<String,Integer> sortedPlayers)
    {
        printer.printEndTable (sortedPlayers);
    }
}
