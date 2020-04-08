public class WildColorCard extends WildCard
{


    public void updateTurn (GameDirection dir, Turn turn)
    {
        if (turn == null)
            return;
        turn.changeTurn (dir,1);
    }
}
