package com.genesis.exams.happyslot.tool;

import com.genesis.exams.slot.SlotMachine;
import com.genesis.exams.slot.SpinResult;
import com.genesis.exams.slot.Symbol;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by VALLA on 2018/4/14.
 */
public class HappySlotMachineUtilTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void spin_test() throws Exception {
        SlotMachine slotMachine = HappySlotMachineUtil.getSlotMachine(3);
        SpinResult spinResult = slotMachine.spin(1000);
        Symbol[] symbols = spinResult.getSymbols();
        assertNotNull(symbols);
    }

    @Test(expected = Exception.class)
    public void spin_num_over_test() throws Exception {
        HappySlotMachineUtil.getSlotMachine(5);
    }

}