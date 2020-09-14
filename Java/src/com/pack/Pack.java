package com.pack;

import java.util.ArrayList;
import java.util.List;

/**
 * A Pack object describes a pack of items. Items can be added which will change
 * pack properties like weight, length, and quantity.
 */
public class Pack {

    private final int number;
    private List<Item> itemList;
    private int length;  // longest length of contained items determines pack length
    private float weight;  // sum over weight of all items in pack
    private int quantity;  // total number of items in pack

    /**
     * Data model for a pack of items.
     *
     * @param number id for identification
     */
    public Pack(int number) {
        this.number = number;
        itemList = new ArrayList<Item>();
        length = 0;
        weight = 0;
        quantity = 0;
    }

    /**
     * Method to add an item to a pack and update pack properties.
     *
     * @param item which shall be added
     */
    public void addItem(Item item) {
        itemList.add(item);
        // updating length, weight, and quantity
        length = Math.max(item.getLength(), length);
        weight += item.getWeight() * item.getQuantity();
        quantity += item.getQuantity();
    }

    /**
     * Print out pack details to console.
     */
    public void print() {
        System.out.println("Pack Number: " + number);
        for (Item item : itemList) {
            System.out.println(item.getId() + "," + item.getLength() + "," + item.getQuantity() + "," + item.getWeight());
        }
        System.out.println("Pack Length: " +length + ", Pack Weight: " + weight + "\n");
    }

    /**
     * Getter function for pack weight.
     *
     * @return weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Getter function for number of items in pack.
     *
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

}
