public class WildDrawCard extends WildCard
    implements DrawType
{
    public boolean act (GameDirection dir, Turn turn, Board board, Color color)
    {
        return true;
    }


    public void updateTurn (GameDirection dir, Turn turn) {

    }

    public void giveCardToPlayer (GameDirection dir, Turn turn, Board board, Color color)
    {

    }
}
