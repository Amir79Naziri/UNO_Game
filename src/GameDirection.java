public class GameDirection
{
    private Direction dir;

    public GameDirection ()
    {
        dir = Direction.CLOCKWISE;
    }

    public void changeDirection ()
    {
        if (dir == Direction.CLOCKWISE)
            dir = Direction.COUNTERCLOCKWISE;
        else
            dir = Direction.CLOCKWISE;
    }

    public Direction getDir () {
        return dir;
    }
}
