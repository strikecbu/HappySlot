package com.genesis.exams.happyslot.model;

import com.genesis.exams.slot.SpinResult;
import com.genesis.exams.slot.Symbol;

/**
 * A SpinResult extends genesis SpinResult
 *
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

    @Override
    public String toString() {
        if (super.getSymbols() == null)
            return super.toString();
        StringBuilder stringBuilder = new StringBuilder();
        Symbol[] symbols = super.getSymbols();
        for (int i = 0; i < symbols.length; i++) {
            stringBuilder.append(symbols[i].getName());
            if (i < symbols.length - 1)
                stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }
}
