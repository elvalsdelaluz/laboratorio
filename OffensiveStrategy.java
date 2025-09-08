package mirobot;
import robocode.JuniorRobot;

public class OffensiveStrategy extends CombatStrategy{

    public OffensiveStrategy (JuniorRobot robot){
        super (robot);
    }
    @Override
    public void onScannedRobot(){
        super.onScannedRobot();
        /*
        //Lo embisto
        System.out.println("Estoy en SCANNED DEBERIA EMBESTIRLO BEARING" +robot.scannedBearing);
        System.out.println("Estoy en SCANNED DEBERIA EMBESTIRLO ANGLE" +robot.scannedAngle);
        System.out.println("Estoy en SCANNED DEBERIA EMBESTIRLO DISTANCE" +robot.scannedDistance);
        robot.turnTo(robot.scannedAngle);
        robot.ahead(robot.scannedDistance);
        LA SUPERCLASE SE QUEDA CON LOS DATOS, TENGO QUE VER COMO RECUPERARLOS ANTES
        */
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
