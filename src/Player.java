import java.util.LinkedList;

/**
 * this class represents a Player in game
 *
 * @author Amir Naziri
 */
public abstract class Player
{
    private int point; // points (Scores)
    private LinkedList<Card> cards; // list of cards
    private boolean shouldUseDraw; // should use just Draw
    private boolean ShouldUseWildDraw; // should use just WildDraw

    /**
     * creates a new Player with given 7 cards for start
     * @param cards list of cards (7 cards for start)
     */
    public Player (LinkedList<Card> cards)
    {
        point = 0;
        this.cards = cards;
        shouldUseDraw = false;
        ShouldUseWildDraw = false;
    }

    /**
     * @return shouldUseDraw
     */
    public boolean isShouldUseDraw ()
    {
        return shouldUseDraw;
    }

    /**
     * @return ShouldUseWildDraw
     */
    public boolean isShouldUseWildDraw () {
        return ShouldUseWildDraw;
    }

    /**
     * change ShouldUseDraw
     * @param shouldUseDraw new input for ShouldUseDraw
     */
    public void setShouldUseDraw (boolean shouldUseDraw) {
        this.shouldUseDraw = shouldUseDraw;
    }

    /**
     * change ShouldUseWildDraw
     * @param shouldUseWildDraw new input for ShouldUseWildDraw
     */
    public void setShouldUseWildDraw (boolean shouldUseWildDraw) {
        ShouldUseWildDraw =
                shouldUseWildDraw;
    }

    /**
     * adding new cards to players card
     * @param newCards list of new cards
     */
    public void addCards (LinkedList<Card> newCards)
    {
        cards.addAll (newCards);
    }

    /**
     * @return list of cards
     */
    public LinkedList<Card> getCards () {
        return cards;
    }

    /**
     * change the point of Player
     * @param point new point
     */
    private void setPoint (int point) {
        this.point = point;
    }

    /**
     * @return size of cards
     */
    public int getSizeOfCards ()
    {
        return getCards ().size ();
    }

    /**
     * @return points of player
     */
    public int getPoint () {
        return point;
    }

    /**
     * remove a card from list
     * @param card card which want to remove
     */
    public void removeCard (Card card)
    {
        getCards ().remove (card);
    }

    /**
     * calculate points by the rule of Game : number cards point : own number
     * move color cards : 20
     * wild cards : 50
     */
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

    /**
     * @return has player Wild card
     */
    public boolean hasWildCard ()
    {
        for (Card card : getCards ())
            if (card instanceof WildCard)
                return true;
        return false;
    }

    /**
     * can player use a wild card
     * @param gameHandler game handler
     * @return result
     */
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

    /**
     * has player match card with board card
     * @param gameHandler game handler
     * @return result
     */
    public boolean hasMatchCard (GameHandler gameHandler)

    {
        return !canUseWildCard (gameHandler) || hasWildCard ();
    }

    /**
     * by this method player gives a card from it's list to gameHandler
     * for placing that on board
     * @param gameHandler game handler
     * @return chosen card
     */
    public abstract Card useCard (GameHandler gameHandler);

    /**
     * @return has player Draw 2+
     */
    public boolean hasColorDraw ()
    {
        for (Card card : getCards ())
            if (card instanceof ColorDrawCard)
                return true;
        return false;
    }

    /**
     * @return has player wildDraw
     */
    public boolean hasWildDraw ()
    {
        for (Card card : getCards ())
            if (card instanceof WildDrawCard)
                return true;
        return false;
    }

}
