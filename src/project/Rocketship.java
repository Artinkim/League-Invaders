package project;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
int speed;
int XV;
int YV;

	Rocketship(int a, int b, int c, int d) {
		super(a, b, c, d);
		speed = 5;
	}
	void update() {
super.update();
x+=XV;
y+=YV;
}
	

	void draw(Graphics g) {
	    g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}

}
