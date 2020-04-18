/**
 * this Enum holds Direction of Game : counterClockWise , ClockWise
 *
 * @author Amir Naziri
 */
public enum Direction
{
    COUNTERCLOCKWISE("\u21BA"), CLOCKWISE("\u21BB");

    private final String UNICODE; // unicode of direction show

    /**
     * creates a new direction
     * @param UNICODE unicode of new Direction
     */
    Direction (String UNICODE)
    {
        this.UNICODE = UNICODE;
    }

    /**
     * @return Direction Unicode
     */
    public String getUniCode ()
    {
        return UNICODE;
    }
}
