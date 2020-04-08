import java.util.LinkedList;


public class WildDrawCard extends WildCard
    implements DrawType
{
    private WildDrawCard () {}
    public boolean act (GameDirection dir, Turn turn, Board board, Color color, Storage storage)
    {
        if (super.act (dir, turn, board, color, storage))
        {
            giveCardToPlayer (dir,turn,board,color,storage);
            return true;
        }
        else return false;
    }


    public void updateTurn (GameDirection dir, Turn turn) {
        if (turn == null)
            return;
        turn.changeTurn (dir,2);
    }

    public void giveCardToPlayer (GameDirection dir, Turn turn, Board board, Color color, Storage storage)
    {

    }

    public static LinkedList<Card> produceCards ()
    {
        LinkedList<Card> list = new LinkedList<> ();

        for (int i = 0; i < 4; i++)
        {
            list.add (new WildDrawCard ());
        }
        return list;
    }
}
