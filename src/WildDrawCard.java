import java.util.LinkedList;


public class WildDrawCard extends WildCard
    implements DrawType
{
    public WildDrawCard () {}


    public boolean use (GameDirection dir, Turn turn, Board board, Color color, Storage storage ,
                        Player[] players)
    {
        if (!super.canUse (board))
            return false;

        giveCardToPlayer (dir, turn, board, color, storage, players);
        updateTurn (dir,turn,1);
        return true;


    }


    public void giveCardToPlayer (GameDirection dir, Turn turn, Board board, Color color,
                                  Storage storage, Player[] players)
    {
        if (turn == null || storage == null)
            return;
        LinkedList<Card> cards = storage.CardsForPlayer (4);
        if (cards != null)
            players[turn.getWhoIsTurn () - 1].addCards (cards);
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
