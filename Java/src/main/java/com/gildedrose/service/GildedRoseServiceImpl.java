package com.gildedrose.service;

import com.gildedrose.model.Item;
import com.gildedrose.model.ItemFactory;

import static com.gildedrose.model.QualityHelpers.*;

public class GildedRoseServiceImpl implements GildedRoseService{

    public Item[] updateQuality(Item[] items) {
        for (Item item : items) {
            new ItemFactory().create(item).updateState();
            if (hasReachedLowestQualityValue(item)) {
                item.setQuality(LOWEST_QUALITY_VALUE);
            } else if (hasReachedHighestQualityValue(item)) {
                item.setQuality(highestValuePossible(item));
            }
        }
        return items;
    }
}
