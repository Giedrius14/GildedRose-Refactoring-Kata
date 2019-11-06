package com.gildedrose.model;

public class Item {

    private String name;

    private int daysLeftToSell;

    private int quality;

    public Item(String name, int daysLeftToSell, int quality) {
        this.name = name;
        this.daysLeftToSell = daysLeftToSell;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.daysLeftToSell + ", " + this.quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDaysLeftToSell() {
        return daysLeftToSell;
    }

    public void setDaysLeftToSell(int daysLeftToSell) {
        this.daysLeftToSell = daysLeftToSell;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
