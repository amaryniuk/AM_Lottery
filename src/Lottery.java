import java.math.*;
import java.text.NumberFormat;
import java.util.*;

public class Lottery {

    // Add tickets to an array, then shuffle the array, then sell them in that order
    static int numTickets = 8;

    // for new game
    static int ticketsSold = 0;
    static List<Integer> ticketList = new ArrayList<Integer>();
    static List<Ticket> ticketsSoldList = new ArrayList<Ticket>();

    // for find winners
    static int firstBall = 0, secondBall = 0, thirdBall = 0;
    static Ticket firstWinner = null, secondWinner = null, thirdWinner = null;

    public static void main(String args[]) {

        int ballNumberChosen;
        BigDecimal pot = new BigDecimal("200.00");
        BigDecimal ticketCost = new BigDecimal("10.00");
        String command;
        String buyerName = null;

        newGame();

        Scanner scanner = new Scanner(System.in);
        while ((command = scanner.nextLine()) != null) {

            if (ticketsSold >= numTickets) {
                System.out.println("Tickets are all sold out. Time for a draw!");
                command = "draw";
            }

            if ("Purchase".equalsIgnoreCase(command) || "p".equalsIgnoreCase(command)) {
                System.out.println("What is the buyer's name?");
                buyerName = scanner.nextLine();
                ballNumberChosen = ticketList.get(ticketsSold);
                ticketsSoldList.add(new Ticket(buyerName, ballNumberChosen));
                ticketsSold++;
                pot = pot.add(ticketCost);
                System.out.println(buyerName + ", your ticket number is: " + ballNumberChosen + ". Good Luck!");
            }

            else if ("Draw".equalsIgnoreCase(command) || "d".equalsIgnoreCase(command)) {

                Draw d = new Draw(numTickets);
                d.showBalls();

                firstBall = d.get1Ball();
                secondBall = d.get2Ball();
                thirdBall = d.get3Ball();

                findWinners(pot);
                newGame();
            }

            else if ("Winners".equalsIgnoreCase(command) || "w".equalsIgnoreCase(command)) {
                findWinners(pot);
            }

            else if ("New Game".equalsIgnoreCase(command) || "n".equalsIgnoreCase(command)) {
                newGame();
            }

            else if ("View Tickets".equalsIgnoreCase(command) || "v".equalsIgnoreCase(command)) {
                for (Ticket t: ticketsSoldList) {
                    t.printTicket();
                }
                System.out.println("Cash in the pot: $" + pot);
            }

            else if ("Quit".equalsIgnoreCase(command) || "q".equalsIgnoreCase(command)) {
                System.out.println("Thanks for playing!");
                break;
            }

            else {
                System.out.println("No Command Given.");
            }
        }
    }

    public static void createTickets(List<Integer> tics, int numTics) {
        for (int i = 1; i <= numTics; i++) {
            tics.add(i);
        }
        Collections.shuffle(tics);
        System.out.println(tics);
    }

    public static void newGame() {
        System.out.println("New Game: [P] Purchase, [D] Draw, [W] Winners, [N] New Game, [V] View Tickets, [Q] Quit.");
        ticketsSold = 0;
        firstBall = 0; secondBall = 0; thirdBall = 0;
        firstWinner = null; secondWinner = null; thirdWinner = null;
        ticketList.clear();
        ticketsSoldList.clear();
        createTickets(ticketList, numTickets);
    }

    public static void findWinners(BigDecimal p) {

        String s;
        double payout;

        BigDecimal payout1 = new BigDecimal("0");
        BigDecimal payout2 = new BigDecimal("0");
        BigDecimal payout3 = new BigDecimal("0");
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.CANADA);

        for (Ticket t: ticketsSoldList) {
            if (t.getTicketNumber() == firstBall) {
                firstWinner = t;
            }
            if (t.getTicketNumber() == secondBall) {
                secondWinner = t;
            }
            if (t.getTicketNumber() == thirdBall) {
                thirdWinner = t;
            }
        }
// test
        if (firstWinner != null) {
            payout1 = p.multiply(new BigDecimal("0.375"));
            payout = payout1.doubleValue();
            s = n.format(payout);
            System.out.println(firstWinner.getName() + " wins 1st prize for ticket # " + firstWinner.getTicketNumber() + ". Prize money: $" + payout);
        }
        else {
            System.out.println("No 1st place winner. Prize money returns to the pot.");
        }

        if (secondWinner != null) {
            payout2 = p.multiply(new BigDecimal("0.075"));
            payout = payout2.doubleValue();
            s = n.format(payout);
            System.out.println(secondWinner.getName() + " wins 2nd prize for ticket # " + secondWinner.getTicketNumber() + ". Prize money: $" + payout);
        }
        else {
            System.out.println("No 2nd place winner. Prize money returns to the pot.");
        }

        if (thirdWinner != null) {
            payout3 = p.multiply(new BigDecimal("0.05"));
            payout = payout3.doubleValue();
            s = n.format(payout);
            System.out.println(thirdWinner.getName() + " wins 3rd prize for ticket # " + thirdWinner.getTicketNumber() + ". Prize money: $" + payout);
        }
        else {
            System.out.println("No 3rd place winner. Prize money returns to the pot.");
        }
    }
}

