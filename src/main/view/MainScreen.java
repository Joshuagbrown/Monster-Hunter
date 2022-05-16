package main.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.controller.GameEnvironment;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import java.awt.Font;

public class MainScreen {

	private JFrame frame;
	private GameEnvironment gameEnvironment;
	private int monsterCount = 0;
	String monsterName = "Empty Slot";


	/**
	 * Create the application.
	 */
	public MainScreen(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		initialize();
		frame.setVisible(true);
	}
	
	public String monsterName(int monsterCount) {
		int partySize = gameEnvironment.getParty().size();
		if (monsterCount < partySize) {
			monsterName = gameEnvironment.getParty().get(monsterCount).getName();
			monsterCount = monsterCount + 1;
		} else {
			monsterName = "Empty Slot";
		}
		return monsterName;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 879, 676);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{463, 432, 0};
		gridBagLayout.rowHeights = new int[]{105, 159, 159, 159, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel playerPanel = new JPanel();
		playerPanel.setBorder(new TitledBorder(null, "Player", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_playerPanel = new GridBagConstraints();
		gbc_playerPanel.anchor = GridBagConstraints.EAST;
		gbc_playerPanel.insets = new Insets(0, 0, 5, 5);
		gbc_playerPanel.gridx = 0;
		gbc_playerPanel.gridy = 0;
		frame.getContentPane().add(playerPanel, gbc_playerPanel);
		GridBagLayout gbl_playerPanel = new GridBagLayout();
		gbl_playerPanel.columnWidths = new int[]{142, 142, 143, 0};
		gbl_playerPanel.rowHeights = new int[]{121, 0};
		gbl_playerPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_playerPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		playerPanel.setLayout(gbl_playerPanel);
		
		JLabel playerNameLabel = new JLabel("Welcome back " + gameEnvironment.getPlayer().getName());
		playerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_playerNameLabel = new GridBagConstraints();
		gbc_playerNameLabel.fill = GridBagConstraints.BOTH;
		gbc_playerNameLabel.insets = new Insets(0, 0, 0, 5);
		gbc_playerNameLabel.gridx = 0;
		gbc_playerNameLabel.gridy = 0;
		playerPanel.add(playerNameLabel, gbc_playerNameLabel);
		
		JLabel playerGoldLabel = new JLabel("Gold: " +(Integer.toString(gameEnvironment.getPlayer().getGold())));
		playerGoldLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_playerGoldLabel = new GridBagConstraints();
		gbc_playerGoldLabel.fill = GridBagConstraints.BOTH;
		gbc_playerGoldLabel.insets = new Insets(0, 0, 0, 5);
		gbc_playerGoldLabel.gridx = 1;
		gbc_playerGoldLabel.gridy = 0;
		playerPanel.add(playerGoldLabel, gbc_playerGoldLabel);
		
		JLabel dayProgressPanel = new JLabel("Day: " + (Integer.toString(gameEnvironment.getDay()) + " / " + Integer.toString(gameEnvironment.getTotalDays())));
		dayProgressPanel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_dayProgressPanel = new GridBagConstraints();
		gbc_dayProgressPanel.gridx = 2;
		gbc_dayProgressPanel.gridy = 0;
		playerPanel.add(dayProgressPanel, gbc_dayProgressPanel);
		
		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel monsterPartyPanel = new JPanel();
		monsterPartyPanel.setBorder(new TitledBorder(null, "Party", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_monsterPartyPanel = new GridBagConstraints();
		gbc_monsterPartyPanel.fill = GridBagConstraints.BOTH;
		gbc_monsterPartyPanel.insets = new Insets(0, 0, 5, 5);
		gbc_monsterPartyPanel.gridx = 0;
		gbc_monsterPartyPanel.gridy = 1;
		frame.getContentPane().add(monsterPartyPanel, gbc_monsterPartyPanel);
		monsterPartyPanel.setLayout(new GridLayout(6, 4, 0, 0));
		
		JLabel monsterPartyTitleLabel = new JLabel("Monsters:");
		monsterPartyTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		monsterPartyTitleLabel.setBackground(Color.BLUE);
		monsterPartyTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		monsterPartyPanel.add(monsterPartyTitleLabel);
		
		JPanel partyStatsPanel = new JPanel();
		partyStatsPanel.setForeground(Color.BLUE);
		partyStatsPanel.setBackground(Color.LIGHT_GRAY);
		monsterPartyPanel.add(partyStatsPanel);
		partyStatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel monsterPartyHealthLabel = new JLabel("Health:");
		monsterPartyHealthLabel.setForeground(new Color(0, 100, 0));
		monsterPartyHealthLabel.setBackground(UIManager.getColor("Button.background"));
		monsterPartyHealthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		partyStatsPanel.add(monsterPartyHealthLabel);
		
		JLabel monsterPartyDamageLabel = new JLabel("Damage:");
		monsterPartyDamageLabel.setForeground(new Color(255, 0, 0));
		monsterPartyDamageLabel.setBackground(Color.LIGHT_GRAY);
		monsterPartyDamageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		partyStatsPanel.add(monsterPartyDamageLabel);
		
		JLabel monsterPartyHealLabel = new JLabel("Heal:");
		monsterPartyHealLabel.setForeground(new Color(255, 215, 0));
		monsterPartyHealLabel.setHorizontalAlignment(SwingConstants.CENTER);
		partyStatsPanel.add(monsterPartyHealLabel);
		
		
		
		JLabel monsterPartyLabel1 = new JLabel(monsterName(monsterCount));
		monsterCount += 1;
		monsterPartyPanel.add(monsterPartyLabel1);
		
		JPanel monster1StatsPanel = new JPanel();
		monster1StatsPanel.setBackground(UIManager.getColor("Button.background"));
		monsterPartyPanel.add(monster1StatsPanel);
		monster1StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel monster1CurrentHealth = new JLabel("New label");
		monster1StatsPanel.add(monster1CurrentHealth);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		monster1StatsPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		monster1StatsPanel.add(lblNewLabel_2_1);
		

		
		JLabel monsterPartyLabel2 = new JLabel(monsterName(monsterCount));
		monsterCount += 1;
		monsterPartyPanel.add(monsterPartyLabel2);
		
		JPanel monster2StatsPanel = new JPanel();
		monsterPartyPanel.add(monster2StatsPanel);
		monster2StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel monster2CurrentHealth = new JLabel("New label");
		monster2StatsPanel.add(monster2CurrentHealth);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		monster2StatsPanel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("New label");
		monster2StatsPanel.add(lblNewLabel_2_2);
		
		JLabel monsterPartyLabel3 = new JLabel(monsterName);
		monsterPartyPanel.add(monsterPartyLabel3);
		
		JPanel monster3StatsPanel = new JPanel();
		monsterPartyPanel.add(monster3StatsPanel);
		monster3StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel monster3CurrentHealth = new JLabel("New label");
		monster3StatsPanel.add(monster3CurrentHealth);
		
		JLabel lblNewLabel_1_3 = new JLabel("New label");
		monster3StatsPanel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("New label");
		monster3StatsPanel.add(lblNewLabel_2_3);

		
		JLabel monsterPartyLabel4 = new JLabel(monsterName(monsterCount));
		monsterCount += 1;
		monsterPartyPanel.add(monsterPartyLabel4);
		
		JPanel monster4StatsPanel = new JPanel();
		monsterPartyPanel.add(monster4StatsPanel);
		monster4StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel monster4CurrentHealth = new JLabel("New label");
		monster4StatsPanel.add(monster4CurrentHealth);
		
		JLabel lblNewLabel_1_4 = new JLabel("New label");
		monster4StatsPanel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_2_4 = new JLabel("New label");
		monster4StatsPanel.add(lblNewLabel_2_4);
		
		JLabel monsterPartyLabel5 = new JLabel(monsterName(monsterCount));
		monsterCount += 1;
		monsterPartyPanel.add(monsterPartyLabel5);
		
		JPanel monster5StatsPanel = new JPanel();
		monsterPartyPanel.add(monster5StatsPanel);
		monster5StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel monster5CurrentHealth = new JLabel("New label");
		monster5StatsPanel.add(monster5CurrentHealth);
		
		JLabel lblNewLabel_1_5 = new JLabel("New label");
		monster5StatsPanel.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_2_5 = new JLabel("New label");
		monster5StatsPanel.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 1;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 2;
		frame.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 2;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 3;
		frame.getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
	}

}
