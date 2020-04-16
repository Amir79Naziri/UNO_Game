import java.util.LinkedList;

public class HumanPlayer extends Player
{
    public HumanPlayer (LinkedList<Card> cards)
    {
        super (cards);
    }

    public Card useCard (UserInterface userInterface, Board board)
    {
        if (userInterface == null)
            return null;
        int index = userInterface.getIndex (getCards ().size ());

        if (getCards ().get (index).canUse (board))
        {
            if (getCards ().get (index) instanceof WildCard )
            {
                if (canUseWildCard (board))
                {
                    Card card = getCards ().get (index);
                    if (isShouldUseWildDraw ())
                    {
                        if (card instanceof WildDrawCard)
                        {
                            this.setShouldUseWildDraw (false);
                            removeCard (card);
                            return card;
                        } else return null;
                    }
                    else
                    {
                        removeCard (card);
                        return card;
                    }
                }
                else return null;
            }
            else
            {
                Card card = getCards ().get (index);
                if (isShouldUseDraw ())
                {
                    if (card instanceof ColorDrawCard)
                    {
                        this.setShouldUseDraw (false);
                        removeCard (card);
                        return card;
                    }
                    else return null;
                }
                else
                {
                    removeCard (card);
                    return card;
                }
            }
        }
        else return null;
    }
}
