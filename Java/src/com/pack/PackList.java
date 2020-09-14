package com.pack;

import java.util.*;

/**
 * A PackList object is an arrangement of items into packs.
 */
public class PackList {

    private final List<Pack> packList;

    /**
     * Model for a list of packs given an item list and pack specifications.
     *
     * @param itemList holds all items which need to be packed
     * @param maxPieces maximum number of items per pack
     * @param maxWeight maximum weight per pack
     */
    public PackList(List<Item> itemList, int maxPieces, float maxWeight) {
        packList = new ArrayList<Pack>();
        int packNumber = 1;
        packList.add(new Pack(packNumber));

        for (Item item : itemList) {
            while (item.getQuantity() > 0) {
                // compute possible quantities of items with respect to available space, weight,
                // or available quantity and choose the smallest among them to fit them in current pack
                int piecesLimit = (maxPieces - packList.get(packNumber - 1).getQuantity());
                float freeWeight = (maxWeight - packList.get(packNumber - 1).getWeight());
                int weightLimit = (int) (freeWeight / item.getWeight());
                int quantity = Math.min(piecesLimit, Math.min(weightLimit, item.getQuantity()));

                // take respective quantity of item and put them into pack
                if (quantity > 0) {
                    item.setQuantity(item.getQuantity() - quantity);
                    Item newItem = new Item(item.getId(), item.getLength(), quantity, item.getWeight());
                    packList.get(packNumber - 1).addItem(newItem);
                }
                // if no items can be added to this pack, start a new one
                else if (quantity == 0) {
                    packNumber += 1;
                    packList.add(new Pack(packNumber));
                }
            }
        }
    }

    /**
     * Print out pack details for all packs in the pack list.
     */
    public void print() {
        for (Pack pack : packList) {
            pack.print();
        }
    }
}
