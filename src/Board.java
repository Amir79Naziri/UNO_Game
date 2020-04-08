public class Board
{
    private Card cardOnBoard;
    private Color color;

    public Board (Card cardOnBoard)
    {
        this.cardOnBoard = cardOnBoard;
    }

    public Card getCardOnBoard () {
        return cardOnBoard;
    }

    public Color getColor () {
        return color;
    }

    public void changeCardOnBoard (Card cardOnBoard)
    {
        this.cardOnBoard = cardOnBoard;
    }

    public void changeColor (Color color)
    {
        this.color = color;
    }
}
