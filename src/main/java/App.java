import com.genesis.exams.slot.*;

/**
 * @author AndyChen
 * @version <ul>
 *          <li>2018/4/13 AndyChen,new
 *          </ul>
 * @since 2018/4/13
 */
public class App {

    private static final int REEL_NUMBERS = 3;

    private static final long DEFAULT_BET = 100;

    public static void main(String[] args) {

        Reel[] reels = new Reel[REEL_NUMBERS];
        //TODO create spinner
        Spinner spinner = null;
        //TODO create evaluator
        Evaluator evaluator = null;

        SlotMachine slotMachine = new SlotMachine(reels, spinner, evaluator);
        Long userBet;
        try {
            userBet = Long.valueOf(args[0]);
        } catch (NumberFormatException e) {
            userBet = DEFAULT_BET;
        }
        SpinResult spinResult = slotMachine.spin(userBet);

        long payout = spinResult.getPayout();
        announcePrint(userBet, payout);
    }

    private static void announcePrint(long bet, long payout){
        String[] wordings = {"ready to spin?", "your bet is ", "3", "2", "1", "GO!",
                "your payout is "};

        for (int i = 0; i < wordings.length; i++) {
            long waitSec = 1000;
            if(i == 1) {
                wordings[i] += bet; //your bet is 100
                waitSec = 2000;
            } else if(i == 6){
                wordings[i] += payout; //your payout is ???
                waitSec = 3000;
            }
            System.out.println(wordings[i]);
            try {
                Thread.sleep(waitSec);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
