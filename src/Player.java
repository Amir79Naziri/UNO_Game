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


    public void removeCard (Card card)
    {
        getCards ().remove (card);
    }


}
