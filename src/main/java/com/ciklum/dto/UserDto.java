package com.ciklum.dto;

/**
 * Created by olegnikitindev on 07.08.2016.
 */
public class UserDto {

    private String name;
    private Type type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    private enum Type {
        MEMORY, DATABASE;
    }

}
