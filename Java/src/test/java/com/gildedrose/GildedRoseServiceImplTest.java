package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.service.GildedRoseService;
import com.gildedrose.service.GildedRoseServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static com.gildedrose.model.Type.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class GildedRoseServiceImplTest {

    private GildedRoseService gildedRoseService;

    @Before
    public void init() {
        this.gildedRoseService = new GildedRoseServiceImpl();
    }

    @Test
    public void updateQualityTest() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 0, 0)};
        Item[] result = gildedRoseService.updateQuality(items);
        assertEquals(AGED_BRIE, result[0].getName());
    }

    @Test
    public void decreaseDaysLeftToSellTest() {
        Item[] items = new Item[]{
                new Item(AGED_BRIE, 0, 0),
                new Item(BACKSTAGE_PASSES, 0, 0),
                new Item(CONJURED_MANA_CAKE, 0, 0),
        };
        Item[] result = gildedRoseService.updateQuality(items);
        Arrays.stream(result).forEach(i ->
                assertEquals(-1, i.getDaysLeftToSell())
        );
    }

    @Test
    public void brieQualityIncreaseTest() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 1, 1)};
        Item[] result = gildedRoseService.updateQuality(items);
        assertEquals(2, result[0].getQuality());
    }

    @Test
    public void brieQualityCantBeMoreThanFiftyTest() {
        Item[] items = new Item[]{
                new Item(AGED_BRIE, 1, 49),
                new Item(AGED_BRIE, 1, 50)
        };
        Item[] result = gildedRoseService.updateQuality(items);
        Arrays.stream(result).forEach(i -> assertTrue(i.getQuality() <= 50));
    }

    @Test
    public void backstagePassesIncreasesQualityByOneWhenDaysLeftToSellMoreThanEleven() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 12, 1)};
        Item[] result = gildedRoseService.updateQuality(items);
        assertEquals(2, result[0].getQuality());
    }

    @Test
    public void backstagePassesIncreasesQualityByOneWhenDaysLeftToSellMoreThanSix() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 7, 1)};
        Item[] result = gildedRoseService.updateQuality(items);
        assertEquals(3, result[0].getQuality());
    }

    @Test
    public void backstagePassesQualitySetToZeroWhenDaysLeftIsZero() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 0, 50)};
        Item[] result = gildedRoseService.updateQuality(items);
        assertEquals(0, result[0].getQuality());
    }

    @Test
    public void standardItemDecreasesQualityByTwoOnceSellByDayIsZeroOrLess() {
        Item[] items = new Item[]{new Item("Standard", 0, 5)};
        Item[] result = gildedRoseService.updateQuality(items);
        assertEquals(3, result[0].getQuality());
    }

    @Test
    public void standardItemCannotHaveQualityBelowZero() {
        Item[] items = new Item[]{new Item("Standard", 0, 0)};
        Item[] result = gildedRoseService.updateQuality(items);
        assertEquals(0, result[0].getQuality());
    }

    @Test
    public void sulfurasQualityIsEighty() {
        Item[] items = new Item[]{new Item(SULFURAS_HAND_OF_RAGNAROS, 1, 80)};
        Item[] result = gildedRoseService.updateQuality(items);
        assertEquals(80, result[0].getQuality());
    }

    @Test
    public void sulfurasDoesNotAlterValues() {
        Item[] items = new Item[]{new Item(SULFURAS_HAND_OF_RAGNAROS, 1, 80)};
        Item[] result = gildedRoseService.updateQuality(items);
        assertEquals(80, result[0].getQuality());
        assertEquals(1, result[0].getDaysLeftToSell());
    }

    @Test
    public void conjuredItemDecreasesQualityByTwoIfDaysLeftIsAboveZero() {
        Item[] items = new Item[]{new Item(CONJURED_MANA_CAKE, 2, 5)};
        Item[] result = gildedRoseService.updateQuality(items);
        assertEquals(3, result[0].getQuality());
    }

    @Test
    public void conjuredItemDecreasesQualityByFourIfDaysLeftIsZeroOrLess() {
        Item[] items = new Item[]{new Item(CONJURED_MANA_CAKE, 0, 5)};
        Item[] result = gildedRoseService.updateQuality(items);
        assertEquals(1, result[0].getQuality());
    }

    @Test
    public void conjuredItemCannotHaveQualityBelowZero() {
        Item[] items = new Item[]{new Item(CONJURED_MANA_CAKE, 0, -1)};
        Item[] result = gildedRoseService.updateQuality(items);
        assertEquals(0, result[0].getQuality());
    }


}
