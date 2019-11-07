package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.service.GildedRoseServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.gildedrose.model.Type.AGED_BRIE;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class GildedRoseServiceImplTest {

    @Test
    public void updateQualityTest() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 0, 0) };
        Item[] result = new GildedRoseServiceImpl().updateQuality(items);
        assertEquals(AGED_BRIE, result[0].getName());
    }

}
