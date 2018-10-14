package project;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rocket;
	ArrayList<Projectile> ps;
	ArrayList<Alien> aliens;
	int enemyTimer;
	int enemySpawnTime;
	int score;

	ObjectManager(Rocketship r) {
		rocket = r;
		ps = new ArrayList<Projectile>();
		aliens = new ArrayList<Alien>();
		enemySpawnTime = 1000;
		enemyTimer = 0;
		score = 0;
	}

	int getScore() {
		return score;
	}

	void addProjectile(Projectile p) {
		ps.add(p);
	}

	void addAlien(Alien a) {
		aliens.add(a);
	}

	void update() {
		rocket.update();
		for (Projectile p : ps) {
			p.update();
		}
		for (Alien a : aliens) {
			a.update();
		}
	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (Projectile p : ps) {
			p.draw(g);
		}
		for (Alien a : aliens) {
			a.draw(g);
		}
	}

	public void manageEnemies() {
		if ((int) System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(450), 0, 50, 50));
			enemyTimer = (int) System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isAlive == false) {
				aliens.remove(aliens.get(i));
			}
		}

		for (int i = 0; i < ps.size(); i++) {
			if (ps.get(i).isAlive == false) {
				ps.remove(ps.get(i));
			}
		}
	}

	void checkCollision() {
		for (Alien a : aliens) {
			if (rocket.collisionBox.intersects(a.collisionBox)) {
				rocket.isAlive = false;
			}
		}

		for (Alien b : aliens) {

			for (Projectile p : ps) {
				if (b.collisionBox.intersects(p.collisionBox)) {
					b.isAlive = false;
					p.isAlive = false;
					score++;

				}
			}
		}
	}

}
