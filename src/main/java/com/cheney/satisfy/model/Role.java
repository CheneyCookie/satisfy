package com.cheney.satisfy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Role implements Serializable {

    private static final long serialVersionUID = -3205299764947160521L;

    private Integer id;
    private String name;
    private List<Permission> permissions = new ArrayList<Permission>();

    public Role(Integer id) {
        super();
        this.id = id;
    }

    public Role() {
        super();
    }

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

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", name=" + name + ", permissions="
                + permissions + "]";
    }
}
