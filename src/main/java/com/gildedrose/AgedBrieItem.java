package com.gildedrose;

public class AgedBrieItem extends GildedRoseItem {

    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        checkAndIncreaseQuality();
    }

    @Override
    protected void updateQualityAfterExpiration() {
        checkAndIncreaseQuality();
    }
}
