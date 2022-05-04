package com.example.appsellcake.entity;

public class CategoryEntity {
    private int pic;
    private String titile;

    public CategoryEntity(int pic, String titile) {
        this.pic = pic;
        this.titile = titile;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
