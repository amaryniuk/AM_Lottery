import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Draw {

    private int firstBall, secondBall, thirdBall;
    private int numberOfBalls;

    List<Integer> ballMachine = new ArrayList<>();

    public Draw(int nB) {
        numberOfBalls = nB;

        for (int i = 1; i <= numberOfBalls; i++) {
            ballMachine.add(i);
        }
        Collections.shuffle(ballMachine);

        firstBall = ballMachine.get(0);
        secondBall = ballMachine.get(1);
        thirdBall = ballMachine.get(2);
    }

    public int get1Ball() { return firstBall; }
    public int get2Ball() { return secondBall; }
    public int get3Ball() { return thirdBall; }

    public void showBalls() {
        System.out.println("First Ball: " + firstBall + ". Second Ball: " + secondBall + ". ThirdBall: " + thirdBall + ".\n");
    }
}