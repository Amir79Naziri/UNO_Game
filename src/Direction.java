public enum Direction
{
    COUNTERCLOCKWISE("\u21BA"), CLOCKWISE("\u21BB");

    private String uniCode;

    private Direction (String uniCode)
    {
        this.uniCode = uniCode;
    }

    public String getUniCode ()
    {
        return uniCode;
    }
}
