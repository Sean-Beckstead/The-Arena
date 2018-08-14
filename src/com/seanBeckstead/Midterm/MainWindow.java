
package com.seanBeckstead.Midterm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * @author Sean Beckstead
 *
 */


/**
 * The Class MainWindow.
 */
public class MainWindow extends JFrame {
	
	/** The gladiator1. */
	private Gladiator gladiator1 = new Gladiator();
	
	/** The gladiator2. */
	private Gladiator gladiator2 = new Gladiator();
	
	/** The cur pane. */
	private static JPanel curPane;
	

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
					frame.setContentPane(curPane = new HomePane(frame));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Instantiates a new main window.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 450, 300);					
	}
	
	

	/**
	 * Gets the gladiator1.
	 *
	 * @return the gladiator1
	 */
	public Gladiator getGladiator1() {
		return gladiator1;
	}
	
	/**
	 * Sets the gladiator1.
	 *
	 * @param gladiator1 the new gladiator1
	 */
	public void setGladiator1(Gladiator gladiator1) {
		this.gladiator1 = gladiator1;
	}
	
	/**
	 * Gets the gladiator2.
	 *
	 * @return the gladiator2
	 */
	public Gladiator getGladiator2() {
		return gladiator2;
	}

	/**
	 * Sets the gladiator2.
	 *
	 * @param gladiator2 the new gladiator2
	 */
	public void setGladiator2(Gladiator gladiator2) {
		this.gladiator2 = gladiator2;
	}
	

	/**
	 * Change panels.
     * method which changes the active panel
	 *
	 * @param nextPane the next pane
	 */
	public void changePanels(JPanel nextPane) {
		curPane = nextPane;
		setContentPane(curPane);		
	}
}
