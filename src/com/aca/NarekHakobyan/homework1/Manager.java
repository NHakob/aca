package com.aca.NarekHakobyan.homework1;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager implements Management {
    private ArrayList<Item> items = new ArrayList<Item>();
    private int soldAMD = 0;
    private int stockAMD = 0;

    private static boolean isCorrectInput(Item item) {
        if (item.price <= 0 || item.quantity < 0 || item.recDuration < 0 || item.memory < 0) {
            System.out.println("Some parameter of item is wrong. Please check");
            return false;
        }
        return true;
    }

    private static int action(Item i) {
        int action;
        Scanner in = new Scanner(System.in);
        act:
        while (true) {
            if (!isCorrectInput(i)) {
                i.print();
                System.out.println("Please check appropriate action\n1)Skip item\n2)Add anyway\n3)Correct the parameters");
                action = in.nextInt();
                switch (action) {
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
                    default:
                        System.out.println("Please enter right action number");
                        continue act;
                }
            }
            return 2;
        }
    }

    private static void updateInput(Item i) {
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Please enter new RAM: ");
            i.memory = in.nextInt();
            System.out.print("\nPlease enter new Recording Duration: ");
            i.recDuration = in.nextInt();
            System.out.print("\nPlease enter new Price: ");
            i.price = in.nextInt();
            System.out.print("\nPlease enter new Quantity: ");
            i.quantity = in.nextInt();
        } while (!isCorrectInput(i));
    }

    Manager(ArrayList<Item> item) {
        act:
        for (Item i : item) {
            switch (action(i)) {
                case 1:
                    continue act;
                case 2:
                    items.add(i);
                    break;
                case 3:
                    updateInput(i);
                    items.add(i);
                    break;

            }
            stockAMD += i.quantity * i.price;
        }
    }

    public void changePrice(String name, int price) {
        for (Item i : this.items) {
            if (i.name.equals(name)) {
                this.stockAMD -= i.quantity * (i.price - price);
                i.price = price;
                return;
            }
        }
    }

    public void addItem(String Name, Type type, int memory, int recDuration, int price, int quantity, VideoQuality videoQuality,
                        SoundFormat soundFormat) {

        Item item = new ItemVideo(Name, type, memory, recDuration, price, quantity, videoQuality, soundFormat);
        switch (action(item)) {
            case 1:
                break;
            case 2:
                items.add(item);
                break;
            case 3:
                updateInput(item);
                items.add(item);
                break;
        }
        stockAMD += item.quantity * item.price;
    }

    public void addItem(String Name, Type typeRecord, Type typeVideo, int memory, int recDuration, int price, int quantity, VideoQuality videoQuality,
                        SoundFormat soundFormat) {

        Item item = new ItemRecordVideo(Name, typeRecord, typeVideo, memory, recDuration, price, quantity, videoQuality, soundFormat);
        switch (action(item)) {
            case 1:
                break;
            case 2:
                items.add(item);
                break;
            case 3:
                updateInput(item);
                items.add(item);
                break;
        }
        stockAMD += item.quantity * item.price;
    }

    public void addItem(String Name, Type type, int memory, int recDuration, int price, int quantity, SoundFormat soundFormat) {

        Item item = new ItemRecord(Name, type, memory, recDuration, price, quantity, soundFormat);
        switch (action(item)) {
            case 1:
                break;
            case 2:
                items.add(item);
                break;
            case 3:
                updateInput(item);
                items.add(item);
                break;
        }
        stockAMD += item.quantity * item.price;
    }

    public int getStockAMD() {
        return stockAMD;
    }

    public int getSoldAMD() {
        return soldAMD;
    }

    public void sellItem(String name) {
        for (Item i : this.items) {
            if (i.name.equals(name)) {
                if (i.quantity > 0) {
                    i.quantity--;
                    stockAMD -= i.price;
                    soldAMD += i.price;
                    return;
                }
            }
        }
        System.out.printf("All %s's sold\n", name);
    }

    public void listOfItems() {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tList of items");
        for (Item item : items) {
            item.print();
        }
    }

    public void listOfItemsByType(Type type) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tList of items");
        System.out.println("Name\t\t\t\t\tType\t\t\tMemory\t\t\t\t\tRecording Duration\t\tPrice\t\tQuantity\t\tVideo Quality\t\tSound Quality");
        for (Item item : items) {
            item.listOfItemsByType(type);
        }
    }
}