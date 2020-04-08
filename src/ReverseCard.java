import java.util.ArrayList;
import java.util.LinkedList;

public class ReverseCard extends ColorCard

{

    private ReverseCard (Color color)
    {
        super(color);
    }



    public boolean act (GameDirection dir, Turn turn, Board board, Color color, Storage storage) {
        boolean result = super.act (dir, turn, board, color,storage);
        if (result)
            return true;
        if (board.getCardOnBoard () instanceof ReverseCard)
        {
            board.changeCardOnBoard (this);
            board.changeColor (this.getColor ());
            return true;
        }
        else return false;
    }


    private void changeDir (GameDirection dir)
    {
        if (dir == null)
            return;
        dir.changeDirection ();
    }


    public void updateTurn (GameDirection dir, Turn turn)
    {
        if (turn == null)
            return;
        changeDir (dir);
        turn.changeTurn (dir,1);
    }

    public static LinkedList<Card> produceCards ()
    {
        LinkedList<Card> list = new LinkedList<> ();

        for (int i = 0; i < 4; i++)
        {
            list.add (new ReverseCard (Color.YELLOW));
            list.add (new ReverseCard (Color.RED));
            list.add (new ReverseCard (Color.GREEN));
            list.add (new ReverseCard (Color.BLUE));
        }
        return list;
    }
}
