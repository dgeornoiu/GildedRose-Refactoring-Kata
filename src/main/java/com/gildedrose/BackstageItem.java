package com.gildedrose;

public class BackstageItem extends GildedRoseItem {
    public BackstageItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        checkAndIncreaseQuality();

        if (this.item.sellIn < 11) {
            checkAndIncreaseQuality();
        }

        if (this.item.sellIn < 6) {
            checkAndIncreaseQuality();
        }
    }

    @Override
    protected void updateQualityAfterExpiration() {
        this.item.quality = 0;
    }
}
