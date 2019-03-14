package com.zemeo.builder;

public enum Mounts {

    ELEKK, RAM, MECHANOSTRIDER, HORSE, SABER, HAWKSTRIDER, WOLF, KODO, RAPTOR, DRAKE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
