package com.gildedrose;

public abstract class GildedRoseItem {

    protected final Item item;

    public GildedRoseItem(Item item) {
        this.item = item;
    }

    public void updateItem() {
        updateQuality();
        updateExpiration();
        if (isExpired()) {
            updateQualityAfterExpiration();
        }
    }

    protected void updateQuality() {
        if (this.item.quality > 0) {
            this.item.quality = this.item.quality - 1;
        }
    }

    protected void updateExpiration() {
        this.item.sellIn = this.item.sellIn - 1;
    }

    protected void updateQualityAfterExpiration() {
        checkAndDecreaseQuality();
    }

    protected void checkAndIncreaseQuality() {
        if (this.item.quality < 50) {
            this.item.quality = this.item.quality + 1;
        }
    }

    private boolean isExpired() {
        return this.item.sellIn < 0;
    }

    protected void checkAndDecreaseQuality() {
        if (this.item.quality > 0) {
            this.item.quality = this.item.quality - 1;
        }
    }

}
