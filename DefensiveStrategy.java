package mirobot;

import robocode.JuniorRobot;

public class DefensiveStrategy extends CombatStrategy{

    public DefensiveStrategy (JuniorRobot robot){
        super (robot);
    }

    @Override
    public void onHitByBullet(){
        robot.turnGunTo(robot.hitByBulletAngle);
        robot.fire(3);
        //Me voy
        getAway();
    }

    @Override
    public void onHitWall() {
        robot.turnTo (robot.hitWallAngle + 90);
        robot.ahead(100);
    }
}
