package com.example.plank;

public class Item {

    String name;
    String tip;
    int image;


    public Item(int image, String name, String tip) {
        this.image = image;
        this.name = name;
        this.tip = tip;
    }

    public String getName() {
        return name;
    }

    public  String getTip(){
        return tip;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
