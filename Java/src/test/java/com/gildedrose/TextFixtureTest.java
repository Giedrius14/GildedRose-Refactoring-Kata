package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.service.GildedRoseService;
import com.gildedrose.service.GildedRoseServiceImpl;

import java.util.Arrays;

import static com.gildedrose.model.Type.*;

public class TextFixtureTest {

    public static void main(String[] args) {
        Item[] items = new Item[] {
                new Item(DEXTERITY_VEST, 10, 20),
                new Item(AGED_BRIE, 2, 0),
                new Item(ELIXIR_OF_THE_MONGOOSE, 5, 7),
                new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 80),
                new Item(SULFURAS_HAND_OF_RAGNAROS, -1, 80),
                new Item(BACKSTAGE_PASSES, 10, 49),
                new Item(BACKSTAGE_PASSES, 5, 49),
                new Item(BACKSTAGE_PASSES, 15, 20),
                new Item(CONJURED_MANA_CAKE, 3, 6) }; //todo   new Item("Conjured Mana Cake", 3, 6) };

        GildedRoseService gildedRoseService = new GildedRoseServiceImpl();

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.printf("-------- day %d --------%n", i);
            System.out.println("name, daysLeftToSell, quality");
            Arrays.stream(items).forEach(System.out::println);
            System.out.println();
            gildedRoseService.updateQuality(items);
        }
    }

}
