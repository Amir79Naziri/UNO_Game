public interface DrawType extends Card
{
    public void giveCardToPlayer (GameDirection dir, Turn turn, Board board, Color color,
                                  Storage storage);
}
