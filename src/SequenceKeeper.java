public class SequenceKeeper
{
    private int seqND;
    private int seqWD;

    public SequenceKeeper ()
    {
        seqND = 1;
        seqWD = 1;
    }


    public void increaseSeqND () {
        this.seqND++;
    }

    public void increaseSeqWD () {
        this.seqWD++;
    }

    public int getSeqND () {
        return seqND;
    }

    public int getSeqWD () {
        return seqWD;
    }

    public void finishSeqND ()
    {
        seqND = 1;
    }

    public void finishSeqWD ()
    {
        seqWD = 1;
    }
}
