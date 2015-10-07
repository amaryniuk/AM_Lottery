
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lottery {
    public static void main(String args[]) {

        int ticketsSold = 0;
        int ballNumberChosen = 0;
        float pot = 200;
        String command = null;
        String buyerName = null;

        // Add tickets to an array, then shuffle the array, then sell them in that order
        int numTickets = 5;

        ArrayList<Integer> ballsArray = new ArrayList<Integer>();
        ArrayList<Ticket> ticketsSoldArray = new ArrayList<Ticket>();



        createTickets(ballsArray, numTickets);

        System.out.println("[P] Purchase, [D] Draw, [W] Winners, [N] New Game, [V] View Tickets, [Q] Quit.");

        Scanner scanner = new Scanner(System.in);

        while ((command = scanner.nextLine()) != null) {

            if (ticketsSold >= numTickets) {
                System.out.println("Tickets are all sold out. Time for a draw");
                command = "draw";   //
            }

            if ("Purchase".equalsIgnoreCase(command) || "p".equalsIgnoreCase(command)) {

                System.out.println("What is the buyer's name?");
                buyerName = scanner.nextLine();
                ballNumberChosen = ballsArray.get(ticketsSold);
                ticketsSoldArray.add(new Ticket(buyerName, ballNumberChosen));
                System.out.println(buyerName + ", your ticket number is: " + ballNumberChosen + ". Good Luck!");
                ticketsSold++;
            }

            else if ("Draw".equalsIgnoreCase(command) || "d".equalsIgnoreCase(command)) {
                System.out.println("Draw");

            }

            else if ("Winners".equalsIgnoreCase(command) || "w".equalsIgnoreCase(command)) {
                System.out.println("Winners:");

            }

            else if ("New Game".equalsIgnoreCase(command) || "n".equalsIgnoreCase(command)) {
                System.out.println("New Game Created");
                ticketsSold = 0;
                ballsArray.clear();
                ticketsSoldArray.clear();
                createTickets(ballsArray, numTickets);

            }

            else if ("View Tickets".equalsIgnoreCase(command) || "v".equalsIgnoreCase(command)) {
                for (Ticket t: ticketsSoldArray) {
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
}

