package main.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BattleScreen {

	private JFrame frmBattle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleScreen window = new BattleScreen();
					window.frmBattle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BattleScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBattle = new JFrame();
		frmBattle.setTitle("Battle");
		frmBattle.setBounds(100, 100, 786, 490);
		frmBattle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBattle.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("My Team:");
		lblNewLabel.setBounds(6, 6, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("My Items:");
		lblNewLabel_1.setBounds(6, 140, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Item 1");
		lblNewLabel_2.setBounds(6, 160, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Item 2");
		lblNewLabel_3.setBounds(6, 188, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Item 3");
		lblNewLabel_4.setBounds(6, 216, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Item 4");
		lblNewLabel_5.setBounds(6, 244, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Item 5");
		lblNewLabel_6.setBounds(6, 272, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Item 6");
		lblNewLabel_7.setBounds(6, 300, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.setBounds(48, 155, 61, 29);
		frmBattle.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Play");
		btnNewButton_1.setBounds(48, 183, 61, 29);
		frmBattle.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Play");
		btnNewButton_2.setBounds(48, 211, 61, 29);
		frmBattle.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Play");
		btnNewButton_3.setBounds(48, 239, 61, 29);
		frmBattle.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Play");
		btnNewButton_4.setBounds(48, 267, 61, 29);
		frmBattle.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Play");
		btnNewButton_5.setBounds(48, 295, 61, 29);
		frmBattle.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_8 = new JLabel("The Fight");
		lblNewLabel_8.setBounds(339, 6, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("VS");
		lblNewLabel_9.setBounds(359, 54, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Current Health:");
		lblNewLabel_10.setBounds(234, 107, 123, 16);
		frmBattle.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Current Health:");
		lblNewLabel_11.setBounds(415, 107, 130, 16);
		frmBattle.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Opponents Team:");
		lblNewLabel_12.setBounds(665, 6, 115, 16);
		frmBattle.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("...");
		lblNewLabel_13.setBounds(6, 28, 123, 16);
		frmBattle.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("...");
		lblNewLabel_14.setBounds(6, 54, 123, 16);
		frmBattle.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("...");
		lblNewLabel_15.setBounds(6, 81, 123, 16);
		frmBattle.getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("...");
		lblNewLabel_16.setBounds(6, 107, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("...");
		lblNewLabel_17.setBounds(650, 28, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_17);
		
		JLabel lblNewLabel_17_1 = new JLabel("...");
		lblNewLabel_17_1.setBounds(650, 54, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_17_1);
		
		JLabel lblNewLabel_17_2 = new JLabel("...");
		lblNewLabel_17_2.setBounds(650, 81, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_17_2);
		
		JLabel lblNewLabel_17_3 = new JLabel("...");
		lblNewLabel_17_3.setBounds(650, 107, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_17_3);
		
		JLabel lblNewLabel_18 = new JLabel("...");
		lblNewLabel_18.setBounds(234, 128, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("...");
		lblNewLabel_19.setBounds(415, 128, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("My Monster");
		lblNewLabel_20.setBounds(234, 54, 88, 16);
		frmBattle.getContentPane().add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("Their monster");
		lblNewLabel_21.setBounds(415, 54, 88, 16);
		frmBattle.getContentPane().add(lblNewLabel_21);
		
		JButton btnNewButton_6 = new JButton("FIGHT");
		btnNewButton_6.setBounds(315, 259, 117, 29);
		frmBattle.getContentPane().add(btnNewButton_6);
		
		JLabel lblNewLabel_22 = new JLabel("Damage:");
		lblNewLabel_22.setBounds(234, 160, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("...");
		lblNewLabel_23.setBounds(234, 196, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("Damage:");
		lblNewLabel_24.setBounds(415, 160, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("...");
		lblNewLabel_25.setBounds(415, 196, 61, 16);
		frmBattle.getContentPane().add(lblNewLabel_25);
	}

}
