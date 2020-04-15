import java.util.LinkedList;



public class WildDrawCard extends WildCard
    implements DrawType
{
    public WildDrawCard () {}


    public boolean use (GameDirection dir, Turn turn, Board board, Color color, Storage storage ,
                        Player[] players, int sequence)
    {
        if (!super.canUse (board))
            return false;
        if (super.use (dir, turn, board, color, storage, players,sequence))
        {
            giveCardToPlayer (dir, turn, board, color, storage, players,sequence);
            updateTurn (dir,turn,1);
            return true;
        }

        storage.addCard (board.changeCardOnBoard (this));
        board.changeColor (color);
        updateTurn (dir,turn,1);
        giveCardToPlayer (dir, turn, board, color, storage, players,sequence);
        updateTurn (dir,turn,1);
        return true;
    }


    public void giveCardToPlayer (GameDirection dir, Turn turn, Board board, Color color,
                                  Storage storage, Player[] players, int sequence)
    {
        if (turn == null || storage == null)
            return;
        LinkedList<Card> cards = storage.CardsForPlayer (sequence * 4);
        if (cards != null)
            players[turn.getWhoIsTurn () - 1].addCards (cards);
    }

    public boolean equals (Object o)
    {
        if (!(super.equals (o))) return false;
        if (o == this) return true;
        return o instanceof WildDrawCard;
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
