import javafx.scene.paint.Color;
import robocode.*;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * DodgyShots - a robot by (your name here)
 */
public class DodgyShots extends Robot {
	/**
	 * run: DodgyShots's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.black, Color.black, Color.orange); // body,gun,radar

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
		setTurnRight(e.getBearing());
		// Shoots always that it's aiming at the enemy
		setFire(3);
		// And move forward
		setAhead(100);
		// Inverts the gun direction on each turn
		gunDirection = -gunDirection;
		// Turn 360 degrees (clockwise or anti clockwise,)
		setTurnGunRight(360 * gunDirection);
		// Execute all the pending actions
		execute();
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
