package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.service.GildedRoseService;
import com.gildedrose.service.GildedRoseServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseServiceImplTest {

    @Test
    public void updateQualityTest() {
        Item[] items = new Item[] { new Item("Food", 0, 0) };
        GildedRoseService app = new GildedRoseServiceImpl();
        Item[] result = app.updateQuality(items);
        assertEquals("Food", result[0].getName());
    }

}
