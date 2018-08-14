package com.seanBeckstead.Midterm;
/**
 * @author Sean Beckstead
 *
 */

/**
 * The Class Arena.
 */
public class Arena implements MoveListener {
	
	/** The fighter1. */
	private Gladiator fighter1;
	
	/** The fighter2. */
	private Gladiator fighter2;
	
	/** The round. */
	private int round;
	
	/** The turn. */
	private int turn;
	
	/** The arena name. */
	private String arenaName;
	
	/** The fight results. */
	private String fightResults;
	

	/**
	 * Instantiates a new arena.
	 *
	 * @param g1 the g1
	 * @param g2 the g2
	 */
	public Arena(Gladiator g1, Gladiator g2) {
		setFighter1(g1);
		setFighter2(g2);
		setArenaName("Arena");		
	}


	/**
	 * Gets the fighter1.
	 *
	 * @return the fighter1
	 */
	public Gladiator getFighter1() {
		return fighter1;
	}

	/**
	 * Sets the fighter1.
	 *
	 * @param fighter1 the new fighter1
	 */
	public void setFighter1(Gladiator fighter1) {
		this.fighter1 = new Gladiator(fighter1);
	}

	/**
	 * Gets the fighter2.
	 *
	 * @return the fighter2
	 */
	public Gladiator getFighter2() {
		return fighter2;
	}

	/**
	 * Sets the fighter2.
	 *
	 * @param fighter2 the new fighter2
	 */
	public void setFighter2(Gladiator fighter2) {
		this.fighter2 = new Gladiator(fighter2);
	}

	/**
	 * Gets the arena name.
	 *
	 * @return the arena name
	 */
	public String getArenaName() {
		return arenaName;
	}

	/**
	 * Sets the arena name.
	 *
	 * @param arenaName the new arena name
	 */
	public void setArenaName(String arenaName) {
		this.arenaName = arenaName;
	}
	
	/**
	 * Gets the round.
	 *
	 * @return the round
	 */
	public int getRound() {
		return round;
	}

	/**
	 * Sets the round.
	 *
	 * @param round the new round
	 */
	public void setRound(int round) {
		this.round = round;
	}

	/**
	 * Gets the turn.
	 *
	 * @return the turn
	 */
	public int getTurn() {
		return turn;
	}

	/**
	 * Sets the turn.
	 *
	 * @param turn the new turn
	 */
	public void setTurn(int turn) {
		this.turn = turn;
	}

	/**
	 * Gets the fight results.
	 *
	 * @return the fight results
	 */
	public String getFightResults() {
		return fightResults;
	}

	/**
	 * Sets the fight results.
	 *
	 * @param fightResults the new fight results
	 */
	public void setFightResults(String fightResults) {
		this.fightResults = fightResults;
	}


	/**
	 * Start fight.
     * method is used to simulate the fight between the two gladiators and output the fight results turn by turn
	 *
	 * @return the string
	 */
	public String startFight() {

        /**
         * first we need to make sure we have two named gladiators
         * which also tells us we have user created gladiators
         */
		if (this.getFighter1() != null && this.getFighter2() != null) {

            /**
             * initializing variables
             */
			round = 1;
			turn = 1;			
			int damage, attackRoll;
			Ability attack;
			
			Gladiator.setMoveListen(this);

            /**
             * set fighters in starting locations
             */
			this.getFighter1().setLocationX(1);
			this.getFighter1().setLocationY(1);
			this.getFighter2().setLocationX(1);
			this.getFighter2().setLocationY(5);

            /**
             * Starts the loop of the fight until a fighter has died
             */
			while (this.getFighter1().getHp() > 0 && this.getFighter2().getHp() > 0) {

                /**
                 * resetting value
                 */
				damage = 0;

                /**
                 * First we figure out who's turn it is in the round and then they can make their attack
                 */
				if (turn == 1) {
					
					attack = this.getFighter1().takeAction(this.getFighter2().getLocationX(), this.getFighter2().getLocationY());
					attackRoll = attack.makeAttack();

                    /**
                     * The attack roll has to beat both AC and their dodge attempt
                     * meaning they penetrate their armor and they hit the fighter
                     */
					if (attack.getName().equalsIgnoreCase("MISS") == false && attackRoll >= this.getFighter2().getAc() && attackRoll >= this.getFighter2().dodgeAttempt()) {

                        /**
                         * hit result
                         */
						damage =  this.getFighter1().getAtkDmg();
						this.getFighter2().setHp(this.getFighter2().getHp() - damage);
						this.setFightResults(this.getFightResults() + "\n" + this.getFighter1().getName() + " lands a hit for " + damage);
						
					} else {

                        /**
                         * miss result
                         */
						this.setFightResults(this.getFightResults() + "\n" + this.getFighter1().getName() + " misses");
						
					}

                    /**
                     * change turns
                     */
					turn = 2;
					
				} else {
					
					attack = this.getFighter2().takeAction(this.getFighter1().getLocationX(), this.getFighter1().getLocationY());
					attackRoll = attack.makeAttack();

                    /**
                     * The attack roll has to beat both AC and their dodge attempt
                     * meaning they penetrate their armor and they hit the fighter
                     */
					if (attackRoll >= this.getFighter1().getAc() && attackRoll >= this.getFighter1().dodgeAttempt()) {

                        /**
                         * hit result
                         */
						damage =  this.getFighter2().getAtkDmg();
						this.getFighter1().setHp(this.getFighter1().getHp() - damage);
                        this.setFightResults(this.getFightResults() + "\n" + this.getFighter2().getName() + " lands a hit for " + damage);
						
					} else {

                        /**
                         * miss result
                         */
                        this.setFightResults(this.getFightResults() + "\n" + this.getFighter2().getName() + " misses");
						
					}

                    /**
                     * change turns and end round
                     */
					turn = 1;
					round ++;
					
				}
			}

            /**
             * Once a fighter has died we must then determine the victor and return the entire fight
             */
			if (this.getFighter1().getHp() <= 0) {

                /**
                 * Gladiator 2 wins
                 */
                this.setFightResults(this.getFightResults() + "\n" +  "Victor in " + round + " rounds is...." + "\n" + this.getFighter2().getName());
                return this.getFightResults();
				
			} else {

                /**
                 * Gladiator 1 wins
                 */
                this.setFightResults(this.getFightResults() + "\n" + "Victor in " + round + " rounds is...." + "\n" + this.getFighter1().getName());
                return this.getFightResults();
				
			}

            /**
             * In case one of our fighters was not named which means it wasn't created, we cannot start the fight
             */
		} else {
			
			return "Fighters are not ready!";
			
		}
	}


	/* (non-Javadoc)
	 * @see com.seanBeckstead.Midterm.MoveListener#onMoveEnded(com.seanBeckstead.Midterm.Gladiator, int, int)
	 */
	@Override
	public void onMove(Gladiator g, int x, int y) {
		this.setFightResults(this.getFightResults() + "\n" + g.getName() + " moved to (" + x + "," + y + ")");
		
	}
	
}
