package com.zemeo.builder;

public class Application {

    public static void main(String[] args){
        Champion Paladin = new Champion.Builder("Darknessaint", Specialisation.PALADIN)
                .setArmour(Armour.PLATE)
                .setMount(Mounts.DRAKE)
                .setRace(Races.HUMAN)
                .setWeapon(Weapons.AXE)
                .build();

        System.out.println(Paladin.toString());
    }
}
