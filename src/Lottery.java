import java.math.*;
import java.util.*;

public class Lottery {

    // Add tickets to an array, then shuffle the array, then sell them in that order
    static int numTickets = 10;

    // for new game
    static int ticketsSold = 0;
    static List<Integer> ticketList = new ArrayList<>();
    static List<Ticket> ticketsSoldList = new ArrayList<>();

    // for find winners
    static int firstBall = 0, secondBall = 0, thirdBall = 0;
    static Ticket firstWinner = null, secondWinner = null, thirdWinner = null;

    public static void main(String args[]) {

        int ballNumberChosen;
        String command;
        String buyerName;
        BigDecimal pot = new BigDecimal("200.00");
        BigDecimal ticketCost = new BigDecimal("10.00");

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
                System.out.println("\nDraw is happening! The total pot for this round is: $" + pot.toPlainString());
                Draw d = new Draw(numTickets);
                d.showBalls();

                firstBall = d.get1Ball();
                secondBall = d.get2Ball();
                thirdBall = d.get3Ball();

                findWinners(pot);
                pot = payoutWinners(pot);
                newGame();
            }

            else if ("Winners".equalsIgnoreCase(command) || "w".equalsIgnoreCase(command)) {
                pot = payoutWinners(pot);
            }

            else if ("New Game".equalsIgnoreCase(command) || "n".equalsIgnoreCase(command)) {
                newGame();
            }

            else if ("View Tickets".equalsIgnoreCase(command) || "v".equalsIgnoreCase(command)) {
                for (Ticket t : ticketsSoldList) {
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
        System.out.println("\n\nNew Game: [P] Purchase, [D] Draw, [W] Winners, [N] New Game, [V] View Tickets, [Q] Quit.");
        ticketsSold = 0;
        firstBall = 0;
        secondBall = 0;
        thirdBall = 0;
        firstWinner = null;
        secondWinner = null;
        thirdWinner = null;
        ticketList.clear();
        ticketsSoldList.clear();
        createTickets(ticketList, numTickets);
    }

    public static void findWinners(BigDecimal pot) {

        for (Ticket t : ticketsSoldList) {
            if (t.getTicketNumber() == firstBall) {
                firstWinner = t;
                firstWinner.setWinnings(pot.multiply(new BigDecimal("0.375")));
            }

            if (t.getTicketNumber() == secondBall) {
                secondWinner = t;
                secondWinner.setWinnings(pot.multiply(new BigDecimal("0.075")));
            }

            if (t.getTicketNumber() == thirdBall) {
                thirdWinner = t;
                thirdWinner.setWinnings(pot.multiply(new BigDecimal("0.05")));
            }
        }
    }

    public static BigDecimal payoutWinners(BigDecimal pot) {
        if (firstWinner != null) {
            System.out.println(firstWinner.getName() + ": $" + firstWinner.getWinnings().toPlainString());
            pot = pot.subtract(firstWinner.getWinnings());
        }
        else
            System.out.println("No 1st winner.");

        if (secondWinner != null) {
            System.out.println(secondWinner.getName() + ": $" + secondWinner.getWinnings().toPlainString());
            pot = pot.subtract(secondWinner.getWinnings());
        }
        else
            System.out.println("No 2nd winner.");

        if (thirdWinner != null) {
            System.out.println(thirdWinner.getName() + ": $" + thirdWinner.getWinnings().toPlainString());
            pot = pot.subtract(thirdWinner.getWinnings());
        }
        else
            System.out.println("No 3rd winner.");

        System.out.println("\nRemaining amount in pot for next game:" + pot.toPlainString());
        return pot;
    }
}
