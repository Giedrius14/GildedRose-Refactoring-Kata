package com.gildedrose.model;

import com.gildedrose.model.items.*;

import java.util.*;

import static com.gildedrose.model.Type.*;

public class ItemFactory{
    private final static List<String> SPECIAL_ITEMS = Arrays.asList(
            SULFURAS_HAND_OF_RAGNAROS,
            AGED_BRIE,
            BACKSTAGE_PASSES,
            CONJURED_MANA_CAKE);

    public CustomisedItem create(Item item) {
        if (isSpecialItem(item)) {
            if (SULFURAS_HAND_OF_RAGNAROS.equals(item.getName())) {
                return new Sulfuras();
            }
            if (AGED_BRIE.equals(item.getName())) {
                return new AgedBrie(item);
            }
            if (BACKSTAGE_PASSES.equals(item.getName())) {
                return new BackstagePasses(item);
            }
            if (CONJURED_MANA_CAKE.equals(item.getName())) {
                return new Conjured(item);
            }
        }
        return new Standard(item);
    }

    private boolean isSpecialItem(Item item) {
        return SPECIAL_ITEMS.contains(item.getName());
    }
}
