public interface Card
{

    boolean act (GameDirection dir, Turn turn, Board board, Color color, Storage storage);
    void updateTurn (GameDirection dir, Turn turn);

}
