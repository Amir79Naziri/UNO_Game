/**
 * this class will save the sequence of using wildDraw and Draw Sequence
 *
 * @author Amir Naziri
 */
public class SequenceKeeper
{
    private int seqND; // sequence for Draw 2+
    private int seqWD; // sequence for WildDraw

    /**
     * creates a new sequence keeper
     */
    public SequenceKeeper ()
    {
        seqND = 1;
        seqWD = 1;
    }

    /**
     * increase sequence of Draw 2+ one unit
     */
    public void increaseSeqND () {
        this.seqND++;
    }

    /**
     * increase sequence of WildDraw one unit
     */
    public void increaseSeqWD () {
        this.seqWD++;
    }

    /**
     * @return sequence of Draw 2+
     */
    public int getSeqND () {
        return seqND;
    }

    /**
     * @return sequence of WildDraw
     */
    public int getSeqWD () {
        return seqWD;
    }

    /**
     * the sequence of Draw 2+ will be finished so the sequence of Draw 2+ will be 1
     */
    public void finishSeqND ()
    {
        seqND = 1;
    }

    /**
     * the sequence of WildDraw will be finished so the sequence of Draw 2+ will be 1
     */
    public void finishSeqWD ()
    {
        seqWD = 1;
    }
}
