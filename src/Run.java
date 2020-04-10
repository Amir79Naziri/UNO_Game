import java.util.LinkedList;

public class Run
{
    public static void main (String[] args) {

        Board board = new Board ();
        board.changeCardOnBoard (new SkipCard (Color.RED));
        board.changeColor (Color.RED);
        Printer pa = new Printer ();
        pa.printCardOnBoard (board);
        LinkedList<Card> cards = new LinkedList<> ();
        cards.add (new WildColorCard ());
        cards.add (new WildDrawCard ());
        cards.add (new NumericCard (Color.BLUE,5));
        cards.add (new SkipCard (Color.RED));
        cards.add (new ReverseCard (Color.YELLOW));
        cards.add (new ColorDrawCard (Color.GREEN));
        cards.add (new NumericCard (Color.BLUE,7));
        cards.add (new WildDrawCard ());
        pa.printCardsOfPlayer (cards);
        System.out.println ("\n\n\n\n\n\n");
        pa.printCardsOfPlayer (cards);
    }
}
