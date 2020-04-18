/**
 * this abstract class represent a Card with it's attributes and behavior
 *
 * @author Amir Naziri
 */
public abstract class Card
{
    /**
     * this method checks that can this card act
     * @param gameHandler game handler
     * @return result of success of act
     */
    public abstract boolean canUse (GameHandler gameHandler);

    /**
     * by this method card will act and changes the State of Game
     * @param gameHandler game handler
     * @param color input color for next state only use for Wild cards
     * @return result of success of act
     */
    public abstract boolean use (GameHandler gameHandler, Color color);

    /**
     * this will change the turn of Players
     * @param gameHandler game handler
     * @param unit unit of change turn
     */
    public void updateTurn (GameHandler gameHandler, int unit)
    {
        if (gameHandler == null)
            return; // some mistake

        gameHandler.getTurn ().changeTurn (gameHandler.getDir (),unit); // change thr turn
                                                                        // by given unit
    }
}
