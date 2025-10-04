package mirobot;

public class DefensiveStrategy extends CombatStrategy{
    @Override
    public void onScannedRobot(Demoleitor lulu) {
        System.out.println("Escanee un robot...., estoy en defensive");
        //lulu.turnGunTo(lulu.scannedAngle);
        lulu.turnGunTo(lulu.scannedAngle);
        if (lulu.scannedVelocity == 0 || lulu.scannedDistance < 200) {
            lulu.fire(2);
        }
        else{
            lulu.fire(1);
        }
    }


    @Override
    void onHitRobot(Demoleitor lulu) {
        System.out.println("Le dispare a un robot esto en defensive");
        //Le sigo disparando
        lulu.turnGunTo(lulu.hitRobotAngle);
        lulu.fire(2);
    }

    @Override
    public void onHitByBullet(Demoleitor lulu){
        System.out.println("Me dispararon, estoy en defensive!!!");
        //lulu.turnGunTo(lulu.hitByBulletAngle);
        lulu.turnGunTo(lulu.hitByBulletAngle);
        if (lulu.scannedVelocity == 0 || lulu.scannedDistance < 200) {
            lulu.fire(2);
        }
        else{
            lulu.fire(1);
        }
        lulu.turnTo(lulu.hitByBulletBearing + 90);
        lulu.ahead(100);
    }

    @Override
    public void onHitWall(Demoleitor lulu) {
        System.out.println("Choque, estoy en defensive");
        lulu.turnTo (lulu.hitWallAngle + 90);
        lulu.ahead(100);
    }
}
