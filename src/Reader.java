import java.util.Random;
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

    public Color getColor (Player playerInTurn, Printer printer)
    {
        if (printer == null)
            return null;
        int chose;
        if (playerInTurn instanceof HumanPlayer)
        {
            printer.printColorGetterMassage ();
            chose = reader.nextInt ();
        }
        else
        {
            Random random = new Random ();
            chose = random.nextInt (4) + 1;
        }

        switch (chose)
        {
            case 1 : return Color.BLUE;
            case 2 : return Color.RED;
            case 3 : return Color.GREEN;
            case 4 : return Color.YELLOW;
            default: return getColor (playerInTurn,printer);
        }
    }
}
