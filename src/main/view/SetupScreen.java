package main.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.controller.GameEnvironment;
import main.controller.GameRunner;
import main.model.Monster;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

/**
Class SetupScreen that implements all the swing elements of the screen shown when the player is setting up the game
@author Josh Brown
*/
public class SetupScreen {
	
	private ArrayList<Monster> startingMonsterList;
	private ArrayList<String> startingListNames = new ArrayList<String>();
	Monster startingMonster;

	private JFrame frame;
	private JPanel panel;
	private JLabel nameLabel;
	private JTextField nameInput;
	private JButton startButton;
	private GameEnvironment gameEnvironment;
	private JPanel panel_1;
	private JLabel daysLabel;
	private JSlider daySlider;
	private JPanel panel_2;
	private JLabel monsterLabel;
	private JComboBox<String> startingMonsterSelector;
	private JPanel panel_3;
	private JLabel difficultyLabel;
	private JComboBox<String> difficultySelector;
	private JLabel nameErrorLabel;
	private JPanel panel_4;
	private JLabel startingMonsterName;
	private JTextField startingMonsterNameInput;
	private JLabel nameErrorLabel_1;
	private JPanel panel_5;
	private JLabel healAmountLabel;
	private JLabel maxHealthLabel;
	private JLabel damageValue;
	private JLabel maxHealthValue;
	private JLabel damageLabel;
	private JLabel healAmountValue;
	private JPanel panel_6;
	private JLabel lblNewLabel;

	/**
	 * Create the application.
	 */
	public SetupScreen(GameEnvironment gameEnvironment, ArrayList<Monster> startingList) {
		this.gameEnvironment = gameEnvironment;
		this.startingMonsterList = startingList;
		for (Monster m : startingMonsterList) {
			this.startingListNames.add(m.getName());
		}
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 884, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(6, 3, 1, 1));
		
		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		nameLabel = new JLabel("Name: ");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(nameLabel);
		
		nameInput = new JTextField();
		panel.add(nameInput);
		
		nameErrorLabel = new JLabel("");
		nameErrorLabel.setForeground(new Color(255, 0, 0));
		panel.add(nameErrorLabel);
		
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		daysLabel = new JLabel("Days:");
		daysLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(daysLabel);
		
		daySlider = new JSlider();
		daySlider.setMajorTickSpacing(1);
		daySlider.setValue(5);
		daySlider.setPaintLabels(true);
		daySlider.setSnapToTicks(true);
		daySlider.setPaintTicks(true);
		daySlider.setMaximum(15);
		daySlider.setMinimum(5);
		panel_1.add(daySlider);
		
		panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		monsterLabel = new JLabel("Starting Monster:");
		monsterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(monsterLabel);
		
		startingMonsterSelector = new JComboBox<String>();
		startingMonsterSelector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startingMonster = startingMonsterList.get(startingMonsterSelector.getSelectedIndex());
				startingMonsterNameInput.setText(startingMonsterSelector.getSelectedItem().toString());
				maxHealthValue.setText(Integer.toString(startingMonster.getMaxHealth()));
				damageValue.setText(Integer.toString(startingMonster.getDamage()));
				healAmountValue.setText(Integer.toString(startingMonster.getHealAmount()));
			}
		});
		startingMonsterSelector.setModel(new DefaultComboBoxModel<String>(startingListNames.toArray(new String[0])));
		panel_2.add(startingMonsterSelector);
		startingMonster = startingMonsterList.get(startingMonsterSelector.getSelectedIndex());
		panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(3, 2, 0, 0));
		
		maxHealthLabel = new JLabel("Max Health:");
		panel_5.add(maxHealthLabel);
		
		maxHealthValue = new JLabel(Integer.toString(startingMonster.getMaxHealth()));
		panel_5.add(maxHealthValue);
		
		damageLabel = new JLabel("Damage:");
		panel_5.add(damageLabel);
		
		damageValue = new JLabel(Integer.toString(startingMonster.getDamage()));
		panel_5.add(damageValue);
		
		healAmountLabel = new JLabel("Heal Amount:");
		panel_5.add(healAmountLabel);
		
		healAmountValue = new JLabel(Integer.toString(startingMonster.getHealAmount()));
		panel_5.add(healAmountValue);
		
		panel_4 = new JPanel();
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(0, 3, 0, 0));
		
		startingMonsterName = new JLabel("Monster Name:");
		startingMonsterName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(startingMonsterName);
		
		startingMonsterNameInput = new JTextField();
		startingMonsterNameInput.setText(startingMonsterSelector.getSelectedItem().toString());
		panel_4.add(startingMonsterNameInput);
		
		nameErrorLabel_1 = new JLabel("");
		nameErrorLabel_1.setForeground(Color.RED);
		panel_4.add(nameErrorLabel_1);
		
		panel_3 = new JPanel();
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));
		
		difficultyLabel = new JLabel("Difficulty:");
		difficultyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(difficultyLabel);
		
		difficultySelector = new JComboBox<String>();
		difficultySelector.setModel(new DefaultComboBoxModel<String>(new String[] {"Easy", "Medium", "Hard"}));
		panel_3.add(difficultySelector);
		
		panel_6 = new JPanel();
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNewLabel = new JLabel("Start Game?");
		panel_6.add(lblNewLabel);
		
		
		startButton = new JButton("Submit");
		panel_6.add(startButton);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valid = true;
				if (!startingMonster.setName(startingMonsterNameInput.getText())) {
					nameErrorLabel_1.setText("Monster name is not between 3 and 15 characters");
					valid = false;
				} else {
					nameErrorLabel_1.setText("");
				}
				if (!gameEnvironment.setupGame(nameInput.getText(), daySlider.getValue(), startingMonster, difficultySelector.getSelectedIndex() + 1)) {
					nameErrorLabel.setText("Name is not between 3 and 15 characters");
					valid = false;
				} else {
					nameErrorLabel.setText("");
				}
				if (valid) {
					frame.dispose();
					GameRunner.launchMainScreen(gameEnvironment);
				}
								
			}
		});
	}

}
