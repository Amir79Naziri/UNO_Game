import java.util.LinkedList;

public class WildColorCard extends WildCard
{

    private WildColorCard () {}

    public void updateTurn (GameDirection dir, Turn turn)
    {
        if (turn == null)
            return;
        turn.changeTurn (dir,1);
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
