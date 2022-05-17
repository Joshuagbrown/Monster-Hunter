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
import main.model.Orc;
import main.model.Wizard;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopScreen {

	private JFrame frmTheShop;
	private JTextField textField;
	private JTextField txtNo;
	private JTextField txtNo_1;
	private JTextField txtNo_2;
	private JTextField txtYes;
	private JTextField txtYes_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private GameEnvironment gameEnvironment;

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
		frmTheShop.setBounds(100, 100, 655, 482);
		frmTheShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTheShop.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("GOLD:");
		lblNewLabel_1.setBounds(463, 6, 45, 16);
		frmTheShop.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setText("$0");
		textField.setBounds(504, 1, 130, 26);
		frmTheShop.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Monsters:");
		lblNewLabel_3.setBounds(17, 38, 74, 16);
		frmTheShop.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Buy:");
		lblNewLabel_4.setBounds(117, 38, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_10 = new JLabel("Locked?");
		lblNewLabel_10.setBounds(390, 38, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_10);
		
		txtNo = new JTextField();
		txtNo.setText("No");
		txtNo.setBounds(390, 55, 61, 26);
		frmTheShop.getContentPane().add(txtNo);
		txtNo.setColumns(10);
		
		txtNo_1 = new JTextField();
		txtNo_1.setText("No");
		txtNo_1.setBounds(390, 85, 61, 26);
		frmTheShop.getContentPane().add(txtNo_1);
		txtNo_1.setColumns(10);
		
		txtNo_2 = new JTextField();
		txtNo_2.setText("No");
		txtNo_2.setBounds(390, 115, 61, 26);
		frmTheShop.getContentPane().add(txtNo_2);
		txtNo_2.setColumns(10);
		
		txtYes = new JTextField();
		txtYes.setText("Yes");
		txtYes.setBounds(390, 144, 61, 26);
		frmTheShop.getContentPane().add(txtYes);
		txtYes.setColumns(10);
		
		txtYes_1 = new JTextField();
		txtYes_1.setText("Yes");
		txtYes_1.setBounds(390, 173, 61, 26);
		frmTheShop.getContentPane().add(txtYes_1);
		txtYes_1.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Max Health, Damage,");
		lblNewLabel_11.setBounds(239, 20, 143, 16);
		frmTheShop.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("30,5,5");
		lblNewLabel_12.setBounds(243, 60, 55, 16);
		frmTheShop.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_14 = new JLabel("50,10,5");
		lblNewLabel_14.setBounds(243, 90, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("100,5,2");
		lblNewLabel_15.setBounds(243, 120, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("50,20,30");
		lblNewLabel_16.setBounds(243, 149, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("80,30,20");
		lblNewLabel_17.setBounds(243, 178, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_17);
		
		JLabel lblNewLabel = new JLabel("Heal Amount");
		lblNewLabel.setBounds(239, 38, 99, 16);
		frmTheShop.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_13 = new JLabel("Items:");
		lblNewLabel_13.setBounds(6, 214, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_21 = new JLabel("Heal Amount +20");
		lblNewLabel_21.setBounds(239, 235, 130, 16);
		frmTheShop.getContentPane().add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("Damage +20");
		lblNewLabel_22.setBounds(239, 266, 111, 16);
		frmTheShop.getContentPane().add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("Health = Max Health");
		lblNewLabel_23.setBounds(239, 291, 143, 26);
		frmTheShop.getContentPane().add(lblNewLabel_23);
		
		JLabel lblNewLabel_2 = new JLabel("Sell:");
		lblNewLabel_2.setBounds(176, 38, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_29 = new JLabel("Quantity");
		lblNewLabel_29.setBounds(463, 38, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_29);
		
		textField_1 = new JTextField();
		textField_1.setBounds(463, 55, 61, 26);
		frmTheShop.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(463, 85, 61, 26);
		frmTheShop.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(463, 115, 61, 26);
		frmTheShop.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(463, 144, 61, 26);
		frmTheShop.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(463, 173, 61, 26);
		frmTheShop.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton gremlinBuyButton = new JButton("$100");
		gremlinBuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnvironment.canBuy(100)) {
					gameEnvironment.getParty().addMonster(new Gremlin());
				}
			}
		});
		gremlinBuyButton.setBounds(91, 53, 74, 29);
		frmTheShop.getContentPane().add(gremlinBuyButton);
		
		JButton elfBuyButton = new JButton("$300");
		elfBuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnvironment.canBuy(0)) {
					gameEnvironment.getParty().addMonster(new Elf());
				}
			}
		});
		elfBuyButton.setBounds(91, 83, 74, 29);
		frmTheShop.getContentPane().add(elfBuyButton);
		
		JButton orcBuyButton = new JButton("$500");
		orcBuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnvironment.canBuy(500)) {
					gameEnvironment.getParty().addMonster(new Orc());
				}
			}
		});
		orcBuyButton.setBounds(91, 113, 74, 29);
		frmTheShop.getContentPane().add(orcBuyButton);
		
		JButton wizardBuyButton = new JButton("$1000");
		wizardBuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnvironment.canBuy(1000)) {
					gameEnvironment.getParty().addMonster(new Wizard());
				}
			}
		});
		wizardBuyButton.setBounds(91, 142, 74, 29);
		frmTheShop.getContentPane().add(wizardBuyButton);
		
		JButton dragonBuyButton = new JButton("$2000");
		dragonBuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnvironment.canBuy(2000)) {
					gameEnvironment.getParty().addMonster(new Dragon());
				}
			}
		});
		dragonBuyButton.setBounds(91, 171, 74, 29);
		frmTheShop.getContentPane().add(dragonBuyButton);
		
		JButton gremlinSellButton = new JButton("$50");
		gremlinSellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnvironment.canSell()) {
					gameEnvironment.getParty().addMonster(new Elf());
				}
			}
		});
		gremlinSellButton.setBounds(164, 53, 74, 29);
		frmTheShop.getContentPane().add(gremlinSellButton);
		
		JButton elfSellButton = new JButton("$200");
		elfSellButton.setBounds(164, 83, 73, 29);
		frmTheShop.getContentPane().add(elfSellButton);
		
		JButton orcSellButton = new JButton("$300");
		orcSellButton.setBounds(164, 113, 73, 29);
		frmTheShop.getContentPane().add(orcSellButton);
		
		JButton wizardSellButton = new JButton("$700");
		wizardSellButton.setBounds(164, 142, 73, 29);
		frmTheShop.getContentPane().add(wizardSellButton);
		
		JButton dragonSellButton = new JButton("$1500");
		dragonSellButton.setBounds(164, 171, 73, 29);
		frmTheShop.getContentPane().add(dragonSellButton);
		
		JLabel lblNewLabel_5 = new JLabel("Gremlin");
		lblNewLabel_5.setBounds(17, 57, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Elf");
		lblNewLabel_6.setBounds(17, 85, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Orc");
		lblNewLabel_7.setBounds(17, 116, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Wizard");
		lblNewLabel_8.setBounds(17, 149, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Dragon");
		lblNewLabel_9.setBounds(17, 178, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_24 = new JLabel("My Team:");
		lblNewLabel_24.setBounds(6, 335, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("My Items:");
		lblNewLabel_25.setBounds(6, 381, 61, 16);
		frmTheShop.getContentPane().add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("Healing Potion");
		lblNewLabel_26.setBounds(6, 235, 99, 16);
		frmTheShop.getContentPane().add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("Damage Potion");
		lblNewLabel_27.setBounds(6, 266, 99, 16);
		frmTheShop.getContentPane().add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("Medical Kit");
		lblNewLabel_28.setBounds(6, 296, 99, 16);
		frmTheShop.getContentPane().add(lblNewLabel_28);
		
		JButton btnNewButton = new JButton("$200");
		btnNewButton.setBounds(91, 229, 74, 29);
		frmTheShop.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("$300");
		btnNewButton_1.setBounds(91, 260, 74, 29);
		frmTheShop.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("$400");
		btnNewButton_2.setBounds(91, 291, 74, 29);
		frmTheShop.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("$100");
		btnNewButton_3.setBounds(164, 229, 73, 29);
		frmTheShop.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("$200");
		btnNewButton_4.setBounds(164, 260, 73, 29);
		frmTheShop.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("$200");
		btnNewButton_5.setBounds(164, 291, 73, 29);
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
		
		JLabel lblNewLabel_18 = new JLabel("New label");
		lblNewLabel_18.setBounds(6, 356, 81, 26);
		frmTheShop.getContentPane().add(lblNewLabel_18);
		
		JLabel lblNewLabel_18_1 = new JLabel("New label");
		lblNewLabel_18_1.setBounds(91, 356, 81, 26);
		frmTheShop.getContentPane().add(lblNewLabel_18_1);
		
		JLabel lblNewLabel_18_2 = new JLabel("New label");
		lblNewLabel_18_2.setBounds(257, 356, 81, 26);
		frmTheShop.getContentPane().add(lblNewLabel_18_2);
		
		JLabel lblNewLabel_18_3 = new JLabel("New label");
		lblNewLabel_18_3.setBounds(176, 356, 81, 26);
		frmTheShop.getContentPane().add(lblNewLabel_18_3);
		
		JLabel lblNewLabel_18_4 = new JLabel("New label");
		lblNewLabel_18_4.setBounds(336, 356, 81, 26);
		frmTheShop.getContentPane().add(lblNewLabel_18_4);
		
		JLabel lblNewLabel_18_4_1 = new JLabel("New label");
		lblNewLabel_18_4_1.setBounds(336, 407, 81, 26);
		frmTheShop.getContentPane().add(lblNewLabel_18_4_1);
		
		JLabel lblNewLabel_18_2_1 = new JLabel("New label");
		lblNewLabel_18_2_1.setBounds(257, 407, 81, 26);
		frmTheShop.getContentPane().add(lblNewLabel_18_2_1);
		
		JLabel lblNewLabel_18_3_1 = new JLabel("New label");
		lblNewLabel_18_3_1.setBounds(176, 407, 81, 26);
		frmTheShop.getContentPane().add(lblNewLabel_18_3_1);
		
		JLabel lblNewLabel_18_1_1 = new JLabel("New label");
		lblNewLabel_18_1_1.setBounds(91, 407, 81, 26);
		frmTheShop.getContentPane().add(lblNewLabel_18_1_1);
		
		JLabel lblNewLabel_18_5 = new JLabel("New label");
		lblNewLabel_18_5.setBounds(6, 407, 81, 26);
		frmTheShop.getContentPane().add(lblNewLabel_18_5);
		
		JLabel lblNewLabel_18_4_1_1 = new JLabel("New label");
		lblNewLabel_18_4_1_1.setBounds(416, 408, 81, 26);
		frmTheShop.getContentPane().add(lblNewLabel_18_4_1_1);
	}
}
