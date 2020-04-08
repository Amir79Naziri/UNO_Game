import java.util.LinkedList;


public class ColorDrawCard extends ColorCard
    implements DrawType
{
    private ColorDrawCard (Color color)
    {
        super(color);
    }

    public boolean act (GameDirection dir, Turn turn, Board board, Color color, Storage storage,
                        Player[] players)
    {
        boolean result = super.act (dir, turn, board, color,storage,players);
        if (!result)
        {
            if (board.getCardOnBoard () instanceof ColorDrawCard)
            {
                board.changeCardOnBoard (this);
                board.changeColor (this.getColor ());
            }
            else return false;
        }
        giveCardToPlayer (dir, turn, board, color, storage, players);
        return true;
    }


    public void updateTurn (GameDirection dir, Turn turn)
    {
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
        LinkedList<Card> cards = storage.CardsForPlayer (2);
        if (cards != null)
            players[turn.getWhoIsTurn () - 1].addCards (cards);
    }

    public static LinkedList<Card> produceCards ()
    {
        LinkedList<Card> list = new LinkedList<> ();

        for (int i = 0; i < 2; i++)
        {
            list.add (new ColorDrawCard (Color.YELLOW));
            list.add (new ColorDrawCard (Color.RED));
            list.add (new ColorDrawCard (Color.GREEN));
            list.add (new ColorDrawCard (Color.BLUE));
        }
        return list;
    }


}
