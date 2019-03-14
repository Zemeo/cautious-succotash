package com.zemeo.builder;

public  enum Specialisation {

    PALADIN, MAGE, ROGUE, WARRIOR, PRIEST, WARLOCK, HUNTER, DRUID, SHAMAN;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
