package main.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import main.controller.GameEnvironment;
import main.controller.GameRunner;
import main.model.Dragon;
import main.model.Elf;
import main.model.Gremlin;
import main.model.Monster;
import main.model.Orc;
import main.model.Wizard;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.SystemColor;

public class ShopScreen {

	private JFrame frmTheShop;
	private JTextField textField;
	private GameEnvironment gameEnvironment;
	private JTextField txtEnterMonsterNickname;

	/**
	 * Create the application
	 *
	 */
	public ShopScreen(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		initialize();
		frmTheShop.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTheShop = new JFrame();
		frmTheShop.setTitle("THE SHOP");
		frmTheShop.setBounds(100, 100, 655, 602);
		frmTheShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTheShop.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(String.format("GOLD: %s", gameEnvironment.getPlayer().getGold()));
		lblNewLabel_1.setBounds(450, 33, 111, 16);
		frmTheShop.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Monsters:");
		lblNewLabel_3.setBounds(6, 6, 74, 16);
		frmTheShop.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Buy:");
		lblNewLabel_4.setBounds(150, 6, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_4);
		
		txtEnterMonsterNickname = new JTextField();
		txtEnterMonsterNickname.setForeground(Color.BLACK);
		txtEnterMonsterNickname.setBounds(112, 32, 99, 19);
		frmTheShop.getContentPane().add(txtEnterMonsterNickname);
		txtEnterMonsterNickname.setColumns(10);
		
		JLabel nicknameErrorlbl = new JLabel("");
		nicknameErrorlbl.setFont(new Font("Tahoma", Font.PLAIN, 8));
		nicknameErrorlbl.setForeground(Color.RED);
		nicknameErrorlbl.setBounds(112, 22, 99, 13);
		frmTheShop.getContentPane().add(nicknameErrorlbl);
		
		JLabel lblNewLabel_11 = new JLabel("Max Health, Damage,");
		lblNewLabel_11.setBounds(239, 19, 143, 16);
		frmTheShop.getContentPane().add(lblNewLabel_11);
		
		JLabel gremlinMaxHealth = new JLabel(Integer.toString(new Gremlin().getMaxHealth()));
		gremlinMaxHealth.setBounds(243, 60, 55, 16);
		frmTheShop.getContentPane().add(gremlinMaxHealth);
		
		JLabel elfMaxHealth = new JLabel(Integer.toString(new Elf().getMaxHealth()));
		elfMaxHealth.setBounds(243, 90, 61, 16);
		frmTheShop.getContentPane().add(elfMaxHealth);
		
		JLabel orcMaxHealth = new JLabel(Integer.toString(new Orc().getMaxHealth()));
		orcMaxHealth.setBounds(243, 120, 61, 16);
		frmTheShop.getContentPane().add(orcMaxHealth);
		
		JLabel wizardMaxHealth = new JLabel(Integer.toString(new Wizard().getMaxHealth()));
		wizardMaxHealth.setBounds(243, 149, 61, 16);
		frmTheShop.getContentPane().add(wizardMaxHealth);
		
		JLabel dragonMaxHealth = new JLabel(Integer.toString(new Dragon().getMaxHealth()));
		dragonMaxHealth.setBounds(243, 178, 61, 16);
		frmTheShop.getContentPane().add(dragonMaxHealth);
		
		JLabel lblNewLabel = new JLabel("Heal Amount");
		lblNewLabel.setBounds(341, 19, 99, 16);
		frmTheShop.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_13 = new JLabel("Items:");
		lblNewLabel_13.setBounds(6, 243, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_21 = new JLabel("Heal Amount +20");
		lblNewLabel_21.setBounds(239, 264, 130, 16);
		frmTheShop.getContentPane().add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("Damage +20");
		lblNewLabel_22.setBounds(239, 295, 111, 16);
		frmTheShop.getContentPane().add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("Health = Max Health");
		lblNewLabel_23.setBounds(239, 320, 143, 26);
		frmTheShop.getContentPane().add(lblNewLabel_23);
		
		JButton gremlinBuyButton = new JButton("$"+Integer.toString(new Gremlin().getPurchasePrice()));
		gremlinBuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monster m = new Gremlin();
				String nickname = txtEnterMonsterNickname.getText();
				if (nickname.length() != 0){
					if (nickname.length() < 3 || nickname.length() > 15) {
						nicknameErrorlbl.setText("Name must be 3 to 15 chars");
						return;
					} else {
						m.setName(nickname);
					}
				}

				if (gameEnvironment.buyMonster(m)) {
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
				} else {
					//TODO - Buy failed
				}
			}
		});
		gremlinBuyButton.setBounds(124, 53, 74, 29);
		frmTheShop.getContentPane().add(gremlinBuyButton);
		
		JButton elfBuyButton = new JButton("$"+Integer.toString(new Elf().getPurchasePrice()));
		elfBuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monster m = new Elf();
				String nickname = txtEnterMonsterNickname.getText();
				if (nickname.length() != 0){
					if (nickname.length() < 3 || nickname.length() > 15) {
						nicknameErrorlbl.setText("Name must be 3 to 15 chars");
						return;
					} else {
						m.setName(nickname);
					}
				}
				if (gameEnvironment.buyMonster(m)) {
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
					//TODO - Buy successful
				} else {
					//TODO - Buy failed
				}
			}
		});
		elfBuyButton.setBounds(124, 83, 74, 29);
		frmTheShop.getContentPane().add(elfBuyButton);
		
		JButton orcBuyButton = new JButton("$"+Integer.toString(new Orc().getPurchasePrice()));
		orcBuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monster m = new Orc();
				String nickname = txtEnterMonsterNickname.getText();
				if (nickname.length() != 0){
					if (nickname.length() < 3 || nickname.length() > 15) {
						nicknameErrorlbl.setText("Name must be 3 to 15 chars");
						return;
					} else {
						m.setName(nickname);
					}
				}
				if (gameEnvironment.buyMonster(m)) {
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
					//TODO - Buy successful
				} else {
					//TODO - Buy failed
				}
			}
		});
		orcBuyButton.setBounds(124, 113, 74, 29);
		frmTheShop.getContentPane().add(orcBuyButton);
		
		JButton wizardBuyButton = new JButton("$"+Integer.toString(new Wizard().getPurchasePrice()));
		wizardBuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monster m = new Wizard();
				String nickname = txtEnterMonsterNickname.getText();
				if (nickname.length() != 0){
					if (nickname.length() < 3 || nickname.length() > 15) {
						nicknameErrorlbl.setText("Name must be 3 to 15 chars");
						return;
					} else {
						m.setName(nickname);
					}
				}
				if (gameEnvironment.buyMonster(m)) {
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
					//TODO - Buy successful
				} else {
					//TODO - Buy failed
				}
			}
		});
		wizardBuyButton.setBounds(124, 142, 74, 29);
		frmTheShop.getContentPane().add(wizardBuyButton);
		if (gameEnvironment.getDay() < 3) {
			wizardBuyButton.setEnabled(false);
		}
		
		JButton dragonBuyButton = new JButton("$"+Integer.toString(new Dragon().getPurchasePrice()));
		dragonBuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monster m = new Dragon();
				String nickname = txtEnterMonsterNickname.getText();
				if (nickname.length() != 0){
					if (nickname.length() < 3 || nickname.length() > 15) {
						nicknameErrorlbl.setText("Name must be 3 to 15 chars");
						return;
					} else {
						m.setName(nickname);
					}
				}
				if (gameEnvironment.buyMonster(m)) {
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
					//TODO - Buy successful
				} else {
					//TODO - Buy failed
				}
			}
		});
		dragonBuyButton.setBounds(124, 171, 74, 29);
		frmTheShop.getContentPane().add(dragonBuyButton);
		if (gameEnvironment.getDay() < 5) {
			dragonBuyButton.setEnabled(false);
		}
		
		JLabel lblNewLabel_5 = new JLabel("Gremlin");
		lblNewLabel_5.setBounds(6, 57, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Elf");
		lblNewLabel_6.setBounds(6, 85, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Orc");
		lblNewLabel_7.setBounds(6, 116, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Wizard");
		lblNewLabel_8.setBounds(6, 149, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Dragon");
		lblNewLabel_9.setBounds(6, 178, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_26 = new JLabel("Healing Potion");
		lblNewLabel_26.setBounds(6, 264, 99, 16);
		frmTheShop.getContentPane().add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("Damage Potion");
		lblNewLabel_27.setBounds(6, 295, 99, 16);
		frmTheShop.getContentPane().add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("Medical Kit");
		lblNewLabel_28.setBounds(6, 325, 99, 16);
		frmTheShop.getContentPane().add(lblNewLabel_28);
		
		JButton btnNewButton = new JButton("$200");
		btnNewButton.setBounds(91, 258, 74, 29);
		frmTheShop.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("$300");
		btnNewButton_1.setBounds(91, 289, 74, 29);
		frmTheShop.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("$400");
		btnNewButton_2.setBounds(91, 320, 74, 29);
		frmTheShop.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("$100");
		btnNewButton_3.setBounds(164, 258, 73, 29);
		frmTheShop.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("$200");
		btnNewButton_4.setBounds(164, 289, 73, 29);
		frmTheShop.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("$200");
		btnNewButton_5.setBounds(164, 320, 73, 29);
		frmTheShop.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Exit");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameRunner.launchMainScreen(gameEnvironment);
				frmTheShop.dispose();
			}
		});
		btnNewButton_6.setBounds(546, 411, 85, 21);
		frmTheShop.getContentPane().add(btnNewButton_6);
		
		JLabel lblNewLabel_18_4_1 = new JLabel("New label");
		lblNewLabel_18_4_1.setBounds(416, 291, 81, 26);
		frmTheShop.getContentPane().add(lblNewLabel_18_4_1);
		
		JLabel lblNewLabel_18_2_1 = new JLabel("New label");
		lblNewLabel_18_2_1.setBounds(507, 259, 81, 26);
		frmTheShop.getContentPane().add(lblNewLabel_18_2_1);
		
		JLabel lblNewLabel_18_3_1 = new JLabel("New label");
		lblNewLabel_18_3_1.setBounds(416, 266, 81, 26);
		frmTheShop.getContentPane().add(lblNewLabel_18_3_1);
		
		JLabel lblNewLabel_18_1_1 = new JLabel("New label");
		lblNewLabel_18_1_1.setBounds(507, 238, 81, 26);
		frmTheShop.getContentPane().add(lblNewLabel_18_1_1);
		
		JLabel lblNewLabel_18_5 = new JLabel("New label");
		lblNewLabel_18_5.setBounds(416, 238, 81, 26);
		frmTheShop.getContentPane().add(lblNewLabel_18_5);
		
		JLabel lblNewLabel_18_4_1_1 = new JLabel("New label");
		lblNewLabel_18_4_1_1.setBounds(507, 289, 81, 26);
		frmTheShop.getContentPane().add(lblNewLabel_18_4_1_1);
		
		JPanel monsterPartyPanel = new JPanel();
		monsterPartyPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Party", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		monsterPartyPanel.setBounds(6, 359, 386, 177);
		frmTheShop.getContentPane().add(monsterPartyPanel);
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
		
		JLabel lblNewLabel_5_1 = new JLabel("Monster Nickname:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.ITALIC, 8));
		lblNewLabel_5_1.setBounds(6, 32, 99, 16);
		frmTheShop.getContentPane().add(lblNewLabel_5_1);
		
		JLabel gremlinDamageLabe = new JLabel(Integer.toString(new Gremlin().getDamage()));
		gremlinDamageLabe.setBounds(297, 62, 55, 16);
		frmTheShop.getContentPane().add(gremlinDamageLabe);
		
		JLabel gremlinHealLabel = new JLabel(Integer.toString(new Gremlin().getHealAmount()));
		gremlinHealLabel.setBounds(356, 62, 55, 16);
		frmTheShop.getContentPane().add(gremlinHealLabel);
		
		JLabel elfDamageLabel = new JLabel(Integer.toString(new Elf().getDamage()));
		elfDamageLabel.setBounds(295, 92, 55, 16);
		frmTheShop.getContentPane().add(elfDamageLabel);
		
		JLabel elfHealLabel = new JLabel(Integer.toString(new Elf().getHealAmount()));
		elfHealLabel.setBounds(356, 92, 55, 16);
		frmTheShop.getContentPane().add(elfHealLabel);
		
		JLabel orcDamageLabel = new JLabel(Integer.toString(new Orc().getDamage()));
		orcDamageLabel.setBounds(295, 122, 55, 16);
		frmTheShop.getContentPane().add(orcDamageLabel);
		
		JLabel orcHealLabel = new JLabel(Integer.toString(new Orc().getHealAmount()));
		orcHealLabel.setBounds(356, 122, 55, 16);
		frmTheShop.getContentPane().add(orcHealLabel);
		
		JLabel wizardDamageLabel = new JLabel(Integer.toString(new Wizard().getDamage()));
		wizardDamageLabel.setBounds(295, 151, 55, 16);
		frmTheShop.getContentPane().add(wizardDamageLabel);
		
		JLabel wizardHealLabel = new JLabel(Integer.toString(new Wizard().getHealAmount()));
		wizardHealLabel.setBounds(356, 151, 55, 16);
		frmTheShop.getContentPane().add(wizardHealLabel);
		
		JLabel dragonDamageLabel = new JLabel(Integer.toString(new Dragon().getDamage()));
		dragonDamageLabel.setBounds(295, 180, 55, 16);
		frmTheShop.getContentPane().add(dragonDamageLabel);
		
		JLabel dragonHealLabel = new JLabel(Integer.toString(new Dragon().getHealAmount()));
		dragonHealLabel.setBounds(356, 180, 55, 16);
		frmTheShop.getContentPane().add(dragonHealLabel);
		
		if (gameEnvironment.getParty().getSize() > 1) {
			JButton sellButton1 = new JButton(String.format("Sell for $%s", gameEnvironment.getParty().getMonsterAtIndex(0).getSellPrice()));
			sellButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gameEnvironment.sellMonster(0);
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
				}
			});
			sellButton1.setBounds(392, 400, 120, 21);
			frmTheShop.getContentPane().add(sellButton1);
		}
		
		if (gameEnvironment.getParty().getSize() > 1) { 
			JButton sellButton2 = new JButton(String.format("Sell for $%s", gameEnvironment.getParty().getMonsterAtIndex(1).getSellPrice()));
			sellButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gameEnvironment.sellMonster(1);
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
				}
			});
			sellButton2.setBounds(392, 428, 120, 21);
			frmTheShop.getContentPane().add(sellButton2);
		}
		
		if (gameEnvironment.getParty().getSize() > 2) {
			JButton sellButton3 = new JButton(String.format("Sell for $%s", gameEnvironment.getParty().getMonsterAtIndex(2).getSellPrice()));
			sellButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gameEnvironment.sellMonster(2);
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
				}
			});
			sellButton3.setBounds(392, 456, 120, 21);
			frmTheShop.getContentPane().add(sellButton3);
		}
		
		if (gameEnvironment.getParty().getSize() > 3) {
			JButton sellButton4 = new JButton(String.format("Sell for $%s", gameEnvironment.getParty().getMonsterAtIndex(3).getSellPrice()));
			sellButton4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gameEnvironment.sellMonster(3);
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
				}
			});
			sellButton4.setBounds(392, 484, 120, 21);
			frmTheShop.getContentPane().add(sellButton4);
		}
		
		if (gameEnvironment.getParty().getSize() > 4) {
			JButton sellButton5 = new JButton(String.format("Sell for $%s", gameEnvironment.getParty().getMonsterAtIndex(4).getSellPrice()));
			sellButton5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gameEnvironment.sellMonster(4);
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
				}
			});
			sellButton5.setBounds(392, 510, 120, 21);
			frmTheShop.getContentPane().add(sellButton5);
		}
	}
}
