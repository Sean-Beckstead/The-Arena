package com.seanBeckstead.Midterm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 * @author Sean Beckstead
 *
 */

/**
 * The Class HomePane.
 */
public class HomePane extends JPanel {

	/** The frame. */
	private static MainWindow frame;


	/**
	 * Instantiates a new home pane.
	 *
	 * @param f the f
	 */
	public HomePane(MainWindow f) {
		frame = f;
		this.setBounds(0, 0, 450, 300);
		this.setLayout(null);
		
		JButton btnStart = new JButton("START");
		btnStart.setBounds(137, 106, 156, 37);
		this.add(btnStart);
		btnStart.addActionListener(new Navigation());
		btnStart.setBackground(new Color(255, 255, 255));
		btnStart.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(137, 60, 156, 18);
		this.add(lblWelcome);
		lblWelcome.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblToTheArena = new JLabel("to the Arena");
		lblToTheArena.setBounds(137, 77, 156, 18);
		this.add(lblToTheArena);
		lblToTheArena.setHorizontalAlignment(SwingConstants.CENTER);
		lblToTheArena.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		
		JLabel lblCreator = new JLabel("By Sean Beckstead");
		lblCreator.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreator.setBounds(137, 156, 156, 16);
		add(lblCreator);
	}



	/**
	 * The Class Navigation.
     * Navigation ActionListener used to tell the MainWindow frame
     * where to navigate to next when this panel is done
	 */
	public class Navigation implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
				frame.changePanels(new GladPane(frame));
		}
	}
}

