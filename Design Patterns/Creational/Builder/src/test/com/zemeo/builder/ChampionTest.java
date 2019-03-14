package com.zemeo.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ChampionTest {


    /**
     * Test to see if we get an IllegalArgumentException when creating a hero with no name
     */
    @Test
    public void testChampionBuilderNoName(){
        assertThrows(IllegalArgumentException.class, () -> new Champion.Builder(null, Specialisation.DRUID));
    }

    /**
     * Test to see if we get an IllegalArgumentException when creating a hero with no Specialisation
     */
    @Test
    public void testChampionBuilderNoSpec(){
        assertThrows(IllegalArgumentException.class, () -> new Champion.Builder("No Spec Salathor", null));
    }

    /**
     * Test to see if hero is built using the correct variables
     */
    @Test
    public void testChampionBuilder(){
        final String name = "Angharad";
        final Specialisation spec = Specialisation.MAGE;
        final Weapons weapon = Weapons.MAGIC;
        final Armour armour = Armour.CLOTH;
        final Races race = Races.DRAENEI;
        final Mounts mount = Mounts.ELEKK;


        final Champion newChampion = new Champion.Builder(name, spec)
                .setWeapon(weapon)
                .setArmour(armour)
                .setRace(race)
                .setMount(mount)
                .build();

        assertNotNull(newChampion);
        assertNotNull(newChampion.toString());
        assertEquals(newChampion.getName(), name);
        assertEquals(newChampion.getSpec(), spec);
        assertEquals(newChampion.getWeapon(), weapon);
        assertEquals(newChampion.getArmour(), armour);
        assertEquals(newChampion.getRace(), race);
        assertEquals(newChampion.getMount(), mount);

    }
}
