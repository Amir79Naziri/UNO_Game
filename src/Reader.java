import java.util.Random;
import java.util.Scanner;

public class Reader
{
    private Scanner reader;

    public Reader ()
    {
        reader = new Scanner (System.in);

    }

    public int getIndexOfChosenCard ()
    {
        String line = reader.nextLine ();
        int index = -1;
        if (isValidIndex (line))
            index = Integer.parseInt (line) - 1;

        return index;
    }

    public Color getColor (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return null;
        int chose = -1;
        if (gameHandler.getPlayerWhoIsTurn () instanceof HumanPlayer)
        {
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
            default: return null;
        }
    }

    public static boolean isValidIndex (String line)
    {
        if (line == null)
            return false;

        char[] splits = line.trim ().toCharArray ();
        int type = splits.length;

        if (type == 1)
            return Character.isDigit (splits[0]);
        else if (type == 2)
            return Character.isDigit (splits[0]) && Character.isDigit (splits[1]);
        else
            return false;
    }
}
