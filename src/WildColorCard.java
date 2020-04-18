import java.util.LinkedList;

/**
 * this class represent a wild four color card
 * this extends wildCard
 * @see WildCard
 * @author Amir Naziri
 */
public class WildColorCard extends WildCard
{

    /**
     * create a new wild four color card
     */
    private WildColorCard () {}

    @Override
    public boolean equals (Object o)
    {
        if (!(super.equals (o))) return false;
        if (o == this) return true;
        return o instanceof WildColorCard;
    }

    /**
     * this will create 4 of this cards
     * @return list of cards
     */
    public static LinkedList<Card> produceCards ()
    {
        LinkedList<Card> list = new LinkedList<> ();

        for (int i = 0; i < 4; i++)
        {
            list.add (new WildColorCard ());
        }
        return list;
    }
}
