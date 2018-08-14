package com.seanBeckstead.Midterm.GladClasses;

import com.seanBeckstead.Midterm.Abilities.BasicMeleeAttack;
import com.seanBeckstead.Midterm.GladClass;
/**
 * @author Sean Beckstead
 *
 */
/**
 * The Class GladClassRogue.
 */
public class GladClassRogue extends GladClass {

    /**
     * Instantiates a new glad class rogue.
     */
    public GladClassRogue() {
        this.setClassName("Rogue");
        this.setAtkBonus(0.8);
        this.setHpBonus(0);
        this.setReflexBonus(0.4);
        this.setStrengthBonus(0);
        this.setDmgBonus(0.2);
        this.setPlayStyle(MELEE);
        this.setAtWill(new BasicMeleeAttack());
    }
}
