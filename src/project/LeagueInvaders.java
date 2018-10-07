package project;

import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	public static void main(String[] args) {

		new LeagueInvaders().setup();
	}

	JFrame frame;
	final int width = 500;
	final int height = 800;
	GamePanel gpanel;

	LeagueInvaders() {
		frame = new JFrame("LeagueInvaders");
		frame.setVisible(true);
		gpanel = new GamePanel();
	}

	void setup() {
		frame.add(gpanel);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gpanel.startGame();
		frame.addKeyListener(gpanel);
	}

}
