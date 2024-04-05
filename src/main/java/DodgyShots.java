import javafx.scene.paint.Color;
import robocode.*;
// import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * DodgyShots - a robot by (your name here)
 */
public class DodgyShots extends AdvancedRobot {
	int gunDirection = 1;
	/**
	 * run: DodgyShots's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// Robot main loop
		while (true) {
			// Replace the next 4 lines with any behavior you would like
			// ahead(100);
			// turnGunRight(360);
			// back(100);
			turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		// Turn the robot towards the enemy
		turnRight(e.getBearing());
		// Shoots always that it's aiming at the enemy
		fire(3);
		// And move forward
		ahead(100);
		// Inverts the gun direction on each turn
		gunDirection = -gunDirection;
		// Turn 360 degrees (clockwise or anti clockwise,)
		turnGunRight(360 * gunDirection);
		execute();
	}

	public void onHitWall(HitWallEvent e) {
		double bearing = e.getBearing(); // get the bearing of the wall
		turnRight(-bearing); // This isn't accurate but release your robot.
		ahead(100); // The robot goes away from the wall.
	}

	double energy = getEnergy();

	public void onHitByBullet(HitByBulletEvent e) {
		double bearing = e.getBearing(); // Get the direction which is arrived the bullet.
		if (energy < 100) { // if the energy is low, the robot go away from the enemy
			turnRight(-bearing); // This isn't accurate but release your robot.
			ahead(100); // The robot goes away from the enemy.
		} else
			turnRight(360); // scan
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	// public void onHitByBullet(HitByBulletEvent e) {
	// // Replace the next line with any behavior you would like
	// back(10);
	// }

	/**
	 * onHitWall: What to do when you hit a wall
	 */
	// public void onHitWall(HitWallEvent e) {
	// // Replace the next line with any behavior you would like
	// back(20);
	// }
}
