import java.util.LinkedList;

public class UserInterface
{
    private Printer printer;
    private Reader reader;

    public UserInterface ()
    {
        printer = new Printer ();
        reader = new Reader ();
    }

    public void showForHumanPlayer (Board board, Player playerInTurn)
    {
        if (playerInTurn == null)
            return;
        printer.printCardOnBoard (board);
        printer.printCardsOfPlayer (playerInTurn.getCards ());
        reader.getIndexOfChosenCard (playerInTurn,printer);
    }

    public void showForMachinePlayer (Board board, Player playerInTurn)
    {
        if (playerInTurn == null)
            return;
        printer.printCardOnBoard (board);
    }

}
