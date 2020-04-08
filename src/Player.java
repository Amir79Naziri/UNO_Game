import java.util.LinkedList;

public class Player
{
    private int point;
    private LinkedList<Card> cards;

    public Player (LinkedList<Card> cards)
    {
        point = 0;
        this.cards = cards;
    }


    public void addCards (LinkedList<Card> newCards)
    {
        cards.addAll (newCards);
    }


    public LinkedList<Card> getCards () {
        return cards;
    }

    public void setPoint (int point) {
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

    public boolean canUseCard (int index, Board board)
    {
        if (!(getCards ().get (index) instanceof  WildCard))
            return true;
        for (Card card : getCards ())
        {
            if (card instanceof ColorCard && ((ColorCard)card).getColor () == board.getColor ())
                return false;
            if (card instanceof NumericCard && board.getCardOnBoard() instanceof NumericCard &&
                    ((NumericCard)card).getNumber () ==
                            ((NumericCard)board.getCardOnBoard ()).getNumber ())
                return false;
        }
        return true;
    }

    public boolean hasWildCard ()
    {
        for (Card card : getCards ())
            if (card instanceof WildCard)
                return true;
        return false;
    }

    public int hasMatchCard (Board board)
    {
        for (Card card : getCards ())
        {
            if (Board instanceof ColorCard)

        }
    }

}
