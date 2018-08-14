
package com.seanBeckstead.Midterm.GladRaces;
/**
 * @author Sean Beckstead
 *
 */
/*
 *   Below is the list of premade races that Gladiators can be.
 *   Each race gives a total bonus of .60 that can be divide up among stats.
 *   The bonus gets factored into the Gladiators (baseStat + (baseStat * raceBonus)).
 */


import com.seanBeckstead.Midterm.GladRace;

/**
 * The Class GladRaceDummy.
 */
public class GladRaceDummy extends GladRace {
		
		/**
		 * Instantiates a new glad race dummy.
		 */
		public GladRaceDummy() {
			this.setRaceName("Dummy");
			this.setHpBonus(0);
			this.setReflexBonus(0);		
			this.setStrengthBonus(0);
			this.setDmgBonus(0);		
		}

	}