import java.util.LinkedList;
import java.util.Random;

public class Storage
{
    private static Storage storage = null;
    private LinkedList<Card> cards;
    private LinkedList<Card> colorCards;


    private Storage ()
    {
        cards = new LinkedList<> ();
        colorCards = new LinkedList<> ();

        cards.addAll (ColorCard.produceCards ());
        cards.addAll (WildCard.produceCards ());
        colorCards.addAll (ColorCard.produceCards ());
    }

    public static Storage getInstanceStorage ()
    {
        if (storage == null)
            storage = new Storage ();
        return storage;
    }

    public int getSize ()
    {
        return cards.size ();
    }


    public LinkedList<Card> CardsForPlayer (int number)
    {
        if (number > getSize ())
            return null;
        LinkedList<Card> playersCards = new LinkedList<> ();
        Random random = new Random ();
        for (int i = 0; i < number; i++)
        {
            int index = random.nextInt (cards.size ());
            playersCards.add (cards.get (index));
            colorCards.remove (cards.get (index));
            cards.remove (index);
        }
        return playersCards;
    }

    public Card CardForBoard ()
    {
        if (colorCards.size () < 1)
            return null;
        Random random = new Random ();
        int index = random.nextInt (colorCards.size ());
        Card card = colorCards.get (index);
        colorCards.remove (index);
        return card;
    }
}