public interface DrawType
{
    void giveCardToPlayer (GameDirection dir, Turn turn, Board board, Color color, Storage storage,
                                  Player[] players, SequenceKeeper sequence);
}
