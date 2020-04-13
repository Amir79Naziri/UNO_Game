
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
        printer.printDir (dir);
        if (showTurn)
            printer.printTurn (turn);
        printer.printAllSize (players);
        printer.printCardOnBoard (board);
        printer.printCardsOfPlayer (playerInTurn);
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

}
