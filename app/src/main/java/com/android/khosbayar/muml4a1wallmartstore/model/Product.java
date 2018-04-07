package com.android.khosbayar.muml4a1wallmartstore.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by khosbayar on 4/6/18.
 */

public class Product implements Parcelable {
    String title;
    double price;
    String color;
    int image;
    String itemId;
    String desc;

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public Product(String title, double price, String color, int image, String itemId, String desc) {
        this.title = title;
        this.price = price;
        this.color = color;
        this.image = image;
        this.itemId = itemId;
        this.desc = desc;
    }

    public Product(Parcel in) {
        this.title = in.readString();
        this.price = in.readDouble();
        this.color = in.readString();
        this.image = in.readInt();
        this.itemId = in.readString();
        this.desc = in.readString();
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public int getImage() {
        return image;
    }

    public String getItemId() {
        return itemId;
    }

    public String getDesc() {
        return desc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeDouble(this.price);
        dest.writeString(this.color);
        dest.writeInt(this.image);
        dest.writeString(this.itemId);
        dest.writeString(this.desc);
    }
}
