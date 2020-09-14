package com.pack;

import java.util.*;

/**
 * UserData holds the relevant packaging data and a list of items which are to
 * be stored in several packs.
 * When constructing an instance of this class, the data has to be entered
 * in the console followed by an empty line.
 */
public class UserData {

    private final String sortOrder;
    final int maxPieces;
    final float maxWeight;
    List<Item> itemList = new ArrayList<Item>();

    /**
     * The constructor will parse console input into a list of items and packaging specifications.
     */
    public UserData() {
        System.out.println("Please enter packaging specifications and a list of items" +
                "(Finish data entry with a blank line.):");
        Scanner scanner = new Scanner(System.in);

        // read packing details
        String line = scanner.nextLine();
        String[] packingSetup = line.split(",");
        this.sortOrder = packingSetup[0];
        this.maxPieces = Integer.parseInt(packingSetup[1]);
        this.maxWeight = Float.parseFloat(packingSetup[2]);

        // read item details
        String[] itemDetails;
        while (!(line = scanner.nextLine()).equals("")) {
            itemDetails = line.split(",");
            int id = Integer.parseInt(itemDetails[0]);
            int length = Integer.parseInt(itemDetails[1]);
            int quantity = Integer.parseInt(itemDetails[2]);
            float weight = Float.parseFloat(itemDetails[3]);

            this.itemList.add(new Item(id, length, quantity, weight));
        }
        this.sortItems();
    }

    /**
     * Method to rearrange item list according to sort order.
     */
    private void sortItems() {
        if (this.sortOrder.equals("NATURAL")) {
            ;
        }
        else if(this.sortOrder.equals("SHORT_TO_LONG")) {
            this.itemList.sort(Comparator.comparing(Item::getLength));
        }
        else if (this.sortOrder.equals("LONG_TO_SHORT")) {
            this.itemList.sort(Comparator.comparing(Item::getLength).reversed());
        }
    }
}