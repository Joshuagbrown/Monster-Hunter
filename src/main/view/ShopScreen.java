package main.view;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.controller.GameEnvironment;
import main.controller.GameRunner;
import main.model.ComfyBed;
import main.model.Dragon;
import main.model.Elf;
import main.model.Gremlin;
import main.model.HealthPotion;
import main.model.Item;
import main.model.Monster;
import main.model.Orc;
import main.model.StrengthPotion;
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

/**
Class ShopScreen that implements all the swing elements of the screen shown when the player is in the Shop
@author Aimee Cloutman
@author Josh Brown
*/
public class ShopScreen {

	private JFrame frmTheShop;
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
		frmTheShop.setBounds(100, 100, 878, 535);
		frmTheShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTheShop.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(String.format("GOLD: %s", gameEnvironment.getPlayer().getGold()));
		lblNewLabel_1.setBounds(417, 6, 111, 16);
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
		lblNewLabel_13.setBounds(502, 6, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_13);
		
		JLabel item1Description = new JLabel(""+new HealthPotion().getDescription());
		item1Description.setBounds(671, 33, 165, 16);
		frmTheShop.getContentPane().add(item1Description);
		
		JLabel item2Description = new JLabel(""+new StrengthPotion().getDescription());
		item2Description.setBounds(671, 60, 165, 16);
		frmTheShop.getContentPane().add(item2Description);
		
		JLabel item3Description = new JLabel(""+new ComfyBed().getDescription());
		item3Description.setBounds(671, 85, 194, 26);
		frmTheShop.getContentPane().add(item3Description);
		
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
		
		JLabel item1Label = new JLabel("Healing Potion");
		item1Label.setBounds(502, 27, 99, 16);
		frmTheShop.getContentPane().add(item1Label);
		
		JLabel item2Label = new JLabel("Damage Potion");
		item2Label.setBounds(502, 58, 99, 16);
		frmTheShop.getContentPane().add(item2Label);
		
		JLabel item3Label = new JLabel("Comfy Bed");
		item3Label.setBounds(502, 88, 99, 16);
		frmTheShop.getContentPane().add(item3Label);
		
