package mirobot;

import robocode.JuniorRobot;

public class SurvivalStrategy extends CombatStrategy{

    public SurvivalStrategy (JuniorRobot robot){
        super (robot);
    }

    @Override
    public void onScannedRobot() {
        //Apuntar el arma hacia el robot
        robot.turnGunTo(robot.scannedAngle);
        //Le sigo disparando
        robot.fire(1);
    }

    @Override
    public void onHitRobot() {
        //Le sigo disparando
        robot.turnGunTo(robot.hitRobotAngle);
        robot.fire(2);
    }

    @Override
    public void onHitByBullet(){
        robot.turnGunTo(robot.hitByBulletAngle);
        robot.fire(1);
        //Me voy
        getAway();
    }

    @Override
    public void onHitWall() {
        getAway();
    }

}
