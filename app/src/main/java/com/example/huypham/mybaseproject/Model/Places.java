package com.example.huypham.mybaseproject.Model;

import java.io.Serializable;

public class Places implements Serializable {
    private String name;

    public Places(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
