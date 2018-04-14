package com.genesis.exams.happyslot.model;

import com.genesis.exams.slot.Symbol;

/**
 * A Symbol extends genesis Symbol
 * @author AndyChen
 * @version <ul>
 *          <li>2018/4/14 AndyChen,new
 *          </ul>
 * @since 2018/4/14
 */
public class HappySymbol extends Symbol {

    /**
     * Mapping Symbol name and weight
     */
    public enum SymbolWeight {
        A(1), B(1), C(1), X(2), Y(3), Z(4);

        int weight;
        SymbolWeight(int weight) {
            this.weight = weight;
        }
        public int getWeight() {
            return this.weight;
        }
    }
    public HappySymbol(String name, int weight) {
        super(name, weight);
    }
}
