/**
 * this interface is for giving card to player after using DrawType
 *
 * @author Amir Naziri
 */
public interface DrawType
{
    /**
     * Gives Card to Player after using a Draw Card in game by previous player
     * @param gameHandler game handler
     */
    void giveCardToPlayer (GameHandler gameHandler);
}
