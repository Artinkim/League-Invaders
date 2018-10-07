package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	GamePanel() {
		tim = new Timer(1000 / 60, this);
		go = new GameObject(20, 20, 20, 40);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		smallFont = new Font("Arial", Font.PLAIN, 20);
	}

	Timer tim;
	GameObject go;
	int key;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font smallFont;

	void updateMenuState() {
		currentState = MENU_STATE;
	}

	void updateGameState() {
		currentState = GAME_STATE;
	}

	void updateEndState() {
		currentState = END_STATE;
	}

	void drawMenuState(Graphics g) {
		g.setColor(new Color(0, 0, 255));
		g.fillRect(0, 0, 500, 800);
		g.setColor(new Color(255, 255, 0));
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 25, 250);
		g.setFont(smallFont);
		g.drawString("Press ENTER to start", 150, 350);
		g.drawString("Press SPACE to instructions", 120, 450);
	}

	void drawGameState(Graphics g) {
		g.setColor(new Color(250, 255, 255));
		g.fillRect(0, 0, 500, 800);
	}

	void drawEndState(Graphics g) {
		g.setColor(new Color(255, 0, 0));
		g.fillRect(0, 0, 500, 800);
		g.setColor(new Color(255, 255, 255));
		g.setFont(titleFont);
		g.drawString("GAME OVER", 100, 250);
		g.setFont(smallFont);
		g.drawString("You killed" + " enemies", 150, 350);
		g.drawString("Press ENTER to restart", 130, 450);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();
		go.update(key);

	}

	void startGame() {
		tim.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		go.draw(g);
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		key = e.getKeyCode();
		System.out.println(key);
		if (key == 10 || key == 13) {
			if (currentState == END_STATE) {
				currentState = MENU_STATE;
			} else if (currentState == GAME_STATE) {
				currentState = END_STATE;
			} else if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
