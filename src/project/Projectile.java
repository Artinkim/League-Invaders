package project;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	int speed;

	Projectile(int a, int b, int c, int d) {
		super(a, b, c, d);
		speed = 10;
	}

	void update() {
		super.update();
		y -= speed;
		if (y < 0) {
			isAlive = true;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
}
