import java.util.LinkedList;

public class Printer
{
    private static int count = 0;

    public void printIndexGivingMassageFromPlayer ()
    {
        System.out.println ("Please Choose one" +
                " Of Your cards ");
    }

    public void printCards (LinkedList<Card> playerCards)
    {
        count = 0;
        if (playerCards == null)
            return;
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
            printMaxSevenCard (cards);
        }
        LinkedList<Card> secCards = new LinkedList<> ();
        for (int j = 0; j < notFullSeven; j++)
        {
            secCards.add (playerCards.get ((7 * fullSeven) + j));
        }
        printMaxSevenCard (secCards);
    }

    private void printMaxSevenCard (LinkedList<Card> cards)
    {
        if (cards == null)
            return;
        if (cards.size () > 7)
            return;
        Color[] colors = new Color[cards.size ()];
        String[] type = new String[cards.size ()];
        int counter = 0;
        for (Card card : cards)
        {
            if (card instanceof WildCard)
            {
                if (card instanceof WildDrawCard)
                    type[counter] = "|     +4      |";
                else
                    type[counter] = "|  fourColor  |";
                colors[counter] = Color.NON_COLOR;
            }
            else
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

        StringBuilder shape = new StringBuilder ();

        addHeaderToShape (shape,colors,cards.size ());
        addMiddleToShape (shape,colors,cards.size ());
        addTypeToShape (shape,type,colors,cards.size ());
        addMiddleToShape (shape,colors,cards.size ());
        addHeaderToShape (shape,colors,cards.size ());
        printNumberDownCard (shape,count * 7,cards.size () + count * 7);
        count++;

        System.out.print (shape.toString ());
        System.out.println ("\n");

    }

    private void addColorToShape (StringBuilder shape, Color color)
    {
        if (color == null)
            return;
        switch (color)
        {
            case GREEN:
                shape.append ("\u001b[38;5;34m");
                break;
            case RED:
                shape.append ("\u001B[31m");
                break;
            case BLUE:
                shape.append ("\u001B[34m");
                break;
            case YELLOW:
                shape.append ("\u001b[38;5;3m");
                break;
        }
    }

    private void addHeaderToShape (StringBuilder shape, Color[] colors, int size)
    {
        for (int i = 0; i < size; i++)
        {
            addColorToShape (shape,colors[i]);
            shape.append ("|$$$$$$$$$$$$$|").append ("\u001B[0m").append ("      ");
        }
        shape.append ("\n");
    }

    private void addMiddleToShape (StringBuilder shape, Color[] colors, int size)
    {
        for (int i = 0; i < size; i++)
        {
            addColorToShape (shape,colors[i]);
            shape.append ("|             |").append ("\u001B[0m").append ("      ");
        }
        shape.append ("\n");
    }

    private void addTypeToShape (StringBuilder shape, String[] type, Color[] colors, int size)
    {
        for (int i = 0; i < size; i++)
        {
            addColorToShape (shape,colors[i]);
            shape.append (type[i]).append ("\u001B[0m").append ("      ");
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
}
