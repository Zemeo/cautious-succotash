package com.zemeo.builder;

public enum Armour {

    PLATE, MAIL, LEATHER, CLOTH;

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
