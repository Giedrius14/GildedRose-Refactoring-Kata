package com.gildedrose.model;

public interface AbstractFactory<T> {
    T updateState(String itemName);
}
