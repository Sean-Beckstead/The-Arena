package com.seanBeckstead.Midterm;

import java.util.Random;

import com.seanBeckstead.Midterm.Abilities.NoAttack;
import com.seanBeckstead.Midterm.GladClasses.GladClassDummy;
import com.seanBeckstead.Midterm.GladRaces.GladRaceDummy;
/**
 * @author Sean Beckstead
 *
 */
/**
 * The Class Gladiator.
 */
public class Gladiator {
	
	/** The move listen. */
	private static MoveListener moveListen;
	
	/** The name. */
	private String name;
	
	/** The location y. */
	private int ac, baseHp, hp, baseReflex, reflex, baseStrength, strength, baseDmg, dmg, movement, locationX, locationY;
	
	/** The special. */
	private Ability atWill1, atWill2, atWill3, special;
	
	/** The glad race. */
	private GladRace gladRace;
	
	/** The glad class. */
	private GladClass gladClass;


	/**
	 * Instantiates a new Gladiator as Dummy Gladiator Constructor with dummy class and race.
	 */
	public Gladiator() {
		setName("");
		setAc(0);
		setHp(0);
		setReflex(0);
		setStrength(0);
		setDmg(0);
		setMovement(0);
		setGladClass(new GladClassDummy());
		setGladRace(new GladRaceDummy());
	}


	/**
	 * Instantiates a new Gladiator as Cloned Gladiator
     * which takes a gladiator and makes a new one exactly the same
	 *
	 * @param g the g
	 */
	public Gladiator(Gladiator g) {
		setName(g.getName());
		setAc(g.getAc());
		setHp(g.getHp());
		setReflex(g.getReflex());
		setStrength(g.getStrength());
		setDmg(g.getDmg());
		setMovement(g.getMovement());
		setGladClass(g.getGladClass());
		setGladRace(g.getGladRace());
		setAtWill1(g.getGladClass().getAtWill());
	}


