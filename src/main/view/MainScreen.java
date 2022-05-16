package main.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.controller.GameEnvironment;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class MainScreen {

	private JFrame frame;
	private GameEnvironment gameEnvironment;


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
		frame.setBounds(100, 100, 870, 558);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel(gameEnvironment.getPlayer().getName());
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel(gameEnvironment.getParty().get(0).getName());
		panel.add(lblNewLabel_1);
	}

}
