package com.genesis.exams.happyslot.model;

import com.genesis.exams.slot.SpinResult;
import com.genesis.exams.slot.Symbol;

/**
 *  A SpinResult extends genesis SpinResult
 * @author AndyChen
 * @version <ul>
 *          <li>2018/4/14 AndyChen,new
 *          </ul>
 * @since 2018/4/14
 */
public class HappySpinResult extends SpinResult {
    public HappySpinResult(Symbol[] symbols, long payout) {
        super(symbols, payout);
    }
}
