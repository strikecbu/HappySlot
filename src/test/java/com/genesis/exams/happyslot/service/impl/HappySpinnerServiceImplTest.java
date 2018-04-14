package com.genesis.exams.happyslot.service.impl;

import com.genesis.exams.happyslot.model.HappyReel;
import com.genesis.exams.happyslot.model.HappySymbol;
import com.genesis.exams.slot.Symbol;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by AndyChen on 2018/4/14.
 */
public class HappySpinnerServiceImplTest {

    private static HappySpinnerServiceImpl happySpinnerService;

    private HappyReel happyReel;

    @BeforeClass
    public static void setEnv() throws Exception {
        happySpinnerService = new HappySpinnerServiceImpl();

    }

    @Before
    public void setUp() throws Exception {
        List<HappySymbol> list = new ArrayList<>();
        HappySymbol happySymbolA = new HappySymbol("A", 1);
        HappySymbol happySymbolB = new HappySymbol("B", 5);
        HappySymbol happySymbolC = new HappySymbol("C", 10);
        list.add(happySymbolA);
        list.add(happySymbolB);
        list.add(happySymbolC);
        happyReel = new HappyReel(list.toArray(new Symbol[list.size()]));
    }

    @Test
    public void original_spin_test() throws Exception {
        Symbol symbol = happySpinnerService.spin(happyReel);
        Assert.assertNotNull(symbol);
        System.out.println("Symbol " + symbol.getName() + " is win");
    }

    @Test(expected = Exception.class)
    public void null_reel_test() throws Exception {
        happySpinnerService.spin(null);
    }

}