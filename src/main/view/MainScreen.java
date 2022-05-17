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
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class MainScreen {

	private JFrame frame;
	private GameEnvironment gameEnvironment;
	String monsterName = "Empty Slot";
	private int monsterCount = 0;

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
		frame.setBounds(0, 0,874, 552);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{452, 377, 0};
		gridBagLayout.rowHeights = new int[]{161, 152, 182, 148, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);

		
		JPanel playerPanel = new JPanel();
		playerPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Player", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_playerPanel = new GridBagConstraints();
		gbc_playerPanel.fill = GridBagConstraints.VERTICAL;
		gbc_playerPanel.insets = new Insets(0, 0, 5, 5);
		gbc_playerPanel.gridx = 0;
		gbc_playerPanel.gridy = 1;
		frame.getContentPane().add(playerPanel, gbc_playerPanel);
		playerPanel.setLayout(new GridLayout(0, 3, 5, 5));
		
		JPanel welcomePanel = new JPanel();
		welcomePanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		playerPanel.add(welcomePanel);
		GridBagLayout gbl_welcomePanel = new GridBagLayout();
		gbl_welcomePanel.columnWidths = new int[]{144, 0};
		gbl_welcomePanel.rowHeights = new int[]{134, 0};
		gbl_welcomePanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_welcomePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		welcomePanel.setLayout(gbl_welcomePanel);
		
		JLabel playerNameLabel = new JLabel("Welcome back " + gameEnvironment.getPlayer().getName());
		playerNameLabel.setFont(new Font("Bell MT", Font.PLAIN, 12));
		GridBagConstraints gbc_playerNameLabel = new GridBagConstraints();
		gbc_playerNameLabel.fill = GridBagConstraints.BOTH;
		gbc_playerNameLabel.gridx = 0;
		gbc_playerNameLabel.gridy = 0;
		welcomePanel.add(playerNameLabel, gbc_playerNameLabel);
		playerNameLabel.setBackground(Color.BLACK);
		playerNameLabel.setForeground(Color.BLACK);
		playerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel goldPanel = new JPanel();
		goldPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		playerPanel.add(goldPanel);
		goldPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel playerGoldLabel = new JLabel("Gold: " +(Integer.toString(gameEnvironment.getPlayer().getGold())));
		playerGoldLabel.setFont(new Font("Bell MT", Font.PLAIN, 12));
		goldPanel.add(playerGoldLabel);
		playerGoldLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel dayPanel = new JPanel();
		dayPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		playerPanel.add(dayPanel);
		dayPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel dayProgressPanel = new JLabel("Day: " + (Integer.toString(gameEnvironment.getDay()) + " / " + Integer.toString(gameEnvironment.getTotalDays())));
		dayProgressPanel.setFont(new Font("Bell MT", Font.PLAIN, 12));
		dayPanel.add(dayProgressPanel);
		dayProgressPanel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel battleSelectionPanel = new JPanel();
		battleSelectionPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Battle Selection", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_battleSelectionPanel = new GridBagConstraints();
		gbc_battleSelectionPanel.fill = GridBagConstraints.BOTH;
		gbc_battleSelectionPanel.insets = new Insets(0, 0, 5, 0);
		gbc_battleSelectionPanel.gridx = 1;
		gbc_battleSelectionPanel.gridy = 1;
		frame.getContentPane().add(battleSelectionPanel, gbc_battleSelectionPanel);
		GridBagLayout gbl_battleSelectionPanel = new GridBagLayout();
		gbl_battleSelectionPanel.columnWidths = new int[]{385, 0};
		gbl_battleSelectionPanel.rowHeights = new int[]{153, 0};
		gbl_battleSelectionPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_battleSelectionPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		battleSelectionPanel.setLayout(gbl_battleSelectionPanel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Bell MT", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		battleSelectionPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel monsterPartyPanel = new JPanel();
		monsterPartyPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Party", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_monsterPartyPanel = new GridBagConstraints();
		gbc_monsterPartyPanel.fill = GridBagConstraints.BOTH;
		gbc_monsterPartyPanel.insets = new Insets(0, 0, 5, 5);
		gbc_monsterPartyPanel.gridx = 0;
		gbc_monsterPartyPanel.gridy = 2;
		frame.getContentPane().add(monsterPartyPanel, gbc_monsterPartyPanel);
		monsterPartyPanel.setLayout(new GridLayout(6, 4, 0, 0));
		
		JLabel monsterPartyTitleLabel = new JLabel("Monsters:");
		monsterPartyTitleLabel.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monsterPartyTitleLabel.setBackground(Color.BLUE);
		monsterPartyTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		monsterPartyPanel.add(monsterPartyTitleLabel);
		
		JPanel partyStatsPanel = new JPanel();
		partyStatsPanel.setForeground(Color.BLUE);
		partyStatsPanel.setBackground(Color.LIGHT_GRAY);
		monsterPartyPanel.add(partyStatsPanel);
		partyStatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel monsterPartyHealthLabel = new JLabel("Health:");
		monsterPartyHealthLabel.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monsterPartyHealthLabel.setForeground(new Color(0, 100, 0));
		monsterPartyHealthLabel.setBackground(UIManager.getColor("Button.background"));
		monsterPartyHealthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		partyStatsPanel.add(monsterPartyHealthLabel);
		
		JLabel monsterPartyDamageLabel = new JLabel("Damage:");
		monsterPartyDamageLabel.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monsterPartyDamageLabel.setForeground(new Color(255, 0, 0));
		monsterPartyDamageLabel.setBackground(Color.LIGHT_GRAY);
		monsterPartyDamageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		partyStatsPanel.add(monsterPartyDamageLabel);
		
		JLabel monsterPartyHealLabel = new JLabel("Heal:");
		monsterPartyHealLabel.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monsterPartyHealLabel.setForeground(new Color(255, 215, 0));
		monsterPartyHealLabel.setHorizontalAlignment(SwingConstants.CENTER);
		partyStatsPanel.add(monsterPartyHealLabel);
		
		
		
		JLabel monsterPartyLabel1 = new JLabel(monsterName(monsterCount));
		monsterCount += 1;
		monsterPartyLabel1.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monsterPartyLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		monsterPartyPanel.add(monsterPartyLabel1);
		
		JPanel monster1StatsPanel = new JPanel();
		monster1StatsPanel.setBackground(UIManager.getColor("Button.background"));
		monsterPartyPanel.add(monster1StatsPanel);
		monster1StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel monster1CurrentHealth = new JLabel("New label");
		monster1CurrentHealth.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monster1CurrentHealth.setForeground(new Color(0, 128, 0));
		monster1CurrentHealth.setHorizontalAlignment(SwingConstants.CENTER);
		monster1StatsPanel.add(monster1CurrentHealth);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblNewLabel_1_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		monster1StatsPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblNewLabel_2_1.setForeground(new Color(255, 165, 0));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		monster1StatsPanel.add(lblNewLabel_2_1);
		

		
		JLabel monsterPartyLabel2 = new JLabel(monsterName(monsterCount));
		monsterCount += 1;
		monsterPartyLabel2.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monsterPartyLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		monsterPartyPanel.add(monsterPartyLabel2);
		
		JPanel monster2StatsPanel = new JPanel();
		monsterPartyPanel.add(monster2StatsPanel);
		monster2StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel monster2CurrentHealth = new JLabel("New label");
		monster2CurrentHealth.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monster2CurrentHealth.setForeground(new Color(0, 128, 0));
		monster2CurrentHealth.setHorizontalAlignment(SwingConstants.CENTER);
		monster2StatsPanel.add(monster2CurrentHealth);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblNewLabel_1_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		monster2StatsPanel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("New label");
		lblNewLabel_2_2.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblNewLabel_2_2.setForeground(new Color(255, 165, 0));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		monster2StatsPanel.add(lblNewLabel_2_2);
		
		JLabel monsterPartyLabel3 = new JLabel(monsterName(monsterCount));
		monsterCount += 1;
		monsterPartyLabel3.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monsterPartyLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		monsterPartyPanel.add(monsterPartyLabel3);
		
		JPanel monster3StatsPanel = new JPanel();
		monsterPartyPanel.add(monster3StatsPanel);
		monster3StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel monster3CurrentHealth = new JLabel("New label");
		monster3CurrentHealth.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monster3CurrentHealth.setForeground(new Color(0, 128, 0));
		monster3CurrentHealth.setHorizontalAlignment(SwingConstants.CENTER);
		monster3StatsPanel.add(monster3CurrentHealth);
		
		JLabel lblNewLabel_1_3 = new JLabel("New label");
		lblNewLabel_1_3.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblNewLabel_1_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		monster3StatsPanel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("New label");
		lblNewLabel_2_3.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblNewLabel_2_3.setForeground(new Color(255, 165, 0));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		monster3StatsPanel.add(lblNewLabel_2_3);
		
				
				JLabel monsterPartyLabel4 = new JLabel(monsterName(monsterCount));
				monsterCount += 1;
				monsterPartyLabel4.setFont(new Font("Bell MT", Font.PLAIN, 12));
				monsterPartyLabel4.setHorizontalAlignment(SwingConstants.CENTER);
				monsterPartyPanel.add(monsterPartyLabel4);
				
				JPanel monster4StatsPanel = new JPanel();
				monsterPartyPanel.add(monster4StatsPanel);
				monster4StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
				
				JLabel monster4CurrentHealth = new JLabel("New label");
				monster4CurrentHealth.setFont(new Font("Bell MT", Font.PLAIN, 12));
				monster4CurrentHealth.setForeground(new Color(0, 128, 0));
				monster4CurrentHealth.setHorizontalAlignment(SwingConstants.CENTER);
				monster4StatsPanel.add(monster4CurrentHealth);
				
				JLabel lblNewLabel_1_4 = new JLabel("New label");
				lblNewLabel_1_4.setFont(new Font("Bell MT", Font.PLAIN, 12));
				lblNewLabel_1_4.setForeground(new Color(255, 0, 0));
				lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
				monster4StatsPanel.add(lblNewLabel_1_4);
				
				JLabel lblNewLabel_2_4 = new JLabel("New label");
				lblNewLabel_2_4.setFont(new Font("Bell MT", Font.PLAIN, 12));
				lblNewLabel_2_4.setForeground(new Color(255, 165, 0));
				lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
				monster4StatsPanel.add(lblNewLabel_2_4);
				
				JLabel monsterPartyLabel5 = new JLabel(monsterName(monsterCount));
				monsterCount += 1;
				monsterPartyLabel5.setFont(new Font("Bell MT", Font.PLAIN, 12));
				monsterPartyLabel5.setHorizontalAlignment(SwingConstants.CENTER);
				monsterPartyPanel.add(monsterPartyLabel5);
				
				JPanel monster5StatsPanel = new JPanel();
				monsterPartyPanel.add(monster5StatsPanel);
				monster5StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
				
				JLabel monster5CurrentHealth = new JLabel("New label");
				monster5CurrentHealth.setFont(new Font("Bell MT", Font.PLAIN, 12));
				monster5CurrentHealth.setForeground(new Color(0, 128, 0));
				monster5CurrentHealth.setHorizontalAlignment(SwingConstants.CENTER);
				monster5StatsPanel.add(monster5CurrentHealth);
				
				JLabel lblNewLabel_1_5 = new JLabel("New label");
				lblNewLabel_1_5.setFont(new Font("Bell MT", Font.PLAIN, 12));
				lblNewLabel_1_5.setForeground(new Color(255, 0, 0));
				lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
				monster5StatsPanel.add(lblNewLabel_1_5);
				
				JLabel lblNewLabel_2_5 = new JLabel("New label");
				lblNewLabel_2_5.setFont(new Font("Bell MT", Font.PLAIN, 12));
				lblNewLabel_2_5.setForeground(new Color(255, 165, 0));
				lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
				monster5StatsPanel.add(lblNewLabel_2_5);
		
		JPanel randomEventPanel = new JPanel();
		randomEventPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "?", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_randomEventPanel = new GridBagConstraints();
		gbc_randomEventPanel.fill = GridBagConstraints.BOTH;
		gbc_randomEventPanel.insets = new Insets(0, 0, 5, 0);
		gbc_randomEventPanel.gridx = 1;
		gbc_randomEventPanel.gridy = 2;
		frame.getContentPane().add(randomEventPanel, gbc_randomEventPanel);
		GridBagLayout gbl_randomEventPanel = new GridBagLayout();
		gbl_randomEventPanel.columnWidths = new int[]{353, 0};
		gbl_randomEventPanel.rowHeights = new int[]{143, 0};
		gbl_randomEventPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_randomEventPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		randomEventPanel.setLayout(gbl_randomEventPanel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Bell MT", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		randomEventPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JPanel itemPanel = new JPanel();
		itemPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Inventory", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_itemPanel = new GridBagConstraints();
		gbc_itemPanel.fill = GridBagConstraints.BOTH;
		gbc_itemPanel.insets = new Insets(0, 0, 0, 5);
		gbc_itemPanel.gridx = 0;
		gbc_itemPanel.gridy = 3;
		frame.getContentPane().add(itemPanel, gbc_itemPanel);
		GridBagLayout gbl_itemPanel = new GridBagLayout();
		gbl_itemPanel.columnWidths = new int[]{59, 82, 28, 100, 29, 91, 0};
		gbl_itemPanel.rowHeights = new int[]{15, 39, 44, 8, 0};
		gbl_itemPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_itemPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		itemPanel.setLayout(gbl_itemPanel);
		
		JButton itemButton1 = new JButton("New button");
		itemButton1.setFont(new Font("Bell MT", Font.PLAIN, 12));
		GridBagConstraints gbc_itemButton1 = new GridBagConstraints();
		gbc_itemButton1.fill = GridBagConstraints.BOTH;
		gbc_itemButton1.insets = new Insets(0, 0, 5, 5);
		gbc_itemButton1.gridx = 1;
		gbc_itemButton1.gridy = 1;
		itemPanel.add(itemButton1, gbc_itemButton1);
		
		JButton itemButton2 = new JButton("New button");
		itemButton2.setFont(new Font("Bell MT", Font.PLAIN, 12));
		GridBagConstraints gbc_itemButton2 = new GridBagConstraints();
		gbc_itemButton2.fill = GridBagConstraints.BOTH;
		gbc_itemButton2.insets = new Insets(0, 0, 5, 5);
		gbc_itemButton2.gridx = 3;
		gbc_itemButton2.gridy = 1;
		itemPanel.add(itemButton2, gbc_itemButton2);
		
		JButton itemButton3 = new JButton("New button");
		itemButton3.setFont(new Font("Bell MT", Font.PLAIN, 12));
		GridBagConstraints gbc_itemButton3 = new GridBagConstraints();
		gbc_itemButton3.fill = GridBagConstraints.BOTH;
		gbc_itemButton3.insets = new Insets(0, 0, 5, 0);
		gbc_itemButton3.gridx = 5;
		gbc_itemButton3.gridy = 1;
		itemPanel.add(itemButton3, gbc_itemButton3);
		
		JButton itemButton4 = new JButton("New button");
		itemButton4.setFont(new Font("Bell MT", Font.PLAIN, 12));
		GridBagConstraints gbc_itemButton4 = new GridBagConstraints();
		gbc_itemButton4.fill = GridBagConstraints.BOTH;
		gbc_itemButton4.insets = new Insets(0, 0, 5, 5);
		gbc_itemButton4.gridx = 1;
		gbc_itemButton4.gridy = 2;
		itemPanel.add(itemButton4, gbc_itemButton4);
		
		JButton itemButton5 = new JButton("New button");
		itemButton5.setFont(new Font("Bell MT", Font.PLAIN, 12));
		GridBagConstraints gbc_itemButton5 = new GridBagConstraints();
		gbc_itemButton5.fill = GridBagConstraints.BOTH;
		gbc_itemButton5.insets = new Insets(0, 0, 5, 5);
		gbc_itemButton5.gridx = 3;
		gbc_itemButton5.gridy = 2;
		itemPanel.add(itemButton5, gbc_itemButton5);
		
		JButton itemButton6 = new JButton("New button");
		itemButton6.setFont(new Font("Bell MT", Font.PLAIN, 12));
		GridBagConstraints gbc_itemButton6 = new GridBagConstraints();
		gbc_itemButton6.insets = new Insets(0, 0, 5, 0);
		gbc_itemButton6.fill = GridBagConstraints.BOTH;
		gbc_itemButton6.gridx = 5;
		gbc_itemButton6.gridy = 2;
		itemPanel.add(itemButton6, gbc_itemButton6);
		
		JPanel shopPanel = new JPanel();
		shopPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Shop", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_shopPanel = new GridBagConstraints();
		gbc_shopPanel.fill = GridBagConstraints.BOTH;
		gbc_shopPanel.gridx = 1;
		gbc_shopPanel.gridy = 3;
		frame.getContentPane().add(shopPanel, gbc_shopPanel);
		GridBagLayout gbl_shopPanel = new GridBagLayout();
		gbl_shopPanel.columnWidths = new int[]{274, 104, 0};
		gbl_shopPanel.rowHeights = new int[]{128, 0};
		gbl_shopPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_shopPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		shopPanel.setLayout(gbl_shopPanel);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Welcome to the Shop!<br/>Here you can purchase new Monsters or Items.<br/>Or you can sell Monsters you no longer need.\r\n</html>");
		lblNewLabel_1.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		shopPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton shopBuyButton = new JButton("Open Shop");
		shopBuyButton.setFont(new Font("Bell MT", Font.PLAIN, 12));
		GridBagConstraints gbc_shopBuyButton = new GridBagConstraints();
		gbc_shopBuyButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_shopBuyButton.gridx = 1;
		gbc_shopBuyButton.gridy = 0;
		shopPanel.add(shopBuyButton, gbc_shopBuyButton);
	}

}
