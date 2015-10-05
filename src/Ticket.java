/**
 * Created by Alan on 15-09-30.
 */
public class Ticket {
    private String name;
    private int ballNumberChosen;

    public Ticket(String name, int ballNumberChosen) {
        this.name = name;
        this.ballNumberChosen = ballNumberChosen;
    }

    public String getName() {
        return name;
    }

    public int getTicket() {
        return ballNumberChosen;
    }
}
