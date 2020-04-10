import java.util.Scanner;

public class Reader
{
    private Scanner reader;


    public Reader ()
    {
        reader = new Scanner (System.in);

    }

    public int getIndexOfChosenCard (Player playerInTurn, Printer printer)
    {
        if (playerInTurn == null)
            return -1;
        printer.printIndexGivingMassageFromPlayer ();
        int index = reader.nextInt () - 1;
        if (index >= playerInTurn.getCards ().size ())
            return getIndexOfChosenCard (playerInTurn,printer);
        else
            return index;
    }

}
