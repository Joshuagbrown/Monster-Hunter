package main.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.controller.GameEnvironment;
import main.controller.GameRunner;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.event.ActionEvent;

public class WinScreen {

	private JFrame frame;


	/**
	 * Create the application.
	 */
	public WinScreen() {
		initialize();
		frame.setVisible(true);
		new Timer(5_000, (e) -> { frame.setVisible(false); frame.dispose(); }).start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(874, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Congrats You Won the fights");
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	}

}
