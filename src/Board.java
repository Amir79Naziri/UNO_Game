public class Board
{
    private Card cardOnBoard;
    private Color color;

    public Board ()
    {
        this.cardOnBoard = null;
    }

    public Card getCardOnBoard () {
        return cardOnBoard;
    }

    public Color getColor () {
        return color;
    }

    public Card changeCardOnBoard (Card cardOnBoard)
    {
        Card lastCard = this.cardOnBoard;
        this.cardOnBoard = cardOnBoard;
        return lastCard;
    }

    public void changeColor (Color color)
    {
        this.color = color;
    }
}
