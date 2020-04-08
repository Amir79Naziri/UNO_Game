import java.util.ArrayList;
import java.util.Random;

public class ColorDrawCard extends ColorCard
    implements DrawType
{
    public ColorDrawCard (Color color)
    {
        super(color);
    }

    public boolean act (GameDirection dir, Turn turn, Board board, Color color
            , ArrayList<Card> cardsInStorage)
    {
        boolean result = super.act (dir, turn, board, color,cardsInStorage);
        if (result)
            return true;
        if (board.getCardOnBoard () instanceof ColorDrawCard)
        {
            board.changeCardOnBoard (this);
            board.changeColor (this.getColor ());
            return true;
        }
        else return false;
    }


    public void updateTurn (GameDirection dir, Turn turn)
    {
        if (turn == null)
            return;
        turn.changeTurn (dir,2);
    }


    public void giveCardToPlayer (GameDirection dir, Turn turn, Board board, Color color
            , ArrayList<Card> cardsInStorage)
    {
        Random random = new Random ();
        Card[] cardsForPlayer = new Card[2];
        for (int i = 0; i < 2; i++)
        {
            int index = random.nextInt (cardsInStorage.size ());
            cardsForPlayer[i] = cardsInStorage.get (index);
            cardsInStorage.remove (index);
        }
    }
}
