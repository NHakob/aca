package com.aca.NarekHakobyan.homework1;

public class ItemRecord extends Item {
    SoundFormat soundFormat;

    ItemRecord(String name, Type type, int memory, int recDuration, int price, int quantity, SoundFormat soundFormat) {
        this.name = name;
        this.type = type;
        this.memory = memory;
        this.recDuration = recDuration;
        this.price = price;
        this.quantity = quantity;
        this.soundFormat = soundFormat;
    }

    @Override
    protected void print() {
        System.out.println("- " + this.name + "\n\t\t" + this.type + " " + this.soundFormat +
                "\n\t\t" + (this.memory == 0 ? "no inside memory" : this.memory + "GB") +
                "\n\t\t" + this.recDuration + " hours recording" +
                "\n\t\t" + this.price + " AMD");
    }

    public void listOfItemsByType(Type type) {
        if (this.type.equals(type))
            this.print();
    }
}
