package com.seanBeckstead.Midterm;

import com.seanBeckstead.Midterm.GladClasses.GladClassFighter;
import com.seanBeckstead.Midterm.GladClasses.GladClassRogue;
import com.seanBeckstead.Midterm.GladRaces.GladRaceElf;
import com.seanBeckstead.Midterm.GladRaces.GladRaceHuman;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Sean
 * Date: 8/14/13
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArenaTest {

    private Gladiator g1, g2;
    private Arena a1;

    @Before
    public void setUp() throws Exception {
        g1 = new Gladiator("Maximus", 12, 22, 10, 18, 4, 5, new GladClassFighter(), new GladRaceHuman());
        g2 = new Gladiator("Loki", 12, 22, 12, 10, 4, 5, new GladClassRogue(), new GladRaceElf());
        a1 = new Arena(new Gladiator(g1), new Gladiator(g2));

    }

    @Test
    public void testStartFight() throws Exception {
        setUp();
        a1.startFight();
        System.out.println(a1.getFightResults());

    }

    @Test
    public void testOnMove() throws Exception {
        setUp();
        a1.onMove(g1, 2, 3);
        a1.onMove(g1, 2, 4);
        a1.onMove(g1, 2, 5);
        a1.getFightResults();

    }
}
