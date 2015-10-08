import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lottery {

    // Add tickets to an array, then shuffle the array, then sell them in that order
    static int numTickets = 10;

    // for new game
    static int ticketsSold = 0;
    static List<Integer> ticketList = new ArrayList<Integer>();
    static List<Ticket> ticketsSoldList = new ArrayList<Ticket>();

    // for find winners
    static int firstBall = 0, secondBall = 0, thirdBall = 0;
    static Ticket firstWinner = null, secondWinner = null, thirdWinner = null;

    public static void main(String args[]) {

        int ballNumberChosen;
        float pot = 200;
        String command;
        String buyerName = null;

        createTickets(ticketList, numTickets);

        System.out.println("[P] Purchase, [D] Draw, [W] Winners, [N] New Game, [V] View Tickets, [Q] Quit.");

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
                System.out.println(buyerName + ", your ticket number is: " + ballNumberChosen + ". Good Luck!");
            }

            else if ("Draw".equalsIgnoreCase(command) || "d".equalsIgnoreCase(command)) {

                Draw d = new Draw(numTickets);
                d.showBalls();

                firstBall = d.get1Ball();
                secondBall = d.get2Ball();
                thirdBall = d.get3Ball();

                findWinners();
                newGame();
            }

            else if ("Winners".equalsIgnoreCase(command) || "w".equalsIgnoreCase(command)) {
                findWinners();
            }

            else if ("New Game".equalsIgnoreCase(command) || "n".equalsIgnoreCase(command)) {
                newGame();
            }

            else if ("View Tickets".equalsIgnoreCase(command) || "v".equalsIgnoreCase(command)) {
                for (Ticket t: ticketsSoldList) {
                    t.printTicket();
                }
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
        System.out.println("New Game Created");
        ticketsSold = 0;
        firstBall = 0; secondBall = 0; thirdBall = 0;
        firstWinner = null; secondWinner = null; thirdWinner = null;
        ticketList.clear();
        ticketsSoldList.clear();
        createTickets(ticketList, numTickets);
    }

    public static void findWinners() {
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
        if (firstWinner != null) {
            System.out.println(firstWinner.getName() + " wins the 1st place prize for picking ball " + firstWinner.getTicketNumber() + ".");
        }
        else {
            System.out.println("No 1st place winner. Prize money returns to the pot.");
        }
        if (secondWinner != null) {
            System.out.println(secondWinner.getName() + " wins the 2nd place prize for picking ball " + secondWinner.getTicketNumber() + ".");
        }
        else {
            System.out.println("No 2nd place winner. Prize money returns to the pot.");
        }
        if (thirdWinner != null) {
            System.out.println(thirdWinner.getName() + " wins the 3rd place prize for picking ball " + thirdWinner.getTicketNumber() + ".");
        }
        else {
            System.out.println("No 3rd place winner. Prize money returns to the pot.");
        }
    }
}

