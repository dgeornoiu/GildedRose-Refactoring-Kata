package com.gildedrose;

public class GildedRoseItem {

    private final Item item;

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
        if (this.item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            checkAndIncreaseQuality();

            if (this.item.sellIn < 11) {
                checkAndIncreaseQuality();
            }

            if (this.item.sellIn < 6) {
                checkAndIncreaseQuality();
            }
        } else if (this.item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else if (this.item.quality > 0) {
            this.item.quality = this.item.quality - 1;
        }
    }

    protected void checkAndIncreaseQuality() {
        if (this.item.quality < 50) {
            this.item.quality = this.item.quality + 1;
        }
    }

    protected void updateQualityAfterExpiration() {
        if (this.item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            this.item.quality = 0;
        } else if (this.item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else {
            checkAndDecreaseQuality();
        }
    }


    private void updateExpiration() {
        if (!this.item.name.equals("Sulfuras, Hand of Ragnaros")) {
            this.item.sellIn = this.item.sellIn - 1;
        }
    }


    private boolean isExpired() {
        return this.item.sellIn < 0;
    }


    private void checkAndDecreaseQuality() {
        if (this.item.quality > 0) {
            this.item.quality = this.item.quality - 1;
        }
    }

}
