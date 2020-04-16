import java.util.LinkedList;

public abstract class Player
{
    private int point;
    private LinkedList<Card> cards;
    private boolean shouldUseDraw;
    private boolean ShouldUseWildDraw;

    public Player (LinkedList<Card> cards)
    {
        point = 0;
        this.cards = cards;
        shouldUseDraw = false;
        ShouldUseWildDraw = false;
    }

    public boolean isShouldUseDraw ()
    {
        return shouldUseDraw;
    }

    public boolean isShouldUseWildDraw () {
        return ShouldUseWildDraw;
    }

    public void setShouldUseDraw (boolean shouldUseDraw) {
        this.shouldUseDraw = shouldUseDraw;
    }

    public void setShouldUseWildDraw (boolean shouldUseWildDraw) {
        ShouldUseWildDraw =
                shouldUseWildDraw;
    }

    public void addCards (LinkedList<Card> newCards)
    {
        cards.addAll (newCards);
    }


    public LinkedList<Card> getCards () {
        return cards;
    }


    private void setPoint (int point) {
        this.point = point;
    }


    public int getPoint () {
        return point;
    }


    public void removeCard (Card card)
    {
        getCards ().remove (card);
    }


    public void calculatePoints ()
    {
        int sum = 0;
        for (Card card : cards)
        {
            if (card instanceof WildCard)
                sum += 50;
            if (card instanceof ColorCard)
            {
                if (card instanceof NumericCard)
                {
                    sum += ((NumericCard)card).getNumber ();
                }
                else
                    sum += 20;
            }
        }
        this.setPoint (sum);
    }

    public boolean hasWildCard ()
    {
        for (Card card : getCards ())
            if (card instanceof WildCard)
                return true;
        return false;
    }

    public boolean canUseWildCard (GameHandler gameHandler)
    {
        if (gameHandler == null)
            return false;

        for (Card card : getCards ())
        {
            if (card instanceof ColorCard && card.canUse (gameHandler))
                return false;
        }
        return true;
    }

    public boolean hasMatchCard (GameHandler gameHandler)

    {
        return !canUseWildCard (gameHandler) || hasWildCard ();
    }


    public abstract Card useCard (GameHandler gameHandler);


    public boolean hasColorDraw ()
    {
        for (Card card : getCards ())
            if (card instanceof ColorDrawCard)
                return true;
        return false;
    }

    public boolean hasWildDraw ()
    {
        for (Card card : getCards ())
            if (card instanceof WildDrawCard)
                return true;
        return false;
    }

}
