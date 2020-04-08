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
}
