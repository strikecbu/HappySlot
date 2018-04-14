package com.genesis.exams.happyslot.service.impl;

import com.genesis.exams.happyslot.model.HappySymbol;
import com.genesis.exams.slot.Symbol;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by AndyChen on 2018/4/14.
 */
public class HappyEvaluatorServiceImplTest {

    private static HappyEvaluatorServiceImpl evaluatorService;

    @BeforeClass
    public static void setEnv() throws Exception {
        evaluatorService = new HappyEvaluatorServiceImpl();
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void evaluate_test() throws Exception {
        HappySymbol symbol = new HappySymbol("A", 20);
        Symbol[] symbols = new Symbol[3];
        symbols[0] = symbol;
        symbols[1] = symbol;
        symbols[2] = symbol;
        long payout = evaluatorService.evaluate(symbols, 100);
        Assert.assertEquals("the result must be 2000", payout, 2000L);
    }

}