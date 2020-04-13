public enum Color
{
    RED ("\u001B[31m"), GREEN ("\u001b[38;5;34m"),
    BLUE ("\u001B[34m"), YELLOW ("\u001b[38;5;3m"),
    GRAY("\u001b[38;5;8m"), NON_COLOR(""),
    RESET ("\u001B[0m");

    private String uniCode;

    private Color (String uniCode)
    {
        this.uniCode = uniCode;
    }

    public String getANSICode ()
    {
        return uniCode;
    }
}
