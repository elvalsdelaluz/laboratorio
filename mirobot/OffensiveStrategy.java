package mirobot;
import robocode.JuniorRobot;

public class OffensiveStrategy extends CombatStrategy{

    public OffensiveStrategy (JuniorRobot robot){
        super (robot);
    }
    @Override
    public void onScannedRobot(){
        //Me copio los valores porque  despues del super se borran
        int dist = robot.scannedDistance;
        int angle = robot.scannedAngle;
        int bearing = robot.scannedBearing;

        super.onScannedRobot();

        //Lo embisto
        if (dist < 200) {
            System.out.println("DISTANCE: " + dist);
            System.out.println("ANGLE: " + angle);
            System.out.println("BEARING: " + bearing);
            robot.turnTo(angle);
            robot.ahead(dist);
        }
    }
    @Override
    public void onHitByBullet() {
        //Le sigo disparando
        robot.turnGunTo(robot.hitByBulletAngle);
        robot.fire(3);
        //Lo embisto
        System.out.println("Estoy en BYBULLET, se supone que lo voy a chocar...");
        robot.turnRight(robot.hitByBulletBearing);
        robot.ahead(100);
    }

    @Override
    public void onHitWall() {
        robot.turnTo(robot.hitWallAngle+90);
        robot.back(300);
    }

}
