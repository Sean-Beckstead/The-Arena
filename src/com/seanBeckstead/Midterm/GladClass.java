package com.seanBeckstead.Midterm;



import com.seanBeckstead.Midterm.Abilities.BasicMeleeAttack;
/**
 * @author Sean Beckstead
 *
 */
/**
 * The Class GladClass.
 */
public abstract class GladClass {

	/** The class name. */
	private String className;
	
	/** The dmg bonus. */
	private double atkBonus, hpBonus, reflexBonus, strengthBonus, dmgBonus;
	
	/** The special. */
	private Ability atWill;
	
	/** The play style. */
	private char playStyle;
	
	/** The Constant MELEE. */
	public final static char MELEE = 'M';
	
	/** The Constant RANGED. */
	public final static char RANGED = 'R';
	
	

	/**
	 * Gets the class name.
	 *
	 * @return the class name
	 */
	public String getClassName() {
		return className;
	}
	
	/**
	 * Sets the class name.
	 *
	 * @param className the new class name
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	
	/**
	 * Gets the play style.
	 *
	 * @return the play style
	 */
	public char getPlayStyle() {
		return playStyle;
	}

	/**
	 * Sets the play style.
	 *
	 * @param playStyle the new play style
	 */
	public void setPlayStyle(char playStyle) {
		this.playStyle = playStyle;
	}

	/**
	 * Gets the atk bonus.
	 *
	 * @return the atk bonus
	 */
	public double getAtkBonus() {
		return atkBonus;
	}
	
	/**
	 * Sets the atk bonus.
	 *
	 * @param atkBonus the new atk bonus
	 */
	public void setAtkBonus(double atkBonus) {
		this.atkBonus = atkBonus;
	}
	
	/**
	 * Gets the hp bonus.
	 *
	 * @return the hp bonus
	 */
	public double getHpBonus() {
		return hpBonus;
	}
	
	/**
	 * Sets the hp bonus.
	 *
	 * @param hpBonus the new hp bonus
	 */
	public void setHpBonus(double hpBonus) {
		this.hpBonus = hpBonus;
	}	
	
	/**
	 * Gets the reflex bonus.
	 *
	 * @return the reflex bonus
	 */
	public double getReflexBonus() {
		return reflexBonus;
	}
	
	/**
	 * Sets the reflex bonus.
	 *
	 * @param reflexBonus the new reflex bonus
	 */
	public void setReflexBonus(double reflexBonus) {
		this.reflexBonus = reflexBonus;
	}
	
	/**
	 * Gets the strength bonus.
	 *
	 * @return the strength bonus
	 */
	public double getStrengthBonus() {
		return strengthBonus;
	}
	
	/**
	 * Sets the strength bonus.
	 *
	 * @param strengthBonus the new strength bonus
	 */
	public void setStrengthBonus(double strengthBonus) {
		this.strengthBonus = strengthBonus;
	}
	
	/**
	 * Gets the dmg bonus.
	 *
	 * @return the dmg bonus
	 */
	public double getDmgBonus() {
		return dmgBonus;
	}
	
	/**
	 * Sets the dmg bonus.
	 *
	 * @param dmgBonus the new dmg bonus
	 */
	public void setDmgBonus(double dmgBonus) {
		this.dmgBonus = dmgBonus;
	}	
	
	/**
	 * Gets the at will.
	 *
	 * @return the at will
	 */
	public Ability getAtWill() {
		return atWill;
	}

	/**
	 * Sets the at will.
	 *
	 * @param atWill the new at will
	 */
	public void setAtWill(Ability atWill) {
		this.atWill = atWill;
	}



}
