import java.util.LinkedList;


public class ColorDrawCard extends ColorCard
    implements DrawType

{
    private ColorDrawCard (Color color)
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
                        Player[] players)
    {
        if (!canUse (board))
            return false;
        if (super.use (dir, turn, board, color, storage, players))
        {
            updateTurn (dir, turn,1);
            giveCardToPlayer (dir, turn, board, color, storage, players);
            updateTurn (dir, turn,1);
            return true;
        }

        board.changeCardOnBoard (this);
        board.changeColor (this.getColor ());
        updateTurn (dir, turn,1);
        giveCardToPlayer (dir, turn, board, color, storage, players);
        updateTurn (dir, turn,1);
        return true;
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
