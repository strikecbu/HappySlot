package com.genesis.exams.happyslot.service.impl;

import com.genesis.exams.slot.Reel;
import com.genesis.exams.slot.Spinner;
import com.genesis.exams.slot.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * implement Spinner for get the result of spin the Reel
 * @author AndyChen
 * @version <ul>
 *          <li>2018/4/14 AndyChen,new
 *          </ul>
 * @since 2018/4/14
 */
public class HappySpinnerServiceImpl implements Spinner{

    /**
     * get result of spin
     * @param reel
     * @return
     */
    public Symbol spin(Reel reel) {
        Symbol[] symbols = reel.getSymbols();
        if (symbols == null) {
            throw new IllegalArgumentException("Reel must symbols inside");
        }
        String[] allBalls = this.getBallBag(symbols);

        Random random = new Random();
        int winningIndex = random.nextInt(allBalls.length);
        String winSymbolName = allBalls[winningIndex];

        return mapSymbol(winSymbolName, symbols);
    }

    /**
     * use symbol's weight make a ball bag for pick
     * @param symbols
     * @return
     */
    private String[] getBallBag(Symbol[] symbols){
        List<String> result = new ArrayList<>();
        for (Symbol symbol : symbols) {
            for(int i = 0; i < symbol.getWeight(); i++) {
                result.add(symbol.getName());
            }
        }
        return result.toArray(new String[result.size()]);
    }

    /**
     * mapping symbol from name
     * @param symbolName
     * @param symbols
     * @return
     */
    private Symbol mapSymbol(String symbolName, Symbol[] symbols) {
        for (Symbol symbol : symbols) {
            if(symbol.getName().equals(symbolName))
                return symbol;
        }
        throw new IllegalArgumentException("Symbols has no match with input name");
    }
}
