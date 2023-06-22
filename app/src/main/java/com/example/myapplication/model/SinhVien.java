package com.example.myapplication.model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private int id;
    private String msv;
    private String name;
    private String namsinh;
    private String que;
    private String namhoc;

    public SinhVien() {
    }

    public SinhVien(String msv, String name, String namsinh, String que, String namhoc) {
        this.msv = msv;
        this.name = name;
        this.namsinh = namsinh;
        this.que = que;
        this.namhoc = namhoc;
    }

    public SinhVien(int id, String msv, String name, String namsinh, String que, String namhoc) {
        this.id = id;
        this.msv = msv;
        this.name = name;
        this.namsinh = namsinh;
        this.que = que;
        this.namhoc = namhoc;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(String namhoc) {
        this.namhoc = namhoc;
    }
}
