import java.util.ArrayList;

public interface Card
{

    boolean act (GameDirection dir, Turn turn, Board board, Color color, ArrayList<Card> cardsInStorage);
    void updateTurn (GameDirection dir, Turn turn);

}
