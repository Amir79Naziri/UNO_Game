/**
 * this class is for holding Direction of Game
 *
 * @author Amir Naziri
 */
public class GameDirection
{
    private Direction dir; // direction of Game

    /**
     * creates a new gameDirection
     */
    public GameDirection ()
    {
        dir = Direction.CLOCKWISE;
    }

    /**
     * change Direction of Game :  cw change to ccw  or  ccw change to cw
     */
    public void changeDirection ()
    {
        if (dir == Direction.CLOCKWISE)
            dir = Direction.COUNTERCLOCKWISE;
        else
            dir = Direction.CLOCKWISE;
    }

    /**
     * @return direction of Game
     */
    public Direction getDirection () {
        return dir;
    }
}
