/**
 * this Enum holds colors with their ANSI code
 *
 * @author Amir Naziri
 */
public enum Color
{
    RED ("\u001B[31m"), GREEN ("\u001b[38;5;34m"),
    BLUE ("\u001B[34m"), YELLOW ("\u001b[38;5;3m"),
    GRAY("\u001b[38;5;8m"), NON_COLOR(""),
    RESET ("\u001B[0m");

    private final String ANSI_CODE; // ANSI code of Color

    /**
     * creates a Color by input ANSI code
     * @param ANSI_CODE ANSI code for color
     */
    Color (String ANSI_CODE)
    {
        this.ANSI_CODE = ANSI_CODE;
    }

    /**
     * @return ANSI code of Color
     */
    public String getANSICode ()
    {
        return ANSI_CODE;
    }
}
