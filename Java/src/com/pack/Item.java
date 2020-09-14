package com.pack;

/**
 * A data model for an item with its properties.
 */
public class Item {

    private final int id;
    private final int length;
    private int quantity;
    private final float weight;

    public Item(int id, int length, int quantity, float weight) {
        this.id = id;
        this.length = length;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getWeight() {
        return weight;
    }

}
