package com.cheney.satisfy.model;

import java.io.Serializable;

public class Permission implements Serializable {

    private static final long serialVersionUID = -1145898481927737336L;

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Permission [id=" + id + ", name=" + name + "]";
    }
}
