
package com.seanBeckstead.Midterm;
/**
 * @author Sean Beckstead
 *
 */

/**
 * The Class GladRace.
 */
public abstract class GladRace {
	
	/** The race name. */
	private String raceName;
	
	/** The dmg bonus. */
	private double hpBonus, reflexBonus, strengthBonus, dmgBonus;		
	
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
	 * Gets the race name.
	 *
	 * @return the race name
	 */
	public String getRaceName() {
		return raceName;
	}
	
	/**
	 * Sets the race name.
	 *
	 * @param raceName the new race name
	 */
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}
	
}

