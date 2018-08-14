package com.seanBeckstead.Midterm.Abilities;

import com.seanBeckstead.Midterm.Ability;
/**
 * @author Sean Beckstead
 *
 */
/**
 * The Class BasicMeleeAttack.
 */
public class BasicMeleeAttack extends Ability {

    /**
     * Instantiates a new basic melee attack.
     */
    public BasicMeleeAttack() {
        this.setName("Basic Melee Attack");
        this.setAbilityType(AT_WILL);
        this.setAttackStatType(STRENGTH);
        this.setRange(1);
        this.setTargetStatType(ARMOR_COUNT);
    }
}
