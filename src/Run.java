import java.util.Scanner;

public class Run
{
    public static void main (String[] args) throws InterruptedException {

        System.out.println ("Welcome To UNO");
        System.out.println ("Please Choose The Type Of Game\n" +
                "1) OnePlayer vs PC\n" +
                "2) MultiPlayer");
        String line = new Scanner (System.in).nextLine ();
        if (!Reader.isValidIndex (line))
        {
            System.out.println ("ERROR in Starting Game");
            return;
        }
        int choose = Integer.parseInt (line);

        if (choose == 1)
        {
            System.out.println ("1) 3 player\n" +
                    "2) 4 Player\n" +
                    "3) 5 Player");
            String line2 = new Scanner (System.in).nextLine ();
            if (!Reader.isValidIndex (line2))
            {
                System.out.println ("ERROR in Starting Game");
                return;
            }
            if (Integer.parseInt (line2) > 3 ||
                    Integer.parseInt (line2) < 1)
            {
                System.out.println ("ERROR in Starting Game");
                return;
            }
            Game game = new GameOnePlayer (Integer.parseInt (line2) + 2);
            game.play ();
            return;
        }
        if (choose == 2)
        {
            System.out.println ("Enter Number Of Players between  2 and 14");
            String line3 = new Scanner (System.in).nextLine ();
            if (!Reader.isValidIndex (line3))
            {
                System.out.println ("ERROR in Starting Game");
                return;
            }
            if (Integer.parseInt (line3) > 14 ||
                    Integer.parseInt (line3) < 2)
            {
                System.out.println ("ERROR in Starting Game");
                return;
            }

            Game game = new GameMultiPlayer (Integer.parseInt (line3));
            game.play ();
        }
        else
        {
            System.out.println ("ERROR in Starting Game");
        }
    }
}
