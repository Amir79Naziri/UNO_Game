import java.util.LinkedList;
import java.util.Random;

/**
 * this class is the Storage of game which keep a total cards in it
 *
 * @author Amir Naziri
 */
public class Storage
{
    private static Storage storage = null; // instance of Storage
    private LinkedList<Card> cards; // list of all cards
    private LinkedList<Card> colorCards; // list of color cards from total list

    /**
     * creates a new Storage
     */
    private Storage ()
    {
        cards = new LinkedList<> ();
        colorCards = new LinkedList<> ();

        cards.addAll (ColorCard.produceCards ());
        cards.addAll (WildCard.produceCards ());
        colorCards.addAll (ColorCard.produceCards ());
    }

    /**
     * add a card to the Storage
     * @param card card
     */
    public void addCard (Card card)
    {
        cards.add (card);
        if (card instanceof ColorCard)
            colorCards.add (card);
    }

    /**
     * this static method will create a instance of Storage
     * @return Storage instance
     */
    public static Storage getInstanceStorage ()
    {
        if (storage == null)
            storage = new Storage ();
        return storage;
    }

    /**
     * @return sizeOfStorage
     */
    public int getSize ()
    {
        return cards.size ();
    }

    /**
     * this will returns a list af cards for player
     * @param number limit size for list of cards
     * @return list of cards
     */
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

    /**
     * this will gives a ColorCard to board for start
     * @return card
     */
    public Card CardForBoard ()
    {
        if (colorCards.size () < 1)
            return null;
        Random random = new Random ();
        int index = random.nextInt (colorCards.size ());
        Card card = colorCards.get (index);
        cards.remove (card);
        colorCards.remove (index);
        return card;
    }
}