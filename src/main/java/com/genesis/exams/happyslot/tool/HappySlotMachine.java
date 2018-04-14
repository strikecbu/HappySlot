package com.genesis.exams.happyslot.tool;

import com.genesis.exams.happyslot.model.HappySpinResult;
import com.genesis.exams.slot.*;

/**
 *
 * @author AndyChen
 * @version <ul>
 *          <li>2018/4/14 AndyChen,new
 *          </ul>
 * @since 2018/4/14
 */
public class HappySlotMachine extends SlotMachine {
    public HappySlotMachine(Reel[] reels, Spinner spinner, Evaluator evaluator) {
        super(reels, spinner, evaluator);
    }

    @Override
    public SpinResult spin(long bet) {
        SpinResult oriSpinResult = super.spin(bet);
        HappySpinResult happySpinResult = new HappySpinResult(oriSpinResult.getSymbols(), oriSpinResult.getPayout());
        return happySpinResult;
    }
}
