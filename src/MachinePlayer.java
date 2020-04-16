import java.util.LinkedList;

public class MachinePlayer extends Player
{
    public MachinePlayer (LinkedList<Card> cards)
    {
        super(cards);
    }

    public Card useCard (GameHandler gameHandler)
    {
        if (canUseWildCard (gameHandler))
        {
            for (Card card : getCards ())
                if (card instanceof WildCard)
                {
                    if (isShouldUseWildDraw ())
                    {
                        if (card instanceof WildDrawCard)
                        {
                            this.setShouldUseWildDraw (false);
                            removeCard (card);
                            return card;
                        }
                    }
                    else
                    {
                        removeCard (card);
                        return card;
                    }
                }
        }
        else
        {
            for (Card card : getCards ())
                if (!(card instanceof NumericCard) && card.canUse (gameHandler))
                {
                    if (isShouldUseDraw ())
                    {
                        if (card instanceof ColorDrawCard)
                        {
                            this.setShouldUseDraw (false);
                            removeCard (card);
                            return card;
                        }
                    }
                    else
                    {
                        removeCard (card);
                        return card;
                    }
                }

            for (Card card : getCards ())
                if (card instanceof NumericCard && card.canUse (gameHandler))
                {
                    removeCard (card);
                    return card;
                }
        }
        return null;
    }
}
