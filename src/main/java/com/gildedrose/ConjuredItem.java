package com.gildedrose;

public class ConjuredItem extends GildedRoseItem {
    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        if (this.item.quality >= 2) {
            this.item.quality = this.item.quality - 2;
        }
        else {
            this.item.quality = 0;
        }
    }

    @Override
    protected void updateQualityAfterExpiration() {
        if (this.item.quality >= 2) {
            this.item.quality = this.item.quality - 2;
        }
        else {
            this.item.quality = 0;
        }
    }
}
