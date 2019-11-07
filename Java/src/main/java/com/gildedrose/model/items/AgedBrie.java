package com.gildedrose.model.items;

import com.gildedrose.model.Item;

public class AgedBrie implements CustomisedItem {

    private final Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    public void updateState() {
        decreaseSellByDayValueByOne();
        increaseQualityByOne();
    }

    private void decreaseSellByDayValueByOne() {
        item.setDaysLeftToSell(item.getDaysLeftToSell() - 1);
    }

    private void increaseQualityByOne() {
        item.setQuality(item.getQuality() + 1);
    }
}
