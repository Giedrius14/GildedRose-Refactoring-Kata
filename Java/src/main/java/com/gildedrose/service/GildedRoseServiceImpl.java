package com.gildedrose.service;

import com.gildedrose.model.Item;

import static com.gildedrose.model.Type.*;

public class GildedRoseServiceImpl implements GildedRoseService{

    public Item[] updateQuality(Item[] items) {
        for (Item item : items) {
            if (!item.getName().equals(AGED_BRIE) && !item.getName().equals(BACKSTAGE_PASSES) && !item.getName().equals(SULFURAS_HAND_OF_RAGNAROS)) {
                if (item.getQuality() > 0) {
                    reduceQuality(item);
                }
            } else {
                if (item.getQuality() < 50) {
                    increaseQuality(item);

                    if (item.getName().equals(BACKSTAGE_PASSES)) {
                        if (item.getDaysLeftToSell() < 11) {
                            increaseQuality(item);
                        }

                        if (item.getDaysLeftToSell() < 6) {
                            increaseQuality(item);
                        }
                    }
                }
            }

            if (!item.getName().equals(SULFURAS_HAND_OF_RAGNAROS)) {
                reduceDaysToSell(item);
            }

            if (item.getDaysLeftToSell() < 0) {
                if (!item.getName().equals(AGED_BRIE)) {
                    if (!item.getName().equals(BACKSTAGE_PASSES)) {
                        if (item.getQuality() > 0) {
                            if (!item.getName().equals(SULFURAS_HAND_OF_RAGNAROS)) {
                                reduceQuality(item);
                            }
                        }
                    } else {
                        item.setQuality(0);
                    }
                } else {
                    if (item.getQuality() < 50) {
                        increaseQuality(item);
                    }
                }
            }
        }
        return items;
    }

    private void reduceDaysToSell(Item item) {
        item.setDaysLeftToSell(item.getDaysLeftToSell() - 1);
    }

    private void increaseQuality(Item item) {
        item.setQuality(item.getQuality() + 1);
    }

    private void reduceQuality(Item item) {
        item.setQuality(item.getQuality() - 1);
    }
}
