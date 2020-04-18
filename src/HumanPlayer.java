import java.util.LinkedList;

/**
 * this class represents a Human Player
 * this extends Player
 * @see Player
 * @author Amir Naziri
 */
public class HumanPlayer extends Player
{
    /**
     * creates a new Human Player
     * @param cards list of Card for begin
     */
    public HumanPlayer (LinkedList<Card> cards)
    {
        super (cards);
    }

    @Override
    public Card useCard (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return null;
        int index = gameHandler.getUserInterface ().getIndex (getSizeOfCards ());
        // index of chosen card
        if (getCards ().get (index).canUse (gameHandler))
        {
            if (getCards ().get (index) instanceof WildCard )
            {
                if (canUseWildCard (gameHandler))
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
