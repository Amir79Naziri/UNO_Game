import java.util.Random;
import java.util.Scanner;

/**
 * this class is for reading from console
 *
 * @author Amir Naziri
 */
public class Reader
{
    private Scanner reader; // reader

    /**
     * creates a new Reader
     */
    public Reader ()
    {
        reader = new Scanner (System.in);

    }

    /**
     * get index of chosen card from console
     * @return index of chosen card
     */
    public int getIndexOfChosenCard ()
    {
        String line = reader.nextLine ();
        int index = -1;
        if (isValidIndex (line))
            index = Integer.parseInt (line) - 1;

        return index;
    }

    /**
     * get one of chosen color after a wild Card
     * @param gameHandler game handler
     * @return Color
     */
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

    /**
     * check if input is valid
     * @param line input line
     * @return result
     */
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
