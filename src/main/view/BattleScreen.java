package main.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import main.controller.GameEnvironment;
import main.controller.GameRunner;
import main.model.Monster;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BattleScreen {

	private JFrame frmBattle;

	private GameEnvironment gameEnvironment;
	/**
	 * Create the application.
	 */
	public BattleScreen(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		initialize();
		frmBattle.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBattle = new JFrame();
		frmBattle.setTitle("Battle");
		frmBattle.setBounds(100, 100, 1117, 369);
		frmBattle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBattle.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("The Fight");
		lblNewLabel_8.setBounds(531, 26, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("VS");
		lblNewLabel_9.setBounds(551, 74, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Current Health:");
		lblNewLabel_10.setBounds(426, 127, 123, 16);
		frmBattle.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Current Health:");
		lblNewLabel_11.setBounds(607, 127, 130, 16);
		frmBattle.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_18 = new JLabel(Integer.toString(gameEnvironment.getParty().getMonsterAtIndex(gameEnvironment.getParty().getCurrentFighterIndex()).getCurrentHealth()));
		lblNewLabel_18.setBounds(426, 148, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel(Integer.toString(gameEnvironment.getEnemyParty().getMonsterAtIndex(gameEnvironment.getEnemyParty().getCurrentFighterIndex()).getCurrentHealth()));
		lblNewLabel_19.setBounds(607, 148, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("My Monster");
		lblNewLabel_20.setBounds(426, 74, 88, 16);
		frmBattle.getContentPane().add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("Their monster");
		lblNewLabel_21.setBounds(607, 74, 88, 16);
		frmBattle.getContentPane().add(lblNewLabel_21);
		
		JButton btnNewButton_6 = new JButton("FIGHT");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!gameEnvironment.fight()) {
					frmBattle.dispose();
					GameRunner.launchBattleScreen(gameEnvironment);
				} else {
					frmBattle.dispose();
					GameRunner.launchMainScreen(gameEnvironment);
				}
				
			}
		});
		btnNewButton_6.setBounds(485, 242, 117, 29);
		frmBattle.getContentPane().add(btnNewButton_6);
		
		JLabel lblNewLabel_22 = new JLabel("Damage:");
		lblNewLabel_22.setBounds(426, 180, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel(Integer.toString(gameEnvironment.getParty().getMonsterAtIndex(gameEnvironment.getParty().getCurrentFighterIndex()).getDamage()));
		lblNewLabel_23.setBounds(426, 216, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("Damage:");
		lblNewLabel_24.setBounds(607, 180, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel(Integer.toString(gameEnvironment.getEnemyParty().getMonsterAtIndex(gameEnvironment.getEnemyParty().getCurrentFighterIndex()).getDamage()));
		lblNewLabel_25.setBounds(607, 216, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_25);
		
		

		
		JPanel monsterPartyPanel = new JPanel();
		monsterPartyPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Party", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		monsterPartyPanel.setBounds(10, 10, 364, 177);
		frmBattle.getContentPane().add(monsterPartyPanel);
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
		
		JPanel enemyMonsterPartyPanel = new JPanel();
		enemyMonsterPartyPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Enemy Party", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		enemyMonsterPartyPanel.setBounds(735, 10, 364, 177);
		frmBattle.getContentPane().add(enemyMonsterPartyPanel);
		enemyMonsterPartyPanel.setLayout(new GridLayout(6, 4, 0, 0));
		
		JLabel enemyMonsterPartyTitleLabel = new JLabel("Monsters:");
		enemyMonsterPartyTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonsterPartyTitleLabel.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonsterPartyTitleLabel.setBackground(Color.BLUE);
		enemyMonsterPartyPanel.add(enemyMonsterPartyTitleLabel);
		
		JPanel enemyPartyStatsPanel = new JPanel();
		enemyPartyStatsPanel.setForeground(Color.BLUE);
		enemyPartyStatsPanel.setBackground(Color.LIGHT_GRAY);
		enemyMonsterPartyPanel.add(enemyPartyStatsPanel);
		enemyPartyStatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel enemyMonsterHealthLabel1 = new JLabel("Health:");
		enemyMonsterHealthLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonsterHealthLabel1.setForeground(new Color(0, 100, 0));
		enemyMonsterHealthLabel1.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonsterHealthLabel1.setBackground(SystemColor.menu);
		enemyPartyStatsPanel.add(enemyMonsterHealthLabel1);
		
		JLabel monsterPartyDamageLabel_1 = new JLabel("Damage:");
		monsterPartyDamageLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		monsterPartyDamageLabel_1.setForeground(Color.RED);
		monsterPartyDamageLabel_1.setFont(new Font("Bell MT", Font.PLAIN, 12));
		monsterPartyDamageLabel_1.setBackground(Color.LIGHT_GRAY);
		enemyPartyStatsPanel.add(monsterPartyDamageLabel_1);
		
		JLabel monsterPartyHealLabel_1 = new JLabel("Heal:");
		monsterPartyHealLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		monsterPartyHealLabel_1.setForeground(new Color(255, 215, 0));
		monsterPartyHealLabel_1.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyPartyStatsPanel.add(monsterPartyHealLabel_1);
		
		JLabel enemyMonsterPartyLabel1 = new JLabel(gameEnvironment.getEnemyParty().getName(0));
		enemyMonsterPartyLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonsterPartyLabel1.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonsterPartyPanel.add(enemyMonsterPartyLabel1);
		
		JPanel enemyMonster1StatsPanel = new JPanel();
		enemyMonster1StatsPanel.setBackground(SystemColor.menu);
		enemyMonsterPartyPanel.add(enemyMonster1StatsPanel);
		enemyMonster1StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel enemyMonster1CurrentHealth = new JLabel(gameEnvironment.getEnemyParty().getHealth(0));
		enemyMonster1CurrentHealth.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonster1CurrentHealth.setForeground(new Color(0, 128, 0));
		enemyMonster1CurrentHealth.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonster1StatsPanel.add(enemyMonster1CurrentHealth);
		
		JLabel enemyMonster1Damage = new JLabel(gameEnvironment.getEnemyParty().getDamage(0));
		enemyMonster1Damage.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonster1Damage.setForeground(Color.RED);
		enemyMonster1Damage.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonster1StatsPanel.add(enemyMonster1Damage);
		
		JLabel enemyMonster1Heal = new JLabel(gameEnvironment.getEnemyParty().getHeal(0));
		enemyMonster1Heal.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonster1Heal.setForeground(new Color(255, 165, 0));
		enemyMonster1Heal.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonster1StatsPanel.add(enemyMonster1Heal);
		
		JLabel enemyMonsterPartyLabel2 = new JLabel(gameEnvironment.getEnemyParty().getName(1));
		enemyMonsterPartyLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonsterPartyLabel2.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonsterPartyPanel.add(enemyMonsterPartyLabel2);
		
		JPanel enemyMonster2StatsPanel = new JPanel();
		enemyMonsterPartyPanel.add(enemyMonster2StatsPanel);
		enemyMonster2StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel enemyMonster2CurrentHealth = new JLabel(gameEnvironment.getEnemyParty().getHealth(1));
		enemyMonster2CurrentHealth.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonster2CurrentHealth.setForeground(new Color(0, 128, 0));
		enemyMonster2CurrentHealth.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonster2StatsPanel.add(enemyMonster2CurrentHealth);
		
		JLabel enemyMonster2Damage = new JLabel(gameEnvironment.getEnemyParty().getDamage(1));
		enemyMonster2Damage.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonster2Damage.setForeground(Color.RED);
		enemyMonster2Damage.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonster2StatsPanel.add(enemyMonster2Damage);
		
		JLabel enemyMonster2Heal = new JLabel(gameEnvironment.getEnemyParty().getHeal(1));
		enemyMonster2Heal.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonster2Heal.setForeground(new Color(255, 165, 0));
		enemyMonster2Heal.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonster2StatsPanel.add(enemyMonster2Heal);
		
		JLabel enemyMonsterPartyLabel3 = new JLabel(gameEnvironment.getEnemyParty().getName(2));
		enemyMonsterPartyLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonsterPartyLabel3.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonsterPartyPanel.add(enemyMonsterPartyLabel3);
		
		JPanel enemyMonster3StatsPanel = new JPanel();
		enemyMonsterPartyPanel.add(enemyMonster3StatsPanel);
		enemyMonster3StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel enemyMonster3CurrentHealth = new JLabel(gameEnvironment.getEnemyParty().getHealth(2));
		enemyMonster3CurrentHealth.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonster3CurrentHealth.setForeground(new Color(0, 128, 0));
		enemyMonster3CurrentHealth.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonster3StatsPanel.add(enemyMonster3CurrentHealth);
		
		JLabel enemyMonster3Damage = new JLabel(gameEnvironment.getEnemyParty().getDamage(2));
		enemyMonster3Damage.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonster3Damage.setForeground(Color.RED);
		enemyMonster3Damage.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonster3StatsPanel.add(enemyMonster3Damage);
		
		JLabel enemyMonster3Heal = new JLabel(gameEnvironment.getEnemyParty().getHeal(2));
		enemyMonster3Heal.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonster3Heal.setForeground(new Color(255, 165, 0));
		enemyMonster3Heal.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonster3StatsPanel.add(enemyMonster3Heal);
		
		JLabel enemyMonsterPartyLabel4 = new JLabel(gameEnvironment.getEnemyParty().getName(3));
		enemyMonsterPartyLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonsterPartyLabel4.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonsterPartyPanel.add(enemyMonsterPartyLabel4);
		
		JPanel enemyMonster4StatsPanel = new JPanel();
		enemyMonsterPartyPanel.add(enemyMonster4StatsPanel);
		enemyMonster4StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel enemyMonster4CurrentHealth = new JLabel(gameEnvironment.getEnemyParty().getHealth(3));
		enemyMonster4CurrentHealth.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonster4CurrentHealth.setForeground(new Color(0, 128, 0));
		enemyMonster4CurrentHealth.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonster4StatsPanel.add(enemyMonster4CurrentHealth);
		
		JLabel enemyMonster4Damage = new JLabel(gameEnvironment.getEnemyParty().getDamage(3));
		enemyMonster4Damage.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonster4Damage.setForeground(Color.RED);
		enemyMonster4Damage.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonster4StatsPanel.add(enemyMonster4Damage);
		
		JLabel enemyMonster4Heal = new JLabel(gameEnvironment.getEnemyParty().getHeal(3));
		enemyMonster4Heal.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonster4Heal.setForeground(new Color(255, 165, 0));
		enemyMonster4Heal.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonster4StatsPanel.add(enemyMonster4Heal);
		
		JLabel enemyMonsterPartyLabel5 = new JLabel(gameEnvironment.getEnemyParty().getName(4));
		enemyMonsterPartyLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonsterPartyLabel5.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonsterPartyPanel.add(enemyMonsterPartyLabel5);
		
		JPanel enemyMonster5StatsPanel = new JPanel();
		enemyMonsterPartyPanel.add(enemyMonster5StatsPanel);
		enemyMonster5StatsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel enemyMonster5CurrentHealth = new JLabel(gameEnvironment.getEnemyParty().getHealth(4));
		enemyMonster5CurrentHealth.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonster5CurrentHealth.setForeground(new Color(0, 128, 0));
		enemyMonster5CurrentHealth.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonster5StatsPanel.add(enemyMonster5CurrentHealth);
		
		JLabel enemyMonster5Damage = new JLabel(gameEnvironment.getEnemyParty().getDamage(4));
		enemyMonster5Damage.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonster5Damage.setForeground(Color.RED);
		enemyMonster5Damage.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonster5StatsPanel.add(enemyMonster5Damage);
		
		JLabel enemyMonster5Heal = new JLabel(gameEnvironment.getEnemyParty().getHeal(4));
		enemyMonster5Heal.setHorizontalAlignment(SwingConstants.CENTER);
		enemyMonster5Heal.setForeground(new Color(255, 165, 0));
		enemyMonster5Heal.setFont(new Font("Bell MT", Font.PLAIN, 12));
		enemyMonster5StatsPanel.add(enemyMonster5Heal);
		
		JPanel itemPanel = new JPanel();
		itemPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Inventory", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		itemPanel.setBounds(10, 197, 364, 118);
		frmBattle.getContentPane().add(itemPanel);
		GridBagLayout gbl_itemPanel = new GridBagLayout();
		gbl_itemPanel.columnWidths = new int[]{82, 28, 100, 29, 91, 0};
		gbl_itemPanel.rowHeights = new int[]{15, 39, 44, 8, 0};
		gbl_itemPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_itemPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		itemPanel.setLayout(gbl_itemPanel);
		
		JButton itemButton1 = new JButton("New button");
		itemButton1.setFont(new Font("Bell MT", Font.PLAIN, 12));
		GridBagConstraints gbc_itemButton1 = new GridBagConstraints();
		gbc_itemButton1.fill = GridBagConstraints.BOTH;
		gbc_itemButton1.insets = new Insets(0, 0, 5, 5);
		gbc_itemButton1.gridx = 0;
		gbc_itemButton1.gridy = 1;
		itemPanel.add(itemButton1, gbc_itemButton1);
		
		JButton itemButton2 = new JButton("New button");
		itemButton2.setFont(new Font("Bell MT", Font.PLAIN, 12));
		GridBagConstraints gbc_itemButton2 = new GridBagConstraints();
		gbc_itemButton2.fill = GridBagConstraints.BOTH;
		gbc_itemButton2.insets = new Insets(0, 0, 5, 5);
		gbc_itemButton2.gridx = 2;
		gbc_itemButton2.gridy = 1;
		itemPanel.add(itemButton2, gbc_itemButton2);
		
		JButton itemButton3 = new JButton("New button");
		itemButton3.setFont(new Font("Bell MT", Font.PLAIN, 12));
		GridBagConstraints gbc_itemButton3 = new GridBagConstraints();
		gbc_itemButton3.fill = GridBagConstraints.BOTH;
		gbc_itemButton3.insets = new Insets(0, 0, 5, 0);
		gbc_itemButton3.gridx = 4;
		gbc_itemButton3.gridy = 1;
		itemPanel.add(itemButton3, gbc_itemButton3);
		
		JButton itemButton4 = new JButton("New button");
		itemButton4.setFont(new Font("Bell MT", Font.PLAIN, 12));
		GridBagConstraints gbc_itemButton4 = new GridBagConstraints();
		gbc_itemButton4.fill = GridBagConstraints.BOTH;
		gbc_itemButton4.insets = new Insets(0, 0, 5, 5);
		gbc_itemButton4.gridx = 0;
		gbc_itemButton4.gridy = 2;
		itemPanel.add(itemButton4, gbc_itemButton4);
		
		JButton itemButton5 = new JButton("New button");
		itemButton5.setFont(new Font("Bell MT", Font.PLAIN, 12));
		GridBagConstraints gbc_itemButton5 = new GridBagConstraints();
		gbc_itemButton5.fill = GridBagConstraints.BOTH;
		gbc_itemButton5.insets = new Insets(0, 0, 5, 5);
		gbc_itemButton5.gridx = 2;
		gbc_itemButton5.gridy = 2;
		itemPanel.add(itemButton5, gbc_itemButton5);
		
		JButton itemButton6 = new JButton("New button");
		itemButton6.setFont(new Font("Bell MT", Font.PLAIN, 12));
		GridBagConstraints gbc_itemButton6 = new GridBagConstraints();
		gbc_itemButton6.fill = GridBagConstraints.BOTH;
		gbc_itemButton6.insets = new Insets(0, 0, 5, 0);
		gbc_itemButton6.gridx = 4;
		gbc_itemButton6.gridy = 2;
		itemPanel.add(itemButton6, gbc_itemButton6);
		
		JButton surrenderButton = new JButton("Surrender?");
		surrenderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.loseFight();
				GameRunner.launchMainScreen(gameEnvironment);
				frmBattle.dispose();
			}
		});
		surrenderButton.setBounds(987, 294, 85, 21);
		frmBattle.getContentPane().add(surrenderButton);
		
		JLabel lblNewLabel = new JLabel(gameEnvironment.getParty().getMonsterAtIndex(gameEnvironment.getParty().getCurrentFighterIndex()).getName());
		lblNewLabel.setBounds(426, 100, 85, 13);
		frmBattle.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(gameEnvironment.getEnemyParty().getMonsterAtIndex(gameEnvironment.getEnemyParty().getCurrentFighterIndex()).getName());
		lblNewLabel_1.setBounds(607, 100, 88, 13);
		frmBattle.getContentPane().add(lblNewLabel_1);
		
		
		
	}
}
