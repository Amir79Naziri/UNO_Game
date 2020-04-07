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

    public void changeCardOnBoard (Card cardOnBoard)
    {
        this.cardOnBoard = cardOnBoard;
        changeColor (cardOnBoard);
    }

    private void changeColor (Card cardOnBoard)
    {
        if (cardOnBoard instanceof ColorCard)
        {
            color = ((ColorCard) cardOnBoard).getColor ();
        }
    }
}
