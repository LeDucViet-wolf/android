package com.example.leducviet_b8829.entity;

public class Finance {
    private int id;
    private String name;
    private Double money;

    public Finance(int id, String name, Double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public Finance(String name, Double money) {
        this.name = name;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
