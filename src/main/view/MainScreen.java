package main.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.controller.GameEnvironment;
import main.controller.GameRunner;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
/**
Class MainScreen that implements all the swing elements of the screen shown when the player is on the Main game screen
@author Josh Brown
*/

public class MainScreen {

	private JFrame frame;
	private GameEnvironment gameEnvironment;
	private int selectedMonster;
	private int selectedItem;

	/**
	 * Create the application.
	 */
	public MainScreen(GameEnvironment gameEnvironment) {
		
		
		
		this.gameEnvironment = gameEnvironment;
		initialize();
		frame.setVisible(true);
		
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
		playerPanel.setLayout(new GridLayout(0, 3, 10, 20));
		
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
		
		JButton nextDayButton = new JButton("Go Next Day");
		if (gameEnvironment.getTotalDays() == gameEnvironment.getDay()) {
			nextDayButton = new JButton("End Game");
		}
		nextDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				if (gameEnvironment.endDay()) {
					GameRunner.launchEndScreen(gameEnvironment);
				} else {
					GameRunner.launchMainScreen(gameEnvironment);
				}
			}
		});
		dayPanel.add(nextDayButton);
		
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
		gbl_battleSelectionPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_battleSelectionPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		battleSelectionPanel.setLayout(gbl_battleSelectionPanel);
		
		JPanel battleButtonPanel = new JPanel();
		battleButtonPanel.setLayout(null);
		GridBagConstraints gbc_battleButtonPanel = new GridBagConstraints();
		gbc_battleButtonPanel.fill = GridBagConstraints.BOTH;
		gbc_battleButtonPanel.gridx = 0;
		gbc_battleButtonPanel.gridy = 0;
		battleSelectionPanel.add(battleButtonPanel, gbc_battleButtonPanel);
		
		JButton battle1Button = new JButton("Easy Fight");
		battle1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.setEasyFightDone(true);
				gameEnvironment.getEnemyMonsters(1);
				GameRunner.launchBattleScreen(gameEnvironment);
				frame.dispose();
			}
		});
		battle1Button.setEnabled(!gameEnvironment.isEasyFightDone());
		battle1Button.setBounds(10, 42, 110, 48);
		battleButtonPanel.add(battle1Button);
		
		JButton battle2Button = new JButton("Normal Fight");
		battle2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.setNormalFightDone(true);
				gameEnvironment.getEnemyMonsters(2);
				GameRunner.launchBattleScreen(gameEnvironment);
				frame.dispose();
			}
		});
		battle2Button.setEnabled(!gameEnvironment.isNormalFightDone());
		battle2Button.setBounds(130, 42, 110, 48);
		battleButtonPanel.add(battle2Button);
		
		JButton battle3Button = new JButton("Hard Fight");
		battle3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.setHardFightDone(true);
				gameEnvironment.getEnemyMonsters(3);
				GameRunner.launchBattleScreen(gameEnvironment);
				frame.dispose();
			}
		});
		battle3Button.setEnabled(!gameEnvironment.isHardFightDone());
		battle3Button.setBounds(250, 42, 110, 48);
		battleButtonPanel.add(battle3Button);
		
		JLabel lblNewLabel = new JLabel("The difficulty of the fight will determine how much gold you will recieve. \r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(10, 100, 375, 38);
		battleButtonPanel.add(lblNewLabel);
		
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
		
		
		
		JLabel monsterPartyLabel1 = new JLabel(gameEnvironment.getParty().getName(0));
		monsterPartyLabel1.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monsterPartyLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		monsterPartyPanel.add(monsterPartyLabel1);
		
		JPanel monster1StatsPanel = new JPanel();
		monster1StatsPanel.setBackground(UIManager.getColor("Button.background"));
		monsterPartyPanel.add(monster1StatsPanel);
		monster1StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel monster1CurrentHealth = new JLabel(gameEnvironment.getParty().getHealth(0));
		monster1CurrentHealth.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monster1CurrentHealth.setForeground(new Color(0, 128, 0));
		monster1CurrentHealth.setHorizontalAlignment(SwingConstants.CENTER);
		monster1StatsPanel.add(monster1CurrentHealth);
		
		JLabel monster1Damage = new JLabel(gameEnvironment.getParty().getDamage(0));
		monster1Damage.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monster1Damage.setForeground(new Color(255, 0, 0));
		monster1Damage.setHorizontalAlignment(SwingConstants.CENTER);
		monster1StatsPanel.add(monster1Damage);
		
		JLabel monster1Heal = new JLabel(gameEnvironment.getParty().getHeal(0));
		monster1Heal.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monster1Heal.setForeground(new Color(255, 165, 0));
		monster1Heal.setHorizontalAlignment(SwingConstants.CENTER);
		monster1StatsPanel.add(monster1Heal);
		
		JLabel monsterPartyLabel2 = new JLabel(gameEnvironment.getParty().getName(1));
		monsterPartyLabel2.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monsterPartyLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		monsterPartyPanel.add(monsterPartyLabel2);
		
		JPanel monster2StatsPanel = new JPanel();
		monsterPartyPanel.add(monster2StatsPanel);
		monster2StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel monster2CurrentHealth = new JLabel(gameEnvironment.getParty().getHealth(1));
		monster2CurrentHealth.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monster2CurrentHealth.setForeground(new Color(0, 128, 0));
		monster2CurrentHealth.setHorizontalAlignment(SwingConstants.CENTER);
		monster2StatsPanel.add(monster2CurrentHealth);
		
		JLabel monster2Damage = new JLabel(gameEnvironment.getParty().getDamage(1));
		monster2Damage.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monster2Damage.setForeground(new Color(255, 0, 0));
		monster2Damage.setHorizontalAlignment(SwingConstants.CENTER);
		monster2StatsPanel.add(monster2Damage);
		
		JLabel monster2Heal = new JLabel(gameEnvironment.getParty().getHeal(1));
		monster2Heal.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monster2Heal.setForeground(new Color(255, 165, 0));
		monster2Heal.setHorizontalAlignment(SwingConstants.CENTER);
		monster2StatsPanel.add(monster2Heal);
	
		JLabel monsterPartyLabel3 = new JLabel(gameEnvironment.getParty().getName(2));
		monsterPartyLabel3.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monsterPartyLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		monsterPartyPanel.add(monsterPartyLabel3);
		
		JPanel monster3StatsPanel = new JPanel();
		monsterPartyPanel.add(monster3StatsPanel);
		monster3StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel monster3CurrentHealth = new JLabel(gameEnvironment.getParty().getHealth(2));
		monster3CurrentHealth.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monster3CurrentHealth.setForeground(new Color(0, 128, 0));
		monster3CurrentHealth.setHorizontalAlignment(SwingConstants.CENTER);
		monster3StatsPanel.add(monster3CurrentHealth);
		
		JLabel monster3Damage = new JLabel(gameEnvironment.getParty().getDamage(2));
		monster3Damage.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monster3Damage.setForeground(new Color(255, 0, 0));
		monster3Damage.setHorizontalAlignment(SwingConstants.CENTER);
		monster3StatsPanel.add(monster3Damage);
		
		JLabel monster3Heal = new JLabel(gameEnvironment.getParty().getHeal(2));
		monster3Heal.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monster3Heal.setForeground(new Color(255, 165, 0));
		monster3Heal.setHorizontalAlignment(SwingConstants.CENTER);
		monster3StatsPanel.add(monster3Heal);
		
				
		JLabel monsterPartyLabel4 = new JLabel(gameEnvironment.getParty().getName(3));
		monsterPartyLabel4.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monsterPartyLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		monsterPartyPanel.add(monsterPartyLabel4);
		
		JPanel monster4StatsPanel = new JPanel();
		monsterPartyPanel.add(monster4StatsPanel);
		monster4StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel monster4CurrentHealth = new JLabel(gameEnvironment.getParty().getHealth(3));
		monster4CurrentHealth.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monster4CurrentHealth.setForeground(new Color(0, 128, 0));
		monster4CurrentHealth.setHorizontalAlignment(SwingConstants.CENTER);
		monster4StatsPanel.add(monster4CurrentHealth);
		
		JLabel monster4Damage = new JLabel(gameEnvironment.getParty().getDamage(3));
		monster4Damage.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monster4Damage.setForeground(new Color(255, 0, 0));
		monster4Damage.setHorizontalAlignment(SwingConstants.CENTER);
		monster4StatsPanel.add(monster4Damage);
		
		JLabel monster4Heal = new JLabel(gameEnvironment.getParty().getHeal(3));
		monster4Heal.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monster4Heal.setForeground(new Color(255, 165, 0));
		monster4Heal.setHorizontalAlignment(SwingConstants.CENTER);
		monster4StatsPanel.add(monster4Heal);
		
		JLabel monsterPartyLabel5 = new JLabel(gameEnvironment.getParty().getName(4));
		monsterPartyLabel5.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monsterPartyLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		monsterPartyPanel.add(monsterPartyLabel5);
		
		JPanel monster5StatsPanel = new JPanel();
		monsterPartyPanel.add(monster5StatsPanel);
		monster5StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel monster5CurrentHealth = new JLabel(gameEnvironment.getParty().getHealth(4));
		monster5CurrentHealth.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monster5CurrentHealth.setForeground(new Color(0, 128, 0));
		monster5CurrentHealth.setHorizontalAlignment(SwingConstants.CENTER);
		monster5StatsPanel.add(monster5CurrentHealth);
		
		JLabel monster5Damage = new JLabel(gameEnvironment.getParty().getDamage(4));
		monster5Damage.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monster5Damage.setForeground(new Color(255, 0, 0));
		monster5Damage.setHorizontalAlignment(SwingConstants.CENTER);
		monster5StatsPanel.add(monster5Damage);
		
		JLabel monster5Heal = new JLabel(gameEnvironment.getParty().getHeal(4));
		monster5Heal.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monster5Heal.setForeground(new Color(255, 165, 0));
		monster5Heal.setHorizontalAlignment(SwingConstants.CENTER);
		monster5StatsPanel.add(monster5Heal);
		
		String randomTitle = "?";
		Color randomTitleColor = new Color(255, 255, 255);
		if (!gameEnvironment.getRandomEventDesc().equals("")) {
			randomTitle = "RANDOM EVENT!";
			randomTitleColor = new Color(255, 0, 0);
		}
		JPanel randomEventPanel = new JPanel();
		randomEventPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, randomTitleColor, new Color(160, 160, 160)), randomTitle, TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		randomEventPanel.setLayout(null);
		GridBagConstraints gbc_randomEventPanel = new GridBagConstraints();
		gbc_randomEventPanel.fill = GridBagConstraints.BOTH;
		gbc_randomEventPanel.insets = new Insets(0, 0, 5, 0);
		gbc_randomEventPanel.gridx = 1;
		gbc_randomEventPanel.gridy = 2;
		frame.getContentPane().add(randomEventPanel, gbc_randomEventPanel);
		
		JLabel randomEventLabel = new JLabel(gameEnvironment.getRandomEventDesc());
		randomEventLabel.setHorizontalAlignment(SwingConstants.CENTER);
		randomEventLabel.setBounds(25, 25, 350, 38);
		randomEventPanel.add(randomEventLabel);
		
		JPanel itemPanel = new JPanel();
		itemPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Inventory", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		itemPanel.setLayout(null);
		GridBagConstraints gbc_itemPanel = new GridBagConstraints();
		gbc_itemPanel.fill = GridBagConstraints.BOTH;
		gbc_itemPanel.insets = new Insets(0, 0, 0, 5);
		gbc_itemPanel.gridx = 0;
		gbc_itemPanel.gridy = 3;
		frame.getContentPane().add(itemPanel, gbc_itemPanel);
		
		
		String[] monsterArray = new String[gameEnvironment.getParty().getSize()];
		for(int i = 0; i < monsterArray.length; i++) {
		    monsterArray[i] = gameEnvironment.getParty().getName(i);
		}
		
		String[] itemArray = new String[gameEnvironment.getInventory().getSize()];
		for(int i = 0; i < itemArray.length; i++) {
		    itemArray[i] = gameEnvironment.getInventory().getName(i);
		}
		
		JComboBox monsterSelectorForItem = new JComboBox(monsterArray);
		monsterSelectorForItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedMonster = monsterSelectorForItem.getSelectedIndex();
			}
			
		});
		monsterSelectorForItem.setModel(new DefaultComboBoxModel(monsterArray));
		monsterSelectorForItem.setMaximumRowCount(5);
		monsterSelectorForItem.setBounds(10, 30, 104, 28);
		itemPanel.add(monsterSelectorForItem);
		
		JComboBox itemSelector = new JComboBox(itemArray);
		itemSelector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedItem = itemSelector.getSelectedIndex();
			}
		});
		itemSelector.setModel(new DefaultComboBoxModel(itemArray));
		itemSelector.setMaximumRowCount(5);
		itemSelector.setBounds(136, 30, 104, 28);
		itemPanel.add(itemSelector);
		
		if (gameEnvironment.getInventory().getSize() > 0) {
			JButton useItem = new JButton("Use Item");
			useItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gameEnvironment.useItem(itemSelector.getSelectedIndex(), monsterSelectorForItem.getSelectedIndex());
					frame.dispose();
					GameRunner.launchMainScreen(gameEnvironment);
				}
			});
			
			useItem.setBounds(296, 30, 91, 28);
			useItem.setFont(new Font("Bell MT", Font.PLAIN, 12));
			itemPanel.add(useItem);			
		}
		
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
		shopBuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameRunner.launchShopScreen(gameEnvironment);
				frame.dispose();
			}
		});
		shopBuyButton.setFont(new Font("Bell MT", Font.PLAIN, 12));
		GridBagConstraints gbc_shopBuyButton = new GridBagConstraints();
		gbc_shopBuyButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_shopBuyButton.gridx = 1;
		gbc_shopBuyButton.gridy = 0;
		shopPanel.add(shopBuyButton, gbc_shopBuyButton);
	}
}
