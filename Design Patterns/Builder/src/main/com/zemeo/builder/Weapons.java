package com.zemeo.builder;

public enum Weapons {

    AXE, SWORD, STAFF, MACE, MAGIC, BOW, CROSSBOW, DAGGER;

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
