import java.util.ArrayList;
import java.util.Random;

public class WildDrawCard extends WildCard
    implements DrawType
{
    public boolean act (GameDirection dir, Turn turn, Board board, Color color,
                        ArrayList<Card> cardsInStorage)
    {
        if (super.act (dir, turn, board, color, cardsInStorage))
        {
            giveCardToPlayer (dir,turn,board,color,cardsInStorage);
            return true;
        }
        else return false;
    }


    public void updateTurn (GameDirection dir, Turn turn) {
        if (turn == null)
            return;
        turn.changeTurn (dir,2);
    }

    public void giveCardToPlayer (GameDirection dir, Turn turn, Board board, Color color
                        , ArrayList<Card> cardsInStorage)
    {

        Random random = new Random ();
        Card[] cardsForPlayer = new Card[4];
        for (int i = 0; i < 4; i++)
        {
            int index = random.nextInt (cardsInStorage.size ());
            cardsForPlayer[i] = cardsInStorage.get (index);
            cardsInStorage.remove (index);
        }
    }
}
