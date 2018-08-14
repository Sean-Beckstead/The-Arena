package com.seanBeckstead.Midterm;
/**
 * @author Sean Beckstead
 *
 */

/**
 * The Class Ability.
 */
public abstract class Ability {
	
	/** The bonus. */
	private int range, bonus;
	
	/** The expended. */
	private boolean expended;
	
	/** The name. */
	private String name; 
	
	/** The ability type. */
	private char attackStatType, targetStatType, abilityType;
	
	/** The Constant REFLEX. */
	public final static char REFLEX = 'R';
	
	/** The Constant STRENGTH. */
	public final static char STRENGTH = 'S';
	
	/** The Constant ARMOR_COUNT. */
	public final static char ARMOR_COUNT = 'A';
	
	/** The Constant AT_WILL. */
	public final static char AT_WILL = 'W';
	
	/** The Constant SPECIAL. */
	public final static char SPECIAL = 'D';
	
	/** The Constant MISS. */
	public final static char MISS = 'M';
	

	/**
	 * Gets the range.
	 *
	 * @return the range
	 */
	public int getRange() {
		return range;
	}

	/**
	 * Sets the range.
	 *
	 * @param range the new range
	 */
	public void setRange(int range) {
		this.range = range;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the attack stat type.
	 *
	 * @return the attack stat type
	 */
	public char getAttackStatType() {
		return attackStatType;
	}

	/**
	 * Sets the attack stat type.
	 *
	 * @param attackStatType the new attack stat type
	 */
	public void setAttackStatType(char attackStatType) {
		this.attackStatType = attackStatType;
	}

	/**
	 * Gets the target stat type.
	 *
	 * @return the target stat type
	 */
	public char getTargetStatType() {
		return targetStatType;
	}

	/**
	 * Sets the target stat type.
	 *
	 * @param targetStatType the new target stat type
	 */
	public void setTargetStatType(char targetStatType) {
		this.targetStatType = targetStatType;
	}
	
	/**
	 * Gets the bonus.
	 *
	 * @return the bonus
	 */
	public int getBonus() {
		return bonus;
	}

	/**
	 * Sets the bonus.
	 *
	 * @param bonus the new bonus
	 */
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	/**
	 * Checks if is expended.
	 *
	 * @return true, if is expended
	 */
	public boolean isExpended() {
		return expended;
	}

	/**
	 * Sets the expended.
	 *
	 * @param expended the new expended
	 */
	public void setExpended(boolean expended) {
		this.expended = expended;
	}

	/**
	 * Gets the ability type.
	 *
	 * @return the ability type
	 */
	public char getAbilityType() {
		return abilityType;
	}

	/**
	 * Sets the ability type.
	 *
	 * @param abilityType the new ability type
	 */
	public void setAbilityType(char abilityType) {
		this.abilityType = abilityType;
	}

	/**
	 * Make attack.
	 *
	 * @return the int
	 */
	public int makeAttack() {
		int atkRoll = (int)(Math.random()*(20));
		atkRoll += bonus;
		return atkRoll;
	}
	
	/**
	 * Target in range.
	 *
	 * @param selfX the self x
	 * @param selfY the self y
	 * @param targetX the target x
	 * @param targetY the target y
	 * @return true, if successful
	 */
	public boolean targetInRange(int selfX, int selfY, int targetX, int targetY) {
		boolean inRange = false;
		// if target is top left
		if (((selfX - this.range) <= targetX && selfX >= targetX) && ((selfY - this.range) <= targetY && selfY >= targetY)) {
			inRange = true;
		
		//target is above
		} else if (selfX == targetX && ((selfY - this.range) <= targetY && selfY >= targetY)) {
			inRange = true;
			
		// target is top right
		} else if (((selfX + this.range) >= targetX && selfX <= targetX) && ((selfY - this.range) <= targetY && selfY >= targetY)) {
			inRange = true;
			
		// target is right
		} else if (((selfX + this.range) >= targetX && selfX <= targetX) && selfY == targetY) {
			inRange = true;
			
		// target is bottom right
		} else if (((selfX + this.range) >= targetX && selfX <= targetX) && ((selfY + this.range) >= targetY && selfY <= targetY)) {
			inRange = true;
			
		// target is below
		} else if (selfX == targetX && ((selfY + this.range) >= targetY && selfY <= targetY)) {
			inRange = true;
			
		// target is bottom left
		} else if (((selfX - this.range) <= targetX && selfX >= targetX) && ((selfY + this.range) >= targetY && selfY <= targetY)) {
			inRange = true;
			
		// target is left
		} else if (((selfX - this.range) <= targetX && selfX >= targetX) &&  selfY == targetY) {
			inRange = true;
		}		
		
		return inRange;
	}

}
