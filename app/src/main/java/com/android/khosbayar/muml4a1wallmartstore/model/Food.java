package com.android.khosbayar.muml4a1wallmartstore.model;

/**
 * Created by khosbayar on 4/6/18.
 */

public class Food {
    private String title;
    private int image;
    private double price;

    public Food(String title, int image, double price) {
        this.title = title;
        this.image = image;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
