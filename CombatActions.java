package mirobot;

public interface CombatActions {
    //onScannedRobot: What to do when you see another robot
    void onScannedRobot();

    //onHitRobot:
    void onHitRobot();

    //onHitByBullet: What to do when you're hit by a bullet
    void onHitByBullet();

    //onHitWall: What to do when you hit a wall
    void onHitWall();
}

//NOTA: Isabel me dijo que tener una interface es más elegante