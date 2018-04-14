package com.genesis.exams.happyslot.service.impl;

import com.genesis.exams.slot.Evaluator;
import com.genesis.exams.slot.Symbol;

import java.util.HashMap;
import java.util.Map;

/**
 * implement Evaluator for the spin payout
 * @author AndyChen
 * @version <ul>
 *          <li>2018/4/14 AndyChen,new
 *          </ul>
 * @since 2018/4/14
 */
public class HappyEvaluatorServiceImpl implements Evaluator{

    /**
     * calculator the payout of spin
     * Winning Combination	Bet Multiplier
     *     A,A,A	               20
     *     B,B,B	               20
     *     C,C,C	               20
     *     A,B,C	               30
     * @param symbols
     * @param bet
     * @return payout
     */
    public long evaluate(Symbol[] symbols, long bet) {
        Map<String, Long> combinationMap = this.getCombination();
        String symbolsCombin = this.getSymbolsCombin(symbols);
        if(combinationMap.containsKey(symbolsCombin)){
            return combinationMap.get(symbolsCombin) * bet;
        }
        return 0;
    }

    private Map<String, Long> getCombination(){
        Map<String, Long> combinationMap = new HashMap<>();
        //TODO change to read property
        combinationMap.put("A,A,A", 20L);
        combinationMap.put("B,B,B", 20L);
        combinationMap.put("C,C,C", 20L);
        combinationMap.put("A,B,C", 30L);
        return combinationMap;
    }

    private String getSymbolsCombin(Symbol[] symbols) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < symbols.length; i++) {
            result.append(symbols[i].getName());
            if(i < symbols.length - 1)
                result.append(",");
        }
        return result.toString();
    }



}
