	package main.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.controller.GameEnvironment;

public class EndScreen {

	private JFrame frame;
	private GameEnvironment gameEnvironment;


	/**
	 * Create the application.
	 */
	public EndScreen(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		initialize();
		frame.setVisible(true);
			
		}
	/** 
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel endTitleLabel = new JLabel("The End! \r\n");
		endTitleLabel.setBounds(10, 10, 57, 44);
		frame.getContentPane().add(endTitleLabel);
		
		JLabel dayTitileLabel = new JLabel("Days Played:\r\n\r\n");
		dayTitileLabel.setBounds(10, 54, 65, 36);
		frame.getContentPane().add(dayTitileLabel);
		
		JLabel scoreTitleLabel = new JLabel("Score:");
		scoreTitleLabel.setBounds(10, 96, 65, 36);
		frame.getContentPane().add(scoreTitleLabel);
		
		JLabel scoreLabel = new JLabel("New label");
		scoreLabel.setBounds(85, 96, 65, 36);
		frame.getContentPane().add(scoreLabel);
		
		JLabel dayLabel = new JLabel("New label");
		dayLabel.setBounds(85, 54, 65, 36);
		frame.getContentPane().add(dayLabel);
	}
}
