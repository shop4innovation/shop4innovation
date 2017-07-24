package com.example.malek.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by malek on 19/07/17.
 */

public class Product implements Parcelable{


    private String Nom;
    private String idp;
    private  String image;
    private String Description;

    protected Product(Parcel in) {
        Nom = in.readString();
        idp = in.readString();
        image = in.readString();
        Description = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getIdp() {
        return idp;
    }

    public void setIdp(String idp) {
        this.idp = idp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Product() {
    }

    public Product(String nom, String idp, String image, String description) {
        Nom = nom;
        this.idp = idp;
        this.image = image;
        Description = description;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Nom);
        parcel.writeString(idp);
        parcel.writeString(image);
        parcel.writeString(Description);
    }
}
