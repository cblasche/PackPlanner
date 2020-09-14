package com.pack;

/**
 * Pack Planner
 *
 * The pack planner is a program that takes a list of items and sorts them into
 * several packs (groups). Find the full description of the problem in
 * SoftwareProgram.pdf.
 */

class Main
{
    public static void main(String[] args) {
        UserData userData = new UserData();
        PackList packList = new PackList(userData.itemList, userData.maxPieces, userData.maxWeight);
        packList.print();
    }
}


