package com.seanBeckstead.Midterm;
/**
 * @author Sean Beckstead
 *
 */
/**
 * The listener interface for receiving move events.
 * The class that is interested in processing a move
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addMoveListener<code> method. When
 * the move event occurs, that object's appropriate
 * method is invoked.
 *
 * @see MoveEvent
 */
public interface MoveListener {
	
	/**
	 * On move
	 *
	 * @param g the g
	 * @param x the x
	 * @param y the y
	 */
	public void onMove(Gladiator g, int x, int y);

}
