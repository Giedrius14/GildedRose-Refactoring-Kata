package com.gildedrose.service;

import com.gildedrose.model.Item;

import static com.gildedrose.model.Type.*;

public class GildedRoseServiceImpl implements GildedRoseService{

    public Item[] updateQuality(Item[] items) {
        for (Item item : items) {
            if (!item.getName().equals(AGED_BRIE)
                    && !item.getName().equals(BACKSTAGE_PASSES)) {
                if (item.getQuality() > 0 && !item.getName().equals(SULFURAS_HAND_OF_RAGNAROS)) {
                    item.setQuality(item.getQuality() - 1);
                }
            } else {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);

                    if (item.getName().equals(BACKSTAGE_PASSES)) {
                        if (item.getDaysLeftToSell() < 11) {
                            item.setQuality(item.getQuality() + 1);
                        }

                        if (item.getDaysLeftToSell() < 6) {
                            item.setQuality(item.getQuality() + 1);
                        }
                    }
                }
            }

            if (!item.getName().equals(SULFURAS_HAND_OF_RAGNAROS)) {
                item.setDaysLeftToSell(item.getDaysLeftToSell() - 1);
            }

            if (item.getDaysLeftToSell() < 0) {
                if (!item.getName().equals(AGED_BRIE)) {
                    if (!item.getName().equals(BACKSTAGE_PASSES)) {
                        if (item.getQuality() > 0) {
                            if (!item.getName().equals(SULFURAS_HAND_OF_RAGNAROS)) {
                                item.setQuality(item.getQuality() - 1);
                            }
                        }
                    } else {
                        item.setQuality(0);
                    }
                } else {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
            }
        }
        return items;
    }
}