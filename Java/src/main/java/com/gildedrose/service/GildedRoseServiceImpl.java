package com.gildedrose.service;

import com.gildedrose.model.Item;

public class GildedRoseServiceImpl implements GildedRoseService{

    public Item[] updateQuality(Item[] items) {
        for (Item item : items) {
            if (!item.getName().equals("Aged Brie")
                    && !item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.getQuality() > 0 && !item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                    item.setQuality(item.getQuality() - 1);
                }
            } else {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);

                    if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.getDaysLeftToSell() < 11) {
                            item.setQuality(item.getQuality() + 1);
                        }

                        if (item.getDaysLeftToSell() < 6) {
                            item.setQuality(item.getQuality() + 1);
                        }
                    }
                }
            }

            if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                item.setDaysLeftToSell(item.getDaysLeftToSell() - 1);
            }

            if (item.getDaysLeftToSell() < 0) {
                if (!item.getName().equals("Aged Brie")) {
                    if (!item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.getQuality() > 0) {
                            if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
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