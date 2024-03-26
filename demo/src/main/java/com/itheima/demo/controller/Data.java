package com.itheima.demo.controller;

public class Data {
    public String name;
    public int id;
    public String address;

    public Data(String name, int id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public Data() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
