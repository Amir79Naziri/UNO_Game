/**
 * this class represents the board in game which has a Card on it and has Color too
 *
 * @author Amir Naziri
 */
public class Board
{
    private Card cardOnBoard; // card on board
    private Color color; // color of board

    /**
     * Creates a new Board
     */
    public Board ()
    {
        this.cardOnBoard = null;
    }

    /**
     * @return Card on board
     */
    public Card getCardOnBoard () {
        return cardOnBoard;
    }

    /**
     * @return Color on Board
     */
    public Color getColor () {
        return color;
    }

    /**
     * changes the Card on board by new Card and returns the previous card on board
     * @param cardOnBoard new Card
     * @return previous card on board
     */
    public Card changeCardOnBoard (Card cardOnBoard)
    {
        Card lastCard = this.cardOnBoard; // save the previous card on board
        this.cardOnBoard = cardOnBoard;
        return lastCard; // return previous card on board
    }

    /**
     * changes the color of board
     * @param color new Color
     */
    public void changeColor (Color color)
    {
        this.color = color;
    }
}
