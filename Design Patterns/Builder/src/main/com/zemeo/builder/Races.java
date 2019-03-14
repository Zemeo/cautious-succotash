package com.zemeo.builder;

public enum Races {

    ORC, GOBLIN, TAUREN, TROLL, UNDEAD, HUMAN, DWARF, GNOME, ELF, DRAENEI;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
