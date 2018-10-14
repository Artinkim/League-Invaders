package project;

import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	int speed;
	Alien(int a, int b, int c, int d) {
		super(a, b, c, d);
		speed = 5;
	}

	void draw(Graphics g) {
		  g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
	void update() {
		super.update();
		y+=speed;
	}

}
