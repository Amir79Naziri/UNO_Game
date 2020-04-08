import java.util.LinkedList;

public class HumanPlayer extends Player
{
    public HumanPlayer (LinkedList<Card> cards)
    {
        super(cards);
    }

    public void doTurn (i)
    {

    }

    private Card useCard (int index)
    {
        return getCards ().get (index);
    }


}
