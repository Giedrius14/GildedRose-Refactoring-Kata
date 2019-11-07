package com.gildedrose.model.items;

import com.gildedrose.model.Item;

public class BackstagePasses implements CustomisedItem {

    private final Item item;

    public BackstagePasses(Item item) {
        this.item = item;
    }

    public void updateState() {
        decreaseSellByDayValueByOne();
        if (isDaysLeftToSellMoreThan(10)) {
            increaseQualityBy(1);
        } else if (isDaysLeftToSellMoreThan(5)) {
            increaseQualityBy(2);
        } else if (isDaysLeftToSellMoreThan(0)) {
            increaseQualityBy(3);
        } else {
            dropQualityToZero();
        }
    }

    private void decreaseSellByDayValueByOne() {
        item.setDaysLeftToSell(item.getDaysLeftToSell() - 1);
    }

    private boolean isDaysLeftToSellMoreThan(int dayNumber) {
        return item.getDaysLeftToSell() > dayNumber;
    }

    private void increaseQualityBy(int qualityValue) {
        item.setQuality(item.getQuality() + qualityValue);
    }

    private void dropQualityToZero() {
        item.setQuality(0);
    }
}
