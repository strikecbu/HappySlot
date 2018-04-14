import com.genesis.exams.happyslot.model.HappySpinResult;
import com.genesis.exams.happyslot.tool.HappySlotMachine;
import com.genesis.exams.happyslot.tool.HappySlotMachineUtil;
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

        SlotMachine slotMachine = HappySlotMachineUtil.getSlotMachine(REEL_NUMBERS);

        Long userBet;
        try {
            userBet = Long.valueOf(args[0]);
        } catch (NumberFormatException e) {
            userBet = DEFAULT_BET;
        } catch (ArrayIndexOutOfBoundsException e) {
            userBet = DEFAULT_BET;
        }
        SpinResult spinResult = slotMachine.spin(userBet);

        App.announcePrint(spinResult, userBet);
    }

    private static void announcePrint(SpinResult spinResult, long bet) {
        long payout = spinResult.getPayout();
        String[] wordings = {"ready to spin?", "your bet is ", "3", "2", "1", "GO!",
                "spin result is ", "your payout is "};

        for (int i = 0; i < wordings.length; i++) {
            long waitSec = 1000;
            if (i == 1) {
                wordings[i] += bet; //your bet is 100
                waitSec = 2000;

            } else if (i == 6) {
                wordings[i] += spinResult.toString();

            } else if (i == 7) {
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
