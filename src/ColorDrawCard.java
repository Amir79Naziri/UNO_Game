import java.util.LinkedList;


public class ColorDrawCard extends ColorCard
    implements DrawType

{
    public ColorDrawCard (Color color)
    {
        super(color);
    }


    public boolean canUse (Board board)
    {
        if (board == null)
            return false;
        if (super.canUse (board))
            return true;
        return board.getCardOnBoard () instanceof ColorDrawCard;
    }

    public boolean use (GameDirection dir, Turn turn, Board board, Color color, Storage storage,
                        Player[] players, int sequence)
    {
        if (!canUse (board))
            return false;
        if (!(super.use (dir, turn, board, color, storage, players,sequence)))
        {
            storage.addCard (board.changeCardOnBoard (this));
            board.changeColor (this.getColor ());
        }

        turn.changeTurn (dir,1);
        if (!(players[turn.getWhoIsTurn () - 1].hasColorDraw ()))
        {
            giveCardToPlayer (dir, turn, board, color, storage, players,sequence);
            updateTurn (dir, turn,1);
        }
        else
            players[turn.getWhoIsTurn () - 1].setShouldUseDraw (true);
        return true;
    }


    public void giveCardToPlayer (GameDirection dir, Turn turn, Board board, Color color,
                                  Storage storage, Player[] players, int sequence)
    {
        LinkedList<Card> cards;
        if (turn == null || storage == null)
            return;

        cards = storage.CardsForPlayer (sequence * 2);

        if (cards != null)
            players[turn.getWhoIsTurn () - 1].addCards (cards);
    }

    public boolean equals (Object o)
    {
        if (!(super.equals (o))) return false;
        if (o == this) return true;
        return o instanceof ColorDrawCard;
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
