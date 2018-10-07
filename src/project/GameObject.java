package project;

import java.awt.Graphics;

import java.awt.event.KeyListener;

public class GameObject {
	int x;
	int y;
	int width;
	int height;

	GameObject(int a, int b, int c, int d) {
		x = a;
		y = b;
		width = c;
		height = d;
	}

	void update(int direction) {
		if (direction == 65) {
			x -= 2;
		}
		if (direction == 68) {
			x += 2;
		}
		if (direction == 87) {
			y -= 2;
		}
		if (direction == 83) {
			y += 2;
		}

	}

	void draw(Graphics g) {
		g.fillRect(x, y, 100, 100);
	}

}
