
public class Ticket {
    private String name;
    private int ballNumberChosen;

    public Ticket(String n, int b) {
        name = n;
        ballNumberChosen = b;
    }

    public String getName() {
        return name;
    }

    public int getTicketNumber() {
        return ballNumberChosen;
    }

    public void printTicket() {
        System.out.println("Name: " + name + ". Ticket: " + ballNumberChosen);
    }
}
