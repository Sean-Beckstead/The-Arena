package com.seanBeckstead.Midterm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.seanBeckstead.Midterm.GladClasses.GladClassFighter;
import com.seanBeckstead.Midterm.GladClasses.GladClassRogue;
import com.seanBeckstead.Midterm.GladRaces.GladRaceDwarf;
import com.seanBeckstead.Midterm.GladRaces.GladRaceElf;
import com.seanBeckstead.Midterm.GladRaces.GladRaceHuman;
import com.seanBeckstead.Midterm.GladRaces.GladRaceOrc;
/**
 * @author Sean Beckstead
 *
 */

/**
 * The Class CreationPane.
 */
public class CreationPane extends JPanel {
	
	/** The c box race. */
	private JComboBox<String[]> cBoxClass, cBoxRace;
	
	/** The txt dmg. */
	private JTextField txtName, txtHp, txtAc, txtStr, txtRef, txtDmg;	
	
	/** The lbl ref. */
	private JLabel lblName, lblDmg, lblHp, lblAc, lblStr, lblRef;
	
	/** The btn create. */
	private JButton btnBack, btnCreate;
	
	/** The g race. */
	private GladRace gRace;
	
	/** The g class. */
	private GladClass gClass;
	
	/** The glad. */
	private Gladiator glad;
	
	/** The gladiator num. */
	private int gladiatorNum;
	
	/** The frame. */
	private static MainWindow frame;

	/**
	 * Instantiates a new creation pane.
	 *
	 * @param f the f
	 * @param gladNum the glad num
	 */
	public CreationPane(MainWindow f, int gladNum) {
		frame = f;
		gladiatorNum = gladNum;

        /**
         * gladNum is used to tell which gladiator we are making/editing
         */
		if	(gladNum == 1) {
			glad = frame.getGladiator1();
		} else {
			glad = frame.getGladiator2();			
		}

		this.setBounds(0, 0, 450, 300);
		this.setLayout(null);
		txtName = new JTextField(glad.getName());
		txtName.setBounds(48, 11, 86, 20);
		this.add(txtName);
		txtName.setColumns(10);		
		lblName = new JLabel("Name:");
		lblName.setBounds(10, 14, 46, 14);
		this.add(lblName);	
		
		cBoxClass = new JComboBox<String[]>();
		if (glad.getGladClass().getClassName() != "Dummy") {
			cBoxClass.setModel(new DefaultComboBoxModel(new String[] {glad.getGladClass().getClassName(), "Rogue", "Fighter"}));
		} else {
			cBoxClass.setModel(new DefaultComboBoxModel(new String[] {"Select Class", "Rogue", "Fighter"}));
		}
		cBoxClass.setBounds(40, 42, 94, 22);
		this.add(cBoxClass);
		
		cBoxRace = new JComboBox<String[]>();
		if (glad.getGladRace().getRaceName() != "Dummy") {
			cBoxRace.setModel(new DefaultComboBoxModel(new String[] {glad.getGladRace().getRaceName(), "Elf", "Human", "Orc", "Dwarf"}));
		} else {
			cBoxRace.setModel(new DefaultComboBoxModel(new String[] {"Select Class", "Elf", "Human", "Orc", "Dwarf"}));
		}
		cBoxRace.setBounds(135, 42, 94, 22);
		this.add(cBoxRace);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new Navigation());
		btnBack.setBounds(323, 217, 97, 25);
		this.add(btnBack);
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new Navigation());
		btnCreate.setBounds(220, 217, 97, 25);
		this.add(btnCreate);
		
		txtHp = new JTextField(glad.getBaseHp() + "");
		txtHp.setBounds(88, 75, 46, 20);
		this.add(txtHp);
		txtHp.setColumns(10);
		
		txtAc = new JTextField(glad.getAc() + "");
		txtAc.setColumns(10);
		txtAc.setBounds(88, 106, 46, 20);
		this.add(txtAc);
		
		txtStr = new JTextField(glad.getBaseStrength() + "");
		txtStr.setColumns(10);
		txtStr.setBounds(88, 137, 46, 20);
		this.add(txtStr);
		
		txtRef = new JTextField(glad.getBaseReflex() + "");
		txtRef.setColumns(10);
		txtRef.setBounds(88, 168, 46, 20);
		this.add(txtRef);
		
		lblHp = new JLabel("HP");
		lblHp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHp.setBounds(40, 78, 46, 14);
		this.add(lblHp);
		
		lblAc = new JLabel("AC");
		lblAc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAc.setBounds(40, 109, 46, 14);
		this.add(lblAc);
		
		lblStr = new JLabel("Str");
		lblStr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStr.setBounds(40, 140, 46, 14);
		this.add(lblStr);
		
		lblRef = new JLabel("Ref");
		lblRef.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRef.setBounds(40, 171, 46, 14);
		this.add(lblRef);
		
		txtDmg = new JTextField(glad.getBaseDmg() + "");
		txtDmg.setColumns(10);
		txtDmg.setBounds(88, 199, 46, 20);
		this.add(txtDmg);
		
		lblDmg = new JLabel("Dmg");
		lblDmg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDmg.setBounds(40, 202, 46, 14);
		this.add(lblDmg);
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
			boolean createChk = true;
			
			if (source == btnBack) {
				frame.changePanels(new GladPane(frame));
			} else if (source == btnCreate) {				
				
				if (cBoxClass.getSelectedItem() == "Rogue") {
					gClass = new GladClassRogue();
				}else if (cBoxClass.getSelectedItem() == "Fighter"){
					gClass = new GladClassFighter();
				} else {
					JOptionPane.showMessageDialog(null, "Please select a class!", "Gladiator Creation:" , JOptionPane.INFORMATION_MESSAGE);
					createChk = false;
				}	
				
				if (cBoxRace.getSelectedItem() == "Elf") {
					gRace = new GladRaceElf();
				}else if (cBoxRace.getSelectedItem() == "Human") {
					gRace = new GladRaceHuman();
				} else if (cBoxRace.getSelectedItem() == "Orc") {
                    gRace = new GladRaceOrc();
                } else if (cBoxRace.getSelectedItem() == "Dwarf") {
                    gRace = new GladRaceDwarf();
                } else {
					JOptionPane.showMessageDialog(null, "Please select a race!", "Gladiator Creation:" , JOptionPane.INFORMATION_MESSAGE);
					createChk = false;
				}
				if (createChk == true) {
					if (gladiatorNum == 1) {
						frame.setGladiator1(new Gladiator(txtName.getText(), (int)Double.parseDouble(txtAc.getText()), (int)Double.parseDouble(txtHp.getText()), (int)Double.parseDouble(txtRef.getText()), (int)Double.parseDouble(txtStr.getText()), (int)Double.parseDouble(txtDmg.getText()), 5, gClass, gRace));
						
					} else {

						frame.setGladiator2(new Gladiator(txtName.getText(), (int)Double.parseDouble(txtAc.getText()), (int)Double.parseDouble(txtHp.getText()), (int)Double.parseDouble(txtRef.getText()), (int)Double.parseDouble(txtStr.getText()), (int)Double.parseDouble(txtDmg.getText()), 5, gClass, gRace));
					}
					frame.changePanels(new GladPane(frame));	
				}
			}
		}
	}
}