	/**
	 * Instantiates a new Gladiator which takes all the stats and makes a Gladiator
	 *
	 * @param n the n
	 * @param armorC the armor c
	 * @param health the health
	 * @param ref the ref
	 * @param str the str
	 * @param damage the damage
	 * @param move the move
	 * @param gClass the g class
	 * @param gRace the g race
	 */
	public Gladiator(String n, int armorC, int health, int ref, int str,
			int damage, int move, GladClass gClass, GladRace gRace) {
		setName(n);
		setAc(armorC);
        setBaseHp(health);
		setHp(health + Integer.parseInt(Math.round(health * gClass.getHpBonus()) + "") + Integer.parseInt(Math.round(health * gRace.getHpBonus()) + ""));
        setBaseReflex(ref);
		setReflex(ref + Integer.parseInt(Math.round(ref * gClass.getReflexBonus()) + "") + Integer.parseInt(Math.round(ref * gRace.getReflexBonus()) + ""));
        setBaseStrength(str);
		setStrength(str + Integer.parseInt(Math.round(str * gClass.getStrengthBonus()) + "") + Integer.parseInt(Math.round(str * gRace.getStrengthBonus()) + ""));
        setBaseDmg(damage);
		setDmg(damage + Integer.parseInt(Math.round(damage * gClass.getDmgBonus()) + "") + Integer.parseInt(Math.round(damage * gRace.getDmgBonus()) + ""));
		setMovement(move);
		setGladClass(gClass);
		setGladRace(gRace);

		if (gClass.getAtWill().getAttackStatType() == Ability.STRENGTH) {
			gClass.getAtWill().setBonus(this.getStrength());
		} else if (gClass.getAtWill().getAttackStatType() == Ability.REFLEX) {
			gClass.getAtWill().setBonus(this.getReflex());
		}

		setAtWill1(gClass.getAtWill());
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
	 * Gets the ac.
	 *
	 * @return the ac
	 */
	public int getAc() {
		return ac;
	}

	/**
	 * Sets the ac.
	 *
	 * @param ac the new ac
	 */
	public void setAc(int ac) {
		this.ac = ac;
	}

	/**
	 * Gets the hp.
	 *
	 * @return the hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * Sets the hp.
	 *
	 * @param hp the new hp
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * Gets the reflex.
	 *
	 * @return the reflex
	 */
	public int getReflex() {
		return reflex;
	}

	/**
	 * Sets the reflex.
	 *
	 * @param reflex the new reflex
	 */
	public void setReflex(int reflex) {
		this.reflex = reflex;
	}

	/**
	 * Gets the strength.
	 *
	 * @return the strength
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * Sets the strength.
	 *
	 * @param strength the new strength
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}

	/**
	 * Gets the dmg.
	 *
	 * @return the dmg
	 */
	public int getDmg() {
		return dmg;
	}

	/**
	 * Sets the dmg.
	 *
	 * @param dmg the new dmg
	 */
	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	/**
	 * Gets the movement.
	 *
	 * @return the movement
	 */
	public int getMovement() {
		return movement;
	}

	/**
	 * Sets the movement.
	 *
	 * @param movement the new movement
	 */
	public void setMovement(int movement) {
		this.movement = movement;
	}

	/**
	 * Gets the location x.
	 *
	 * @return the location x
	 */
	public int getLocationX() {
		return locationX;
	}

	/**
	 * Sets the location x.
	 *
	 * @param locationX the new location x
	 */
	public void setLocationX(int locationX) {
		this.locationX = locationX;
	}

	/**
	 * Gets the location y.
	 *
	 * @return the location y
	 */
	public int getLocationY() {
		return locationY;
	}

	/**
	 * Sets the location y.
	 *
	 * @param locationY the new location y
	 */
	public void setLocationY(int locationY) {
		this.locationY = locationY;
	}

	/**
	 * Gets the at will1.
	 *
	 * @return the at will1
	 */
	public Ability getAtWill1() {
		return atWill1;
	}

	/**
	 * Sets the at will1.
	 *
	 * @param atWill1 the new at will1
	 */
	public void setAtWill1(Ability atWill1) {
		this.atWill1 = atWill1;
	}

	/**
	 * Gets the glad race.
	 *
	 * @return the glad race
	 */
	public GladRace getGladRace() {
		return gladRace;
	}

	/**
	 * Sets the glad race.
	 *
	 * @param gladRace the new glad race
	 */
	public void setGladRace(GladRace gladRace) {
		this.gladRace = gladRace;
	}

	/**
	 * Gets the glad class.
	 *
	 * @return the glad class
	 */
	public GladClass getGladClass() {
		return gladClass;
	}

	/**
	 * Sets the glad class.
	 *
	 * @param gladClass the new glad class
	 */
	public void setGladClass(GladClass gladClass) {
		this.gladClass = gladClass;
	}


	/**
	 * Gets the end move listen.
	 *
	 * @return the end move listen
	 */
	public static MoveListener getMoveListen() {
		return moveListen;
	}

	/**
	 * Sets the move listen.
	 *
	 * @param moveListen the new move listen
	 */
	public static void setMoveListen(MoveListener moveListen) {
		Gladiator.moveListen = moveListen;
	}

    public int getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(int baseHp) {
        this.baseHp = baseHp;
    }

    public int getBaseReflex() {
        return baseReflex;
    }

    public void setBaseReflex(int baseReflex) {
        this.baseReflex = baseReflex;
    }

    public int getBaseStrength() {
        return baseStrength;
    }

    public void setBaseStrength(int baseStrength) {
        this.baseStrength = baseStrength;
    }

    public int getBaseDmg() {
        return baseDmg;
    }

    public void setBaseDmg(int baseDmg) {
        this.baseDmg = baseDmg;
    }


	/**
	 * Take action.
	 *
	 * @param enemyLocX the enemy loc x
	 * @param enemyLocY the enemy loc y
	 * @return the ability
	 */
	public Ability takeAction(int enemyLocX, int enemyLocY) {
		Ability attack = new NoAttack();
		if (this.getGladClass().getPlayStyle() == GladClass.MELEE) {
			if (this.getAtWill1().targetInRange(this.getLocationX(), this.getLocationY(), enemyLocX, enemyLocY)) {
				attack = this.getAtWill1();
			} else {
				this.moveTowardsEnemy(enemyLocX, enemyLocY);
				if (this.getAtWill1().targetInRange(this.getLocationX(),this.getLocationY(), enemyLocX, enemyLocY)) {
					attack = this.getAtWill1();
				}

			}
		} else if (this.getGladClass().getPlayStyle() == GladClass.RANGED) {

		}
		return attack;
	}


	/**
	 * Gets the atk dmg.
	 *
	 * @return the atk dmg
	 */
	public int getAtkDmg() {
		Random rand = new Random();
		return rand.nextInt(this.getDmg() - 1) + 1;
	}


	/**
	 * Move towards enemy.
	 *
	 * @param targetX the target x
	 * @param targetY the target y
	 */
	public void moveTowardsEnemy(int targetX, int targetY) {
		int selfX, selfY;
		
		int moveCount = 0;		
		boolean inRange = false;	
		
		while (!inRange && moveCount < this.getMovement()) {
			selfX = this.getLocationX();
			selfY = this.getLocationY();
			
			// if target is top left
			if (((selfX - 25) <= targetX && selfX > targetX) && ((selfY - 25) <= targetY && selfY > targetY)) {
				selfX -= 1;
				selfY -= 1;
	
			// target is above
			} else if (selfX == targetX	&& ((selfY - 25) <= targetY && selfY > targetY)) {
				selfY -= 1;
	
			// target is top right
			} else if (((selfX + 25) >= targetX && selfX < targetX) && ((selfY - 25) <= targetY && selfY > targetY)) {
				selfX += 1;
				selfY -= 1;
	
			// target is right
			} else if (((selfX + 25) >= targetX && selfX < targetX) && selfY == targetY) {
				selfX += 1;
	
			// target is bottom right
			} else if (((selfX + 25) >= targetX && selfX < targetX) && ((selfY + 25) >= targetY && selfY < targetY)) {
				selfX += 1;
				selfY += 1;
	
			// target is below
			} else if (selfX == targetX && ((selfY + 25) >= targetY && selfY < targetY)) {
				selfY += 1;
	
			// target is bottom left
			} else if (((selfX - 25) <= targetX && selfX > targetX) && ((selfY + 25) >= targetY && selfY < targetY)) {
				selfX -= 1;
				selfY += 1;
	
			// target is left
			} else if (((selfX - 25) <= targetX && selfX > targetX) && selfY == targetY) {
				selfX -= 1;
			}			
			
			this.setLocationX(selfX);
			this.setLocationY(selfY);
			moveCount += 1;			

			
			if (this.getAtWill1().targetInRange(selfX, selfY, targetX, targetY)) {
				inRange = true;
				if (moveListen != null) {
					moveListen.onMove(this, selfX, selfY);
				}
			}			
		}
		
	}


	/**
	 * Dodge attempt.
	 *
	 * @return the int
	 */
	public int dodgeAttempt() {
		Random rand = new Random();
		int dodgeRoll = rand.nextInt(20 - 1) + 1;
		if (this.getGladClass() != null) {
			dodgeRoll += this.getReflex();
		}
		return dodgeRoll;
	}

}
