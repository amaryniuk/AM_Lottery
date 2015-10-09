import java.math.BigDecimal;

public class Ticket {
    private String name;
    private int ballNumberChosen;
    private BigDecimal winnings = new BigDecimal("0");
    private boolean winner = false;

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

    public BigDecimal getWinnings() { return winnings; }

    public void setWinnings (BigDecimal w) {
        winner = true;
        winnings = w.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public void printTicket() {
        System.out.println("Name: " + name + ". Ticket: " + ballNumberChosen);
    }


}
