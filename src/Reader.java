import java.util.Scanner;

public class Reader
{
    private Scanner reader;
    private Printer printer;


    public Reader (Printer printer)
    {
        reader = new Scanner (System.in);
        this.printer = printer;
    }

    public int getIndexOfChosenCard (Player playerInTurn)
    {
        if (playerInTurn == null)
            return -1;
        printer.printIndexGivingMassageFromPlayer ();
        int index = reader.nextInt () - 1;
        if (index >= playerInTurn.getCards ().size ())
            return getIndexOfChosenCard (playerInTurn);
        else
            return index;
    }

}
