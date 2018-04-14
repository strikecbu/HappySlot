package com.genesis.exams.happyslot.tool;

import com.genesis.exams.happyslot.model.HappyReel;
import com.genesis.exams.happyslot.model.HappySymbol;
import com.genesis.exams.happyslot.service.impl.HappyEvaluatorServiceImpl;
import com.genesis.exams.happyslot.service.impl.HappySpinnerServiceImpl;
import com.genesis.exams.slot.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AndyChen
 * @version <ul>
 *          <li>2018/4/14 AndyChen,new
 *          </ul>
 * @since 2018/4/14
 */
public class HappySlotMachineUtil {

    private static HappySlotMachineUtil thisUtil;

    static {
        thisUtil = new HappySlotMachineUtil();
    }

    public static SlotMachine getSlotMachine(int reelNumber) {
        return thisUtil.initlotMachine(reelNumber);
    }

    private SlotMachine initlotMachine(int reelNumber) {
        HappySlotMachine happySlotMachine;

        Reel[] reels = this.getHappyReels(reelNumber);
        Spinner spinner = new HappySpinnerServiceImpl();
        Evaluator evaluator = new HappyEvaluatorServiceImpl();

        happySlotMachine = new HappySlotMachine(reels, spinner, evaluator);

        return happySlotMachine;
    }

    private Reel[] getHappyReels(int reelNumber) {
        List<Reel> result = new ArrayList<>();
        List<String> reelProperties = this.getReelProperties();
        if(reelNumber > reelProperties.size())
            throw new IllegalArgumentException("too much reel number given");
        for (int i = 0; i < reelNumber; i++) {
            Reel happyReel = this.intiReel(reelProperties.get(i));
            result.add(happyReel);
        }
        return result.toArray(new HappyReel[result.size()]);
    }

    private List<String> getReelProperties() {
        //TODO can get from property
        String reel1 = "A,B,C,X,Y,Z";
        String reel2 = "Z,Y,X,A,B,C";
        String reel3 = "A,B,C,X,Y,Z";
        List<String> reelsStrList = new ArrayList<>();
        reelsStrList.add(reel1);
        reelsStrList.add(reel2);
        reelsStrList.add(reel3);

        return reelsStrList;
    }

    private Reel intiReel(String symbolStr) {
        List<Symbol> list = new ArrayList<>();
        String[] symbols = symbolStr.split(",");
        for (String symbolName : symbols) {
            for (HappySymbol.SymbolWeight symbol : HappySymbol.SymbolWeight.values()) {
                if (symbol.toString().equals(symbolName)) {
                    list.add(new HappySymbol(symbolName, symbol.getWeight()));
                }
            }
        }
        return new HappyReel(list.toArray(new Symbol[list.size()]));
    }

}
