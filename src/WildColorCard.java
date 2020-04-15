import java.util.LinkedList;

public class WildColorCard extends WildCard
{

    private WildColorCard () {}


    public boolean equals (Object o)
    {
        if (!(super.equals (o))) return false;
        if (o == this) return true;
        return o instanceof WildColorCard;
    }

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
