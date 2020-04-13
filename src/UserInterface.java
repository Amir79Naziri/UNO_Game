
public class UserInterface
{
    private Printer printer;
    private Reader reader;

    public UserInterface ()
    {
        printer = new Printer ();
        reader = new Reader ();
    }

    public int showForHumanPlayer (Board board, Player playerInTurn, Turn turn,
                                   GameDirection dir,Player[] players, int type)
    {
        if (playerInTurn == null)
            return -1;
        printer.printTurnAndDir (turn,dir);
        printer.printAllSize (players);
        printer.printCardOnBoard (board);
        printer.printCardsOfPlayer (playerInTurn);
        if (type == 1)
            return reader.getIndexOfChosenCard (playerInTurn,printer);
        else
            return -1;
    }

    public void showForMachinePlayer (Board board, Player playerInTurn, Turn turn,
                                      GameDirection dir, Player[] players)
    {
        if (playerInTurn == null)
            return;
        printer.printTurnAndDir (turn,dir);
        printer.printAllSize (players);
        printer.printCardOnBoard (board);
    }

    public Color getColor ()
    {
        return reader.getColor (printer);
    }

}
