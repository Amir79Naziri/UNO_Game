public enum Direction
{
    COUNTERCLOCKWISE ("CounterClockWise"), CLOCKWISE ("ClockWise");

    private String name;

    private Direction(String name)
    {
        this.name = name;
    }


    public String getName ()
    {
        return name;
    }
}
