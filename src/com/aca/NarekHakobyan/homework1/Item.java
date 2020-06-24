package com.aca.NarekHakobyan.homework1;

import java.util.Scanner;

public abstract class Item {
    String name;
    int memory;
    int recDuration;
    int price;
    int quantity = 0;
    Type type;
    protected abstract void print();
    protected abstract void listOfItemsByType(Type type);
}
