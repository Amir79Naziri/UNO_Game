import java.util.*;

/**
 * this class will be used for printing anything on console for user
 *
 * @author Amir Naziri
 */
public class Printer
{
    /**
     * this will print massage for getting input from user
     */
    public void printIndexGivingMassageFromPlayer ()
    {
        System.out.println ("Please Choose one" +
                " Of Your cards ");
    }

    /**
     * this will pint no match card
     */
    public void printNoMatchCard ()
    {
        System.out.println ("No Match Card!");
    }

    /**
     * this will show the colors list to choose one of them
     */
    public void printColorGetterMassage ()
    {
        System.out.println ("please Choose a Color :\n" +
                "1) " + Color.BLUE.getANSICode () + '\u2B1B' + Color.RESET.getANSICode () + "\n" +
                "2) " + Color.RED.getANSICode () + '\u2B1B' + Color.RESET.getANSICode () + "\n" +
                "3) " + Color.GREEN.getANSICode () + '\u2B1B' + Color.RESET.getANSICode () + "\n" +
                "4) " + Color.YELLOW.getANSICode () + '\u2B1B' + Color.RESET.getANSICode () + "\n");
    }

    /**
     * this will print all
     * @param gameHandler game handler
     */
    public void printAllSize (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return;

        int counter = 1;
        for (Player player : gameHandler.getPlayers ())
        {
            System.out.print ("Player " + counter + ":" + player.getSizeOfCards () + "   ");
            if (counter == 11)
                System.out.println ();
            counter++;
        }
        System.out.println ();
    }

    /**
     * print the card on board
     * @param gameHandler game handler
     */
    public void printCardOnBoard (GameHandler gameHandler)
    {

        if (gameHandler == null)
            return;

        LinkedList<Card> cards = new LinkedList<> ();
        cards.add (gameHandler.getBoard ().getCardOnBoard ());
        printMaxSevenCard ("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ",cards,false,
                "",0);
        System.out.print ("\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "      Board color :");
        System.out.print ("  " + gameHandler.getBoard ().getColor ().getANSICode () + '\u2B1B' +
                Color.RESET.getANSICode () + "  ");

        System.out.println ();
    }

    /**
     * print who is turn
     * @param gameHandler game handler
     */
    public void printTurn (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return;
        System.out.print ("Player" + gameHandler.getTurn ().getWhoIsTurn () + "  turn      ");
    }

    /**
     * print the direction of game
     * @param gameHandler game handler
     */
    public void printDir (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return;
        System.out.println (" DIR : " + gameHandler.getDir ().getDirection ().getUniCode ());
    }

    /**
     * print the final score table
     * @param sortedPlayers list of players who sorted by their point less to most
     */
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

    /**
     * prints the players card
     * @param gameHandler game handler
     */
    public void printCardsOfPlayer (GameHandler gameHandler)
    {
        System.out.println ("________________________________________________________________" +
                "___________________________________________________________________" +
                "________________");
        int count = 0;
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
            count = printMaxSevenCard
                    ("",cards,true,gameHandler.getPlayerWhoIsTurn ()
                    .getClass ().getName (),count);
        }
        LinkedList<Card> secCards = new LinkedList<> ();
        for (int j = 0; j < notFullSeven; j++)
        {
            secCards.add (playerCards.get ((7 * fullSeven) + j));
        }
        if (notFullSeven != 0)
            printMaxSevenCard
                    ("",secCards,true,gameHandler.getPlayerWhoIsTurn ()
                    .getClass ().getName (),count);
        System.out.println ("________________________________________________________________" +
                "___________________________________________________________________" +
                "________________");
    }

    /**
     * prints maximum 7 cards in a row
     * @param dis beginner string for every line which use for printing cards in middle of
     *            screen
     * @param cards list of at  cards
     * @param showNumber can show number under cards
     * @param playerType player is human or machine
     * @param count this will use for printing numbers under cards
     * @return count
     */
    private int printMaxSevenCard (String dis, LinkedList<Card> cards, boolean showNumber,
                                     String playerType, int count)
    {
        if (cards == null)
            return 0;
        if (cards.size () > 7)
            return 0;

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
        return count;
    }

    /**
     * add color to cards
     * @param shape the base string for cards show
     * @param color input color
     */
    private void addColorToShape (StringBuilder shape, Color color)
    {
        if (color == null)
            return;
        shape.append (color.getANSICode ());
    }

    /**
     * add |$$$$$$$$$$| to card
     * @param dis beginner string for every line which use for printing cards in middle of
     *               screen
     * @param shape the base string for cards show
     * @param colors colors for every max 7 card
     * @param size size of cards 0 < x <= 7 can be
     */
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

    /**
     * add |          | to card
     * @param dis beginner string for every line which use for printing cards in middle of
     *                screen
     * @param shape the base string for cards show
     * @param colors colors for every max 7 card
     * @param size size of cards 0 < x <= 7 can be
     */
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

    /**
     * add |    typeOFCard   |  to card
     * @param dis beginner string for every line which use for printing cards in middle of
     *                screen
     * @param shape the base string for cards show
     * @param colors colors for every max 7 card
     * @param size size of cards 0 < x <= 7 can be
     * @param type list of players type
     */
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

    /**
     * this will prints a number down card
     * @param shape the base string for cards show
     * @param start start number
     * @param finish finish number
     */
    private void printNumberDownCard (StringBuilder shape, int start, int finish)
    {

        for (int i = start; i < finish; i++)
        {
            shape.append ("      (").append (i + 1).append (")            ");
        }
        shape.append ("\n");
    }

    /**
     * this will find color and type for all cards
     * @param type raw list of types
     * @param colors raw list of colors
     * @param cards list of cards
     * @param key if key 1 : cards are visible   else cards are invisible
     */
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
