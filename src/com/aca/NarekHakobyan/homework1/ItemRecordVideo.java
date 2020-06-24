package com.aca.NarekHakobyan.homework1;

public class ItemRecordVideo extends Item {
    Type typeVideo;
    Type recordType;
    VideoQuality videoQuality;
    SoundFormat soundFormat;

    ItemRecordVideo(String name, Type recordType, Type videoType, int memory, int recDuration, int price, int quantity,
                    VideoQuality videoQuality, SoundFormat soundFormat) {
        this.name = name;
        this.recordType = recordType;
        this.typeVideo = videoType;
        this.memory = memory;
        this.recDuration = recDuration;
        this.price = price;
        this.quantity = quantity;
        this.videoQuality = videoQuality;
        this.soundFormat = soundFormat;
    }

    @Override
    protected void print() {
        System.out.println("- " + this.name +
                "\n\t\t" + this.recordType + " " + this.soundFormat + ", " + this.typeVideo + " " + this.videoQuality +
                "\n\t\t" + (this.memory == 0 ? "no inside memory" : this.memory + "GB") +
                "\n\t\t" + this.recDuration + " hours recording" +
                "\n\t\t" + this.price + " AMD");
    }

    public void listOfItemsByType(Type type) {
        if (this.typeVideo.name().equals(type.name()) || this.recordType.name().equals(type.name()))
            this.print();
    }
}
