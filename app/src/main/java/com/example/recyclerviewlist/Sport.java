package com.example.recyclerviewlist;

public class Sport {

    private final int imageResource;
    private String title;
    private String info;

    public Sport(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getInfo() {
        return info;
    }

    public String getTitle() {
        return title;
    }
}
