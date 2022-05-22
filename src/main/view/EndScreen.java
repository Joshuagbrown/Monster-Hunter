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
		dayTitileLabel.setBounds(10, 54, 101, 36);
		frame.getContentPane().add(dayTitileLabel);
		
		JLabel scoreTitleLabel = new JLabel("Score:");
		scoreTitleLabel.setBounds(10, 96, 101, 36);
		frame.getContentPane().add(scoreTitleLabel);
		
		JLabel scoreLabel = new JLabel(Integer.toString(gameEnvironment.getScore()));
		scoreLabel.setBounds(136, 96, 65, 36);
		frame.getContentPane().add(scoreLabel);
		
		JLabel dayLabel = new JLabel(Integer.toString(gameEnvironment.getTotalDays()));
		dayLabel.setBounds(136, 54, 65, 36);
		frame.getContentPane().add(dayLabel);
	}
}
