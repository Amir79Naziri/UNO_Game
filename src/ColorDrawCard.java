import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class ColorDrawCard extends ColorCard
    implements DrawType
{
    private ColorDrawCard (Color color)
    {
        super(color);
    }

    public boolean act (GameDirection dir, Turn turn, Board board, Color color, Storage storage)
    {
        boolean result = super.act (dir, turn, board, color,storage);
        if (result)
            return true;
        if (board.getCardOnBoard () instanceof ColorDrawCard)
        {
            board.changeCardOnBoard (this);
            board.changeColor (this.getColor ());
            return true;
        }
        else return false;
    }


    public void updateTurn (GameDirection dir, Turn turn)
    {
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
            list.add (new ColorDrawCard (Color.YELLOW));
            list.add (new ColorDrawCard (Color.RED));
            list.add (new ColorDrawCard (Color.GREEN));
            list.add (new ColorDrawCard (Color.BLUE));
        }
        return list;
    }


}
