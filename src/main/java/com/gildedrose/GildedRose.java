package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            GildedRoseItem gildedRoseItem;
            if ("Aged Brie".equals(item.name)) {
                gildedRoseItem = new AgedBrieItem(item);
            } else {
                gildedRoseItem = new GildedRoseItem(item);
            }
            gildedRoseItem.updateItem();
        }
    }
}
