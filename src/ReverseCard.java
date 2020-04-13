import java.util.LinkedList;

public class ReverseCard extends ColorCard

{

    public ReverseCard (Color color)
    {
        super(color);
    }


    public boolean canUse (Board board)
    {
        if (board == null)
            return false;
        if (super.canUse (board))
            return true;
        return board.getCardOnBoard () instanceof ReverseCard;
    }

    public boolean use (GameDirection dir, Turn turn, Board board, Color color, Storage storage,
                        Player[] players) {

        if (!canUse (board))
            return false;
        if (super.use (dir, turn, board, color, storage, players))
        {
            changeDir (dir);
            updateTurn (dir,turn,1);
            return true;
        }

        storage.addCard (board.changeCardOnBoard (this));
        board.changeColor (this.getColor ());
        changeDir (dir);
        updateTurn (dir,turn,1);
        return true;
    }


    private void changeDir (GameDirection dir)
    {
        if (dir == null)
            return;
        dir.changeDirection ();
    }

    public boolean equals (Object o)
    {
        if (!(super.equals (o))) return false;
        if (o == this) return true;
        return o instanceof ReverseCard;
    }

    public static LinkedList<Card> produceCards ()
    {
        LinkedList<Card> list = new LinkedList<> ();

        for (int i = 0; i < 2; i++)
        {
            list.add (new ReverseCard (Color.YELLOW));
            list.add (new ReverseCard (Color.RED));
            list.add (new ReverseCard (Color.GREEN));
            list.add (new ReverseCard (Color.BLUE));
        }
        return list;
    }
}
