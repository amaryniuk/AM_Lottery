
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lottery {
    public static void main(String args[]) {

        int ticketsSold = 0;
        int ballNumberChosen = 0;
        float pot = 0;
        String command = null;
        String buyerName = null;

        // Add tickets to an array, then shuffle the array, then sell them in that order
        int numTickets = 10;

        List<Integer> ballsArray = new ArrayList<Integer>();
        List<Object> ticketsSoldArray = new ArrayList<Object>();

        createTickets(ballsArray, numTickets);



        System.out.println("What do you want to do? Purchase, Draw, Winners, New Game, Quit.");

        Scanner scanner = new Scanner(System.in);


        while((command = scanner.nextLine()) != null) {
            if("p".equalsIgnoreCase(command) || "purchase".equalsIgnoreCase(command)) {

                System.out.println("What is the buyer's name?");
                buyerName = scanner.nextLine();
                ballNumberChosen = ballsArray.get(ticketsSold);


              ticketsSoldArray.add(new Ticket(buyerName, ballNumberChosen));
//                Ticket newTicket = new Ticket(buyerName, ballNumberChosen);
//                ticketsSoldArray.add(newTicket);
//                newTicket.printTicket();


                System.out.println(ticketsSoldArray.toString()); //
                ticketsSold++;

            }
            else if("d".equalsIgnoreCase(command) || "draw".equalsIgnoreCase(command)) {
                System.out.println("Draw");

            }
            else if("winners".equalsIgnoreCase(command)) {
                System.out.println("Winners:");

            }
            else if("new game".equalsIgnoreCase(command)) {
                System.out.println("New Game");

            }
            else {
                System.out.println("No Command Given.");

            }
        }

    }

    public static void createTickets(List<Integer> tic, int numTic) {

        for (int i = 1; i <= numTic; i++) {
            tic.add(i);
        }
        Collections.shuffle(tic);
        System.out.println(tic);
    }
}

