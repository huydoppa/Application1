package com.example.myapplication.model;

import java.io.Serializable;

public class SinhVienLop implements Serializable {
    private int id;
    private String msv;
    private String malop;

    public SinhVienLop() {
    }

    public SinhVienLop(int id, String msv, String malop) {
        this.id = id;
        this.msv = msv;
        this.malop = malop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }
}
