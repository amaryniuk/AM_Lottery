package AM_Lottery;


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

        System.out.println("What do you want to do? Purchase or Draw");

        Scanner scanner = new Scanner(System.in);


        while((command = scanner.nextLine()) != null) {
            if("purchase".equalsIgnoreCase(command)) {

                System.out.println("What is the buyer's name?");
                buyerName = scanner.nextLine();
                ballNumberChosen = tickets.get()


            }
            else if("draw".equalsIgnoreCase(command)) {
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

        createTickets();
    }



    public static void createTickets() {

        // Add tickets to an array, then shuffle the array, then sell them in that order
        int numTickets = 10;

        public List<Integer> tickets = new ArrayList<Integer>();

        for (int i = 1; i <= numTickets; i++) {
            tickets.add(i);
        }

        Collections.shuffle(tickets);

        for (int i = 0; i < numTickets; i++) {
            System.out.println(tickets.get(i));
        }
    }
}

