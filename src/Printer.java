
import java.util.*;

public class Printer
{
    private static int count = 0;

    public void printIndexGivingMassageFromPlayer ()
    {
        System.out.println ("Please Choose one" +
                " Of Your cards ");
    }

    public void printNoMatchCard ()
    {
        System.out.println ("No Match Card!");
    }


    public void printColorGetterMassage ()
    {
        System.out.println ("please Choose a Color :\n" +
                "1) " + Color.BLUE.getANSICode () + '\u2B1B' + Color.RESET.getANSICode () + "\n" +
                "2) " + Color.RED.getANSICode () + '\u2B1B' + Color.RESET.getANSICode () + "\n" +
                "3) " + Color.GREEN.getANSICode () + '\u2B1B' + Color.RESET.getANSICode () + "\n" +
                "4) " + Color.YELLOW.getANSICode () + '\u2B1B' + Color.RESET.getANSICode () + "\n");
    }

    public void printAllSize (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return;

        int counter = 1;
        for (Player player : gameHandler.getPlayers ())
        {
            System.out.print ("Player " + counter + ":" + player.getCards ().size () + "   ");
            if (counter == 11)
                System.out.println ();
            counter++;
        }
        System.out.println ();
    }

    public void printCardOnBoard (GameHandler gameHandler)
    {

        if (gameHandler == null)
            return;

        LinkedList<Card> cards = new LinkedList<> ();
        cards.add (gameHandler.getBoard ().getCardOnBoard ());
        printMaxSevenCard ("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ",cards,false,
                "");
        System.out.print ("\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "      Board color :");
        System.out.print ("  " + gameHandler.getBoard ().getColor ().getANSICode () + '\u2B1B' +
                Color.RESET.getANSICode () + "  ");

        System.out.println ();
    }

    public void printTurn (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return;
        System.out.print ("Player" + gameHandler.getTurn ().getWhoIsTurn () + "  turn      ");
    }

    public void printDir (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return;
        System.out.println (" DIR : " + gameHandler.getDir ().getDirection ().getUniCode ());
    }

    public void printEndTable (LinkedHashMap<String,Integer> sortedPlayers)
    {
        if (sortedPlayers == null)
            return;
        System.out.println ("   Players             |             Score");
        System.out.println ("---------------------------------------------");
        for (Map.Entry<String,Integer> a : sortedPlayers.entrySet ())
        {
            System.out.println ("   " + a.getKey () + "             |               "
                    + a.getValue ());
            System.out.println ("---------------------------------------------");
        }
    }

    public void printCardsOfPlayer (GameHandler gameHandler)
    {
        System.out.println ("________________________________________________________________" +
                "___________________________________________________________________" +
                "________________");
        count = 0;
        if (gameHandler == null)
            return;
        LinkedList<Card> playerCards = gameHandler.getPlayerWhoIsTurn ().getCards ();
        int size = playerCards.size ();
        int fullSeven = size / 7;
        int notFullSeven = size % 7;
        for (int i = 0; i < fullSeven; i++)
        {
            LinkedList<Card> cards = new LinkedList<> ();
            for (int j = 0; j < 7; j++)
            {
                cards.add (playerCards.get ((7 * i) + j));
            }
            printMaxSevenCard ("",cards,true,gameHandler.getPlayerWhoIsTurn ()
                    .getClass ().getName ());
        }
        LinkedList<Card> secCards = new LinkedList<> ();
        for (int j = 0; j < notFullSeven; j++)
        {
            secCards.add (playerCards.get ((7 * fullSeven) + j));
        }
        if (notFullSeven != 0)
            printMaxSevenCard ("",secCards,true,gameHandler.getPlayerWhoIsTurn ()
                    .getClass ().getName ());
        System.out.println ("________________________________________________________________" +
                "___________________________________________________________________" +
                "________________");
    }

    private void printMaxSevenCard (String dis, LinkedList<Card> cards, boolean showNumber,
                                     String playerType)
    {
        if (cards == null)
            return;
        if (cards.size () > 7)
            return;

        Color[] colors = new Color[cards.size ()];
        String[] type = new String[cards.size ()];
        if (playerType.equals ("MachinePlayer"))
        {
            findColorsAndType (type,colors,cards,2);
        }
        else
            findColorsAndType (type,colors,cards,1);

        StringBuilder shape = new StringBuilder ();

        addHeaderToShape (dis,shape,colors,cards.size ());
        addMiddleToShape (dis,shape,colors,cards.size ());
        addTypeToShape (dis,shape,type,colors,cards.size ());
        addMiddleToShape (dis,shape,colors,cards.size ());
        addHeaderToShape (dis,shape,colors,cards.size ());
        if (showNumber)
        {
            printNumberDownCard (shape,count * 7,cards.size () + count * 7);
            count++;
        }


        System.out.print (shape.toString ());
        System.out.println ();
    }

    private void addColorToShape (StringBuilder shape, Color color)
    {
        if (color == null)
            return;
        shape.append (color.getANSICode ());
    }

    private void addHeaderToShape (String dis, StringBuilder shape, Color[] colors, int size)
    {
        for (int i = 0; i < size; i++)
        {
            addColorToShape (shape,colors[i]);
            shape.append (dis).append ("|$$$$$$$$$$$$$|").append (Color.RESET.getANSICode ()).
                    append ("      ");
        }
        shape.append ("\n");
    }

    private void addMiddleToShape (String dis, StringBuilder shape, Color[] colors, int size)
    {
        for (int i = 0; i < size; i++)
        {
            addColorToShape (shape,colors[i]);
            shape.append (dis).append ("|             |").append (Color.RESET.getANSICode ()).
                    append ("      ");
        }
        shape.append ("\n");
    }

    private void addTypeToShape (String dis, StringBuilder shape, String[] type, Color[] colors
            , int size)
    {
        for (int i = 0; i < size; i++)
        {
            addColorToShape (shape,colors[i]);
            shape.append (dis).append (type[i]).append (Color.RESET.getANSICode ()).
                    append ("      ");
        }
        shape.append ("\n");
    }

    private void printNumberDownCard (StringBuilder shape, int start, int finish)
    {

        for (int i = start; i < finish; i++)
        {
            shape.append ("      (").append (i + 1).append (")            ");
        }
        shape.append ("\n");
    }

    private void findColorsAndType (String[] type, Color[] colors,LinkedList<Card> cards,
                                    int key)
    {
        if (cards == null)
            return;
        int counter = 0;
        if (key == 1)
        {
            for (Card card : cards)
            {
                if (card instanceof WildCard)
                {
                    if (card instanceof WildDrawCard)
                        type[counter] = "|     +4      |";
                    if (card instanceof WildColorCard)
                        type[counter] = "|  fourColor  |";
                    colors[counter] = Color.NON_COLOR;
                }
                if (card instanceof ColorCard)
                {
                    colors[counter] = ((ColorCard)card).getColor ();

                    if (card instanceof NumericCard)
                        type[counter] = "|      " + ((NumericCard) card).getNumber () + "      |";
                    if (card instanceof ReverseCard)
                        type[counter] = "|   reverse   |";
                    if (card instanceof SkipCard)
                        type[counter] = "|    skip     |";
                    if (card instanceof ColorDrawCard)
                        type[counter] = "|     +2      |";
                }
                counter++;
            }
        }
        if (key == 2)
        {
            for (int i = 0; i < cards.size (); i++)
            {
                colors[counter] = Color.GRAY;
                type[counter] = "|      X      |";
                counter++;
            }
        }
    }
}
