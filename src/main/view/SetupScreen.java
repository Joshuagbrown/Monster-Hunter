package main.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.controller.GameEnvironment;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetupScreen {

	private JFrame frame;
	private JPanel panel;
	private JLabel nameLabel;
	private JTextField nameInput;
	private JButton nameButton;
	private GameEnvironment gameEnvironment;

	/**
	 * Create the application.
	 */
	public SetupScreen(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 884, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(5, 3, 1, 1));
		
		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		nameLabel = new JLabel("Name: ");
		panel.add(nameLabel);
		
		nameInput = new JTextField();
		panel.add(nameInput);
		
		nameButton = new JButton("Submit");
		nameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.setupPlayer(nameInput.getText());
			}
		});
		panel.add(nameButton);
	}

}
