package com.seanBeckstead.Midterm;

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
 * The Class GladPane.
 */
public class GladPane extends JPanel {
	
	/** The lbl glad name_2. */
	private JLabel lblGladiator_1, lblGladiator_2, lblGladName_1, lblGladName_2;
	
	/** The btn add_2. */
	private JButton btnFight, btnAdd_1, btnAdd_2;
	
	/** The frame. */
	private MainWindow frame;
	

	/**
	 * Instantiates a new glad pane.
	 *
	 * @param f the f
	 */
	public GladPane(MainWindow f) {	
		frame = f;
		this.setBounds(0, 0, 450, 300);
		this.setLayout(null);
		
		lblGladiator_1 = new JLabel("Gladiator 1");
		lblGladiator_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGladiator_1.setBounds(28, 11, 73, 14);
		this.add(lblGladiator_1);
		
		lblGladName_1 = new JLabel(frame.getGladiator1().getName());
		lblGladName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGladName_1.setBounds(28, 36, 73, 14);
		add(lblGladName_1);
		
		lblGladiator_2 = new JLabel("Gladiator 2");
		lblGladiator_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblGladiator_2.setBounds(304, 11, 73, 14);
		this.add(lblGladiator_2);	
		
		lblGladName_2 = new JLabel(frame.getGladiator2().getName());
		lblGladName_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblGladName_2.setBounds(304, 36, 73, 14);
		add(lblGladName_2);
		
		btnFight = new JButton("Fight");
		btnFight.addActionListener(new Navigation());
		btnFight.setBounds(175, 227, 89, 23);
		this.add(btnFight);
		
		btnAdd_1 = new JButton("Add");
		btnAdd_1.addActionListener(new Navigation());
		btnAdd_1.setBounds(28, 63, 73, 23);
		this.add(btnAdd_1);
		
		btnAdd_2 = new JButton("Add");
		btnAdd_2.addActionListener(new Navigation());
		btnAdd_2.setBounds(304, 63, 73, 23);
		this.add(btnAdd_2);		
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
			Object source = event.getSource();
			
			if (source == btnAdd_1) {
				frame.changePanels(new CreationPane(frame, 1));
			} else if (source == btnAdd_2) {
				frame.changePanels(new CreationPane(frame, 2));				
			} else if (source == btnFight) {
				frame.changePanels(new FightPane(frame));					
			}
		}
	}
}
