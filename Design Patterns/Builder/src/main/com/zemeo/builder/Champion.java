package com.zemeo.builder;

import java.util.ArrayList;

/**
 *  Champion Class that contains every variable
 */
public class Champion {

    private final String name;
    private final Specialisation spec;
    private final Armour armour;
    private final Races race;
    private final Weapons weapon;
    private final Mounts mount;

    private Champion(Builder builder) {
        this.name = builder.name;
        this.spec = builder.spec;
        this.armour = builder.armour;
        this.race = builder.race;
        this.weapon = builder.weapon;
        this.mount = builder.mount;
    }

    public String getName(){
        return name;
    }

    public Specialisation getSpec() {
        return spec;
    }

    public Armour getArmour() {
        return armour;
    }

    public Races getRace() {
        return race;
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public Mounts getMount() {
        return mount;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("There once was a ")
                .append(getRace())
                .append(" ")
                .append(getSpec())
                .append(" who went by the name ")
                .append(getName())
                .append(" who rode upon a great ")
                .append(getMount())
                .append(", cleaving enemies down with their ")
                .append(getWeapon());

        return stringBuffer.toString();
    }

    /**
     *  Builder Class
     */
    public static class Builder {

        private final String name;
        private final Specialisation spec;
        private  Armour armour;
        private  Races race;
        private  Weapons weapon;
        private  Mounts mount;

        public Builder(String name, Specialisation spec) {
            if (spec == null || name == null) {
                throw new IllegalArgumentException("Your Champion requires a name and specialisation");
            }
            this.name = name;
            this.spec = spec;
        }

        public Builder setArmour(Armour armour) {
            this.armour = armour;
            return this;
        }

        public Builder setRace(Races race) {
            this.race = race;
            return this;
        }

        public Builder setWeapon(Weapons weapon) {
            this.weapon = weapon;
            return this;
        }

        public Builder setMount(Mounts mount) {
            this.mount = mount;
            return this;
        }

        public Champion build(){
            return new Champion(this);
        }
    }
}
