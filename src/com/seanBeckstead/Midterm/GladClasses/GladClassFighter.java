package com.seanBeckstead.Midterm.GladClasses;

import com.seanBeckstead.Midterm.Abilities.BasicMeleeAttack;
import com.seanBeckstead.Midterm.GladClass;
/**
 * @author Sean Beckstead
 *
 */
/**
 * The Class GladClassFighter.
 */
public class GladClassFighter extends GladClass {

    /**
     * Instantiates a new glad class fighter.
     */
    public GladClassFighter() {
        this.setClassName("Fighter");
        this.setAtkBonus(0.4);
        this.setHpBonus(0.2);
        this.setReflexBonus(0);
        this.setStrengthBonus(0.4);
        this.setDmgBonus(0.1);
        this.setPlayStyle(MELEE);
        this.setAtWill(new BasicMeleeAttack());
    }
}
