package mirobot;

abstract class CombatStrategy {
    //onScannedRobot: What to do when you see another robot
    abstract void onScannedRobot(Demoleitor lulu);

    //onHitByBullet: What to do when you're hit by a bullet
    abstract void onHitByBullet(Demoleitor lulu);

    //onHitWall: What to do when you hit a wall
    abstract void onHitWall(Demoleitor lulu);


}
