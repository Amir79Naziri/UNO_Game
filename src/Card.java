public interface Card
{

    boolean act (GameDirection dir, Turn turn, Board board, Color color, Storage storage,
                 Player[] players);
    void updateTurn (GameDirection dir, Turn turn);

}