		JButton item1BuyButton = new JButton("$"+new HealthPotion().getPurchasePrice());
		item1BuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item i = new HealthPotion();
				if (gameEnvironment.buyItem(i)) {
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
					//TODO - Buy successful
				} else {
					//TODO - Buy failed
				}
			}
		});
		item1BuyButton.setBounds(587, 21, 74, 29);
		frmTheShop.getContentPane().add(item1BuyButton);
		
		JButton item2BuyButton = new JButton("$"+new StrengthPotion().getPurchasePrice());
		item2BuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item i = new StrengthPotion();
				if (gameEnvironment.buyItem(i)) {
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
					//TODO - Buy successful
				} else {
					//TODO - Buy failed
				}
			}
		});
		item2BuyButton.setBounds(587, 52, 74, 29);
		frmTheShop.getContentPane().add(item2BuyButton);
		
		JButton item3BuyButton = new JButton("$"+new ComfyBed().getPurchasePrice());
		item3BuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item i = new ComfyBed();
				if (gameEnvironment.buyItem(i)) {
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
					//TODO - Buy successful
				} else {
					//TODO - Buy failed
				}
			}
		});
		item3BuyButton.setBounds(587, 83, 74, 29);
		frmTheShop.getContentPane().add(item3BuyButton);
		
		JButton btnNewButton_6 = new JButton("Exit");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameRunner.launchMainScreen(gameEnvironment);
				frmTheShop.dispose();
			}
		});
		btnNewButton_6.setBounds(751, 462, 85, 21);
		frmTheShop.getContentPane().add(btnNewButton_6);
		
		JPanel monsterPartyPanel = new JPanel();
		monsterPartyPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Party", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		monsterPartyPanel.setBounds(6, 229, 386, 177);
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
		
		JPanel inventoryPanel = new JPanel();
		inventoryPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Inventory", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		inventoryPanel.setBounds(519, 229, 178, 177);
		frmTheShop.getContentPane().add(inventoryPanel);
		inventoryPanel.setLayout(new GridLayout(7, 1, 0, 0));
		
		JLabel itemLabel = new JLabel("Items:");
		itemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		itemLabel.setFont(new Font("Bell MT", Font.PLAIN, 12));
		itemLabel.setBackground(Color.BLUE);
		inventoryPanel.add(itemLabel);
		
		JLabel lblNewLabel_2 = new JLabel(gameEnvironment.getInventory().getName(0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		inventoryPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_10 = new JLabel(gameEnvironment.getInventory().getName(1));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		inventoryPanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_12 = new JLabel(gameEnvironment.getInventory().getName(2));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		inventoryPanel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_14 = new JLabel(gameEnvironment.getInventory().getName(3));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		inventoryPanel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel(gameEnvironment.getInventory().getName(4));
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		inventoryPanel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel(gameEnvironment.getInventory().getName(5));
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		inventoryPanel.add(lblNewLabel_16);
		if (gameEnvironment.getInventory().getSize() > 0) {
			JButton item1Sell = new JButton(String.format("Sell for $%s", gameEnvironment.getInventory().getItemAtIndex(0).getSellPrice()));
			item1Sell.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gameEnvironment.sellItem(0);
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
				}
			});
			item1Sell.setBounds(700, 267, 120, 21);
			frmTheShop.getContentPane().add(item1Sell);
		}
		if (gameEnvironment.getInventory().getSize() > 1) {	
			JButton item2Sell = new JButton(String.format("Sell for $%s", gameEnvironment.getInventory().getItemAtIndex(1).getSellPrice()));
			item2Sell.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gameEnvironment.sellItem(1);
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
				}
			});
			item2Sell.setBounds(700, 290, 120, 21);
			frmTheShop.getContentPane().add(item2Sell);
		}
		
		if (gameEnvironment.getInventory().getSize() > 2) {
			JButton item3Sell = new JButton(String.format("Sell for $%s", gameEnvironment.getInventory().getItemAtIndex(2).getSellPrice()));
			item3Sell.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gameEnvironment.sellItem(2);
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
				}
			});
			item3Sell.setBounds(700, 311, 120, 21);
			frmTheShop.getContentPane().add(item3Sell);
		}
		
		if (gameEnvironment.getInventory().getSize() > 3) {
			JButton item4Sell = new JButton(String.format("Sell for $%s", gameEnvironment.getInventory().getItemAtIndex(3).getSellPrice()));
			item4Sell.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gameEnvironment.sellItem(3);
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
				}
			});
			item4Sell.setBounds(700, 334, 120, 21);
			frmTheShop.getContentPane().add(item4Sell);
		}
		
		if (gameEnvironment.getInventory().getSize() > 4) {
			JButton item5Sell = new JButton(String.format("Sell for $%s", gameEnvironment.getInventory().getItemAtIndex(4).getSellPrice()));
			item5Sell.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gameEnvironment.sellItem(4);
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
				}
			});
			item5Sell.setBounds(700, 355, 120, 21);
			frmTheShop.getContentPane().add(item5Sell);
		}
		
		if (gameEnvironment.getInventory().getSize() > 5) {
			JButton item6Sell = new JButton(String.format("Sell for $%s", gameEnvironment.getInventory().getItemAtIndex(5).getSellPrice()));
			item6Sell.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gameEnvironment.sellItem(5);
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
				}
			});
			item6Sell.setBounds(700, 378, 120, 21);
			frmTheShop.getContentPane().add(item6Sell);
		}
		
		if (gameEnvironment.getParty().getSize() > 1) {
			JButton sellButton1 = new JButton(String.format("Sell for $%s", gameEnvironment.getParty().getMonsterAtIndex(0).getSellPrice()));
			sellButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gameEnvironment.sellMonster(0);
					frmTheShop.dispose();
					GameRunner.launchShopScreen(gameEnvironment);
				}
			});
			sellButton1.setBounds(392, 265, 120, 21);
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
			sellButton2.setBounds(392, 293, 120, 21);
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
			sellButton3.setBounds(392, 321, 120, 21);
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
			sellButton4.setBounds(392, 349, 120, 21);
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
			sellButton5.setBounds(392, 377, 120, 21);
			frmTheShop.getContentPane().add(sellButton5);
		}
	}
}
