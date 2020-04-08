import java.util.LinkedList;

public class HumanPlayer extends Player
{
    public HumanPlayer (LinkedList<Card> cards)
    {
        super(cards);
    }

    public Card doTurn (int index,Board board)
    {
        if (canUseWildCard (index,board))
            return getCards ().get (index);
        else
            return null;
    }
}
