package com.gildedrose.model;

import static com.gildedrose.model.Type.SULFURAS_HAND_OF_RAGNAROS;

public class QualityHelpers {
    private static final int LOWEST_QUALITY_VALUE = 0;
    private static final int SULFURAS_ITEM_MAX_QUALITY_VALUE = 80;
    private static final int STANDARD_ITEM_MAX_QUALITY_VALUE = 50;


    public boolean hasReachedLowestQualityValue(Item item) {
        return item.getQuality() < LOWEST_QUALITY_VALUE;
    }

    public static int highestValuePossible(Item item) {
        if (item.getName().equals(SULFURAS_HAND_OF_RAGNAROS)) {
            return SULFURAS_ITEM_MAX_QUALITY_VALUE;
        }
        return STANDARD_ITEM_MAX_QUALITY_VALUE;
    }
}
