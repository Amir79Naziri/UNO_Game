import java.util.LinkedList;


public class WildDrawCard extends WildCard
    implements DrawType
{
    private WildDrawCard () {}


    public boolean act (GameDirection dir, Turn turn, Board board, Color color, Storage storage ,
                        Player[] players)
    {
        if (super.act (dir, turn, board, color, storage,players))
        {
            giveCardToPlayer (dir, turn, board, color, storage, players);
            return true;
        }
        else return false;
    }

    public void updateTurn (GameDirection dir, Turn turn) {
        if (turn == null)
            return;
        turn.changeTurn (dir,1);
    }


    public void giveCardToPlayer (GameDirection dir, Turn turn, Board board, Color color, Storage storage,
                                  Player[] players)
    {
        if (turn == null || storage == null)
            return;
        turn.changeTurn (dir,1);
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
