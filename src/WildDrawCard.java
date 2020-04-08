import java.util.LinkedList;


public class WildDrawCard extends WildCard
    implements DrawType
{
    private WildDrawCard () {}


    public boolean use (GameDirection dir, Turn turn, Board board, Color color, Storage storage ,
                        Player[] players)
    {
        if (!canUse (board))
            return false;
        if (super.use (dir, turn, board, color, storage, players))
        {
            giveCardToPlayer (dir, turn, board, color, storage, players);
            updateTurn (dir,turn,1);
            return true;
        }

        storage.addCard (board.changeCardOnBoard (this));
        board.changeColor (color);
        updateTurn (dir,turn,1);
        giveCardToPlayer (dir, turn, board, color, storage, players);
        updateTurn (dir,turn,1);
        return true;
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
