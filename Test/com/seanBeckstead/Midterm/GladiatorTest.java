package com.seanBeckstead.Midterm;

import com.seanBeckstead.Midterm.GladClasses.GladClassFighter;
import com.seanBeckstead.Midterm.GladClasses.GladClassRogue;
import com.seanBeckstead.Midterm.GladRaces.GladRaceElf;
import com.seanBeckstead.Midterm.GladRaces.GladRaceHuman;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * Created with IntelliJ IDEA.
 * User: Sean
 * Date: 8/14/13
 * Time: 5:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class GladiatorTest {

    private Gladiator g1, g2;

    @Before
    public void setUp() throws Exception {
        g1 = new Gladiator("Maximus", 12, 22, 10, 15, 4, 5, new GladClassFighter(), new GladRaceHuman());
        g2 = new Gladiator("Loki", 12, 22, 15, 10, 4, 5, new GladClassRogue(), new GladRaceElf());

        g1.setLocationX(1);
        g1.setLocationY(1);

        g2.setLocationX(3);
        g2.setLocationY(1);
    }

    @Test
    public void testGladiatorCreation() throws Exception {

        this.setUp();

        assertEquals("Maximus", g1.getName());
        assertEquals("Human", g1.getGladRace().getRaceName());
        assertEquals("Fighter", g1.getGladClass().getClassName());
        System.out.println(g1.getName());
        System.out.println("HP: " + g1.getHp());
        System.out.println("Strength: " + g1.getStrength());
        System.out.println("Reflex: " + g1.getReflex());
        System.out.println("AC: " + g1.getAc());
        System.out.println("Damage: " + g1.getDmg());


        assertEquals("Loki", g2.getName());
        assertEquals("Elf", g2.getGladRace().getRaceName());
        assertEquals("Rogue", g2.getGladClass().getClassName());
        System.out.println(g2.getName());
        System.out.println("HP: " + g2.getHp());
        System.out.println("Strength: " + g2.getStrength());
        System.out.println("Reflex: " + g2.getReflex());
        System.out.println("AC: " + g2.getAc());
        System.out.println("Damage: " + g2.getDmg());

    }

    @Test
    public void testTakeAction() throws Exception {
        this.setUp();
        Ability ability = g1.takeAction(g2.getLocationX(), g2.getLocationY());
        assertEquals(Ability.class, g1.takeAction(g2.getLocationX(), g2.getLocationY()).getClass().getSuperclass());
    }

    @Test
    public void testGetAtkDmg() throws Exception {
        setUp();
        assertEquals(Integer.class, g1.getAtkDmg());
    }

    @Test
    public void testMoveTowardsEnemy() throws Exception {
        this.setUp();
        int x = g1.getLocationX();
        int y = g1.getLocationY();
        g1.moveTowardsEnemy(4,5);

        assertNotSame(x, g1.getLocationX());
        assertNotSame(y, g1.getLocationY());
    }

    @Test
    public void testDodgeAttempt() throws Exception {
        this.setUp();
        assertEquals(Integer.class, g1.dodgeAttempt());
    }
}
