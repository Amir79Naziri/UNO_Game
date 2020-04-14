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
        String line = reader.nextLine ();
        int index = -1;
        if (isValidIndex (line))
            index = Integer.parseInt (line) - 1;

        if (index >= playerInTurn.getCards ().size () || index < 0)
            return getIndexOfChosenCard (playerInTurn,printer);
        else
            return index;
    }

    public Color getColor (Player playerInTurn, Printer printer)
    {
        if (printer == null)
            return null;
        int chose = -1;
        if (playerInTurn instanceof HumanPlayer)
        {
            printer.printColorGetterMassage ();
            String line = reader.nextLine ();
            if (isValidIndex (line))
                chose = Integer.parseInt (line);
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

    public static boolean isValidIndex (String line)
    {
        if (line == null)
            return false;
        char[] splits = line.trim ().toCharArray ();
        if (splits.length != 1)
            return false;
        return Character.isDigit (splits[0]);
    }

}
