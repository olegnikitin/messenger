package com.ciklum.dto;

import com.ciklum.enums.StorageType;

/**
 * Created by olegnikitindev on 07.08.2016.
 */
public class UserDto {

    private String name;
    private StorageType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StorageType getType() {
        return type;
    }

    public void setType(StorageType type) {
        this.type = type;
    }
}
