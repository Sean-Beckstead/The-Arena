package com.seanBeckstead.Midterm;

import com.seanBeckstead.Midterm.Abilities.BasicMeleeAttack;
import com.seanBeckstead.Midterm.Abilities.NoAttack;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Sean
 * Date: 8/14/13
 * Time: 5:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class AbilityTest {
    private Ability a1, a2;

    @Before
    public void setUp() throws Exception {
       a1 = new BasicMeleeAttack();
       a2 = new NoAttack();
    }

    @Test
    public void testMakeAttack() throws Exception {
        setUp();
        assertEquals(Integer.class, a1.makeAttack());

    }

    @Test
    public void testTargetInRange() throws Exception {
        setUp();
        assertEquals(true, a1.targetInRange(1,1,2,2));
        assertEquals(true, a1.targetInRange(1,1,2,4));

    }
}
