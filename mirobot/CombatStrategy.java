package mirobot;
import robocode.JuniorRobot;

public abstract class CombatStrategy implements CombatActions {
    protected JuniorRobot robot;

    public CombatStrategy (JuniorRobot robot) {
        this.robot = robot;
    }

    //onScannedRobot: What to do when you see another robot
    public void onScannedRobot() {
        robot.turnGunTo(robot.scannedAngle);
        //Le disparo
        int power;
        if (robot.scannedDistance < 120 || robot.scannedVelocity == 0) {
            power = 3;
        } else if (robot.scannedDistance < 200) {
            power = 2;
        } else {
            power = 1;
        }
        robot.fire(power);
    }
    //onHitRobot:
    @Override
    public void onHitRobot() {
        //Le sigo disparando
        robot.turnGunTo(robot.hitRobotAngle);
        robot.fire(3);
    }

    //onHitByBullet: What to do when you're hit by a bullet
    public abstract void onHitByBullet();

    //onHitWall: What to do when you hit a wall
    public abstract void onHitWall();

    //I do crazy things
    public void getAway (){
        int newAngle = robot.heading+77;
        robot.turnTo(newAngle);
        robot.ahead (70);
    }
}
//COLOQUIO, es más elegante una interfaz con una clase abstracta
