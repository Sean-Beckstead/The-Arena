package com.seanBeckstead.Midterm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
/**
 * @author Sean Beckstead
 *
 */

/**
 * The Class FightPane.
 */
public class FightPane extends JPanel {
	
	/** The btn run fight. */
	private JButton btnBack, btnRunFight;
	
	/** The txt pane results. */
	private JTextPane txtPaneResults;
	
	/** The lbl fight count. */
	private JLabel lblGlad1, lblGlad2, lblFightCount;
	
	/** The glad1 wins. */
	private int glad1Wins = 0;
	
	/** The glad2 wins. */
	private int	glad2Wins = 0;
	
	/** The run count. */
	private JSpinner runCount;
	
	/** The victor. */
	private String fightResults, victor;
	
	/** The arena. */
	private Arena arena;
	
	/** The frame. */
	private MainWindow frame;
	
	/** The scroll pane. */
	private JScrollPane scrollPane;
	

	/**
	 * Instantiates a new fight pane.
	 *
	 * @param f the f
	 */
	public FightPane(MainWindow f) {
		frame = f;		

		this.setBounds(0, 0, 450, 300);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(323, 224, 71, 25);
		btnBack.addActionListener(new Navigation());
		setLayout(null);
		add(btnBack);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(12, 80, 410, 131);
		add(scrollPane);
		
		txtPaneResults = new JTextPane();
		scrollPane.setViewportView(txtPaneResults);
		
		btnRunFight = new JButton("Run Fight(s)");
		btnRunFight.setBounds(208, 224, 103, 25);
		btnRunFight.addActionListener(new Fight());
		add(btnRunFight);
		
		JLabel lblWinCount = new JLabel("Win Count");
		lblWinCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinCount.setBounds(12, 13, 426, 16);
		add(lblWinCount);
		
		lblGlad1 = new JLabel(frame.getGladiator1().getName());
		lblGlad1.setBounds(12, 42, 198, 16);
		add(lblGlad1);
		
		lblGlad2 = new JLabel(frame.getGladiator2().getName());
		lblGlad2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGlad2.setBounds(222, 42, 200, 16);
		add(lblGlad2);
		
		lblFightCount = new JLabel("Fight Count: 0");
		lblFightCount.setBounds(12, 224, 126, 16);
		add(lblFightCount);
		
		runCount = new JSpinner();
		runCount.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
		runCount.setBounds(138, 224, 58, 24);
		add(runCount);
	}
	
	

	/**
	 * The Class Fight.
     * ActionListener which will be added to btnRunFight
	 */
	public class Fight implements ActionListener {
		
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent event) {

            /**
             * Check if Gladiator 1 has been created
             */
			if (frame.getGladiator1().getName() != "") {

                /**
                 * Check if Gladiator 2 has been created                   *
                 */
				if (frame.getGladiator2().getName() != "") {

                    /**
                     * We run the fight as many times as the spinner runCount has selected
                     */
					for (int i = 1; i <= Integer.parseInt(runCount.getValue().toString()); i++ ) {

                        /**
                         * we build a new Arena with the gladiators every time so the fighters reset their health
                         */
						arena = new Arena(frame.getGladiator1(), frame.getGladiator2());
						fightResults = arena.startFight();

                        /**
                         * This split is used to filter out the victors name and add to their win count
                         */
						if (fightResults.split("\n")[fightResults.split("\n").length - 1].equalsIgnoreCase(frame.getGladiator1().getName())){
							glad1Wins += 1;
						} else {
							glad2Wins += 1;
						}

                        /**
                         * after the victor has been decided it updates the labels and textPane to show the results
                         */
						lblGlad1.setText(frame.getGladiator1().getName() + " :   " + glad1Wins);
						lblGlad2.setText(glad2Wins + "   : " + frame.getGladiator2().getName());
						lblFightCount.setText("Total Fights: " + (glad1Wins + glad2Wins));						
						txtPaneResults.setText(txtPaneResults.getText() + "\n" + fightResults);
					}

                    /**
                     * If Gladiator 2 has not been created it tells you
                     */
				} else {
					txtPaneResults.setText("Missing gladiator 2");					
				}

                /**
                 * If Gladiator 1 has not been created it tells you
                 */
			} else {
				txtPaneResults.setText("Missing gladiator 1");
			}
		}

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
