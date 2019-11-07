package com.gildedrose.model.items;

import com.gildedrose.model.Item;

public class Standard implements CustomisedItem {

    private final Item item;

    public Standard(Item item) {
        this.item = item;
    }

    public void updateState() {
        decreaseSellByDayValueByOne();
        if (isDaysLeftToSellOverZero()) {
            decreaseQualityBy(decreasingValueOverZeroDaysToSell());
        } else {
            decreaseQualityBy(decreasingValueForZeroOrLessDaysToSell());
        }
    }

    public int decreasingValueOverZeroDaysToSell() {
        return 1;
    }

    private void decreaseSellByDayValueByOne() {
        item.setDaysLeftToSell(item.getDaysLeftToSell() - 1);
    }

    private boolean isDaysLeftToSellOverZero() {
        return item.getDaysLeftToSell() > 0;
    }

    private void decreaseQualityBy(int qualityValue) {
        item.setQuality(item.getQuality() - qualityValue);
    }

    private int decreasingValueForZeroOrLessDaysToSell() {
        return decreasingValueOverZeroDaysToSell() * 2;
    }
}
