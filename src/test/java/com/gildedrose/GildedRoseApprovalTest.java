package com.gildedrose;

import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

@UseReporter(DiffReporter.class)
public class GildedRoseApprovalTest {

    @Test
    public void normalItemUpdateQuality() {

        Item[] items = new Item[]{new Item("+5 Dexterity Vest", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(items[0].sellIn, 9);
        assertEquals(items[0].quality, 19);
    }

    @Test
    public void normalItemQualityNeverGoesNegative() {

        Item[] items = new Item[]{new Item("+5 Dexterity Vest", 10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(items[0].sellIn, 9);
        assertEquals(items[0].quality, 0);
    }

    @Test
    public void normalItemQualityDegradesTwiceAsSellInDateHasPassed() {

        Item[] items = new Item[]{new Item("+5 Dexterity Vest", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(items[0].sellIn, -1);
        assertEquals(items[0].quality, 8);
    }

    @Test
    public void agedBrieIncreasesInQualityWhenItGetsOlder() {

        Item[] items = new Item[]{new Item("Aged Brie", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(items[0].sellIn, 4);
        assertEquals(items[0].quality, 11);
    }

    @Test
    public void agedBrieItemDoesNotExceedMaxQuality() {

        Item[] items = new Item[]{new Item("Aged Brie", 10, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }


    @Test
    public void agedBrieQualityIncreseasTwiceAsSellinDateHasPassed() {

        Item[] items = new Item[]{new Item("Aged Brie", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(12, items[0].quality);
    }

    @Test
    public void sulfurasNeverChangeQualityAndSellInWhenItGetsOlder() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(items[0].sellIn, 5);
        assertEquals(items[0].quality, 80);
    }

    @Test
    public void backstagePasses_increasesInQuality_over10Days() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 12, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(items[0].sellIn, 11);
        assertEquals(items[0].quality, 11);
    }

    @Test
    public void backstagePasses_increasesBy2InQuality_lowerOrEqualThan10AndHigherThan5Days() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(12, items[0].quality);
    }

    @Test
    public void backstagePasses_increasesBy3InQuality_lowerOrEqualThan5Days() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(4, items[0].sellIn);
        assertEquals(13, items[0].quality);
    }


    @Test
    public void backstagePassesDropsTo0whenConcertDay() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    public void backstagePassesDoesntExceedMaxQuality() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(3, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    public void conjuredItemQualityDecreasesTwiceAsNormalItem() {

        Item[] items = new Item[]{new Item("Conjured Mana Cake", 2, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(1, items[0].sellIn);
        assertEquals(3, items[0].quality);
    }

    @Test
    public void conjuredItemQualityDecreasesTwiceAsNormalItemAsSellinDateHasPassed() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 0, 8)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(4, items[0].quality);
    }


}
