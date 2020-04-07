public interface Card
{

    boolean act (GameDirection dir, Turn turn, Board board, Color color);
    void updateTurn (GameDirection dir, Turn turn);

}
