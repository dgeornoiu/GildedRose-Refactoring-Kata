package com.gildedrose;

import java.util.Map;
import java.util.function.Function;

public class GildedRoseItemFactory {

    private static final Map<String, Function<Item, GildedRoseItem>> ITEMS = Map.of(
        "Aged Brie", AgedBrieItem::new,
        "Backstage passes to a TAFKAL80ETC concert", BackstageItem::new,
        "Sulfuras, Hand of Ragnaros", SulfurasItem::new
    );

    public static GildedRoseItem getUpdater(Item item) {
        return ITEMS.getOrDefault(item.name, GildedRoseDefaultItem::new).apply(item);
    }
}
