package com.phong.xemdienthoai;

public class DataShop {
    private int hinhanh;
    private String name;

    public DataShop(int hinhanh, String name) {
        this.hinhanh = hinhanh;
        this.name = name;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
