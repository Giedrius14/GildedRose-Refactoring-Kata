package com.gildedrose.model.items;

import com.gildedrose.model.Item;

public class Conjured extends Standard {

    public Conjured(Item item) {
        super(item);
    }

    @Override
    public int decreasingValueOverZeroDaysToSell() {
        return 2;
    }
}
